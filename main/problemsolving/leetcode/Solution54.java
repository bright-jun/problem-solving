package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution54 {
    private static final int[][] Dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    /**
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 10
     * -100 <= matrix[i][j] <= 100
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        return spiralOrder_0(matrix);
    }

    /**
     * Time: O(M*N)
     * Space: O(1)
     */
    public List<Integer> spiralOrder_0(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] visited = new boolean[m][n];

        List<Integer> answer = new ArrayList<>();

        int dir = 0;
        int r = 0;
        int c = 0;
        answer.add(matrix[r][c]);
        visited[r][c] = true;

        boolean turned = false;
        while (true) {
            int nr = r + Dir[dir][0];
            int nc = c + Dir[dir][1];
            if (nr >= 0 && nc >= 0 && nr < m && nc < n && !visited[nr][nc]) {
                // move
                r = nr;
                c = nc;
                answer.add(matrix[r][c]);
                visited[r][c] = true;
                turned = false;
            } else {
                // if turn again break;
                if (turned) {
                    break;
                }
                // turn 90 degree
                dir = (dir + 1) % 4;
                turned = true;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution54 solution54 = new Solution54();
        List<Integer> answer;
        int[][] matrix;
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        answer = solution54.spiralOrder_0(matrix);
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        answer = solution54.spiralOrder_0(matrix);
    }
}
