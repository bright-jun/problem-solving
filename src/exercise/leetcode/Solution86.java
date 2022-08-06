package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

public class Solution86 {
	/*
	 * The number of nodes in the list is in the range [0, 200].
	 * -100 <= Node.val <= 100
	 * -200 <= x <= 200
	 */
	public ListNode partition(ListNode head, int x) {

		if(head == null) {
			return null;
		}
		
		ListNode tailHead = null;
		ListNode tailNow = null;

		ListNode nowNode = head;
		ListNode beforeNode = null;

		while (nowNode.next != null) {
			if (nowNode.val >= x) {
				// pop
				if (beforeNode == null) {
					// pop from head
					if (tailHead == null) {
						tailHead = new ListNode(nowNode.val);
						tailNow = tailHead;
					} else {
						tailNow.next = new ListNode(nowNode.val);
						tailNow = tailNow.next;
					}
					head = nowNode.next;
				} else {
					// pop from middle
					if (tailHead == null) {
						tailHead = new ListNode(nowNode.val);
						tailNow = tailHead;
					} else {
						tailNow.next = new ListNode(nowNode.val);
						tailNow = tailNow.next;
					}
					beforeNode.next = nowNode.next;
				}
			} else {
				// set beforeNode
				beforeNode = nowNode;
			}
			nowNode = nowNode.next;
		}
		nowNode.next = tailHead;

		return head;
	}
	
	public static void main(String[] args) {
		Solution86 solution86 = new Solution86();
		ListNode answer;
		/*
		 * Input: head = [1,4,3,2,5,2], x = 3
		 * Output: [1,2,2,4,3,5]
		 */
		ListNode head = ListNode.generate(new Integer[] { 1, 4, 3, 2, 5, 2 });
		answer = solution86.partition(head, 3);
		
		/*
		 * Input: head = [2,1], x = 2
		 * Output: [1,2]
		 */
		head = ListNode.generate(new Integer[] { 2, 1 });
		answer = solution86.partition(head, 2);
		
		/*
		 * Input: head = [], x = 2
		 * Output: []
		 */
		head = ListNode.generate(new Integer[] {});
		answer = solution86.partition(head, 2);
		
		/*
		 * Input: head = [1,4,3,0,5,2], x = 2
		 * Output: [1,0,4,3,5,2]
		 */
		head = ListNode.generate(new Integer[] { 1, 4, 3, 0, 5, 2 });
		answer = solution86.partition(head, 2);
		
		return;
	}
}
