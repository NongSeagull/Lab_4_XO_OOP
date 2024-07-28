/**
 *
 * @author 65160230 Piyapong
 */

public class Player {
    private char player;

    public Player(){
        this.player = ' ';
    }

    public Player(char symbol) {
        this.player = symbol;
    }

    public char getSymbol() {
        return player;
    }

    @Override
    public String toString() {
        return "Player is : " + player ;
    }
}
