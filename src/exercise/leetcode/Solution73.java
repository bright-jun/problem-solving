package exercise.leetcode;

import java.util.Stack;

public class Solution73 {
    /**
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -2^31 <= matrix[i][j] <= 2^31 - 1
     * You must do it in place.
     */
    public void setZeroes(int[][] matrix) {
        setZeroes_0(matrix);
    }

    /**
     * Time:O(MN)
     * Space: O(MN)
     */
    public void setZeroes_0(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // O(MN)
        Stack<int[]> stack = new Stack<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    stack.push(new int[]{r, c});
                }
            }
        }

        for (int[] zero : stack) {
            for (int c = 0; c < n; c++) {
                matrix[zero[0]][c] = 0;
            }
            for (int r = 0; r < m; r++) {
                matrix[r][zero[1]] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] matrix;
        matrix = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution73.setZeroes(matrix);
        matrix = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution73.setZeroes(matrix);
    }
}
