package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution94 {
    /**
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     * Inorder: left -> root -> right
     * root is inorder
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        inorderTraverseIteratively(root, answer);
        return answer;
    }

    /**
     * Time complexity : O(N)
     * Space complexity: O(H), ⌈log(N+1)⌉ - 1 <= H(= height of binary tree) <= N - 1
     */
    public void inorderTraverseRecursively(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        // left
        inorderTraverseRecursively(root.left, list);
        // root
        list.add(root.val);
        // right
        inorderTraverseRecursively(root.right, list);
    }

    /**
     * Time complexity : O(N)
     * Space complexity: O(H), ⌈log(N+1)⌉ - 1 <= H(= height of binary tree) <= N - 1
     */
    public void inorderTraverseIteratively(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                // move to leftmost
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            list.add(current.val);
            // if current has right node, move to leftmost
            current = current.right;
        }
    }

    public static void main(String[] args) {
        Solution94 solution94 = new Solution94();
        List<Integer> answer;
        TreeNode root = TreeNode.generate(new Integer[]{1, null, 2, 3});
        answer = solution94.inorderTraversal(root);
        root = TreeNode.generate(new Integer[]{});
        answer = solution94.inorderTraversal(root);
        root = TreeNode.generate(new Integer[]{1});
        answer = solution94.inorderTraversal(root);
        root = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7}); // 4,2,5,1,6,3,7
        answer = solution94.inorderTraversal(root);
    }
}
