package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution92 {
	/*
	 * The number of nodes in the list is n.
	 * 1 <= n <= 500
	 * -500 <= Node.val <= 500
	 * 1 <= left <= right <= n
	 */
	public ListNode reverseBetween(ListNode head, int left, int right) {
		return null;
	}

	public static void main(String[] args) {
		Solution92 solution92 = new Solution92();
		ListNode answer;
		ListNode head = new ListNode();
		answer = solution92.reverseBetween(head, 2, 4);
		
		head = new ListNode();
		answer = solution92.reverseBetween(head, 1, 1);
	}
}
