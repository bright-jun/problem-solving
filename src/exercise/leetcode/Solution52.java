package exercise.leetcode;

public class Solution52 {
    /**
     * 1 <= n <= 9
     */
    public int totalNQueens(int n) {
        return totalNQueens_1(n);
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

    /**
     * Time: O(N!)
     * Space: O(N)
     */
    public static boolean[] Vertical;
    public static boolean[] LeftDiagonal;
    public static boolean[] RightDiagonal;

    public int totalNQueens_1(int n) {
        Answer = 0;
        N = n;
        Vertical = new boolean[N];
        LeftDiagonal = new boolean[2 * N]; // [-n, n-1]
        RightDiagonal = new boolean[2 * N]; // [0, 2n-1]

        nQueen_1(0);

        return Answer;
    }

    public void nQueen_1(int row) {
        if (row == N) {
            // add Answer
            Answer++;
            return;
        }

        for (int col = 0; col < N; col++) {
            // put queen (row, col)
            // consider checking row = 0 board, and draw straight line vertically or leftDiagonally or rightDiagonally
            int leftDiagonalCol = col - row + N; // [-n, n-1] // start of left diagonal
            int rightDiagonalCol = col + row; // [0, 2n-1] // start of right diagonal
            if (Vertical[col] || LeftDiagonal[leftDiagonalCol] || RightDiagonal[rightDiagonalCol]) {
                continue;
            }

            Vertical[col] = true;
            LeftDiagonal[leftDiagonalCol] = true;
            RightDiagonal[rightDiagonalCol] = true;
            nQueen_1(row + 1);
            Vertical[col] = false;
            LeftDiagonal[leftDiagonalCol] = false;
            RightDiagonal[rightDiagonalCol] = false;
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
