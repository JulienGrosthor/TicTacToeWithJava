package display;

import game.BoardGame;
import game.ConnectFour;
import game.Gomoku;
import game.TicTacToe;
import player.Player;
import player.HumanPlayer;
import player.ArtificialPlayer;

import java.util.Scanner;

public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);
    View view = new View();

    public BoardGame playerMenu() {
        while (true) {
            view.showMenu();

            int choice = getIntInput();

            switch (choice) {
                case 1:
                    return new TicTacToe();
                case 2:
                    return new ConnectFour();
                case 3:
                    return new Gomoku();
                case 4:
                    view.okBye();
                    System.exit(0);
                default:
                    view.wrongInputs();
            }
        }
    }

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