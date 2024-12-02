package model.games;

import model.board.Cell;

public class EndGameVerification {
    private final Cell[][] board;
    private final int rows;
    private final int cols;

    public EndGameVerification(Cell[][] board, int rows, int cols) {
        this.board = board;
        this.rows = rows;
        this.cols = cols;
    }
    protected boolean isDraw() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.board[i][j].getRepresentation().isBlank()) {
                    return false; // Si une cellule est vide, pas de match nul
                }
            }
        }
        return true; // Toutes les cellules sont remplies
    }

    protected boolean isOver() {
        return (verifyRows() || verifyCols() || verifyDiagonals());
    }

    private boolean verifyDiagonals() {

        return (areAllCellsEqual(getPrimaryDiagonal()) || areAllCellsEqual(getSecondaryDiagonal()));
    }

    private boolean verifyRows() {
        for (int i = 0; i < this.rows; i++) {
            if (areAllCellsEqual(this.board[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyCols() {
        for (int i = 0; i < this.cols; i++) {
            if (areAllCellsEqual(getColumn(i))) {
                return true;
            }
        }
        return false;
    }

    private boolean areAllCellsEqual(Cell[] cells) {
        String first = cells[0].getRepresentation();
        if (first == null || first.isBlank()) {
            return false; // Case vide : pas de victoire
        }
        for (Cell cell : cells) {
            if (!cell.getRepresentation().equals(first)) {
                return false;
            }
        }
        return true;
    }

    // Retourne une colonne sous forme de tableau
    private Cell[] getColumn(int colIndex) {
        Cell[] column = new Cell[cols];
        for (int i = 0; i < cols; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }

    // Retourne la diagonale principale (de haut-gauche à bas-droite)
    private Cell[] getPrimaryDiagonal() {
        int size = Math.min(rows, cols);
        Cell[] diagonal = new Cell[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    // Retourne la diagonale secondaire (de haut-droite à bas-gauche)
    private Cell[] getSecondaryDiagonal() {
        int size = Math.min(rows, cols);
        Cell[] diagonal = new Cell[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][size - 1 - i];
        }
        return diagonal;
    }

}
