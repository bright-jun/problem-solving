package exercise.leetcode;

import exercise.leetcode.datastructure.ListNode;

import java.util.PriorityQueue;

public class Solution23 {
    /**
     * k == lists.length
     * 0 <= k <= 10^4
     * 0 <= lists[i].length <= 500
     * -10^4 <= lists[i][j] <= 10^4
     * lists[i] is sorted in ascending order.
     * The sum of lists[i].length will not exceed 104.
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists_1(lists);
    }

    /**
     * Time: O(NlogN)
     * Space: O(N)
     */
    private ListNode mergeKLists_1(ListNode[] lists) {
        ListNode answer = null;
        ListNode last = answer;

        // Using Heap(Priority Queue)
        PriorityQueue<ListNode> pq = new PriorityQueue<>((ln1, ln2) -> ln1.val - ln2.val);
        for (int k = 0; k < lists.length; k++) {
            if (lists[k] != null) {
                pq.offer(lists[k]);
            }
        }

        while (!pq.isEmpty()) {
            ListNode minimum = pq.poll();
            if (minimum.next != null) {
                pq.offer(minimum.next);
            }

            if (last == null) {
                last = new ListNode(minimum.val, null);
                answer = last;
            } else {
                last.next = new ListNode(minimum.val, null);
                last = last.next;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNode.generate(new Integer[]{1, 4, 5});
        lists[1] = ListNode.generate(new Integer[]{1, 3, 4});
        lists[2] = ListNode.generate(new Integer[]{2, 6});
        solution23.mergeKLists(lists);

        lists = new ListNode[1];
        lists[0] = null;
        solution23.mergeKLists(lists);

        lists = new ListNode[0];
        solution23.mergeKLists(lists);
    }
}
