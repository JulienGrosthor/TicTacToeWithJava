package game;

public class Gomoku extends BoardGame {

    public Gomoku() {
        super(15, 15);
        initPlayers();
        play();
        changeCurrentPlayer();
    }
}