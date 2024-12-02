package model.player;

import model.board.Cell;

import java.util.Scanner;

public class HumanPlayer extends Player {

    public HumanPlayer(String representation) {
        super(representation);
    }

    @Override
    public int[] makeMove(Cell[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt() - 1; // Conversion 1-3 => 0-2
        int col = scanner.nextInt() - 1; // Conversion 1-3 => 0-2
        return new int[]{row, col};
    }
}
