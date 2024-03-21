package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

/**
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 */
public class Solution206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode right = new ListNode(cur.val, null);
        while (cur.next != null) {
            cur = cur.next;
            ListNode left = new ListNode(cur.val, right);
            right = left;
        }

        return right;
    }

    public static void main(String[] args) {
        Solution206 solution206 = new Solution206();
        ListNode head = ListNode.generate(new Integer[]{1, 2, 3, 4, 5});
        head = solution206.reverseList(head);
        head = ListNode.generate(new Integer[]{1, 2});
        head = solution206.reverseList(head);
        head = ListNode.generate(new Integer[]{});
        head = solution206.reverseList(head);
    }
}
