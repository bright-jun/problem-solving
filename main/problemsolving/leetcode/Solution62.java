package problemsolving.leetcode;

public class Solution62 {

	/*
	 * The test cases are generated so that the answer will be less than or equal to
	 * 2 * 10^9 < Integer.MAX. 1 <= m, n <= 100
	 */
	public int uniquePaths(int m, int n) {
		int[][] grid = new int[m][n];

		grid[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int left = 0;
				int up = 0;

				if (i == 0 && j == 0) {
					continue;
				}

				if (i != 0) {
					up = grid[i - 1][j];
				}

				if (j != 0) {
					left = grid[i][j - 1];
				}

				grid[i][j] = up + left;
			}
		}

		return grid[m - 1][n - 1];
	}

	public static void main(String[] args) {
		Solution62 solution62 = new Solution62();
		int answer;
		answer = solution62.uniquePaths(3, 7);
		answer = solution62.uniquePaths(1, 7);
		return;
	}
}
