package exercise.leetcode;

class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class Solution148 {
	/*
	 * The number of nodes in the list is in the range [0, 5 * 10^4]. -10^5 <=
	 * Node.val <= 10^5
	 * 
	 * Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant
	 * space)?
	 * 
	 */
	public void swap(ListNode n1, ListNode n2) {
		ListNode temp = n1.next;
		n1.next = n2.next;
		n2.next = temp;
	}
    
    public void swapVal(ListNode n1, ListNode n2) {
		int temp = n1.val;
		n1.val = n2.val;
		n2.val = temp;
	}
    
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		// bubble sort
		head.next = sortList(head.next);

		if (head.val <= head.next.val) {
			// sorted well
			return head;
		} else {
			// need sort
			ListNode now = head;
			while (now.next != null) {
				if (now.val > now.next.val) {
					swapVal(now, now.next);
					now = now.next;
				} else {
					break;
				}
			}
			return head;
		}
	}

	public static void main(String[] args) {
		Solution148 solution148 = new Solution148();

		ListNode[] listNodeArray = new ListNode[4];
		for (int i = 0; i < listNodeArray.length; i++) {
			listNodeArray[i] = new ListNode(i);
		}
		listNodeArray[0] = new ListNode(4);
		listNodeArray[1] = new ListNode(2);
		listNodeArray[2] = new ListNode(1);
		listNodeArray[3] = new ListNode(3);
		
		listNodeArray[0].next = listNodeArray[1];  
		listNodeArray[1].next = listNodeArray[2];
		listNodeArray[2].next = listNodeArray[3];
		                    
		solution148.sortList(listNodeArray[0]);
		/*
		 * 4 2 1 3
		 */

		listNodeArray = new ListNode[5];
		for (int i = 0; i < listNodeArray.length; i++) {
			listNodeArray[i] = new ListNode();
		}
		listNodeArray[0] = new ListNode(-1, listNodeArray[1]);
		listNodeArray[1] = new ListNode(5, listNodeArray[2]);
		listNodeArray[2] = new ListNode(3, listNodeArray[3]);
		listNodeArray[3] = new ListNode(4, listNodeArray[4]);
		listNodeArray[4] = new ListNode(0);
		solution148.sortList(listNodeArray[0]);

		solution148.sortList(new ListNode());
		return;
	}
}
