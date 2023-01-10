package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class Solution145 {
    /**
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraverseRecursively(root, answer);
        return answer;
    }

    /**
     * Time complexity : O(N)
     * Space complexity: O(H), ⌈log(N+1)⌉ - 1 <= H(= height of binary tree) <= N - 1
     */
    public void postorderTraverseRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // left
        postorderTraverseRecursively(root.left, list);
        // right
        postorderTraverseRecursively(root.right, list);
        // root
        list.add(root.val);
    }

    public static void main(String[] args) {
        Solution145 solution144 = new Solution145();
        List<Integer> answer;
        TreeNode root = TreeNode.generate(new Integer[]{1, null, 2, 3});
        answer = solution144.postorderTraversal(root);
        root = TreeNode.generate(new Integer[]{});
        answer = solution144.postorderTraversal(root);
        root = TreeNode.generate(new Integer[]{1});
        answer = solution144.postorderTraversal(root);
        root = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        answer = solution144.postorderTraversal(root);
    }
}
