package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution144 {
    /**
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        preorderTraverseRecursively(root, answer);
        return answer;
    }

    /**
     * Time complexity : O(N)
     * Space complexity: O(H), ⌈log(N+1)⌉ - 1 <= H(= height of binary tree) <= N - 1
     */
    public void preorderTraverseRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // root
        list.add(root.val);
        // left
        preorderTraverseRecursively(root.left, list);
        // right
        preorderTraverseRecursively(root.right, list);
    }

    public static void main(String[] args) {
        Solution144 solution144 = new Solution144();
        List<Integer> answer;
        TreeNode root = TreeNode.generate(new Integer[]{1, null, 2, 3});
        answer = solution144.preorderTraversal(root);
        root = TreeNode.generate(new Integer[]{});
        answer = solution144.preorderTraversal(root);
        root = TreeNode.generate(new Integer[]{1});
        answer = solution144.preorderTraversal(root);
    }
}
