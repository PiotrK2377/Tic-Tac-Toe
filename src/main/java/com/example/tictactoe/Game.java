package com.example.tictactoe;


public class Game {

    public static void placeMoveX(char[][]board, String position) {
        switch (position) {
            case "1":
                board[0][0] = 'X';
                break;
            case "2":
                board[0][1] = 'X';
                break;
            case "3":
                board[0][2] = 'X';
                break;
            case "4":
                board[1][0] = 'X';
                break;
            case "5":
                board[1][1] = 'X';
                break;
            case "6":
                board[1][2] = 'X';
                break;
            case "7":
                board[2][0] = 'X';
                break;
            case "8":
                board[2][1] = 'X';
                break;
            case "9":
                board[2][2] = 'X';
                break;

        }
    }

    public static void placeMoveO(char[][]board, int positionComp) {
        switch (positionComp) {
            case 1:
                board[0][0] = 'O';
                break;
            case 2:
                board[0][1] = 'O';
                break;
            case 3:
                board[0][2] = 'O';
                break;
            case 4:
                board[1][0] = 'O';
                break;
            case 5:
                board[1][1] = 'O';
                break;
            case 6:
                board[1][2] = 'O';
                break;
            case 7:
                board[2][0] = 'O';
                break;
            case 8:
                board[2][1] = 'O';
                break;
            case 9:
                board[2][2] = 'O';
                break;

        }
    }

    public static boolean correctMovement(char[][] board, int position) {
        switch (position) {
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;

        }
    }

    public static boolean winnerX(char[][] board) {
        if ((board[0][0] == 'X' && board[0][1] == 'X' && board[0][2] == 'X') ||
                (board[1][0] == 'X' && board[1][1] == 'X' && board[1][2] == 'X') ||
                (board[2][0] == 'X' && board[2][1] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][0] == 'X' && board[2][0] == 'X') ||
                (board[0][1] == 'X' && board[1][1] == 'X' && board[2][1] == 'X') ||
                (board[0][2] == 'X' && board[1][2] == 'X' && board[2][2] == 'X') ||

                (board[0][0] == 'X' && board[1][1] == 'X' && board[2][2] == 'X') ||
                (board[0][2] == 'X' && board[1][1] == 'X' && board[2][0] == 'X')) {
            return true;
        }
        return false;
    }

    public static boolean winnerO(char[][] board) {
        if ((board[0][0] == 'O' && board[0][1] == 'O' && board[0][2] == 'O') ||
                (board[1][0] == 'O' && board[1][1] == 'O' && board[1][2] == 'O') ||
                (board[2][0] == 'O' && board[2][1] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][0] == 'O' && board[2][0] == 'O') ||
                (board[0][1] == 'O' && board[1][1] == 'O' && board[2][1] == 'O') ||
                (board[0][2] == 'O' && board[1][2] == 'O' && board[2][2] == 'O') ||

                (board[0][0] == 'O' && board[1][1] == 'O' && board[2][2] == 'O') ||
                (board[0][2] == 'O' && board[1][1] == 'O' && board[2][0] == 'O')) {
            return true;
        }
        return false;
    }

}
