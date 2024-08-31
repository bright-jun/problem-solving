package problemsolving.leetcode;

import java.util.LinkedList;
import java.util.Queue;

import problemsolving.leetcode.datastructure.TreeNode;

public class Solution104 {
	public int maxDepth(TreeNode root) {
		return maxDepth_sol2(root);
	}

	/*
	 * Time: O(N)
	 * Space: O(1 ~ logN)
	 */
	public int maxDepth_sol1(TreeNode root) {
		// BFS
		if (root == null) {
			return 0;
		}
		int depth = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.size() > 0) {
			depth++;
			for (int i = 0, qSize = queue.size(); i < qSize; i++) {
				TreeNode now = queue.poll();
				if (now.left != null) {
					queue.add(now.left);
				}
				if (now.right != null) {
					queue.add(now.right);
				}
			}
		}

		return depth;
	}

	/*
	 * Time: O(N)
	 * Space: O(logN ~ N)
	 */
	public int maxDepth_sol2(TreeNode root) {
		// DFS
		if (root == null) {
			return 0;
		}

		return Math.max(maxDepth_sol2(root.left), maxDepth_sol2(root.right)) + 1;
	}

	public static void main(String[] args) {
		Solution104 solution104 = new Solution104();
		int answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 3, 9, 20, null, null, 15, 7 });
		answer = solution104.maxDepth(root);
		root = TreeNode.generate(new Integer[] { 1, null, 2 });
		answer = solution104.maxDepth(root);
	}
}
