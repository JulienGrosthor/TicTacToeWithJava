import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3; // Taille du plateau de jeu
    private Cell[][] board; // Plateau de jeu en 2D.
    private Player player1; // Le joueur 1.
    private Player player2; // Le joueur 2.
    private Player currentPlayer; // Le joueur actuel.

    // Constructeur pour initialiser le plateau de jeu et les joueurs
    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialisation des cellules
            }
        }

        // Initialisation des joueurs
        player1 = new Player(" X ");
        player2 = new Player(" O ");
        currentPlayer = player1;
    }

    // Méthode pour jouer à tour de rôle.
    public void play() {

        int turns = 0; // compteur pour savoir combien de coups ont été joués.

        // Tant que le jeu n'est pas terminé
        while (!isOver() && turns < SIZE * SIZE) {
            // Afficher le plateau
            display();

            // Demander le coup du joueur actuel.
            int[] move = getMoveFromPlayer();

            // Marquer la case avec le symbole du joueur actuel.
            if (board[move[0]][move[1]].getRepresentation().equals("   ")) {
                board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
                turns++;

                // Vérifier si le jeu est terminé après le coup
                if (isOver()) {
                    display(); // Afficher le plateau final
                    System.out.println("Player " + currentPlayer.getRepresentation() + " wins!");
                    return;
                }

                // Changer de joueur après chaque coup
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("Cell is already taken, please try again.");
            }
        }

        // Si toutes les cases sont remplies sans gagnant
        if (!isOver()) {
            display();
            System.out.println("It's a draw! The game is over.");
        }
    }

    // Méthode pour obtenir le coup du joueur
    public int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row;
        int col;

        while (true) {
            System.out.print("Player " + currentPlayer.getRepresentation() + ", enter row and column number (between 1 and 3): ");
            try {
                row = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0.
                col = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0.

                if (row >= 0 && row < SIZE && col >= 0 && col < SIZE) {
                    return new int[]{row, col};
                } else {
                    System.out.println("Invalid row or column number. Please enter numbers between 1 and 3.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter numbers between 1 and 3.");
                scanner.nextLine(); // Clear buffer
            }
        }
    }

    // Méthode pour vérifier si le jeu est terminé
    public boolean isOver() {
        // Vérifier toutes les lignes
        for (int i = 0; i < SIZE; i++) {
            if (areAllCellsEqual(board[i])) {
                return true;
            }
        }

        // Vérifier toutes les colonnes
        for (int i = 0; i < SIZE; i++) {
            if (areAllCellsEqual(getColumn(i))) {
                return true;
            }
        }

        // Vérifier les deux diagonales
        if (areAllCellsEqual(getPrimaryDiagonal()) || areAllCellsEqual(getSecondaryDiagonal())) {
            return true;
        }

        // Si aucune condition n'est remplie
        return false;
    }

    // Vérifie si toutes les cellules d'une ligne/colonne/diagonale sont identiques
    private boolean areAllCellsEqual(Cell[] cells) {
        String first = cells[0].getRepresentation();
        if (first.equals("   ")) return false; // Case vide : pas de victoire
        for (Cell cell : cells) {
            if (!cell.getRepresentation().equals(first)) {
                return false;
            }
        }
        return true;
    }

    // Retourne une colonne sous forme de tableau
    private Cell[] getColumn(int colIndex) {
        Cell[] column = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            column[i] = board[i][colIndex];
        }
        return column;
    }

    // Retourne la diagonale principale (de haut-gauche à bas-droite)
    private Cell[] getPrimaryDiagonal() {
        Cell[] diagonal = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            diagonal[i] = board[i][i];
        }
        return diagonal;
    }

    // Retourne la diagonale secondaire (de haut-droite à bas-gauche)
    private Cell[] getSecondaryDiagonal() {
        Cell[] diagonal = new Cell[SIZE];
        for (int i = 0; i < SIZE; i++) {
            diagonal[i] = board[i][SIZE - 1 - i];
        }
        return diagonal;
    }

    // Méthode pour afficher le plateau de jeu
    public void display() {

        System.out.println("""
                ╭━━━━╮╱╱╱╭━━━━╮╱╱╱╱╱╭━━━━╮
                ┃╭╮╭╮┃╱╱╱┃╭╮╭╮┃╱╱╱╱╱┃╭╮╭╮┃
                ╰╯┃┃┣╋━━╮╰╯┃┃┣┻━┳━━╮╰╯┃┃┣┻━┳━━╮
                ╱╱┃┃┣┫╭━╯╱╱┃┃┃╭╮┃╭━╯╱╱┃┃┃╭╮┃┃━┫
                ╱╱┃┃┃┃╰━╮╱╱┃┃┃╭╮┃╰━╮╱╱┃┃┃╰╯┃┃━┫
                ╱╱╰╯╰┻━━╯╱╱╰╯╰╯╰┻━━╯╱╱╰╯╰━━┻━━╯
                It's time to dudu du dududududuelll!!""");

        // Afficher le plateau
        for (int i = 0; i < SIZE; i++) {
            System.out.println("-------------");
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation() + "|");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }
}
