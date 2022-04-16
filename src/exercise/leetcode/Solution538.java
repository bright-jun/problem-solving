package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution538 {
	
	public void rightInOrder(TreeNode root, int total) {
		if(root == null) {
			return;
		}
		rightInOrder(root.right, total);
		total += root.val;
		root.val = total;
		rightInOrder(root.left, total);
	}
	
    public TreeNode convertBST(TreeNode root) {
    	
    	// search Right -> Root -> Left
    	// ref https://leetcode.com/problems/convert-bst-to-greater-tree/discuss/1951757/Simple-easy-c%2B%2B-solution
    	
    	
    	
    	
    	
    	
    	
    	
    	
        return null;
    }
    
    public static void main(String[] args) {
    	Solution538 solution538 = new Solution538();
    	
    	
    	
    	
    	
		TreeNode tn2 = new TreeNode(0);
		tn2.left = null;
		tn2.right = new TreeNode(1);
		System.out.println(solution538.convertBST(tn2));
		
	}
}
