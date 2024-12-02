package model.player;


import model.board.Cell;

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
            row = random.nextInt(board.length); // Taille dynamique
            col = random.nextInt(board[0].length);
        } while (!board[row][col].getRepresentation().equals("   "));
        return new int[]{row, col};
    }

}