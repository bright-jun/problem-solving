package exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    /**
     * 1 <= n <= 9
     */
    public List<List<String>> solveNQueens(int n) {
        return solveNQueens_0(n);
    }

    /**
     * Time: O(N!)
     * Space: O(N^2)
     */
    public static int N;
    public char[][] Board;
    public static List<List<String>> Answer;

    public List<List<String>> solveNQueens_0(int n) {
        Answer = new ArrayList<>();
        N = n;
        Board = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Board[i][j] = '.';
            }
        }

        nQueen(0);

        return Answer;
    }

    public void nQueen(int row) {
        if (row == N) {
            // add Answer
            List<String> answerList = new ArrayList<>();
            for (int r = 0; r < N; r++) {
                StringBuilder rowStr = new StringBuilder();
                for (char c : Board[r]) {
                    rowStr.append(c);
                }
                answerList.add(rowStr.toString());
            }
            Answer.add(answerList);
            return;
        }

        for (int i = 0; i < N; i++) {
            // put queen (row, i)
            // check validate
            boolean isValid = true;
            for (int r = 0; r < row; r++) {
                // vertical check
                if (Board[r][i] != '.') {
                    isValid = false;
                    break;
                }
                // diagonal check
                if (i - (row - r) >= 0 && Board[r][i - (row - r)] != '.') {
                    isValid = false;
                    break;
                }
                if (i + (row - r) < N && Board[r][i + (row - r)] != '.') {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                Board[row][i] = 'Q';
                nQueen(row + 1);
                Board[row][i] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        List<List<String>> answer;
        answer = solution51.solveNQueens(1); // answer: [["Q"]]
        answer = solution51.solveNQueens(4); // answer: [[".Q..","...Q","Q..."],["..Q.","Q...","...Q"]]
        answer = solution51.solveNQueens(9);
    }
}
