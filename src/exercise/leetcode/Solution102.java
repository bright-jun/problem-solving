package exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

import exercise.leetcode.datastructure.TreeNode;

public class Solution102 {

	/*
	 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
	 * <= 1000
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		int level = 1;
		inOrderLevel(root, answer, level);

		return answer;
	}

	public void inOrderLevel(TreeNode treeNode, List<List<Integer>> answer, int level) {

		if (treeNode == null) {
			return;
		}

		// in-order traversal + depth
		if (answer.size() >= level) {
			answer.get(level - 1).add(treeNode.val);
		} else {
			answer.add(new ArrayList<Integer>());
			answer.get(level - 1).add(treeNode.val);
		}
		inOrderLevel(treeNode.left, answer, level + 1);
		inOrderLevel(treeNode.right, answer, level + 1);
	}

	public static void main(String[] args) {
		Solution102 solution102 = new Solution102();
		List<List<Integer>> answer;

		{
//			Input: root = [3,9,20,null,null,15,7]
//			Output: [[3],[9,20],[15,7]]
			TreeNode t0 = new TreeNode(3);
			TreeNode t1 = new TreeNode(9);
			TreeNode t2 = new TreeNode(20);
//			TreeNode t3 = new TreeNode();
//			TreeNode t4 = new TreeNode();
			TreeNode t5 = new TreeNode(15);
			TreeNode t6 = new TreeNode(7);

			t0.left = t1;
			t0.right = t2;
			t2.left = t5;
			t2.right = t6;

			answer = solution102.levelOrder(t0);
		}

		{
//			Input: root = [1]
//			Output: [[1]]
			TreeNode t0 = new TreeNode(1);
			answer = solution102.levelOrder(t0);
		}

		{
//			Input: root = []
//			Output: []
			answer = solution102.levelOrder(null);
		}
	}
}
