package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * <p>
 * 3 <= list1.length <= 10^4
 * 1 <= a <= b < list1.length - 1
 * 1 <= list2.length <= 10^4
 */
public class Solution1669 {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode nodeA = list1;
        for (int i = 0; i < a - 1; i++) {
            nodeA = nodeA.next;
        }
        ListNode nodeB = list1;
        for (int i = 0; i < b + 1; i++) {
            nodeB = nodeB.next;
        }
        nodeA.next = list2;

        ListNode last = list2;
        while (last.next != null) {
            last = last.next;
        }
        last.next = nodeB;

        return list1;
    }

    public static void main(String[] args) {
        Solution1669 solution1669 = new Solution1669();
        ListNode answer = null;
        ListNode listNode1 = ListNode.generate(new Integer[]{10, 1, 13, 6, 9, 5});
        ListNode listNode2 = ListNode.generate(new Integer[]{1000000, 1000001, 1000002});
        answer = solution1669.mergeInBetween(listNode1, 3, 4, listNode2);

        listNode1 = ListNode.generate(new Integer[]{0, 1, 2, 3, 4, 5, 6});
        listNode2 = ListNode.generate(new Integer[]{1000000, 1000001, 1000002, 1000003, 1000004});
        answer = solution1669.mergeInBetween(listNode1, 2, 5, listNode2);
    }
}
