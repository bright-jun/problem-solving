package exercise.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import exercise.leetcode.datastructure.TreeNode;

public class Solution653 {
	/*
	 * The number of nodes in the tree is in the range [1, 10^4].
	 * -10^4 <= Node.val <= 10^4
	 * root is guaranteed to be a valid binary search tree.
	 * -10^5 <= k <= 10^5
	 */
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new LinkedList<Integer>();

		// Improve using TreeNode ref
		TreeNode head;
		{
			TreeNode now = root;
			while (now.left != null) {
				now = now.left;
			}
			head = now;
		}
		TreeNode tail;
		{
			TreeNode now = root;
			while (now.right != null) {
				now = now.right;
			}
			tail = now;
		}

		while (head.val < tail.val) {
			int sum = head.val + tail.val;
			if (sum < k) {
				head = getSuccessor(root, head);
			}
			if (sum == k) {
				return true;
			}
			if (sum > k) {
				tail = getPredecessor(root, tail);
			}
		}

		return false;
	}

	private TreeNode getSuccessor(TreeNode root, TreeNode target) {
		TreeNode successor = null;
		TreeNode now = root;
		while (now != null) {
			if (now.val < target.val) {
				now = now.right;
			}
			if (now.val > target.val) {
				successor = now;
				now = now.left;
			}
		}
		return successor;
	}

	private TreeNode getPredecessor(TreeNode root, TreeNode target) {
		TreeNode predecessor = null;
		TreeNode now = root;
		while (now != null) {
			if (now.val < target.val) {
				predecessor = now;
				now = now.right;
			}
			if (now.val > target.val) {
				now = now.left;
			}
		}
		return predecessor;
	}

	public static void main(String[] args) {
		Solution653 solution653 = new Solution653();
		boolean answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
		answer = solution653.findTarget(root, 9);
		root = TreeNode.generate(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
		answer = solution653.findTarget(root, 28);
		return;
	}
}
