package problemsolving.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution695 {

    public static int[][] Dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /*
     * m == grid.length
     * n == grid[i].length
     * 1 <= m, n <= 50
     * grid[i][j] is either 0 or 1.
     */
    public int maxAreaOfIsland(int[][] grid) {
        int answer = 0;

        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    // DFS
                    int tempAnswer = 1;

                    Deque<int[]> dq = new LinkedList<int[]>();
                    dq.add(new int[]{i, j});
                    grid[i][j] = 8;
                    while (!dq.isEmpty()) {
                        int[] now = dq.pollFirst();
                        for (int d = 0; d < 4; d++) {
                            int nr = now[0] + Dir[d][0];
                            int nc = now[1] + Dir[d][1];
                            if (nr >= 0 && nr < r && nc >= 0 && nc < c && grid[nr][nc] == 1) {
                                dq.add(new int[]{nr, nc});
                                grid[nr][nc] = 8;
                                tempAnswer++;
                            }
                        }
                    }
                    answer = Math.max(answer, tempAnswer);
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution695 solution695 = new Solution695();
        int answer;
        answer = solution695.maxAreaOfIsland(
                new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                        {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                        {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}});
        answer = solution695.maxAreaOfIsland(new int[][]{{0, 0, 0, 0, 0, 0, 0, 0}});
    }
}
