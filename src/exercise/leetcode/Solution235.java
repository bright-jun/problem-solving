package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution235 {
	/*
	 * The number of nodes in the tree is in the range [2, 10^5].
	 * -10^9 <= Node.val <= 10^9
	 * All Node.val are unique.
	 * p != q
	 * p and q will exist in the BST.
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// record path while BST search
		// find lowestCommonAncestor
		return null;
	}

	public static void main(String[] args) {
		Solution235 solution235 = new Solution235();
		TreeNode answer;
		TreeNode root = TreeNode.generate(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		answer = solution235.lowestCommonAncestor(root, root.left, root.right); // 2 8 -> 6
		root = TreeNode.generate(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		answer = solution235.lowestCommonAncestor(root, root.left, root.left.right); // 2 1 -> 1 
		
		return;
	}
}
