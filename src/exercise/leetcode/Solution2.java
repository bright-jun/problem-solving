package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode answer = new ListNode();

		int ans = 0;
		int carry = 0;
		ListNode l1Now = l1;
		ListNode l2Now = l2;

		ListNode ansNow = answer;
		while (l1Now != null || l2Now != null || carry > 0) {

			int l1val = l1Now == null ? 0 : l1Now.val;
			int l2val = l2Now == null ? 0 : l2Now.val;

			ans = (l1val + l2val + carry) % 10;
			carry = (l1val + l2val + carry) / 10;

			ansNow.val = ans;

			if (l1Now != null) {
				l1Now = l1Now.next;
			}
			if (l2Now != null) {
				l2Now = l2Now.next;
			}

			if (l1Now != null || l2Now != null || carry > 0) {
				ansNow.next = new ListNode();
				ansNow = ansNow.next;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution2 solution2 = new Solution2();
		ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		solution2.addTwoNumbers(l1, l2);
		// last carry only case
		// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
		// Output: [8,9,9,9,0,0,0,1]
	}
}
