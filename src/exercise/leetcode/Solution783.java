package exercise.leetcode;

import java.util.Iterator;
import java.util.TreeSet;

import exercise.leetcode.datastructure.TreeNode;

public class Solution783 {
	/*
	 * The number of nodes in the tree is in the range [2, 100].
	 * 0 <= Node.val <= 10^5
	 */
	public int minDiffInBST(TreeNode root) {
		TreeSet<Integer> treeSet = new TreeSet<Integer>();

		dfs(root, treeSet);

		int diff = Integer.MAX_VALUE;
		Iterator<Integer> iterator = treeSet.iterator();
		Integer before = diff;
		while(iterator.hasNext()) {
			int now = iterator.next();
			diff = Math.min(diff, Math.abs(before - now));
			before = now;
		}
		return diff;
	}

	public void dfs(TreeNode root, TreeSet<Integer> treeSet) {
		if (root == null) {
			return;
		}

		treeSet.add(root.val);

		dfs(root.left, treeSet);
		dfs(root.right, treeSet);
	}

	public static void main(String[] args) {
		Solution783 solution783 = new Solution783();
		int answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 4, 2, 6, 1, 3 });
		answer = solution783.minDiffInBST(root); // 1
		root = TreeNode.generate(new Integer[] { 1, 0, 48, null, null, 12, 49 });
		answer = solution783.minDiffInBST(root); // 1
		root = TreeNode.generate(new Integer[] { 90, 69, null, 49, 89, null, 52 });
		answer = solution783.minDiffInBST(root); // 1
	}
}
