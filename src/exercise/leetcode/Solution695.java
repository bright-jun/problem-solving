package exercise.leetcode;

public class Solution695 {

	public static int[][] Dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	
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
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution695 solution695 = new Solution695();
		int answer;
		answer = solution695.maxAreaOfIsland(
				new int[][] { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
						{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
						{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
						{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } });
		answer = solution695.maxAreaOfIsland(new int[][] { { 0, 0, 0, 0, 0, 0, 0, 0 } });
	}
}
