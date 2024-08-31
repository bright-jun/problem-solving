package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

import java.util.Iterator;
import java.util.TreeSet;

public class Solution783 {
    /*
     * The number of nodes in the tree is in the range [2, 100].
     * 0 <= Node.val <= 10^5
     */
    public int minDiffInBST(TreeNode root) {
        return minDiffInBST_sol1(root);
    }

    /*
     * Time: O(N + logN)
     * Space: O(N)
     */
    public int minDiffInBST_sol1(TreeNode root) {
        TreeSet<Integer> treeSet = new TreeSet<Integer>();

        dfs(root, treeSet);

        int diff = Integer.MAX_VALUE;
        Iterator<Integer> iterator = treeSet.iterator();
        Integer before = diff;
        while (iterator.hasNext()) {
            int now = iterator.next();
            diff = Math.min(diff, Math.abs(before - now));
            before = now;
        }
        return diff;
    }

    public void dfs(TreeNode root, TreeSet<Integer> treeSet) {
        if (root == null) {
            return;
        }

        treeSet.add(root.val);

        dfs(root.left, treeSet);
        dfs(root.right, treeSet);
    }

    /*
     * Time: O(N)
     * Space: O(N)
     */
    public TreeNode prev = null;
    public int diff = Integer.MAX_VALUE;

    public int minDiffInBST_sol2(TreeNode root) {
        // recursive by inorder-traversal
        if (root.left != null) {
            minDiffInBST_sol2(root.left);
        }

        if (prev != null) {
            diff = Math.min(diff, root.val - prev.val);
        }
        prev = root;

        if (root.right != null) {
            minDiffInBST_sol2(root.right);
        }
        return diff;
    }

    public static void main(String[] args) {
        Solution783 solution783 = new Solution783();
        int answer;
        TreeNode root;
        root = TreeNode.generate(new Integer[]{4, 2, 6, 1, 3});
        answer = solution783.minDiffInBST(root); // 1
        root = TreeNode.generate(new Integer[]{1, 0, 48, null, null, 12, 49});
        answer = solution783.minDiffInBST(root); // 1
        root = TreeNode.generate(new Integer[]{90, 69, null, 49, 89, null, 52});
        answer = solution783.minDiffInBST(root); // 1
    }
}
