package view;

import model.Cell;
import model.Player;

public class View {

    public void showMenu() {
        System.out.println("""
                    CHOOSE YOUR GAME:\s
                    1) TicTacToe\s
                    2) Connect Four\s
                    3) Gomoku\s
                    4) QUIT
                    """);
    }

    public void okBye() {
        System.out.println("Ok bye!");
    }

    public void finishText() {
        System.out.println("GAME OVER");
    }

//    public void drawText() {
//        System.out.println("It's a draw!");
//    }

    public void playerMoveChoice(Player currentPlayer) {
        System.out.println("player " + currentPlayer.getRepresentation() + ", enter row + ENTER, then column + ENTER (between 1 and 3): ");
    }

    public void cellTaken() {
        System.out.println("Cell is already taken, please try again.");
    }

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

    public void playerOneChoice() {
        System.out.println("Is Player 1 (X) a human? (yay/nay)");
    }

    public void playerTwoChoice() {
        System.out.println("Is Player 2 (O) a human? (yay/nay)");
    }

    public void wrongInputs() {
        System.out.println("Wrong input(s), please try again.");
    }

    public void showRowInput() {
        System.out.println("Enter row:");
    }

    public void showColumnInput() {
        System.out.println("Enter column:");
    }
}