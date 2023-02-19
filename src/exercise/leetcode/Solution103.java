package exercise.leetcode;

import java.util.LinkedList;
import java.util.List;

import exercise.leetcode.datastructure.TreeNode;

public class Solution103 {
	/*
	 * The number of nodes in the tree is in the range [0, 2000].
	 * -100 <= Node.val <= 100
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		return zigzagLevelOrder_sol1(root);
	}

	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public List<List<Integer>> zigzagLevelOrder_sol1(TreeNode root) {
		// DFS
		List<List<Integer>> answer = new LinkedList<>();

		dfs(root, 0, answer);

		return answer;
	}

	public void dfs(TreeNode now, int depth, List<List<Integer>> answer) {
		if (now == null) {
			return;
		}

		if (answer.size() < depth + 1) {
			answer.add(new LinkedList<>());
		}
		if (depth % 2 == 0) {
			// zig ( left -> right)
			answer.get(depth).add(now.val);
		} else {
			// zag ( right -> left)
			answer.get(depth).add(0, now.val);
		}

		dfs(now.left, depth + 1, answer);
		dfs(now.right, depth + 1, answer);
	}

	public static void main(String[] args) {
		Solution103 solution103 = new Solution103();
		List<List<Integer>> answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 3, 9, 20, null, null, 15, 7 });
		answer = solution103.zigzagLevelOrder(root);
		root = TreeNode.generate(new Integer[] { 1 });
		answer = solution103.zigzagLevelOrder(root);
		root = TreeNode.generate(new Integer[] {});
		answer = solution103.zigzagLevelOrder(root);
	}
}
