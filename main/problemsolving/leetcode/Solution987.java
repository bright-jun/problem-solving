package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.TreeNode;

import java.util.List;

public class Solution987 {
    /*
     * The number of nodes in the tree is in the range [1, 1000].
     * 0 <= Node.val <= 1000
     * There may be multiple nodes in the same row and same column.
     * In such a case, sort these nodes by their values.
     */
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // Search -> mark (depth, index) & add answerList

        // sort every elementList of answerList by their values.

        return null;
    }

    public static void main(String[] args) {
        Solution987 solution987 = new Solution987();

        List<List<Integer>> answer;
        TreeNode root;

        root = TreeNode.generate(new Integer[]{3, 9, 20, null, null, 15, 7});
        // [[9],[3,15],[20],[7]]
        answer = solution987.verticalTraversal(root);

        root = TreeNode.generate(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        // [[4],[2],[1,5,6],[3],[7]]
        answer = solution987.verticalTraversal(root);

        root = TreeNode.generate(new Integer[]{1, 2, 3, 4, 6, 5, 7});
        // [[4],[2],[1,5,6],[3],[7]]
        answer = solution987.verticalTraversal(root);

        return;
    }
}
