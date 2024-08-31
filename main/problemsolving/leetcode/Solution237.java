package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

public class Solution237 {
    /*
     * The number of the nodes in the given list is in the range [2, 1000].
     * -1000 <= Node.val <= 1000
     * The value of each node in the list is unique.
     * The node to be deleted is in the list and is not a tail node.
     */
    public void deleteNode(ListNode node) {

    }

    public static void main(String[] args) {
        Solution237 solution237 = new Solution237();
        ListNode node;
        node = ListNode.generate(new Integer[]{4, 5, 1, 9});
        solution237.deleteNode(node.next);
        node = ListNode.generate(new Integer[]{4, 5, 1, 9});
        solution237.deleteNode(node.next.next);
        return;
    }
}
