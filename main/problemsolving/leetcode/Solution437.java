package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

public class Solution437 {
    /*
     * The number of nodes in the tree is in the range [0, 1000].
     * -10^9 <= Node.val <= 10^9
     * -1000 <= targetSum <= 1000
     */
    public int pathSum(TreeNode root, int targetSum) {
        return -1;
    }

    public static void main(String[] args) {
        Solution437 solution437 = new Solution437();
        int answer;
        TreeNode root;
        root = TreeNode.generate(new Integer[]{10, 5, -3, 3, 2, null, 11, 3, -2, null, 1});
        answer = solution437.pathSum(root, 8);
        root = TreeNode.generate(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        answer = solution437.pathSum(root, 22);
        return;
    }
}
