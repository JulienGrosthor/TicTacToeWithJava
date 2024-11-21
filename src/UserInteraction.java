import java.util.Scanner;

public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);
    View view = new View();

    protected Player initPlayerOne() {
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

    protected Player initPlayerTwo() {
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
}