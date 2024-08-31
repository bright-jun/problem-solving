package problemsolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Solution542 {
    public static int[][] Dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /*
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n <= 10^4
     * 1 <= m * n <= 10^4
     * mat[i][j] is either 0 or 1.
     * There is at least one 0 in mat.
     */
    public int[][] updateMatrix(int[][] mat) {
        return updateMatrix_sol1(mat);
    }

    /*
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int[][] updateMatrix_sol1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int distance = -1;
        while (queue.size() > 0) {
            distance++;
            for (int i = 0, qSize = queue.size(); i < qSize; i++) {
                int[] now = queue.poll();
                mat[now[0]][now[1]] = distance;
                for (int d = 0; d < 4; d++) {
                    int nr = now[0] + Dir[d][0];
                    int nc = now[1] + Dir[d][1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        queue.add(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        Solution542 solution542 = new Solution542();
        int[][] answer;
        answer = solution542.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}});
        answer = solution542.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        answer = solution542
                .updateMatrix(new int[][]{{0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}, {0, 1, 0}});
    }
}
