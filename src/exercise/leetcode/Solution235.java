package exercise.leetcode;

import java.util.LinkedList;
import java.util.List;

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
		// find lowestCommonAncestor
		TreeNode now = root;

		while (now != null) {
			// both find left
			if (now.val < p.val && now.val < q.val) {
				now = now.right;
			}
			// both find right
			else if (now.val > p.val && now.val > q.val) {
				now = now.left;
			}
			// find target
			else if (now.val == p.val || now.val == q.val) {
				break;
			}
			// no more common ancestor
			else {
				break;
			}
		}

		return now;
	}

	public static void main(String[] args) {
		Solution235 solution235 = new Solution235();
		TreeNode answer;
		TreeNode root = TreeNode.generate(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		answer = solution235.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)); // 2 8 -> 6
		root = TreeNode.generate(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		answer = solution235.lowestCommonAncestor(root, new TreeNode(2), new TreeNode(1)); // 2 1 -> 1 
		root = TreeNode.generate(new Integer[] { 6, 2, 8, 0, 4, 7, 9, null, null, 3, 5 });
		answer = solution235.lowestCommonAncestor(root, new TreeNode(3), new TreeNode(5)); // 3 5 -> 4
		
		return;
	}
}
