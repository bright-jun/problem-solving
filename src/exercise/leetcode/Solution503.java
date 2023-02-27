package exercise.leetcode;

import java.util.TreeMap;

public class Solution503 {
	/*
	 * 1 <= nums.length <= 10^4
	 * -10^9 <= nums[i] <= 10^9
	 */
	public int[] nextGreaterElements(int[] nums) {
		return nextGreaterElements_sol1(nums);
	}

	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public int[] nextGreaterElements_sol1(int[] nums) {
		// use stack
		return null;
	}

	public static void main(String[] args) {
		Solution503 solution503 = new Solution503();
		int[] answer;
		answer = solution503.nextGreaterElements(new int[] { 1, 2, 1 });
		answer = solution503.nextGreaterElements(new int[] { 1, 2, 3, 4, 3 });
		answer = solution503.nextGreaterElements(new int[] { 5, 4, 3, 2, 1 });
	}
}
