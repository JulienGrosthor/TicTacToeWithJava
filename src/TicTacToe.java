import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3; // Taille du plateau de jeu
    private Cell[][] board; // Plateau de jeu

    // Constructeur pour initialiser le plateau de jeu
    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialisation des cellules
            }
        }
    }

    // Méthode pour afficher le plateau de jeu et gérer les interactions avec le joueur
    public void display() {
        // Afficher le plateau et demander un mouvement jusqu'à ce que la partie soit terminée
        while (true) {
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

            // Obtenir le coup du joueur
            int[] move = getMoveFromPlayer();

            // Marquer la case avec "X"
            if (board[move[0]][move[1]].getRepresentation().equals("   ")) {
                board[move[0]][move[1]].setRepresentation(" X "); // Le joueur joue "X"
            } else {
                System.out.println("Cell is already taken, try again.");
                continue; // Si la case est déjà prise, on demande à nouveau un mouvement
            }
        }
    }

    // Méthode pour obtenir le coup du joueur
    public int[] getMoveFromPlayer() {
        Scanner scanner = new Scanner(System.in);
        int row = -1, col = -1;

        while (true) {
            System.out.print("Enter row and column number (between 1 and 3): ");
            try {
                row = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0
                col = scanner.nextInt() - 1; // Décrémenter pour que les indices commencent à 0

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
}
