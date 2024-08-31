package problemsolving.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import problemsolving.leetcode.datastructure.TreeNode;

public class Solution103 {
	/*
	 * The number of nodes in the tree is in the range [0, 2000].
	 * -100 <= Node.val <= 100
	 */
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		return zigzagLevelOrder_sol2(root);
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

	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public List<List<Integer>> zigzagLevelOrder_sol2(TreeNode root) {
		// BFS
		List<List<Integer>> answer = new LinkedList<>();
		if (root == null) {
			return answer;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int depth = -1;
		while (queue.size() > 0) {
			depth++;
			if (answer.size() < depth + 1) {
				answer.add(new LinkedList<>());
			}
			for (int i = 0, qSize = queue.size(); i < qSize; i++) {
				TreeNode now = queue.poll();
				if (depth % 2 == 0) {
					// zig ( left -> right)
					answer.get(depth).add(now.val);
				} else {
					// zag ( right -> left)
					answer.get(depth).add(0, now.val);
				}
				if (now.left != null) {
					queue.add(now.left);
				}
				if (now.right != null) {
					queue.add(now.right);
				}
			}
		}

		return answer;
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
