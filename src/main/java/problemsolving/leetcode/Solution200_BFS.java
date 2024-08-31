package problemsolving.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution200_BFS {

    public static int[][] Dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int R;
    public static int C;

    public int numIslands(char[][] grid) {
        R = grid.length;
        C = grid[0].length;

        int answer = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    answer++;
                    // BFS
                    Deque<int[]> dq = new LinkedList<int[]>();
                    dq.add(new int[]{i, j});
                    grid[i][j] = '#';

                    while (!dq.isEmpty()) {
                        for (int k = 0, qsize = dq.size(); k < qsize; k++) {
                            int[] now = dq.pollFirst();

                            for (int d = 0; d < 4; d++) {
                                int nr = now[0] + Dir[d][0];
                                int nc = now[1] + Dir[d][1];
                                if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == '1') {
                                    dq.add(new int[]{nr, nc});
                                    grid[nr][nc] = '#';
                                }
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution200_BFS solution200 = new Solution200_BFS();

        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
        System.out.println(solution200.numIslands(new char[][]{{'0'}}));
        System.out.println(solution200.numIslands(new char[][]{{'1'}}));
    }
}
