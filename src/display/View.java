package display;

import cell.Cell;
import player.Player;

/**
 * Classe responsable de l'affichage des messages et du plateau de jeu.
 * Elle centralise toutes les interactions visuelles.
 */
public class View {

    /**
     * Affiche un message de victoire.
     */
    public void victoryText() {
        System.out.println("WINNER WINNER CHICKEN DINNER!!!");
    }

    public void drawText() {
        System.out.println("It's a draw!");
    }

    /**
     * Affiche un message pour demander au joueur actuel de jouer.
     *
     * @param currentPlayer Le joueur dont c'est le tour.
     */
    public void playerMoveChoice(Player currentPlayer) {
        System.out.println("player " + currentPlayer.getRepresentation() + ", enter row + ENTER, then column + ENTER (between 1 and 3): ");
    }

    /**
     * Affiche un message lorsque la cellule choisie est déjà prise.
     */
    public void cellTaken() {
        System.out.println("cell.Cell is already taken, please try again.");
    }

    /**
     * Affiche une bannière ASCII pour le jeu.
     */
    public void displayBanner() {
        System.out.println("""
                  ________                              ___________.__               \s
                 /  _____/_____    _____   ____         \\__    ___/|__| _____   ____ \s
                /   \\  ___\\__  \\  /     \\_/ __ \\   ______ |    |   |  |/     \\_/ __ \\\s
                \\    \\_\\  \\/ __ \\|  Y Y  \\  ___/  /_____/ |    |   |  |  Y Y  \\  ___/\s
                 \\______  (____  /__|_|  /\\___  >         |____|   |__|__|_|  /\\___  >
                        \\/     \\/      \\/     \\/                            \\/     \\/\s
                """);
    }

    public void displayBoard(Cell[][] board, int rows, int cols) {
        String separator = "-".repeat(cols * 4 + 1);

        // Afficher le plateau
        for (int i = 0; i < rows; i++) {
            System.out.println(separator);
            System.out.print("|");
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j].getRepresentation() + "|");
            }
            System.out.println();
        }
        System.out.println(separator);
    }

    /**
     * Affiche un message pour demander si le joueur 1 est humain ou artificiel.
     */
    public void playerOneChoice() {
        System.out.println("Is Player 1 (X) a human? (yay/nay)");
    }

    /**
     * Affiche un message pour demander si le joueur 2 est humain ou artificiel.
     */
    public void playerTwoChoice() {
        System.out.println("Is Player 2 (O) a human? (yay/nay)");
    }

    /**
     * Affiche un message pour indiquer une saisie incorrecte.
     */
    public void wrongInput() {
        System.out.println("Wrong input, please try again.");
    }
}