import java.util.Scanner;

public class TicTacToe {

    private static final int SIZE = 3; // Taille du plateau de jeu
    private Cell[][] board; // Plateau de jeu
    private Player player1; // Le joueur 1 (X).
    private Player player2; // Le joueur 2 (O).
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
        player2 = new Player(" O");
        currentPlayer = player1;
    }

    // Méthode pour jouer à tour de rôle.
    public void play() {
        int turns = 0; // compteur pour savoir combien de coups ont été joués.

        // Tant que le plateau n'est pas plein (avec les 9 cases remplies donc).
        while (turns < SIZE * SIZE) {
            // Afficher le plateau
            display();

            // Demander le coup du joueur actuel.
            int[] move = getMoveFromPlayer();

            // Marquer la case avec le symbole du joueur actuel.
            if (board[move[0]][move[1]].getRepresentation().equals("   ")) {
                board[move[0]][move[1]].setRepresentation(currentPlayer.getRepresentation());
                turns++;

                // Si toutes les cases sont remplies, le jeu se termine.
                if (turns == SIZE * SIZE) {
                    display(); // Plateau final.
                    System.out.println("All cells are filled in, the game is over");
                    break;
                }

                // Changer de joueur après chaque coup
                currentPlayer = (currentPlayer == player1) ? player2 : player1;
            } else {
                System.out.println("CELL IS ALREADY TAKEN, PLEASE TRY AGAIN.");
            }
        }
    }

    // Méthode pour afficher le plateau de jeu
    public void display() {

        System.out.println("\n" +
                "\n" +
                "╭━━━━╮╱╱╱╭━━━━╮╱╱╱╱╱╭━━━━╮\n" +
                "┃╭╮╭╮┃╱╱╱┃╭╮╭╮┃╱╱╱╱╱┃╭╮╭╮┃\n" +
                "╰╯┃┃┣╋━━╮╰╯┃┃┣┻━┳━━╮╰╯┃┃┣┻━┳━━╮\n" +
                "╱╱┃┃┣┫╭━╯╱╱┃┃┃╭╮┃╭━╯╱╱┃┃┃╭╮┃┃━┫\n" +
                "╱╱┃┃┃┃╰━╮╱╱┃┃┃╭╮┃╰━╮╱╱┃┃┃╰╯┃┃━┫\n" +
                "╱╱╰╯╰┻━━╯╱╱╰╯╰╯╰┻━━╯╱╱╰╯╰━━┻━━╯\n" +
                "It's time to dudu du dududududuelll!!");

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
}
