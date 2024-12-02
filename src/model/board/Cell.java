package model.board;

public class  Cell {

    private String representation;

    public Cell() {
        this.representation = "   "; // La cellule est vide au départ
    }

    public String getRepresentation() {
        return representation;
    }

    public void setRepresentation(String representation) {
        this.representation = representation;
    }
}