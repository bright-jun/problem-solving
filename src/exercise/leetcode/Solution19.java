package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution19 {
	/*
	 * The number of nodes in the list is sz.
	 * 1 <= sz <= 30
	 * 0 <= Node.val <= 100
	 * 1 <= n <= sz
	 */
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head.next == null) {
			return null;
		}

		// create dummy as -1th node (before_target)
		ListNode dummy = new ListNode(-1, head);
		ListNode before_target = dummy;
		ListNode tail = head;
		for (int i = 0; i < n - 1; i++) {
			tail = tail.next;
		}
		while (true) {
			if (tail.next == null) {
				// find end
				before_target.next = before_target.next.next;
				break;
			}
			// move next
			before_target = before_target.next;
			tail = tail.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		Solution19 solution19 = new Solution19();
		ListNode head;
		head = ListNode.generate(new Integer[] { 1, 2, 3, 4, 5 });
		head = solution19.removeNthFromEnd(head, 2);
		head = ListNode.generate(new Integer[] { 1 });
		head = solution19.removeNthFromEnd(head, 1);
		head = ListNode.generate(new Integer[] { 1, 2 });
		head = solution19.removeNthFromEnd(head, 1);
		head = ListNode.generate(new Integer[] { 1, 2 });
		head = solution19.removeNthFromEnd(head, 2);
		return;
	}
}
