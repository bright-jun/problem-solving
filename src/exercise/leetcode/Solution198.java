package exercise.leetcode;

public class Solution198 {
	/*
	 * 1 <= nums.length <= 100
	 * 0 <= nums[i] <= 400
	 */
	public int rob(int[] nums) {

		int[][] money = new int[2][nums.length];
		// do not rob
		money[0][0] = 0;
		// do rob
		money[1][0] = nums[0];

		for (int i = 1; i < nums.length; i++) {
			// do not rob = max( do not rob before , do rob before )
			money[0][i] = Math.max(money[0][i - 1], money[1][i - 1]);
			// do rob = do not rob before + do rob now
			money[1][i] = money[0][i - 1] + nums[i];
		}

		return Math.max(money[0][nums.length - 1], money[1][nums.length - 1]);
	}

	public int rob2(int[] nums) {

		int[] money = new int[nums.length];

		money[0] = nums[0];
		if (nums.length == 1) {
			return money[nums.length - 1];
		}
		
		// max = max(do not rob before , do rob before)
		money[1] = Math.max(nums[0], nums[1]);
		if (nums.length == 2) {
			return money[nums.length - 1];
		}

		for (int i = 2; i < nums.length; i++) {
			// max = max(do not rob before or do rob before , do not rob before and rob now)
			money[i] = Math.max(money[i - 1], money[i - 2] + nums[i]);
		}

		return money[nums.length - 1];
	}

	public static void main(String[] args) {
		Solution198 solution198 = new Solution198();
		int answer = -1;
		answer = solution198.rob2(new int[] { 1, 2, 3, 1 });
		answer = solution198.rob2(new int[] { 2, 7, 9, 3, 1 });
		answer = solution198.rob2(new int[] { 2, 7, 3, 9, 1 });
		answer = solution198.rob2(new int[] { 1 });
		answer = solution198.rob2(new int[] { 1, 9 });
		answer = solution198.rob2(new int[] { 9, 1 });
		return;
	}
}
