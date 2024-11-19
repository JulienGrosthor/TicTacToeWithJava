public class Cell {

    private String representation;

    // Constructeur pour initialiser la représentation de la cellule
    public Cell() {
        this.representation = "   "; // La cellule est vide au départ
    }

    // Méthode pour obtenir la représentation de la cellule
    public String getRepresentation() {
        return representation;
    }

    // Méthode pour définir la représentation de la cellule (marquer la cellule)
    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}