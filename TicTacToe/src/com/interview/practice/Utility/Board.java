package com.interview.practice.Utility;

import com.interview.practice.CommonEnum.Symbol;
import com.interview.practice.GameStateHandler.Context.GameContext;

// Board Representation
    public class Board {
        private final int rows;
        private final int columns;
        private Symbol[][] grid;
        public Board(int rows, int columns) {
            this.rows = rows;
            this.columns = columns;
            grid = new Symbol[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    grid[i][j] = Symbol.EMPTY;
                }
            }
        }
        // Checks if a given position is within the bounds of the board.
        public boolean isValidMove(Position pos) {
            return pos.row >= 0 && pos.row < rows && pos.col >= 0 && pos.col < columns
                    && grid[pos.row][pos.col] == Symbol.EMPTY;
        }
        // Allows players to make their moves
        public void makeMove(Position pos, Symbol symbol) {
            grid[pos.row][pos.col] = symbol;
        }
        // Determines the current state of the game by checking for
        // Rows, Columns and Diagonals for winning conditions
        public void checkGameState(GameContext context, Player currentPlayer) {

            // Check rows
            for (int row = 0; row < rows; row++) {
                if (isRowWinning(row)) {
                    context.next(currentPlayer, true);
                    return;
                }
            }

            // Check columns
            for (int column = 0; column < columns; column++) {
                if (isColumnWinning(column)) {
                    context.next(currentPlayer, true);
                    return;
                }
            }

            // Check diagonals
            if (isMainDiagonalWinning() || isAntiDiagonalWinning()) {
                context.next(currentPlayer, true);
                return;
            }

            // TODO: Check draw / game in progress
        }

    private boolean isRowWinning(int row) {

        if (grid[row][0] == Symbol.EMPTY) {
            return false;
        }

        Symbol first = grid[row][0];

        for (int column = 1; column < columns; column++) {
            if (grid[row][column] != first) {
                return false;
            }
        }

        return true;
    }

    private boolean isColumnWinning(int column) {

        if (grid[0][column] == Symbol.EMPTY) {
            return false;
        }

        Symbol first = grid[0][column];

        for (int row = 1; row < rows; row++) {
            if (grid[row][column] != first) {
                return false;
            }
        }

        return true;
    }

    private boolean isMainDiagonalWinning() {

        int size = Math.min(rows, columns);

        if (grid[0][0] == Symbol.EMPTY) {
            return false;
        }

        Symbol first = grid[0][0];

        for (int i = 1; i < size; i++) {
            if (grid[i][i] != first) {
                return false;
            }
        }

        return true;
    }

    private boolean isAntiDiagonalWinning() {

        int size = Math.min(rows, columns);

        if (grid[0][columns - 1] == Symbol.EMPTY) {
            return false;
        }

        Symbol first = grid[0][columns - 1];

        for (int i = 1; i < size; i++) {
            if (grid[i][columns - 1 - i] != first) {
                return false;
            }
        }

        return true;
    }
}
