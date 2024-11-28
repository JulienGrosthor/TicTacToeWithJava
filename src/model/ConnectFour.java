package model;

public class ConnectFour extends BoardGame{

    public ConnectFour() {
        super(6, 7);
        initPlayers();
        play();
    }
}
