package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

public class Solution92 {
	/*
	 * The number of nodes in the list is n.
	 * 1 <= n <= 500
	 * -500 <= Node.val <= 500
	 * 1 <= left <= right <= n
	 * Follow up: Could you do it in one pass?
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {

		if (left == right) {
			return head;
		}

		int idx = 1;

		ListNode nowNode = head;
		ListNode leftNode = null; // ( left - 1 ) node
		ListNode rightNode = null; // ( right + 1 ) node
		ListNode reverseTail = new ListNode();
		ListNode reverseNext = new ListNode();
		ListNode reverseNextNext = null;

		while (nowNode != null) {
			if (idx == left - 1) {
				leftNode = nowNode;
			}
			if (idx == left) {
				reverseTail.val = nowNode.val;
				reverseNext = new ListNode();
				reverseNext.next = reverseTail;
			}
			if (left < idx && idx < right) {
				reverseNext.val = nowNode.val;
				reverseNextNext = new ListNode();
				reverseNextNext.next = reverseNext;
				reverseNext = reverseNextNext;
			}
			if (idx == right) {
				reverseNext.val = nowNode.val;
			}
			if (idx == right + 1) {
				rightNode = nowNode;
			}
			nowNode = nowNode.next;
			idx++;
		}

		if (leftNode != null) {
			leftNode.next = reverseNext;
		} else {
			head = reverseNext;
		}

		if (rightNode != null) {
			reverseTail.next = rightNode;
		}

		return head;
	}

	public static void main(String[] args) {
		Solution92 solution92 = new Solution92();
		ListNode answer;
		/*
		 * Input: head = [1,2,3,4,5], left = 2, right = 4
		 * Output: [1,4,3,2,5]
		 */
		ListNode head = ListNode.generate(new Integer[] { 1, 2, 3, 4, 5 });
		answer = solution92.reverseBetween(head, 2, 4);
		
		/*
		 * Input: head = [5], left = 1, right = 1
		 * Output: [5]
		 */
		head = ListNode.generate(new Integer[] { 5 });
		answer = solution92.reverseBetween(head, 1, 1);
		
		/*
		 * Input: head = [3,5], left = 2, right = 2
		 * Input: [3,5]
		 */
		head = ListNode.generate(new Integer[] { 3, 5 });
		answer = solution92.reverseBetween(head, 2, 2);
		
		/*
		 * Input: head = [3,5], left = 1, right = 2
		 * Input: [5,3]
		 */
		head = ListNode.generate(new Integer[] { 3, 5 });
		answer = solution92.reverseBetween(head, 1, 2);
		
		return;
	}
}
