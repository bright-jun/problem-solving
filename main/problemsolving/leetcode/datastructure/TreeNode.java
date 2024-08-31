package problemsolving.leetcode.datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * Generate TreeNode.
     *
     * @param elements the elements
     * @return the tree node
     * @author Myungjun Kim
     */
	public static TreeNode generate(Integer[] elements) {

		if (elements.length == 0) {
			return null;
		}

		Queue<TreeNode> treeNodes = new LinkedList<TreeNode>();
		for (Integer element : elements) {
			treeNodes.add(integerToTreeNode(element));
		}
		Queue<TreeNode> parents = new LinkedList<TreeNode>();

		TreeNode root = treeNodes.poll();
		parents.add(root);
		TreeNode now;

		while (!parents.isEmpty()) {
			now = parents.poll();
			if (now == null) {
				continue;
			}
			now.left = treeNodes.poll();
			now.right = treeNodes.poll();
			parents.add(now.left);
			parents.add(now.right);
		}

		return root;
	}


    /**
     * Integer to TreeNode.
     *
     * @param element the element
     * @return the tree node
     * @author Myungjun Kim
     */
    public static TreeNode integerToTreeNode(Integer element) {
        if (element == null) {
            return null;
        } else {

        	return new TreeNode(element);
        }
    }
}
