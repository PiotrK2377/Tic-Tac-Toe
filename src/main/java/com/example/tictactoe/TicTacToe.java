package com.example.tictactoe;

import java.util.Random;
import java.util.Scanner;

import static com.example.tictactoe.Board.displayBoard;
import static com.example.tictactoe.Board.displayBoard10x10;


public class TicTacToe {
    public static void main(String[] args) {

        Board board = new Board();
        Game game = new Game();
        Game10x10 game10x10 = new Game10x10();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Chose board: 3x3[t] or 10x10[s]");
        String choseBoard = scanner.nextLine();

        if (choseBoard.equals("t")) {

            displayBoard(board.getBoard());

            while (true) {

                playerTurn(board, game);
                if (endOfTheGame(board.getBoard(),game)) {
                    break;
                }
                computerTurn(board, game);
                if (endOfTheGame(board.getBoard(),game)) {
                    break;
                }
                displayBoard(board.getBoard());
            }
        } else if (choseBoard.equals("s")) {

            displayBoard10x10(board.getBoard10x10());

            while (true) {
                playerTurn10(board, game10x10);
                if (endOfTheGame10(board.getBoard10x10(), game10x10)) {
                    break;
                }
                computerTurn10x10(board, game10x10);
                if (endOfTheGame10(board.getBoard10x10(), game10x10)) {
                    break;
                }
                displayBoard10x10(board.getBoard10x10());

            }
        } else {
            System.out.println("Try again correctly");
            TicTacToe.main(new String[0]);
        }

    }

    private static void computerTurn(Board board, Game game) {
        Random rand = new Random();
        int computerMove;
        while (true) {
            computerMove = rand.nextInt(9) + 1;
            if (game.correctMovement(board.getBoard(), computerMove)) {
                break;
            }
        }
        System.out.println("Computer move: " + computerMove);
        game.placeMoveO(board.getBoard(), computerMove);
    }

    private static void computerTurn10x10(Board board, Game10x10 game10x10) {
        Random rad = new Random();
        int computerMove10;
        while (true) {
            computerMove10 = rad.nextInt(100) + 1;
            if (game10x10.correctMovement10(board.getBoard10x10(), computerMove10)) {
                break;
            }
        }
        System.out.println("Computer move: " + computerMove10);
        game10x10.placeMove(board.getBoard10x10(), Integer.toString(computerMove10),'O');
    }

    private static void playerTurn(Board board, Game game) {
        String playerMove;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("To play, select a number between 1 and 9");
            playerMove = scanner.nextLine();
            if (game.correctMovement(board.getBoard(), Integer.parseInt(playerMove))) {
                break;
            } else {
                System.out.println(playerMove + " it's not the right move");
            }
        }
        game.placeMoveX(board.getBoard(), playerMove);
    }

    private static void playerTurn10(Board board, Game10x10 game10x10) {
        String playerMove10;
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("To play, select a number between 1 and 100");
            playerMove10 = scan.nextLine();
            if (game10x10.correctMovement10(board.getBoard10x10(), Integer.parseInt(playerMove10))) {
                break;
            } else {
                System.out.println(playerMove10 + " it's not the right move");
            }
        }
        game10x10.placeMove(board.getBoard10x10(), playerMove10,'X');
    }

    static boolean endOfTheGame(char[][] board, Game game) {

        if (game.winnerX(board)) {
            displayBoard(board);
            System.out.println("Player using X win !!");
            return true;
        }

        if (game.winnerO(board)) {
            displayBoard(board);
            System.out.println("Computer using O win !!");
            return true;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        displayBoard(board);
        System.out.println("the game ended in a draw");
        return true;
    }

    static boolean endOfTheGame10(char[][] board10x10, Game10x10 game10x10) {

        if (game10x10.allWins(board10x10,'X')) {
            displayBoard10x10(board10x10);
            System.out.println("Player wins!");
            return true;
        }

        if (game10x10.allWins(board10x10, 'O')) {
            displayBoard10x10(board10x10);
            System.out.println("Computer wins!");
            return true;
        }

        for (int i = 0; i < board10x10.length; i++) {
            for (int j = 0; j < board10x10[i].length; j++) {
                if (board10x10[i][j] == ' ') {
                    return false;
                }
            }
        }
        displayBoard10x10(board10x10);
        System.out.println("The game end in a tie!");
        return true;
    }
}
