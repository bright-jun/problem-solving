package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution112 {
	public boolean hasPathSum(TreeNode root, int targetSum) {
		return false;
	}

	public static void main(String[] args) {
		Solution112 solution112 = new Solution112();
		boolean answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1 });
		answer = solution112.hasPathSum(root, 22); // true
		root = TreeNode.generate(new Integer[] { 1, 2, 3 });
		answer = solution112.hasPathSum(root, 5); // false
		root = TreeNode.generate(new Integer[] {});
		answer = solution112.hasPathSum(root, 0); // false
		return;
	}
}
