package problemsolving.leetcode;

public class Solution289 {
    public static int[][] DIR = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    public static int MARK = 10;

    private boolean inBoard(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

    /**
     * m == board.length
     * n == board[i].length
     * 1 <= m, n <= 25
     * board[i][j] is 0 or 1.
     */
    public void gameOfLife(int[][] board) {
        gameOfLife1(board);
    }

    /**
     * Time: O(MN)
     * Space: O(1)
     */
    public void gameOfLife1(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int neighbor = 0;
                for (int d = 0; d < 8; d++) {
                    int nr = r + DIR[d][0];
                    int nc = c + DIR[d][1];
                    if (inBoard(nr, nc, m, n) && (board[nr][nc] == 1 || board[nr][nc] == 1 - MARK)) {
                        neighbor++;
                    }
                }
                if (board[r][c] == 1 || board[r][c] == 1 - MARK) { // live cell
                    if (neighbor < 2 || 3 < neighbor) {
                        board[r][c] -= MARK;
                    }
                } else { // dead cell
                    if (neighbor == 3) {
                        board[r][c] += MARK;
                    }
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] > 0) {
                    board[r][c] = 1;
                } else {
                    board[r][c] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution289 solution289 = new Solution289();
        int[][] board;
        board = new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}};
        solution289.gameOfLife(board);
        board = new int[][]{{1, 1}, {1, 0}};
        solution289.gameOfLife(board);
    }
}
