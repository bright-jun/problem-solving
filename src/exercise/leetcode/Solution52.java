package exercise.leetcode;

public class Solution52 {
    /**
     * 1 <= n <= 9
     */
    public int totalNQueens(int n) {
        return totalNQueens_0(n);
    }

    /**
     * Time: O(N!)
     * Space: O(N^2)
     */
    public static int N;
    public boolean[][] Board;
    public static int Answer;

    public int totalNQueens_0(int n) {
        Answer = 0;
        N = n;
        Board = new boolean[N][N];

        nQueen(0);

        return Answer;
    }

    public void nQueen(int row) {
        if (row == N) {
            // add Answer
            Answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // put queen (row, i)
            // check validate
            boolean isValid = true;
            for (int r = 0; r < row; r++) {
                // vertical check
                if (Board[r][i]) {
                    isValid = false;
                    break;
                }
                // diagonal check
                if (i - (row - r) >= 0 && Board[r][i - (row - r)]) {
                    isValid = false;
                    break;
                }
                if (i + (row - r) < N && Board[r][i + (row - r)]) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                Board[row][i] = true;
                nQueen(row + 1);
                Board[row][i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution52 solution52 = new Solution52();
        int answer;
        for (int i = 0; i < 10; i++) {
            answer = solution52.totalNQueens(i);
        }
    }
}
