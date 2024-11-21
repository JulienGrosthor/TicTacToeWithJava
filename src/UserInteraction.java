import java.util.Scanner;

public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);

    protected Player initPlayerOne() {
        String input1 = scanner.nextLine();
        if (input1.equalsIgnoreCase("yay")) {
            return new HumanPlayer(" X ");
        } else {
            return new ArtificialPlayer(" X ");
        }
    }


    protected Player initPlayerTwo() {
        String input2 = scanner.nextLine();
        if (input2.equalsIgnoreCase("yay")) {
            return new HumanPlayer(" O ");
        } else {
            return new ArtificialPlayer(" O ");
        }
    }
}