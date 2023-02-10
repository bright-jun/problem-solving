package exercise.leetcode;

import java.util.LinkedList;

public class Solution1162 {
	public static int[][] Dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	/*
	 * n == grid.length
	 * n == grid[i].length
	 * 1 <= n <= 100
	 * grid[i][j] is 0 or 1
	 */
	public int maxDistance(int[][] grid) {
		return maxDistance_sol1(grid);
	}

	/*
	 * Time: O(N^2 * N^2) = 10^8 ... TLE
	 * Space: O(N^2)
	 */
	public int maxDistance_sol1(int[][] grid) {
		int n = grid.length;
		int answer = -1;

		// check every water point
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					// Do BFS
					int[][] tempGrid = copyOf(grid);
					int distance = 0;
					LinkedList<int[]> ll = new LinkedList<int[]>();
					ll.add(new int[] { i, j });
					bfs: while (ll.size() > 0) {
						distance++;
						for (int k = 0, lsize = ll.size(); k < lsize; k++) {
							int[] now = ll.pop();
							if (tempGrid[now[0]][now[1]] == 1) {
								answer = Math.max(answer, distance - 1);
								break bfs;
							}
							tempGrid[now[0]][now[1]] = 9; // visited
							for (int d = 0; d < 4; d++) {
								int nr = now[0] + Dir[d][0];
								int nc = now[1] + Dir[d][1];
								if (nr >= 0 && nr < n && nc >= 0 && nc < n && tempGrid[nr][nc] != 9) {
									ll.add(new int[] { nr, nc });
								}
							}
						}
					}
				}
			}
		}

		return answer;
	}

	public int[][] copyOf(int[][] grid) {
		int n = grid.length;
		int[][] copy = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = grid[i][j];
			}
		}
		return copy;
	}

	public static void main(String[] args) {
		Solution1162 solution1162 = new Solution1162();
		int answer;
		answer = solution1162.maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } });
		answer = solution1162.maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } });
	}
}
