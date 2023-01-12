package exercise.leetcode;

import exercise.leetcode.datastructure.TreeNode;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {
    /**
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     * Postorder: left -> right -> root
     * root is postorder
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        postorderTraverseIteratively(root, answer);
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

    /**
     * Time complexity : O(N)
     * Space complexity: O(H), ⌈log(N+1)⌉ - 1 <= H(= height of binary tree) <= N - 1
     */
    public void postorderTraverseIteratively(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        Deque<TreeNode> deque = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode now = stack.pop();
            if (now != null) {
                // root
                deque.addFirst(now);
                // poll: left -> right
                // pop -> addFirst: right -> left
                // push: left -> right
                // left
                stack.push(now.left);
                // right
                stack.push(now.right);
            }
        }
        while (!deque.isEmpty()) {
            list.add(deque.poll().val);
        }
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
        root = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7}); // 4,5,2,6,7,3,1
        answer = solution144.postorderTraversal(root);
    }
}
