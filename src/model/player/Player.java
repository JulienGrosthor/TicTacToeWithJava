package model.player;

import model.board.Cell;

public abstract class Player {

    private final String representation;

    public Player(String representation) {
        this.representation = representation;
    }

    public String getRepresentation() {
        return representation;
    }

    public abstract int[] makeMove(Cell[][] board);

}
