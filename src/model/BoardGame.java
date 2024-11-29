package model;

import controller.UserInteraction;
import view.View;

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

    public void play() {
        View view = new View();
        UserInteraction userInteraction = new UserInteraction();
        EndGameVerification endGameVerification = new EndGameVerification(board, rows, cols);

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

            if (!(endGameVerification.isDraw() || endGameVerification.isOver())) {
                changeCurrentPlayer(); // Changement de joueur si le jeu continue
            }
        } while (!(endGameVerification.isDraw() || endGameVerification.isOver()));

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


    // Méthode pour vérifier si le jeu est terminé








    // Vérifie si toutes les cellules d'une ligne/colonne/diagonale sont identiques


}