package game;

import cell.Cell;
import display.UserInteraction;
import display.View;
import player.ArtificialPlayer;
import player.HumanPlayer;
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

        do {
            display();

            int[] move;
            if (currentPlayer != null) {
                view.playerMoveChoice(currentPlayer);
                move = getMoveFromPlayer(currentPlayer); // Demande d'input utilisateur
            } else {
                move = currentPlayer.makeMove(board); // IA choisit ses coordonnées
            }

            cellEmpty(move); // Validation et mise à jour du plateau avec les coordonnées

            if (!(isDraw() || isOver(this.board))) {
                changeCurrentPlayer(); // Changement de joueur si le jeu continue
            }
        } while (!(isDraw() || isOver(this.board)));

        display();
        view.finishText();
        Runtime.getRuntime().halt(userInteraction.getIntInput());
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

        // Vérifier si le coup est dans les limites du plateau
        if (!isValidMove(move)) {
            view.wrongInputs(); // Afficher un message d'erreur
            int[] newMove = getMoveFromPlayer(currentPlayer);
            cellEmpty(newMove); // Rejouer
            return;
        }

        // Vérifier si la case est vide
        if (board[move[0]][move[1]].getRepresentation().isBlank()) {
            board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
        } else {
            view.cellTaken(); // Case déjà prise
            int[] newMove = getMoveFromPlayer(currentPlayer);
            cellEmpty(newMove); // Rejouer
        }
    }

    private boolean isValidMove(int[] move) {
        int row = move[0];
        int col = move[1];
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    /**
     * Récupère le mouvement du joueur actuel.
     *
     * @param player Le joueur qui joue actuellement.
     * @return Un tableau contenant les coordonnées de la case (ligne, colonne).
     */
    public int[] getMoveFromPlayer(Player player) {

        UserInteraction userInteraction = new UserInteraction();
        View view = new View();

        int row = -1;
        int col = -1;

        if (player instanceof HumanPlayer) {
        // Lire la ligne
        view.showRowInput();
        row = userInteraction.getIntInput() - 1; // Lecture d'un entier pour la ligne

        // Lire la colonne
        view.showColumnInput();
        col = userInteraction.getIntInput() - 1; // Lecture d'un entier pour la colonne

        return new int[]{row, col};
        } else {
            return player.makeMove(board);
        }
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