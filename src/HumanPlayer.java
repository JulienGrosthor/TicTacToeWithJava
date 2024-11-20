import java.util.Scanner;

public class HumanPlayer extends Player {

    // Constructeur
    public HumanPlayer(String representation) {
        super(representation);
    }

    // Implémentation de la méthode makeMove.
    @Override
    public int[] makeMove(Cell[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt() -1; // Conversion 1-3 => 0-2
        int col = scanner.nextInt() -1; // Conversion 1-3 => 0-2
        return new int[] {row, col};
    }
}
