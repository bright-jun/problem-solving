package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution234 {
	/*
	 * The number of nodes in the list is in the range [1, 10^5].
	 * 0 <= Node.val <= 9
	 * Follow up: Could you do it in O(n) time and O(1) space?
	 */
	public boolean isPalindrome(ListNode head) {
		return false;
	}

	public static void main(String[] args) {
		Solution234 solution234 = new Solution234();
		ListNode head;
		boolean answer;
		
		head = ListNode.generate(new Integer[] { 1, 2, 2, 1 });
		answer = solution234.isPalindrome(head);
		head = ListNode.generate(new Integer[] { 1, 2 });
		answer = solution234.isPalindrome(head);

		return;

	}
}
