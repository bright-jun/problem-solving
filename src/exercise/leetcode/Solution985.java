package exercise.leetcode;

public class Solution985 {
	/*
	 * 1 <= nums.length <= 10^4
	 * -10^4 <= nums[i] <= 10^4
	 * 1 <= queries.length <= 10^4
	 * -10^4 <= vali <= 10^4
	 * 0 <= indexi < nums.length
	 */
	public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
		int sum = 0;
		int[] answer = new int[queries.length];
		for (int num : nums) {
			if (num % 2 == 0) {
				sum += num;
			}
		}
		for (int i = 0; i < queries.length; i++) {
			int before = nums[queries[i][1]];
			int after = nums[queries[i][1]] + queries[i][0];
			nums[queries[i][1]] = after;

			if (before % 2 == 0) {
				sum -= before;
			}
			if (after % 2 == 0) {
				sum += after;
			}

			answer[i] = sum;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution985 solution985 = new Solution985();
		int[] answer;
		answer = solution985.sumEvenAfterQueries(new int[] { 1, 2, 3, 4 },
				new int[][] { { 1, 0 }, { -3, 1 }, { -4, 0 }, { 2, 3 } });
		answer = solution985.sumEvenAfterQueries(new int[] { 1 }, new int[][] { { 4, 0 } });

		return;
	}
}
