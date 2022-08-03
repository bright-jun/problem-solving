package exercise.leetcode.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

        List<TreeNode> treeNodes = Arrays.stream(elements)
            .map(TreeNode::integerToTreeNode)
            .collect(Collectors.toList());

        /*
        0.left  <- 1
		0.right <- 2

		1.left  <- 3
		1.right <- 4
		2.left  <- 5
		2.right <- 6

		3.left  <- 7
		3.right <- 8
		4.left  <- 9
		4.right <- 10
		5.left  <- 11
		5.right <- 12
		6.left  <- 13
		6.right <- 14
         */
        for (int i = 1; i < treeNodes.size(); i++) {
            if (treeNodes.get(i) != null) {
                if (i % 2 == 0) {
                    treeNodes.get((i - 1) / 2).right = treeNodes.get(i);
                } else {
                    treeNodes.get((i - 1) / 2).left = treeNodes.get(i);
                }
            }
        }

        return treeNodes.get(0);
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
