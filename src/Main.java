import game.BoardGame;
import game.ConnectFour;
import game.Gomoku;
import game.TicTacToe;

/**
 * Classe principale contenant le point d'entrée du programme.
 * Démarre le jeu de Tic Tac Toe.
 */
public class Main {

    //TEST MORPION
//    public static void main(String[] args) {
//        BoardGame ticTacToe = new TicTacToe();
//        ticTacToe.play();
//    }

    //TEST GOMOKU
    public static void main(String[] args) {
        BoardGame gomoku = new Gomoku();
        gomoku.play();
    }

    //TEST PUISSANCE4
//    public static void main(String[] args) {
//        BoardGame connectFour = new ConnectFour();
//        connectFour.play();
//    }
}