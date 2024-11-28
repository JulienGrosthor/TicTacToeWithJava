import display.UserInteraction;
import game.BoardGame;
import game.ConnectFour;
import game.Gomoku;
import game.TicTacToe;

/**
 * Classe principale contenant le point d'entrée du programme.
 * Démarre le jeu de Tic Tac Toe.
 */
public class Main {

    public static void main(String[] args) {

        UserInteraction userInteraction = new UserInteraction();
        BoardGame game = userInteraction.playerMenu();

        game.play();
    }
}