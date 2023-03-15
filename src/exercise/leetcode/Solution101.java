package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Solution101 {
    /*
     * The number of nodes in the tree is in the range [1, 1000].
     * -100 <= Node.val <= 100
     */
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric_sol1(root);
    }

    /*
     * Time: O(N)
     * Space: O(N)
     */
    public boolean isSymmetric_sol1(TreeNode root) {

        TreeNode left = root.left;
        TreeNode right = root.right;

        List<Integer> leftList = new LinkedList<>();
        List<Integer> rightList = new LinkedList<>();
        // left->right vs right->left
        leftToRightInorder(left, leftList);
        rightToLeftInorder(right, rightList);

        int lSize = leftList.size();
        int rSize = rightList.size();

        if (lSize != rSize) {
            return false;
        }

        for (int i = 0; i < lSize; i++) {
            if ((int) rightList.get(i) != leftList.get(i)) {
                return false;
            }
        }

        return true;
    }

    public void leftToRightInorder(TreeNode now, List<Integer> list) {
        if (now == null) {
            list.add(-1000);
            return;
        }
        TreeNode left = now.left;
        leftToRightInorder(left, list);
        list.add(now.val);
        TreeNode right = now.right;
        leftToRightInorder(right, list);
    }

    public void rightToLeftInorder(TreeNode now, List<Integer> list) {
        if (now == null) {
            list.add(-1000);
            return;
        }
        TreeNode right = now.right;
        leftToRightInorder(right, list);
        list.add(now.val);
        TreeNode left = now.left;
        leftToRightInorder(left, list);
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
