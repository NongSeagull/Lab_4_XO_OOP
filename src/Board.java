
/**
 *
 * @author 65160230 Piyapong
 */

public class Board {
    private char[][] table =
    {{'-', '-', '-'},
    {'-', '-', '-'},
    {'-', '-', '-'}};
    private Player p1;
    private Player p2;
    private Player currentPlayer;
    private int count = 0;
    private int row;
    private int col;
            
    public Board(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        if(Math.random()<0.5){
            currentPlayer = p1;
        }else{
            currentPlayer = p2;
        }
    }

    public char[][] getTable() {
        return table;
    }

    public void setTable(char[][] table) {
        this.table = table;
    }

    public Player getP1() {
        return p1;
    }

    public void setP1(Player p1) {
        this.p1 = p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setP2(Player p2) {
        this.p2 = p2;
    }

    public boolean setRowCol(int row, int col){
        if(table[row][col] != '-') {
            return false;
        }else{
            table[row][col] = currentPlayer.getSymbol();
            count++;
            this.row = row;
            this.col = col;
            return true;
        }
    }
    
    public void switchTurn(){
        if(currentPlayer == p1){
            currentPlayer = p2;
        }else{
            currentPlayer = p1;
        }
    }

    public boolean isFinish() {
        if(checkWin()){
            return true;
        }
        if(checkDraw()){
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        if(checkRowWin()){
            return true;
        }
        if(checkColWin()){
            return true;
        }
        if(checkDiagonalWin()){
            return true;
        }
        return false;
    }
    
    public boolean checkDraw(){
        if (count == 9){
            return true;
        }
        return false;
    }
    
    public boolean checkRowWin(){
        if(table[row][0] == currentPlayer.getSymbol() && table[row][1] == currentPlayer.getSymbol() && table[row][2] == currentPlayer.getSymbol()){
            return true;
        }
        return false;
    }
    public boolean checkColWin(){
        if(table[0][col] == currentPlayer.getSymbol() && table[1][col] == currentPlayer.getSymbol() && table[2][col] == currentPlayer.getSymbol()){
            return true;
        }
        return false;
    }
    
    public boolean checkDiagonalWin(){
        if(checkDiagonalPattern1Win()){
            return true;
        }
        if(checkDiagonalPattern2Win()){
            return true;
        }
        return false;
    }
    
    public boolean checkDiagonalPattern1Win(){
        if(table[0][0] == currentPlayer.getSymbol() && table[1][1] == currentPlayer.getSymbol() && table[2][2] == currentPlayer.getSymbol()){
            return true;
        }
        return false;
    }
    public boolean checkDiagonalPattern2Win(){
        if(table[2][2] == currentPlayer.getSymbol() && table[1][1] == currentPlayer.getSymbol() && table[0][0] == currentPlayer.getSymbol()){
            return true;
        }
        return false;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    
}
