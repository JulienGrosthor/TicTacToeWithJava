import java.util.Scanner;

public class UserInteraction {

    private final Scanner scanner = new Scanner(System.in);

    private void initPlayerOne(Player player1) {
        String input1 = scanner.nextLine();
        player1 = input1.equalsIgnoreCase("yay")
                ? new HumanPlayer(" X ")
                : new ArtificialPlayer(" X ");
    }

    private void initPlayerTwo(Player player2) {
        String input2 = scanner.nextLine();
        player2 = input2.equalsIgnoreCase("yay")
                ? new HumanPlayer(" X ")
                : new ArtificialPlayer(" X ");
    }
}