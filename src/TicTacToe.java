import java.util.Scanner;

public class TicTacToe {

    private final int size = 3; // Taille du plateau de jeu
    private Cell[][] board; // Plateau de jeu en 2D.
    private Player player1; // Le joueur 1.
    private Player player2; // Le joueur 2.
    private Player currentPlayer; // Le joueur actuel.
    //    private int player1Score = 0;
//    private int player2Score = 0;
    Scanner scanner = new Scanner(System.in);


    // Constructeur pour initialiser le plateau de jeu et les joueurs
    public TicTacToe() {
        initBoard();
        initPlayers();
    }

    private void initPlayers() {
        // Config joueur 1
        System.out.println("Is Player 1 (X) a human? (yay/nay)");
        String input1 = scanner.nextLine();
        this.player1 = input1.equalsIgnoreCase("yay")
                ? new HumanPlayer(" X ")
                : new ArtificialPlayer(" X ");

        // Config joueur 2
        System.out.println("Is Player 2 (O) a human? (yay/nay)");
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

        // Tant que le jeu n'est pas terminé
        do {
            // Afficher le plateau
            display();

            // Demander le coup du joueur actuel.
            int[] move = getMoveFromPlayer(this.currentPlayer);

            // Marquer la case avec le symbole du joueur actuel.
            cellEmpty(move);

            if (!isOver(this.board) || !isDraw()) {
                changeCurrentPlayer();
            }

        } while (isDraw() || isOver(this.board));

        display();
        System.out.println("WINNER WINNER CHICKEN DINNER!!!");

    }

    private void changeCurrentPlayer() {
        this.currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private void cellEmpty(int[] move) {
        if (board[move[0]][move[1]].getRepresentation().equals("   ")) {

            board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
            // Changer de joueur après chaque coup

        } else {
            System.out.println("Cell is already taken, please try again.");
        }
    }

    public int[] getMoveFromPlayer(Player player) {
//        if (this.currentPlayer instanceof ArtificialPlayer) {
//            // Si le joueur actuel est un joueur artificiel, obtenir un coup automatiquement
//            System.out.println("Bot player plays: ");
//            return currentPlayer.makeMove(board);
//        }
//        return getMoveFromHuman();
        return player.makeMove(this.board);
    }

    // Extraire la logique pour un joueur humain
//    private int[] getMoveFromHuman() {
//        int row;
//        int col;
//
//        while (true) {
//            System.out.print("Player " + currentPlayer.getRepresentation() + ", enter row and column number (between 1 and 3): ");
//            try {
//                row = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0.
//                col = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0.
//
//                if (row >= 0 && row < size && col >= 0 && col < size) {
//                    return new int[]{row, col};
//                } else {
//                    System.out.println("Invalid row or column number. Please enter numbers between 1 and 3.");
//                }
//            } catch (Exception e) {
//                System.out.println("Invalid input. Please enter numbers between 1 and 3.");
//                scanner.nextLine(); // Clear buffer
//            }
//        }
//    }

//    public boolean isWinningMove(int row, int col) {
//        // Vérifier la ligne du dernier coup
//        if (areAllCellsEqual(board[row])) return true;
//
//        // Vérifier la colonne du dernier coup
//        if (areAllCellsEqual(getColumn(col))) return true;
//
//        // Vérifier la diagonale principale si applicable
//        if (row == col && areAllCellsEqual(getPrimaryDiagonal())) return true;
//
//        // Vérifier la diagonale secondaire si applicable
//        if (row + col == size - 1 && areAllCellsEqual(getSecondaryDiagonal())) return true;
//
//        return false;
//    }


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
        displayBanner();
        displayBoard();
    }

    private void displayBoard() {
        // Afficher le plateau
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation() + "|");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    private void displayBanner() {
        System.out.println("""
                ╭━━━━╮╱╱╱╭━━━━╮╱╱╱╱╱╭━━━━╮
                ┃╭╮╭╮┃╱╱╱┃╭╮╭╮┃╱╱╱╱╱┃╭╮╭╮┃
                ╰╯┃┃┣╋━━╮╰╯┃┃┣┻━┳━━╮╰╯┃┃┣┻━┳━━╮
                ╱╱┃┃┣┫╭━╯╱╱┃┃┃╭╮┃╭━╯╱╱┃┃┃╭╮┃┃━┫
                ╱╱┃┃┃┃╰━╮╱╱┃┃┃╭╮┃╰━╮╱╱┃┃┃╰╯┃┃━┫
                ╱╱╰╯╰┻━━╯╱╱╰╯╰╯╰┻━━╯╱╱╰╯╰━━┻━━╯
                It's time to dudu du dududududuelll!!""");
    }
}

