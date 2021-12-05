import java.util.ArrayList;

public class Board {
    private int[][] board = new int[5][5];
    private boolean[][] visited = new boolean[5][5];
    public int lastCard = -1; 
    
    // null constructor: creates an empty board
    public Board() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = 0;
            }
        }
    }

    public Board(ArrayList<String> lines) {
        for (int i = 0; i < 5; i++) {
            String[] line = lines.get(i).trim().split("\\s+");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(line[j]);
            }
        }
    }

    public void checkBoard(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    visited[i][j] = true;
                    // return true;
                }
            }
        }
        // return false;
    }

    public boolean isWinning() {
        for (int i = 0; i < 5; i++) {
            boolean yflag = true;
            boolean xflag = true;
    
            for (int j = 0; j < 5; j++) {
                yflag = visited[i][j] && yflag;
                xflag = visited[j][i] && xflag;
            }
            if (xflag || yflag) {
                return true;
            }
        }
        // check for diagonals
        boolean d1 = true;
        boolean d2 = true;
        for (int i = 0; i < 5; i++) {
            d1 = visited[i][i] && d1;
            d2 = visited[i][4 - i] && d2;
        }

        return d1 || d2;
    }

    public int getAllUnvisited() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    count += board[i][j];
                }
            }
        }
        return count;
    }
}
