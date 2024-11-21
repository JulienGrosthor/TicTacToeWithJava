import java.util.Random;

/**
 * Classe représentant un joueur artificiel pour le jeu de Tic Tac Toe.
 * Le joueur effectue ses coups de manière aléatoire.
 */
public class ArtificialPlayer extends Player {
    public ArtificialPlayer(String representation) {
        super(representation);
    }

    /**
     * Génère un coup aléatoire sur le plateau de jeu.
     *
     * @param board Le plateau de jeu actuel.
     * @return Un tableau contenant les coordonnées de la case choisie (ligne, colonne).
     */
    @Override
    public int[] makeMove(Cell[][] board) {
        Random random = new Random();
        int row, col;

        do {
            row = random.nextInt(3); // Génère un index entre 0 et 2
            col = random.nextInt(3);
        } while (!board[row][col].getRepresentation().equals("   ")); // Vérifie que la case est vide

        return new int[]{row, col};
    }
}
