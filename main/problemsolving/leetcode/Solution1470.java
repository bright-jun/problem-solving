package problemsolving.leetcode;

public class Solution1470 {
	/*
	 * 1 <= n <= 500
	 * nums.length == 2n
	 * 1 <= nums[i] <= 10^3
	 */
	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public int[] shuffle(int[] nums, int n) {
		int[] answer = new int[n * 2];
		for (int i = 0; i < n; i++) {
			answer[i * 2] = nums[i];
			answer[i * 2 + 1] = nums[n + i];
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution1470 solution1470 = new Solution1470();
		int[] answer;
		answer = solution1470.shuffle(new int[] { 2, 5, 1, 3, 4, 7 }, 3);
		answer = solution1470.shuffle(new int[] { 1, 2, 3, 4, 4, 3, 2, 1 }, 4);
		answer = solution1470.shuffle(new int[] { 1, 1, 2, 2 }, 2);
	}
}
