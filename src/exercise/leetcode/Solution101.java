package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

public class Solution101 {
    /*
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric_sol1(root);
    }

    /*
     * Time:
     * Space:
     */
    public boolean isSymmetric_sol1(TreeNode root) {
        // preorder vs postorder
        return false;
    }

    public static void main(String[] args) {
        Solution101 solution101 = new Solution101();
        boolean answer;
        TreeNode root;
        root = TreeNode.generate(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        answer = solution101.isSymmetric(root);
        root = TreeNode.generate(new Integer[]{1, 2, 2, null, 3, null, 3});
        answer = solution101.isSymmetric(root);
    }
}
