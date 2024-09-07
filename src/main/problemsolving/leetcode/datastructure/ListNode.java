package problemsolving.leetcode.datastructure;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /**
     * Generate ListNode.
     *
     * @param elements the elements
     * @return the tree node
     * @author Myungjun Kim
     */
    public static ListNode generate(Integer[] elements) {

        if (elements.length == 0) {
            return null;
        }

        List<ListNode> listNodes = Arrays.stream(elements)
            .map(ListNode::integerToListNode)
            .collect(Collectors.toList());

        for (int i = 1; i < listNodes.size(); i++) {
            if (listNodes.get(i) != null) {
                listNodes.get(i - 1).next = listNodes.get(i);
            }
        }

        return listNodes.get(0);
    }

    /**
     * Integer to ListNode.
     *
     * @param element the element
     * @return the tree node
     * @author Myungjun Kim
     */
    public static ListNode integerToListNode(Integer element) {
        if (element == null) {
            return null;
        } else {
            return new ListNode(element);
        }
    }
}
