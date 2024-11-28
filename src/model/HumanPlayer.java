package model;

import java.util.Scanner;

/**
 * Classe représentant un joueur humain pour le jeu de Tic Tac Toe.
 * Le joueur entre ses coordonnées manuellement.
 */
public class HumanPlayer extends Player {

    /**
     * Constructeur pour initialiser un joueur humain avec un symbole spécifique.
     *
     * @param representation Le symbole du joueur humain (ex. " X " ou " O ").
     */
    public HumanPlayer(String representation) {
        super(representation);
    }

    /**
     * Permet au joueur humain de choisir une case en entrant les coordonnées.
     *
     * @param board Le plateau de jeu actuel.
     * @return Un tableau contenant les coordonnées de la case choisie (ligne, colonne).
     */
    @Override
    public int[] makeMove(Cell[][] board) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt() - 1; // Conversion 1-3 => 0-2
        int col = scanner.nextInt() - 1; // Conversion 1-3 => 0-2
        return new int[]{row, col};
    }
}
