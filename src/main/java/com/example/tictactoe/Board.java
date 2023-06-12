package com.example.tictactoe;


public class Board {
    char[][] board = {{' ', ' ', ' '},
                      {' ', ' ', ' '},
                      {' ', ' ', ' '}};

    char[][] board10x10 = {{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '}};
    public char[][] getBoard() {
        return board;
    }

    public char[][] getBoard10x10() {
        return board10x10;
    }

    public static void displayBoard(char[][] board) {
        int d3 = board.length;

        for (int row = 0; row < d3; row++) {
            System.out.print("|");
            for (int column = 0; column < d3; column++) {
                System.out.print(board[row][column] + "|");
            }
            System.out.println();
        }
    }

    public static void displayBoard10x10(char[][] board10x10) {
       int d = board10x10.length;

       for (int row = 0; row < d; row++) {
           System.out.print("|");
           for (int column = 0; column < d; column++) {
               System.out.print(board10x10[row][column] + "|");
           }
           System.out.println();
       }
    }

}
