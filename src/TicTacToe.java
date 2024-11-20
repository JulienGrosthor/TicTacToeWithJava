import java.util.Scanner;

public class TicTacToe {

    private final int size = 3; // Taille du plateau de jeu
    private Cell[][] board; // Plateau de jeu en 2D.
    private Player player1; // Le joueur 1.
    private Player player2; // Le joueur 2.
    private Player currentPlayer; // Le joueur actuel.

    Scanner scanner = new Scanner(System.in);


    // Constructeur pour initialiser le plateau de jeu et les joueurs
    public TicTacToe() {
        initBoard();
        initPlayers();
    }

    private void initPlayers() {

        View view = new View();

        // Config joueur 1
        view.playerOneChoice();
        String input1 = scanner.nextLine();
        this.player1 = input1.equalsIgnoreCase("yay")
                ? new HumanPlayer(" X ")
                : new ArtificialPlayer(" X ");

        // Config joueur 2
        view.playerTwoChoice();
        String input2 = scanner.nextLine();
        this.player2 = input2.equalsIgnoreCase("yay")
                ? new HumanPlayer(" O ")
                : new ArtificialPlayer(" O ");

        this.currentPlayer = this.player1; // On commence toujours par le joueur 1.
    }

    // Méthode pour initier le tableau de jeu
    private void initBoard() {
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell(); // Initialisation des cellules
            }
        }
    }

    // Méthode pour jouer à tour de rôle.
    public void play() {

        View view = new View();

        // Tant que le jeu n'est pas terminé
        do {
            // Afficher le plateau
            display();

            // Demander le coup du joueur actuel.
            view.playerMoveChoice(currentPlayer);

            int[] move = getMoveFromPlayer(this.currentPlayer);

            // Marquer la case avec le symbole du joueur actuel.
            cellEmpty(move);

            if (!(isDraw() || isOver(this.board))) {
                changeCurrentPlayer();
            }

        } while (!(isDraw() || isOver(this.board)));

        display();
        view.victoryText();
    }

    private void changeCurrentPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void cellEmpty(int[] move) {

        View view = new View();

        if (board[move[0]][move[1]].getRepresentation().equals("   ")) {

            board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
            // Changer de joueur après chaque coup

        } else {
            view.cellTaken();
        }
    }

    public int[] getMoveFromPlayer(Player player) {

        return player.makeMove(this.board);
    }

    // Méthode pour vérifier si le jeu est à égalité
    private boolean isDraw() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
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
        for (int i = 0; i < this.size; i++) {
            if (areAllCellsEqual(board[i])) {
                return true;
            }
        }
        return false;
    }

    private boolean verifyCols(Cell[][] board) {
        for (int i = 0; i < this.size; i++) {
            if (areAllCellsEqual(getColumn(i, board))) {
                return true;
            }
        }
        return false;
    }

    // Vérifie si toutes les cellules d'une ligne/colonne/diagonale sont identiques
    private boolean areAllCellsEqual(Cell[] cells) {
        String first = cells[0].getRepresentation();
        if (first.isBlank()) {
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
        Cell[] column = new Cell[size];
        for (int i = 0; i < size; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }

    // Retourne la diagonale principale (de haut-gauche à bas-droite)
    private Cell[] getPrimaryDiagonal(Cell[][] board) {
        Cell[] diagonal = new Cell[this.size];
        for (int i = 0; i < this.size; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    // Retourne la diagonale secondaire (de haut-droite à bas-gauche)
    private Cell[] getSecondaryDiagonal(Cell[][] board) {
        Cell[] diagonal = new Cell[size];
        for (int i = 0; i < size; i++) {
            diagonal[i] = board[i][size - 1 - i];
        }
        return diagonal;
    }

    // Méthode pour afficher le plateau de jeu
    public void display() {

        View view = new View();

        view.displayBanner();
        view.displayBoard(this.board, this.size);
    }

}