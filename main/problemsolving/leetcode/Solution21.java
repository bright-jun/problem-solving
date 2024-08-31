package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

public class Solution21 {
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null && list2 == null) {
			return null;
		} else if (list1 == null && list2 != null) {
			return list2;
		} else if (list1 != null && list2 == null) {
			return list1;
		}

		ListNode ans = new ListNode();
		
		// two pointer
		ListNode point1 = list1;
		ListNode point2 = list2;
		
		if(point1.val <= point2.val) {
			ans = point1;
			point1 = point1.next;
			// end of list
			if(point1 == null) {
				ans.next = point2;
			}
		} else {
			ans = point2;
			point2 = point2.next;
			// end of list
			if(point2 == null) {
				ans.next = point1;
			}
		}
		
		return ans;
	}

	public static void main(String[] args) {
		Solution21 solution21 = new Solution21();
		ListNode list1 = new ListNode();
		/*
		 * [1,2,4]
		 * [1,3,4]
		 */
		ListNode list2 = new ListNode();
		System.out.println(solution21.mergeTwoLists(list1, list2));
	}
}
