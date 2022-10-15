package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution2095 {
	/*
	 * The number of nodes in the list is in the range [1, 10^5].
	 * 1 <= Node.val <= 10^5
	 */
	public ListNode deleteMiddle(ListNode head) {
		if (head.next == null) {
			return null;
		}

		if (head.next.next == null) {
			head.next = head.next.next;
			return head;
		}

		ListNode before_mid = head;
		ListNode mid = head.next;
		ListNode tail = head.next.next;

		while (true) {
			// length is odd
			if (tail.next == null) {
				before_mid.next = before_mid.next.next;
				break;
			}
			// length is even
			if (tail.next.next == null) {
				mid.next = mid.next.next;
				break;
			}
			// move next
			before_mid = before_mid.next;
			mid = mid.next;
			tail = tail.next.next;
		}

		return head;
	}

	public static void main(String[] args) {
		Solution2095 solution2095 = new Solution2095();
		ListNode head;
		head = ListNode.generate(new Integer[] { 1, 3, 4, 7, 1, 2, 6 });
		solution2095.deleteMiddle(head); // delete 7
		head = ListNode.generate(new Integer[] { 1, 2, 3, 4 });
		solution2095.deleteMiddle(head); // delete 3
		head = ListNode.generate(new Integer[] { 1, 2, 3 });
		solution2095.deleteMiddle(head); // delete 2
		head = ListNode.generate(new Integer[] { 2, 1 });
		solution2095.deleteMiddle(head); // delete 1
		head = ListNode.generate(new Integer[] { 2 });
		solution2095.deleteMiddle(head); // delete 2
		return;
	}
}
