package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

public class Solution112 {

    public static boolean Answer;
    public static int TargetSum;

    /*
     * The number of nodes in the tree is in the range [0, 5000].
     * -1000 <= Node.val <= 1000
     * -1000 <= targetSum <= 1000
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Answer = false;
        TargetSum = targetSum;

        dfs(root, root.val);

        return Answer;
    }

    public void dfs(TreeNode now, int tempSum) {
        if (Answer) {
            return;
        }

        // check only leaf-root
        if (now.left == null && now.right == null) {
            if (tempSum == TargetSum) {
                Answer = true;
                return;
            }
        }

        // left
        TreeNode left = now.left;
        if (left != null) {
            dfs(left, tempSum + left.val);
        }

        // right
        TreeNode right = now.right;
        if (right != null) {
            dfs(right, tempSum + right.val);
        }
    }

    public static void main(String[] args) {
        Solution112 solution112 = new Solution112();
        boolean answer;
        TreeNode root;
        root = TreeNode.generate(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1});
        answer = solution112.hasPathSum(root, 22); // true
        root = TreeNode.generate(new Integer[]{1, 2, 3});
        answer = solution112.hasPathSum(root, 5); // false
        root = TreeNode.generate(new Integer[]{});
        answer = solution112.hasPathSum(root, 0); // false
        root = TreeNode.generate(new Integer[]{1, 2});
        answer = solution112.hasPathSum(root, 1); // true
        // val can be minus
        root = TreeNode.generate(new Integer[]{-2, null, -3});
        answer = solution112.hasPathSum(root, -5); // true
        return;
    }
}
