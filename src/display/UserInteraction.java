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
            view.wrongInput();
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
            view.wrongInput();
            return initPlayerTwo();
        }
    }

//    public void getPlayerChoice() {
//        int choice;
//
//        // Boucle jusqu'à ce que l'utilisateur saisisse un choix valide
//        while (true) {
//            try {
//                choice = Integer.parseInt(scanner.nextLine());
//
//                // Vérifier si l'entrée est valide
//                if (choice == 1 || choice == 2 || choice == 3) {
//                    return;
//                } else {
//                    view.wrongInput();
//                }
//            } catch (NumberFormatException e) {
//                view.wrongInput();
//            }
//        }
//    }

}