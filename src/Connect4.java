import java.util.Scanner;

public class Connect4 {
    Scanner stdin = new Scanner(System.in);
    //create board
    //second value displayed is going to be red or yellow
    String[][] board = new String[6][7];
    boolean endGame = false;

    public Connect4() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                board[i][j] = "| ";
            }
        }
    }

    public void dispBoard() {
        System.out.println(" 0 1 2 3 4 5 6");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("| \n");
        }
        System.out.print(". . . . . . . . \n");
    }

    //method for testing win conditions
    public boolean win(int row, int col){
        int count = 0;
        // test rows
        for (int i = 1; i < 4; i++) {
            if (col - i < 0)
                break;
            if (board[row][col].equals(board[row][col - i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        for (int i = 1; i < 4; i++) {
            if (col + i > 6)
                break;
            if (board[row][col].equals(board[row][col + i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        if(count >= 3)
            return true;
        //test columns
        count = 0;
        for (int i = 1; i < 4; i++) {
            if (row - i < 0)
                break;
            if (board[row][col].equals(board[row-i][col])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        for (int i = 1; i < 4; i++) {
            if (row + i > 5)
                break;
            if (board[row][col].equals(board[row + i][col])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        if(count >= 3)
            return true;
        // test diagonals
        count = 0;
        for (int i = 1; i < 4; i++) {
            if (row - i < 0 || col + i > 6)
                break;
            if (board[row][col].equals(board[row-i][col+i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        for (int i = 1; i < 4; i++) {
            if (row + i > 5 || col - i < 0)
                break;
            if (board[row][col].equals(board[row + i][col-i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        if(count >= 3)
            return true;
        // test diagonal left to right
        count = 0;
        for (int i = 1; i < 4; i++) {
            if (row + i > 5 || col + i > 6)
                break;
            if (board[row][col].equals(board[row+i][col+i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        for (int i = 1; i < 4; i++) {
            if (row - i < 0 || col - i < 0)
                break;
            if (board[row][col].equals(board[row - i][col-i])) {
                count++;
            } else {
                break;
            }
            if (count >= 3)
                break;
        }
        if(count >= 3)
            return true;
        return false;
    }
}
