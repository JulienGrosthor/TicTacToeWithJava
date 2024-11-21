package vue;

import game.Cell;
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
        System.out.println("game.Cell is already taken, please try again.");
    }

    /**
     * Affiche une bannière ASCII pour le jeu.
     */
    public void displayBanner() {
        System.out.println("""
                ╭━━━━╮╱╱╱╭━━━━╮╱╱╱╱╱╭━━━━╮
                ┃╭╮╭╮┃╱╱╱┃╭╮╭╮┃╱╱╱╱╱┃╭╮╭╮┃
                ╰╯┃┃┣╋━━╮╰╯┃┃┣┻━┳━━╮╰╯┃┃┣┻━┳━━╮
                ╱╱┃┃┣┫╭━╯╱╱┃┃┃╭╮┃╭━╯╱╱┃┃┃╭╮┃┃━┫
                ╱╱┃┃┃┃╰━╮╱╱┃┃┃╭╮┃╰━╮╱╱┃┃┃╰╯┃┃━┫
                ╱╱╰╯╰┻━━╯╱╱╰╯╰╯╰┻━━╯╱╱╰╯╰━━┻━━╯
                It's time to dudu du dududududuelll!!""");
    }

    /**
     * Affiche le plateau de jeu avec les symboles actuels.
     *
     * @param board Le plateau de jeu.
     * @param size  La taille du plateau.
     */
    public void displayBoard(Cell[][] board, int size) {
        // Afficher le plateau
        for (int i = 0; i < size; i++) {
            System.out.println("-------------");
            System.out.print("|");
            for (int j = 0; j < size; j++) {
                System.out.print(board[i][j].getRepresentation() + "|");
            }
            System.out.println();
        }
        System.out.println("-------------");
    }

    /**
     * Affiche un message pour demander si le joueur 1 est humain ou artificiel.
     */
    public void playerOneChoice() {
        System.out.println("Is Player.Player 1 (X) a human? (yay/nay)");
    }

    /**
     * Affiche un message pour demander si le joueur 2 est humain ou artificiel.
     */
    public void playerTwoChoice() {
        System.out.println("Is Player.Player 2 (O) a human? (yay/nay)");
    }

    /**
     * Affiche un message pour indiquer une saisie incorrecte.
     */
    public void wrongInput() {
        System.out.println("Wrong input, please try again.");
    }
}