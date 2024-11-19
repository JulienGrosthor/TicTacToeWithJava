import java.util.Scanner;

public class ArtificialPlayer extends Player {

    public ArtificialPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getRepresentation().equals("   ")) { // Cellule vide
                    return new int[]{i, j};
                }
            }
        }
        return null; // Pas de cellule vide (ne devrait pas arriver).
    }
}
