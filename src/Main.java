import game.TicTacToe;

/**
 * Classe principale contenant le point d'entrée du programme.
 * Démarre le jeu de Tic Tac Toe.
 */
public class Main {
    /**
     * Point d'entrée principal du programme.
     *
     * @param args Arguments en ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.play();
    }
}
