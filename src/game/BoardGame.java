package game;

import cell.Cell;
import display.UserInteraction;
import display.View;
import player.Player;

public abstract class BoardGame {

    private final int rows;
    private final int cols;
    private Cell[][] board; // Plateau de jeu en 2D.
    private Player player1; // Le joueur 1.
    private Player player2; // Le joueur 2.
    private Player currentPlayer; // Le joueur actuel.

    public BoardGame(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        initBoard();
    }

    // Méthode pour initier le tableau de jeu
    protected void initBoard() {
        this.board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell(); // Initialisation des cellules
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    protected void initPlayers() {

        View view = new View();
        UserInteraction userInteraction = new UserInteraction();

        // Config joueur 1
        view.playerOneChoice();
        player1 = userInteraction.initPlayerOne();

        // Config joueur 2
        view.playerTwoChoice();
        player2 = userInteraction.initPlayerTwo();

        this.currentPlayer = this.player1; // On commence toujours par le joueur 1.
    }

    /**
     * Permet de jouer à tour de rôle jusqu'à ce qu'il y ait un gagnant ou une égalité.
     * Gère également les changements de joueur et les interactions avec les joueurs.
     */
    public void play() {

        View view = new View();
        UserInteraction userInteraction = new UserInteraction();

        // Tant que le jeu n'est pas terminé
        do {
            // Afficher le plateau
            display();

            // Demander le coup du joueur actuel.
            view.playerMoveChoice(currentPlayer);

//            userInteraction.getPlayerChoice();

            int[] move = getMoveFromPlayer(this.currentPlayer);

            // Marquer la case avec le symbole du joueur actuel.
            cellEmpty(move);

            if (!(isDraw() || isOver(this.board))) {
                changeCurrentPlayer();
            }

        } while (!(isDraw() || isOver(this.board)));

        display();
        view.victoryText();
        System.exit(666);
    }

    protected void changeCurrentPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    /**
     * Affiche le plateau de jeu à chaque étape.
     */
    public void display() {

        View view = new View();

        view.displayBanner();
        view.displayBoard(board, getRows(), getCols());
    }

    private void cellEmpty(int[] move) {

        View view = new View();

        if (board[move[0]][move[1]].getRepresentation().equals("   ")) {

            board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
            // Changer de joueur après chaque coup

        } else { // Rejouer si case déjà prise
            view.cellTaken();
            int[] newMove = getMoveFromPlayer(currentPlayer);
            cellEmpty(newMove);
        }
    }

    /**
     * Récupère le mouvement du joueur actuel.
     *
     * @param player Le joueur qui joue actuellement.
     * @return Un tableau contenant les coordonnées de la case (ligne, colonne).
     */
    public int[] getMoveFromPlayer(Player player) {

        return player.makeMove(this.board);
    }

    // Méthode pour vérifier si le jeu est à égalité
    private boolean isDraw() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (this.board[i][j].getRepresentation().isBlank()) {
                    return false; // Si une cellule est vide, pas de match nul
                }
            }
        }
        return true; // Toutes les cellules sont remplies
    }

    // Méthode pour vérifier si le jeu est terminé
    private boolean isOver(Cell[][] board) {
        return (verifyRows(board) || verifyCols(board) || verifyDiagonals(board));
    }

    private boolean verifyDiagonals(Cell[][] board) {
        return (areAllCellsEqual(getPrimaryDiagonal(board)) || areAllCellsEqual(getSecondaryDiagonal(board)));
    }

    private boolean verifyRows(Cell[][] board) {
        for (int i = 0; i < this.rows; i++) {
            if (areAllCellsEqual(board[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyCols(Cell[][] board) {
        for (int i = 0; i < this.cols; i++) {
            if (areAllCellsEqual(getColumn(i, board))) {
                return true;
            }
        }
        return false;
    }

    // Vérifie si toutes les cellules d'une ligne/colonne/diagonale sont identiques
    private boolean areAllCellsEqual(Cell[] cells) {
        String first = cells[0].getRepresentation();
        if (first == null ||first.isBlank()) {
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
    private Cell[] getColumn(int colIndex, Cell[][] board) {
        Cell[] column = new Cell[cols];
        for (int i = 0; i < cols; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }

    // Retourne la diagonale principale (de haut-gauche à bas-droite)
    private Cell[] getPrimaryDiagonal(Cell[][] board) {
        int size = Math.min(rows, cols);
        Cell[] diagonal = new Cell[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    // Retourne la diagonale secondaire (de haut-droite à bas-gauche)
    private Cell[] getSecondaryDiagonal(Cell[][] board) {
        int size = Math.min(rows, cols);
        Cell[] diagonal = new Cell[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][size - 1 - i];
        }
        return diagonal;
    }
}
