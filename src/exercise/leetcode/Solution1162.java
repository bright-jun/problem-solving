package exercise.leetcode;

public class Solution1162 {
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
	 * Time: 
	 * Space: 
	 */
	public int maxDistance_sol1(int[][] grid) {
		return -1;
	}

	public static void main(String[] args) {
		Solution1162 solution1162 = new Solution1162();
		int answer;
		answer = solution1162.maxDistance(new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } });
		answer = solution1162.maxDistance(new int[][] { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } });
	}
}
