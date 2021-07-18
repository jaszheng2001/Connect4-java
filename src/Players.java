import java.util.Scanner;

public class Players {
    private Connect4 connect4;
    private Scanner stdin = new Scanner(System.in);

    public Players(Connect4 connect4) {
        this.connect4 = connect4;
    }

    public void p1() {
        System.out.print("Player 1's Turn, Enter a column: ");
        boolean valid = false;
        int j = 0;
        int col = 0;
        while (!valid) {
            col = stdin.nextInt();
            if(col > 6 || col < 0){
                System.out.print("Player 1, Invalid input, try again: ");
                continue;
            }
            for (j = 5; j > 0; j--) {
                if (connect4.board[j][col].charAt(1) == ' ') {
                    break;
                }
            }
            if (j == 0 && connect4.board[0][col].charAt(1) != ' ') {
                System.out.print("Player 1, Column is Full, try again: ");
            } else {
                connect4.board[j][col] = "|R";
                valid = true;
            }
        }
        connect4.dispBoard();
        if (connect4.win(j,col)) {
            System.out.println("Player 1 wins!");
            connect4.endGame = true;
        }
    }

    public void p2() {
        System.out.print("Player 2's Turn, Enter a column: ");
        boolean valid = false;
        int col2 = 0;
        int k = 0;
        while (!valid) {
            col2 = stdin.nextInt();
            if(col2 > 6 || col2 < 0){
                System.out.print("Player 2, Invalid input, try again: ");
                continue;
            }
            for (k = 5; k > 0; k--) {
                if (connect4.board[k][col2].charAt(1) == ' ') {
                    break;
                }
            }
            if (k == 0 && connect4.board[0][col2].charAt(1) != ' ') {
                System.out.print("Player 2, Column is Full, try again: ");
            } else {
                connect4.board[k][col2] = "|Y";
                valid = true;
            }
        }
        connect4.dispBoard();
        if (connect4.win(k,col2)) {
            System.out.println("Player 2 wins!");
            connect4.endGame = true;
        }
    }
}
