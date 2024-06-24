package exercise.leetcode;

import java.util.HashSet;
import java.util.Set;
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
        setZeroes_2(matrix);
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

    /**
     * Time:O(MN)
     * Space: O(M + N)
     */
    public void setZeroes_1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        // O(M)
        Set<Integer> rowSet = new HashSet<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    rowSet.add(r);
                    break;
                }
            }
        }

        // O(N)
        Set<Integer> colSet = new HashSet<>();
        for (int c = 0; c < n; c++) {
            for (int r = 0; r < m; r++) {
                if (matrix[r][c] == 0) {
                    colSet.add(c);
                    break;
                }
            }
        }

        for (int r : rowSet) {
            for (int c = 0; c < n; c++) {
                matrix[r][c] = 0;
            }
        }
        for (int c : colSet) {
            for (int r = 0; r < m; r++) {
                matrix[r][c] = 0;
            }
        }
    }

    /**
     * Time:O(MN*(M+N))
     * Space: O(number of zeroes)
     */
    public void setZeroes_2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int marker = Integer.MIN_VALUE;

        while (true) {
            boolean isDuplicated = false;
            for (int r = 0; r < m; r++) {
                if (isDuplicated) {
                    break;
                }
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == marker) {
                        marker++;
                        isDuplicated = true;
                        break;
                    }
                }
            }
            if (!isDuplicated) {
                break;
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == 0) {
                    for (int nc = 0; nc < n; nc++) {
                        if (nc == c || matrix[r][nc] == 0 || matrix[r][nc] == marker) {
                            continue;
                        }
                        matrix[r][nc] = marker;
                    }
                    for (int nr = 0; nr < m; nr++) {
                        if (nr == r || matrix[nr][c] == 0 || matrix[nr][c] == marker) {
                            continue;
                        }
                        matrix[nr][c] = marker;
                    }
                }
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (matrix[r][c] == marker) {
                    matrix[r][c] = 0;
                }
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
