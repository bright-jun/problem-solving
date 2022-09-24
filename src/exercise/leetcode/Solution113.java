package exercise.leetcode;

import java.util.List;

import exercise.leetcode.datastructure.TreeNode;

/*
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */
public class Solution113 {
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		return null;
	}

	public static void main(String[] args) {
		Solution113 solution113 = new Solution113();
		List<List<Integer>> answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1 });
		answer = solution113.pathSum(root, 22);
		root = TreeNode.generate(new Integer[] { 1, 2, 3 });
		answer = solution113.pathSum(root, 5);
		root = TreeNode.generate(new Integer[] { 1, 2 });
		answer = solution113.pathSum(root, 0);
		return;
	}
}
