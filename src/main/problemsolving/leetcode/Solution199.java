package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution199 {
    /**
     * The number of nodes in the tree is in the range [0, 100].
     * -100 <= Node.val <= 100
     */
    public List<Integer> rightSideView(TreeNode root) {
        return rightSideView1(root);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public List<Integer> rightSideView1(TreeNode root) {
        // BFS
        List<Integer> answer = new ArrayList<>();
        if (root == null) {
            return answer;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int rightMost = 0;
            // left to right
            for (int i = 0, queueSize = queue.size(); i < queueSize; i++) {
                TreeNode now = queue.poll();
                rightMost = now.val;
                if (now.left != null) {
                    queue.add(now.left);
                }
                if (now.right != null) {
                    queue.add(now.right);
                }
            }
            answer.add(rightMost);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution199 solution199 = new Solution199();
        TreeNode root;
        List<Integer> answer;
        root = TreeNode.generate(new Integer[]{1, 2, 3, null, 5, null, 4});
        answer = solution199.rightSideView(root);
        root = TreeNode.generate(new Integer[]{1, null, 3});
        answer = solution199.rightSideView(root);
        root = TreeNode.generate(new Integer[]{});
        answer = solution199.rightSideView(root);
        root = TreeNode.generate(new Integer[]{1, 2, 3, null, 5, null, 4, 6});
        answer = solution199.rightSideView(root);
    }
}
