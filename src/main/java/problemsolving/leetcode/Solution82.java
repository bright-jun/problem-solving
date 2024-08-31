package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution82 {
    /*
     * 1 1 2 2 3 4 5 ans o n n n n now o o next o
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        ListNode now = head;
        arrayList.add(now.val);
        while (now.next != null) {
            arrayList.add(now.next.val);
            now = now.next;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i : arrayList) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }

        arrayList = new ArrayList<Integer>();

        for (int i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) {
                arrayList.add(i);
            }
        }

        if (arrayList.size() == 0) {
            return null;
        }

        arrayList.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        ListNode[] listNodeList = new ListNode[arrayList.size()];
        for (int i = 0; i < listNodeList.length; i++) {
            listNodeList[i] = new ListNode();
        }
//		for (ListNode listNode : listNodeList) {
//			listNode = new ListNode();
//		}
        for (int i = 0; i < arrayList.size() - 1; i++) {
            listNodeList[i].val = arrayList.get(i);
            listNodeList[i].next = listNodeList[i + 1];
        }
        listNodeList[arrayList.size() - 1].val = arrayList.get(arrayList.size() - 1);

        return listNodeList[0];
		
		/*
		ListNode ans = new ListNode(-999, head);

		ListNode nextNode = ans.next;
		while (true) {
			if (nextNode == null) {
				break;
			} else {
				if (nextNode.next == null || nextNode.val != nextNode.next.val) {
					nextNode.next = nextNode.next;
					nextNode = nextNode.next; // move next
					break;
				} else {
					ListNode findNextNode = nextNode;
					// skip next till find diff node
					while (true) {
						if (findNextNode.next == null || nextNode.val != findNextNode.next.val) {
							findNextNode = findNextNode.next;
							break;
						}
						findNextNode = findNextNode.next;
					}
					nextNode.next = findNextNode;
				}
			}
			// move next
			nextNode = nextNode.next;
		}

		return ans.next;
		*/
    }

    public static void main(String[] args) {
        Solution82 solution82 = new Solution82();
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(3);
        ListNode listNode6 = new ListNode(4);
        ListNode listNode7 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;

        solution82.deleteDuplicates(listNode1);
    }
}
