package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution108 {
	/*
	 * 1 <= nums.length <= 10^4
	 * -10^4 <= nums[i] <= 10^4
	 * nums is sorted in a strictly increasing order.
	 */
	public TreeNode sortedArrayToBST(int[] nums) {
		return null;
	}

	public static void main(String[] args) {
		Solution108 solution108 = new Solution108();
		TreeNode answer;
		answer = solution108.sortedArrayToBST(new int[] { -10, -3, 0, 5, 9 });
		answer = solution108.sortedArrayToBST(new int[] { 1, 3 });
	}
}
