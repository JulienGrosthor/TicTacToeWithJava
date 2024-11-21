public class View {

    public void victoryText() {
        System.out.println("WINNER WINNER CHICKEN DINNER!!!");
    }

    public void playerMoveChoice(Player currentPlayer) {
        System.out.println("Player " + currentPlayer.getRepresentation() + ", enter row + ENTER, then column + ENTER (between 1 and 3): ");
    }

    public void cellTaken() {
        System.out.println("Cell is already taken, please try again.");
    }

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

    public void playerOneChoice() {
        System.out.println("Is Player 1 (X) a human? (yay/nay)");
    }

    public void playerTwoChoice() {
        System.out.println("Is Player 2 (O) a human? (yay/nay)");
    }

}
