package problemsolving.leetcode;

public class Solution334 {
	/*
	 * 1 <= nums.length <= 5 * 10^5
	 * -2^31 <= nums[i] <= 2^31 - 1
	 */
	public boolean increasingTriplet(int[] nums) {
		int twinNum = Integer.MAX_VALUE; // 2-stack

		if (nums.length <= 2) {
			return false;
		}

		// edge case, nums[i] = Integer.MAX_VALUE
		if (nums[0] < nums[1]) {
			twinNum = Math.min(twinNum, nums[1]);
		}

		for (int i = 2; i < nums.length; i++) {
			// check increasing case(twin) fits triplet
			if (nums[i] > twinNum) {
				return true;
			}
			// memory every increasing case(twin)
			if (nums[i] > nums[i - 1]) {
				// greedy -> minimum case covers all case
				twinNum = Math.min(twinNum, nums[i]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Solution334 solution334 = new Solution334();
		boolean answer;
		answer = solution334.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }); // true
		answer = solution334.increasingTriplet(new int[] { 1, 0, 2, 0, 3, 0, 4, 0, 5 }); // true
		answer = solution334.increasingTriplet(new int[] { 5, 4, 3, 2, 1 }); // false
		answer = solution334.increasingTriplet(new int[] { 2, 1, 5, 0, 4, 6 }); // true
		answer = solution334.increasingTriplet(new int[] { 100, 101, 1, 2, 102 }); // true
		answer = solution334.increasingTriplet(new int[] { 100, 101, 1, 102 }); // true
		answer = solution334.increasingTriplet(new int[] { 100, 101, 1, 2, 3 }); // true
		answer = solution334.increasingTriplet(new int[] { 10000, 10001, 1000, 1001, 100, 101 }); // false
		answer = solution334.increasingTriplet(new int[] { 10000, 10001, 1000, 1001, 100, 101, 102 }); // true
		// edge case -> twin cases can be more than one index apart
		answer = solution334.increasingTriplet(new int[] { 1, 5, 0, 4, 1, 3 }); // true
		return;
	}
}
