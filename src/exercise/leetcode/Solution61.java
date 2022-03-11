package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution61 {
	// node		: 0 1 2 3 4 / length 5
	// rotate	: 0 4 3 2 1 (5 - 5%5)%5
	//            5 9 8 7 6 
	
	public ListNode rotateRight(ListNode head, int k) {

		if (head == null) {
			return null;
		}

		int listLength = 1;
		ListNode nowNode = head;
		while (nowNode.next != null) {
			nowNode = nowNode.next;
			listLength++;
		}

		int target = (listLength - k % listLength) % listLength;
		if (target == 0) {
			return head;
		}

		// link end to first
		nowNode = head;
		for (int i = 0; i < listLength - 1; i++) {
			nowNode = nowNode.next;
		}

		ListNode endOfNode = nowNode;
		endOfNode.next = head;

		// de-link target-1 ~/~ target
		nowNode = head;
		for (int i = 0; i < target - 1; i++) {
			nowNode = nowNode.next;
		}

		ListNode beforeTargetNode = nowNode;
		ListNode targetNode = beforeTargetNode.next;
		beforeTargetNode.next = null;

		return targetNode;
	}
	
	public static void main(String[] args) {
		Solution61 solution61 = new Solution61();
		ListNode head;
		head= new ListNode(1, new ListNode(2));	 
		solution61.rotateRight(head, 1); // [2,1]
		head= new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		solution61.rotateRight(head, 0);
		head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		solution61.rotateRight(head, 1);
	}
}
