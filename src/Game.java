import java.util.Scanner;

/**
 *
 * @author 65160230 Piyapong
 */

public class Game {
    private int row;
    private int col;
    Scanner kb = new Scanner(System.in);
    private Player O , X;
    private Board board;

    public Game() {
        X = new Player('X');
        O = new Player('O');

    }

    public void play() {
    this.showWelcome();
    newGame(); 
    while (true) {
        System.out.print("Do You Wanna Play ?  (Yes or No) : ");
        char answer = kb.next().charAt(0);

        if (answer == 'n' || answer == 'N') {
            System.out.printf("%-2s%-2s", " ", "---- End Game ----");
            System.out.println();
            break;
        }else{
            this.showWelcome();
            newGame();
        }
    }
}

    public void newGame() {
        board = new Board(X, O);
        while(true){
            this.showTable();
            this.showTurn();
            this.inputRowAndCol();
            if(board.isFinish()){
                if(board.checkWin()){
                    System.out.println("\t\t-- " + board.getCurrentPlayer().getSymbol() + "win --");
                    break;
                }else{
                    System.out.printf("%-2s%-2s", " ", "---- It's a Draw ----");
                    System.out.println();
                    break;
                }
            }else {
                board.switchTurn();
            }
        }
    }

    private void showWelcome() {
        System.out.print("=== Welcome to OX Game ===");
        System.out.println();
    }

    private void showTable() {
        char[][] table = board.getTable();
        for (row = 0; row < table.length; row++) {
            for (col = 0; col < table.length; col++) {
                System.out.printf("%-4s%-2c%-2s", "|", table[row][col], " ");
            }
            System.out.printf("%-2s", "|");
            System.out.println();
        }
    }

    public void inputRowAndCol() {
        while (true) {
            System.out.print("Please Input Row and Column : ");
            row = kb.nextInt() - 1;
            col = kb.nextInt() - 1;
            if (board.setRowCol(row, col)) {
                break;
            }
            System.out.println("this position is already exist, please try again.");
        }
    }

    private void showTurn() {
        System.out.printf("%-2s%-2s", " ", "---- It's " +
                board.getCurrentPlayer().getSymbol() + " turn ----");
        System.out.println();
    }
}
