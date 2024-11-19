public abstract class Player {

    private String representation;

    // Constructeur pour initialiser la représentation du joueur
    public Player(String representation) {
        this.representation = representation;
    }

    // Getter pour retourner la représentation
    public String getRepresentation() {
        return representation;
    }

    // Méthode abstraite pour jouer un coup
    public abstract int[] makeMove(Cell[][] board);

}
