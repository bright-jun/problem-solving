package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

public class Solution101 {
    /*
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric_sol1(root);
    }

    public static boolean Answer = true;

    /*
     * Time: O(N)
     * Space: O(N)
     */
    public boolean isSymmetric_sol1(TreeNode root) {
        Answer = true;
        TreeNode left = root.left;
        TreeNode right = root.right;

        // left->right vs right->left
        inorder(left, right);

        return Answer;
    }

    public void inorder(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
        } else if (left != null && right != null) {
            if (left.val != right.val) {
                Answer = false;
            } else {
                TreeNode leftLeft = left.left;
                TreeNode rightRight = right.right;
                inorder(leftLeft, rightRight);
                TreeNode leftRight = left.right;
                TreeNode rightLeft = right.left;
                inorder(leftRight, rightLeft);
            }
        } else {
            Answer = false;
        }
    }

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        boolean answer;
        TreeNode root;
        root = TreeNode.generate(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        answer = solution101.isSymmetric(root);
        root = TreeNode.generate(new Integer[]{1, 2, 2, null, 3, null, 3});
        answer = solution101.isSymmetric(root);
        // left child != right chlid
        root = TreeNode.generate(new Integer[]{1, 2, 2, 2, null, 2});
        answer = solution101.isSymmetric(root);
    }
}
