package player;
import cell.Cell;

/**
 * Classe abstraite représentant un joueur de Tic Tac Toe.
 * Les joueurs peuvent être humains ou artificiels.
 */
public abstract class Player {

    private final String representation;

    /**
     * Constructeur pour initialiser un joueur avec un symbole spécifique.
     *
     * @param representation Le symbole du joueur (ex. " X " ou " O ").
     */
    public Player(String representation) {
        this.representation = representation;
    }

    /**
     * Récupère le symbole du joueur.
     *
     * @return Le symbole du joueur.
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * Méthode abstraite permettant à un joueur de jouer un coup.
     *
     * @param board Le plateau de jeu actuel.
     * @return Un tableau contenant les coordonnées de la case choisie (ligne, colonne).
     */
    public abstract int[] makeMove(Cell[][] board);

}
