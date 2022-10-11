package exercise.leetcode;

public class Solution334 {
	/*
	 * 1 <= nums.length <= 5 * 10^5
	 * -2^31 <= nums[i] <= 2^31 - 1
	 */
	public boolean increasingTriplet(int[] nums) {
		return false;
	}

	public static void main(String[] args) {
		Solution334 solution334 = new Solution334();
		boolean answer;
		answer = solution334.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }); // true
		answer = solution334.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }); // false
		answer = solution334.increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }); // true
		return;
	}
}
