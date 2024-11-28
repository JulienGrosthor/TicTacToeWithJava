package display;

import player.Player;
import player.HumanPlayer;
import player.ArtificialPlayer;

import java.util.Scanner;

/**
 * Classe responsable des interactions avec les utilisateurs lors de la configuration des joueurs.
 */
public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);
    View view = new View();

    /**
     * Initialise le joueur 1 (humain ou artificiel) selon la saisie de l'utilisateur.
     *
     * @return Un joueur (humain ou artificiel) pour le joueur 1.
     */
    public Player initPlayerOne() {
        String input1 = scanner.nextLine().trim().toLowerCase();
        if (input1.equals("yay")) {
            return new HumanPlayer(" X ");
        } else if (input1.equals("nay")) {
            return new ArtificialPlayer(" X ");
        } else {
            view.wrongInputs();
            return initPlayerOne();
        }
    }

    /**
     * Initialise le joueur 2 (humain ou artificiel) selon la saisie de l'utilisateur.
     *
     * @return Un joueur (humain ou artificiel) pour le joueur 2.
     */
    public Player initPlayerTwo() {
        String input1 = scanner.nextLine().trim().toLowerCase();
        if (input1.equals("yay")) {
            return new HumanPlayer(" O ");
        } else if (input1.equals("nay")) {
            return new ArtificialPlayer(" O ");
        } else {
            view.wrongInputs();
            return initPlayerTwo();
        }
    }

    // Méthode pour lire un entier avec validation
    public int getIntInput() {

        while (!scanner.hasNextInt()) {
            scanner.next(); // Vider le buffer pour ignorer l'entrée incorrecte
            view.wrongInputs();
        }
        return scanner.nextInt();
    }
}