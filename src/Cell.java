/**
 * Classe représentant une cellule du plateau de jeu.
 * Chaque cellule contient une représentation visuelle (vide ou occupée par un joueur).
 */
public class Cell {

    private String representation;

    /**
     * Constructeur par défaut pour initialiser une cellule vide.
     */
    public Cell() {
        this.representation = "   "; // La cellule est vide au départ
    }

    /**
     * Récupère la représentation actuelle de la cellule.
     *
     * @return La chaîne de caractères représentant la cellule.
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * Met à jour la représentation de la cellule.
     *
     * @param representation La nouvelle représentation de la cellule.
     */
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}