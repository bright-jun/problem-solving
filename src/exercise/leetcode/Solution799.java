package exercise.leetcode;

public class Solution799 {
	/*
	 * simulation
	 */
	
	public static double[][] CT; // champagneTower

	public double champagneTower(int poured, int query_row, int query_glass) {

		CT = new double[query_row + 1][query_row + 1];
		CT[0][0] = poured;

		// nth row flow simulation
		for (int n = 1; n <= query_row; n++) {
			for (int i = 0; i <= n; i++) {
				if (i == 0) { // left end
					// from right top
					CT[n][i] = Math.max(0, (CT[n - 1][i] - 1)) / 2;
				} else if (i == n) { // right end
					// from left top
					CT[n][i] = Math.max(0, (CT[n - 1][i - 1] - 1)) / 2;
				} else {
					// from left top & from right top
					CT[n][i] = Math.max(0, (CT[n - 1][i - 1] - 1)) / 2 + Math.max(0, (CT[n - 1][i] - 1)) / 2;
				}
			}
		}

		return Math.min(1, CT[query_row][query_glass]);
	}

	// 1 : 1
	// 2 : 1 1
	// 4 : 1 2 1
	// 8 : 1 3 3 1
	// 16: 1 4 6 4 1

	public static void main(String[] args) {
		Solution799 solution799 = new Solution799();
		System.out.println(solution799.champagneTower(1, 1, 1));
		System.out.println(solution799.champagneTower(2, 1, 1));
		System.out.println(solution799.champagneTower(3, 1, 0));
		System.out.println(solution799.champagneTower(4, 2, 0));
		System.out.println(solution799.champagneTower(4, 2, 1));
		System.out.println(solution799.champagneTower(4, 2, 2));
		// liquid doesn't flow like pascal...
		System.out.println(solution799.champagneTower(25, 6, 1)); // sig6 21, enough 4-> 4*(6/64) // 0.18750
		System.out.println(solution799.champagneTower(100000009, 33, 17));
	}
}
