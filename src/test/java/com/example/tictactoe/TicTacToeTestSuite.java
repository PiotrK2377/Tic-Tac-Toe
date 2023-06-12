package com.example.tictactoe;

import org.junit.jupiter.api.*;

import static com.example.tictactoe.Game.*;
import static com.example.tictactoe.TicTacToe.*;


class TicTacToeTestSuite {

    @BeforeEach
    public void before() {
        System.out.println("Test Case: begin");
    }

    @AfterEach
    public void after() {
        System.out.println("Test Case: end");
    }

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Test Suite: begin");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("Test Suite: end");
    }

    @Nested
    @DisplayName("Test wins O")
    class TestWinsO {
        @Test
        void testWinsRowsO() {
            //Given
            char[][] board1 = {{'O', 'O', 'O'}, {'X', ' ', 'X'}, {' ', ' ', ' '}};
            char[][] board2 = {{'X', 'X', ' '}, {'O', 'O', 'O'}, {' ', ' ', ' '}};
            char[][] board3 = {{'X', 'X', ' '}, {'O', ' ', 'X'}, {'O', 'O', 'O'}};

            //When & Then
            Assertions.assertTrue(winnerO(board1));
            Assertions.assertTrue(winnerO(board2));
            Assertions.assertTrue(winnerO(board3));
        }

        @Test
        void testWinsColumnsO() {
            //Given
            char[][] board1 = {{'O', 'X', 'X'}, {'O', ' ', 'X'}, {'O', ' ', ' '}};
            char[][] board2 = {{'X', 'O', ' '}, {'X', 'O', 'X'}, {' ', 'O', ' '}};
            char[][] board3 = {{'X', 'X', 'O'}, {'O', ' ', 'O'}, {' ', 'X', 'O'}};

            //When & Then
            Assertions.assertTrue(winnerO(board1));
            Assertions.assertTrue(winnerO(board2));
            Assertions.assertTrue(winnerO(board3));
        }

        @Test
        void testWinsDiagonalsO() {
            //Given
            char[][] board1 = {{'O', 'X', ' '}, {'O', 'O', 'X'}, {'X', ' ', 'O'}};
            char[][] board2 = {{'X', 'O', 'O'}, {'X', 'O', 'X'}, {'O', ' ', ' '}};

            //When & Then
            Assertions.assertTrue(winnerO(board1));
            Assertions.assertTrue(winnerO(board2));
        }
    }

    @Nested
    @DisplayName("Test wins X")
    class TestWinsX {

        @Test
        void testWinsRowsX() {
            //Given
            char[][] board1 = {{'X', 'X', 'X'}, {'O', ' ', 'O'}, {' ', ' ', ' '}};
            char[][] board2 = {{'O', 'O', ' '}, {'X', 'X', 'X'}, {' ', ' ', ' '}};
            char[][] board3 = {{'O', 'O', ' '}, {'O', ' ', 'O'}, {'X', 'X', 'X'}};

            //When & Then
            Assertions.assertTrue(winnerX(board1));
            Assertions.assertTrue(winnerX(board2));
            Assertions.assertTrue(winnerX(board3));
        }

        @Test
        void testWinsColumnsX() {
            //Given
            char[][] board1 = {{'X', 'O', 'O'}, {'X', ' ', 'O'}, {'X', ' ', ' '}};
            char[][] board2 = {{'O', 'X', ' '}, {'O', 'X', 'X'}, {' ', 'X', ' '}};
            char[][] board3 = {{'O', 'O', 'X'}, {'X', ' ', 'X'}, {' ', 'O', 'X'}};

            //When & Then
            Assertions.assertTrue(winnerX(board1));
            Assertions.assertTrue(winnerX(board2));
            Assertions.assertTrue(winnerX(board3));
        }

        @Test
        void testWinsDiagonalsX() {
            //Given
            char[][] board1 = {{'X', 'O', ' '}, {'O', 'X', 'O'}, {'X', ' ', 'X'}};
            char[][] board2 = {{'O', 'X', 'X'}, {'O', 'X', 'O'}, {'X', ' ', ' '}};

            //When & Then
            Assertions.assertTrue(winnerX(board1));
            Assertions.assertTrue(winnerX(board2));
        }
    }

    @Nested
    @DisplayName("Test tie game")
    class TestTieCondition {

        @Test
        void testTie() {
            //Given
            Game game = new Game();
            char[][] board1 = {{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'O', 'X', 'X'}};
            char[][] board2 = {{'O', 'X', 'O'}, {'O', 'X', 'X'}, {'X', 'O', 'O'}};

            //When & Then
            Assertions.assertTrue(endOfTheGame(board1,game));
            Assertions.assertTrue(endOfTheGame(board2,game));
        }
    }

    @Nested
    @DisplayName("Test correct movement")
    class TestCorrectMovement {
        @Test
        void testMovement() {
            //Given
            Game game = new Game();
            char[][] board = {{'X', 'O', 'X'}, {'X', 'O', 'O'}, {'O', 'X', 'X'}};

            //When & Then
            Assertions.assertFalse(correctMovement(board, 1));

        }
    }

}
