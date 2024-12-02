import controller.UserInteraction;
import model.games.BoardGame;

public class Main {

    public static void main(String[] args) {

        UserInteraction userInteraction = new UserInteraction();
        BoardGame game = userInteraction.playerMenu();

        game.play();
    }
}