package model.games;

public class TicTacToe extends BoardGame {

    public TicTacToe() {
        super(3, 3);
        initPlayers();
        play();
    }
}
