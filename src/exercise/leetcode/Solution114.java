package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution114 {

	public static TreeNode AnsNode;
	public static TreeNode AnsNowNode;

	/*
	 * The number of nodes in the tree is in the range [0, 2000]. -100 <= Node.val
	 * <= 100
	 */
	public void flatten(TreeNode root) {
		AnsNode = null;
		AnsNowNode = null;

		if (root == null) {
			return;
		}

		preOrderTraversal(root);

//		parameter is reference
//		need deep copy, not just reference address copy
//		root = AnsNode;
		root.val = AnsNode.val;
		root.left = AnsNode.left;
		root.right = AnsNode.right;

		return;
	}

	public void preOrderTraversal(TreeNode nowNode) {
		if (nowNode == null) {
			return;
		}

		if (AnsNode == null) {
			AnsNode = new TreeNode(nowNode.val);
		} else {
			if (AnsNowNode == null) {
				AnsNowNode = new TreeNode(nowNode.val);
				AnsNode.right = AnsNowNode;
			} else {
				AnsNowNode.right = new TreeNode(nowNode.val);
				AnsNowNode = AnsNowNode.right;
			}
		}

		preOrderTraversal(nowNode.left);
		preOrderTraversal(nowNode.right);
	}

	public static void main(String[] args) {
		Solution114 solution114 = new Solution114();

//		Input: root = [1,2,5,3,4,null,6]
//		Output: [1,null,2,null,3,null,4,null,5,null,6]
        TreeNode tn = TreeNode.generate(new Integer[]{1, 2, 5, 3, 4, null, 6});
		solution114.flatten(tn);
		solution114.flatten(new TreeNode());
		solution114.flatten(null);

		return;
	}
}
