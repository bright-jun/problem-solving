package exercise.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import exercise.leetcode.datastructure.TreeNode;

public class Solution113 {
	
	public static int TargetSum;
	public static List<List<Integer>> Answer;
	
	/*
	 * The number of nodes in the tree is in the range [0, 5000].
	 * -1000 <= Node.val <= 1000
	 * -1000 <= targetSum <= 1000
	 */
	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		Answer = new LinkedList<List<Integer>>();
		
		if(root == null) {
			return Answer;
		}
		
		TargetSum = targetSum;
		Stack<Integer> path = new Stack<Integer>();
		path.add(root.val);
		dfs(root, root.val, path);
		
		// root-to-leaf paths
		return Answer;
	}

	public void dfs(TreeNode now, int tempSum, Stack<Integer> path) {

		// root-to-leaf paths
		if (now.left == null && now.right == null) {
			if (tempSum == TargetSum) {
				Answer.add(path.stream().collect(Collectors.toList()));
			}
		}

		// left
		TreeNode left = now.left;
		if (left != null) {
			path.add(left.val);
			dfs(left, tempSum + left.val, path);
			path.pop();
		}

		// right
		TreeNode right = now.right;
		if (right != null) {
			path.add(right.val);
			dfs(right, tempSum + right.val, path);
			path.pop();
		}
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
