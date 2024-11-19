import java.util.Random;

public class ArtificialPlayer extends Player {
    public ArtificialPlayer(String representation) {
        super(representation);
    }

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

//    // Méthode pour obtenir le coup du joueur artificiel
//    public int[] getMove(Cell[][] board) {
//
//    }
}
