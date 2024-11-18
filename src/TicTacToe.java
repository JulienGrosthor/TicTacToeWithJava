public class TicTacToe {

    private static final int SIZE = 3; // Taille du plateau de jeu de morpion.
    private Cell[][] board; // Plateau de jeu en deux dimensions.
    private Player player; // Le joueur actif.

    // Constructeur pour initialiser le plateau et le joueur.
    public TicTacToe() {
        board = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = new Cell(); // Initialisation des cellules
            }
        }
        player = new Player(" X "); // Initialisation du joueur par défaut.
    }

    /**
     * Affiche le plateau de jeu dans la console.
     */
    public void display() {
        for (int i = 0; i < SIZE; i++) {
            // Ligne supérieure (bordure horizontale)
            System.out.println("-------------");

            // Ligne des cellules avec bordures verticales
            System.out.print("|");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j].getRepresentation() + "|");
            }
            System.out.println(); // Nouvelle ligne après les cellules
        }
        // Ligne inférieure finale
        System.out.println("-------------");
    }
}
