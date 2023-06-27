package com.example.tictactoeJavaFX;

public class Game {

    public int boardSize;
    public char[][] board;

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public char[][] getBoard() {
        return board = new char[boardSize][boardSize];
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public boolean hasWon(char player) {

        if (board == null) {
            return false;
        } else if (getBoardSize() == 10) {
            // Check rows
            for (int row = 0; row < boardSize; row++) {
                for (int col = 0; col < boardSize - 4; col++) {
                    boolean win = true;
                    for (int i = 0; i < 5; i++) {
                        if (board[row][col + i] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }

            // Check columns
            for (int col = 0; col < boardSize; col++) {
                for (int row = 0; row < boardSize - 4; row++) {
                    boolean win = true;
                    for (int i = 0; i < 5; i++) {
                        if (board[row + i][col] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }

            // Check diagonals (top-left to bottom-right)
            for (int row = 0; row < boardSize - 4; row++) {
                for (int col = 0; col < boardSize - 4; col++) {
                    boolean win = true;
                    for (int i = 0; i < 5; i++) {
                        if (board[row + i][col + i] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }

            // Check diagonals (top-right to bottom-left)
            for (int row = 0; row < boardSize - 4; row++) {
                for (int col = 4; col < boardSize; col++) {
                    boolean win = true;
                    for (int i = 0; i < 5; i++) {
                        if (board[row + i][col - i] != player) {
                            win = false;
                            break;
                        }
                    }
                    if (win) {
                        return true;
                    }
                }
            }

        } else if (getBoardSize() == 3) {
            // Check rows
            for (int row = 0; row < boardSize; row++) {
                if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                    return true;
                }
            }

            // Check columns
            for (int col = 0; col < boardSize; col++) {
                if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                    return true;
                }
            }

            // Check diagonals
            if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
                return true;
            }

            if (board[2][0] == player && board[1][1] == player && board[0][2] == player) {
                return true;
            }

            return false;
        }
        return false;

    }

}
