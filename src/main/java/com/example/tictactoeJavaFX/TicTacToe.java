package com.example.tictactoeJavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


import java.util.Optional;


public class TicTacToe extends Application {

    private char currentPlayer;
    private boolean gameRunning;
    private boolean computerPlayerEnabled;

    private Button[][] buttons;

    private Label statusLabel;

    private Label statusScore;

    private Button resetButton;

    private char[][] board;


    int computerScore = 0;
    int scorePoints = 0;

    Game game = new Game();

    ScoreBase base = new ScoreBase();

    private void enableResetButton() {
        resetButton.setDisable(false);
    }

    @Override
    public void start(Stage primaryStage) {
        showBoardSizeDialog(); // method asking about the size of the board

        board = new char[game.getBoardSize()][game.getBoardSize()];
        game.setBoard(board);
        currentPlayer = 'X';
        gameRunning = true;
        computerPlayerEnabled = true;

        initializeBoard();
        base.readRanking();

        GridPane gridPane = createGridPane();
        addButtonsToGridPane(gridPane);

        statusLabel = new Label("Player " + currentPlayer + "'s turn");
        statusLabel.setStyle("-fx-font-size: 30px; -fx-padding: 2px;");

        Pane root = new Pane();
        root.getChildren().addAll(gridPane, statusLabel);
        Scene scene;
        if (game.getBoardSize() == 10) {
            scene = new Scene(root, 1000, 1000);
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(scene);
            primaryStage.show();
        } else if (game.getBoardSize() == 3) {
            scene = new Scene(root, 400, 350);
            primaryStage.setTitle("Tic Tac Toe");
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        statusScore = new Label("Scores");
        statusScore.setStyle("-fx-font-size: 30px; -fx-padding: 2px;");
        if (game.getBoardSize() == 10) {
            statusScore.setTranslateX(860);
            statusScore.setTranslateY(20);
        } else if (game.getBoardSize() == 3) {
            statusScore.setTranslateX(280);
            statusScore.setTranslateY(20);
        }
        root.getChildren().add(statusScore);




        resetButton = new Button("Reset Game");
        resetButton.setOnAction(e -> startNewGame());
        if (game.getBoardSize() == 10) {
            resetButton.setTranslateX(550);
            resetButton.setTranslateY(860);
        } else if (game.getBoardSize() == 3) {
            resetButton.setTranslateX(20);
            resetButton.setTranslateY(300);
        }
        root.getChildren().add(resetButton);

        Button newGameButton = createNewGameButton();
        root.getChildren().add(newGameButton);

        Button exitButton = createExitButton();
        root.getChildren().add(exitButton);

        base.getScoreDisplay().setPrefWidth(100);
        base.getScoreDisplay().setPrefHeight(200);
        base.getScoreDisplay().setMouseTransparent(true);
        base.getScoreDisplay().setFocusTraversable(false);
        if (game.getBoardSize() == 10) {
            base.getScoreDisplay().setTranslateX(860);
            base.getScoreDisplay().setTranslateY(80);
        } else if (game.getBoardSize() == 3) {
            base.getScoreDisplay().setTranslateX(275);
            base.getScoreDisplay().setTranslateY(80);
        }
        root.getChildren().add(base.getScoreDisplay());

    }
    private void showBoardSizeDialog() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Choose Board Size");
        alert.setHeaderText("Select the board size for the game");
        alert.setContentText("Choose the desired board size:");

        ButtonType buttonType3x3 = new ButtonType("3x3");
        ButtonType buttonType10x10 = new ButtonType("10x10");

        alert.getButtonTypes().setAll(buttonType3x3, buttonType10x10);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonType3x3) {
            game.setBoardSize(3);
        } else if (result.get() == buttonType10x10) {
            game.setBoardSize(10);
        }
    }

    private GridPane createGridPane() {
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setTranslateX(20);
        gridPane.setTranslateY(50);

        return gridPane;
    }

    private void addButtonsToGridPane(GridPane gridPane) {
        buttons = new Button[game.getBoardSize()][game.getBoardSize()];

        for (int row = 0; row < game.getBoardSize(); row++) {
            for (int col = 0; col < game.getBoardSize(); col++) {
                Button button = new Button();
                button.setPrefSize(70, 70);
                button.setStyle("-fx-font-size: 30px; -fx-text-fill: green;");
                int finalRow = row;
                int finalCol = col;
                button.setOnAction(e -> handleButtonClicked(finalRow, finalCol));

                buttons[row][col] = button;
                gridPane.add(button, col, row);
            }
        }
    }

    private Button createNewGameButton() {
        Button newGameButton = new Button("New game");
        newGameButton.setOnAction(e -> {
            Stage stage = (Stage) newGameButton.getScene().getWindow();
            stage.close();
            base.saveRanking();
            TicTacToe newGame = new TicTacToe();
            newGame.start(new Stage());
        });
        if (game.getBoardSize() == 10) {
            newGameButton.setTranslateX(650);
            newGameButton.setTranslateY(860);
        } else if (game.getBoardSize() == 3) {
            newGameButton.setTranslateX(110);
            newGameButton.setTranslateY(300);
        }
        return newGameButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit game");
        exitButton.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation of the end of the game");
            alert.setHeaderText("Are you sure you want to quit the game ?");
            alert.setContentText("Click 'OK' to confirm.");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                Stage stage = (Stage) exitButton.getScene().getWindow();
                stage.close();
            }
        });
        if (game.getBoardSize() == 10) {
            exitButton.setTranslateX(750);
            exitButton.setTranslateY(860);
        } else if (game.getBoardSize() == 3) {
            exitButton.setTranslateX(195);
            exitButton.setTranslateY(300);
        }
        return exitButton;
    }

    private void initializeBoard() {
        int bo = game.getBoardSize();
        for (int row = 0; row < bo; row++) {
            for (int col = 0; col < bo; col++) {
                board[row][col] = ' ';
            }
        }
    }

    private void updateButton(int row, int col) {
        buttons[row][col].setText(String.valueOf(board[row][col]));
        buttons[row][col].setDisable(true);
    }

    private void handleButtonClicked(int row, int col) {
        if (!gameRunning || board[row][col] != ' ') {
            return;
        }

        board[row][col] = currentPlayer;
        updateButton(row, col);

        if (game.hasWon('X')) {
            endGame("Player wins!");
            scorePoints++;
            base.setPlayerScore(scorePoints);
            return;
        } else if (isBoardFull()) {
            endGame("It's a tie!");
            return;
        } else if (game.hasWon('O')) {
            endGame("Computer wins!");
            computerScore++;
            return;
        }


        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        statusLabel.setText("Player " + currentPlayer + "'s turn");

        if (computerPlayerEnabled && currentPlayer == 'O') {
            makeComputerMove();
        }
    }

    private void makeComputerMove() {
        int row;
        int col;
        do {
            row = (int) (Math.random() * game.getBoardSize());
            col = (int) (Math.random() * game.getBoardSize());
        } while (board[row][col] != ' ');

        board[row][col] = currentPlayer;
        updateButton(row, col);

        if (game.hasWon(currentPlayer)) {
            endGame("Player " + currentPlayer + " wins!");
            return;
        } else if (isBoardFull()) {
            endGame("It's a tie!");
            return;
        }
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        statusLabel.setText("Player " + currentPlayer + "'s turn");
    }

    private boolean isBoardFull() {
        int bo = game.getBoardSize();
        for (int row = 0; row < bo; row++) {
            for (int col = 0; col < bo; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private void endGame(String message) {
        gameRunning = false;
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    private void startNewGame() {

        initializeBoard();
        currentPlayer = 'X';
        gameRunning = true;

        for (int row = 0; row < game.getBoardSize(); row++) {
            for (int col = 0; col < game.getBoardSize(); col++) {
                buttons[row][col].setText("");
                buttons[row][col].setDisable(false);
            }
        }

        resetButton.setDisable(true);
        enableResetButton();

        if (computerPlayerEnabled && currentPlayer == 'O') {
            makeComputerMove();
        }

    }

    @Override
    public void stop(){
        base.saveRanking();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
