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
        setZeroes_3(matrix);
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

    /**
     * Time:O(MN)
     * Space: O(number of zeroes)
     */
    public void setZeroes_3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int marker = Integer.MIN_VALUE;
        while (true) {
            boolean duplicated = false;
            for (int r = 0; r < m; r++) {
                if (duplicated) {
                    break;
                }
                for (int c = 0; c < n; c++) {
                    if (matrix[r][c] == marker) {
                        marker++;
                        duplicated = true;
                        break;
                    }
                }
            }
            if (!duplicated) {
                break;
            }
        }

        boolean isFirstRowZero = false;
        for (int c = 0; c < n; c++) {
            if (matrix[0][c] == 0) {
                isFirstRowZero = true;
                break;
            }
        }
        boolean isFirstColZero = false;
        for (int r = 0; r < m; r++) {
            if (matrix[r][0] == 0) {
                isFirstColZero = true;
                break;
            }
        }
        // mark first row & first col as flag to fill with 0
        // idea. exclude first row & first row for mutually exclusive calculation
        for (int r = 1; r < m; r++) {
            for (int c = 1; c < n; c++) {
                if (matrix[r][c] == 0) {
                    matrix[0][c] = marker;
                    matrix[r][0] = marker;
                }
            }
        }
        // use mark and fill 0
        for (int c = 1; c < n; c++) {
            if (matrix[0][c] == 0 || matrix[0][c] == marker) {
                for (int r = 0; r < m; r++) {
                    matrix[r][c] = 0;
                }
            }
        }
        for (int r = 1; r < m; r++) {
            if (matrix[r][0] == 0 || matrix[r][0] == marker) {
                for (int c = 0; c < n; c++) {
                    matrix[r][c] = 0;
                }
            }
        }
        // consider first row & first col
        if (isFirstRowZero) {
            for (int c = 0; c < n; c++) {
                matrix[0][c] = 0;
            }
        }
        if (isFirstColZero) {
            for (int r = 0; r < m; r++) {
                matrix[r][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution73 solution73 = new Solution73();
        int[][] matrix;
        matrix = new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        solution73.setZeroes(matrix);
        matrix = new int[][]{
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        solution73.setZeroes(matrix);
        matrix = new int[][]{
            {1, 2, 3, 4},
            {5, 0, 7, 8},
            {0, 10, 11, 12},
            {13, 14, 15, 0}
        };
        solution73.setZeroes(matrix);
    }
}
