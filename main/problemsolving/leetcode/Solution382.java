package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.ListNode;

public class Solution382 {
    /*
     * The number of nodes in the linked list will be in the range [1, 10^4].
     * -10^4 <= Node.val <= 10^4
     * At most 10^4 calls will be made to getRandom.
     */
    private ListNode head;

    public Solution382(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        return getRandom_sol1();
    }

    /*
     * Time: O(N)
     * Space: O(N)
     */
    public int getRandom_sol1() {
        int lSize = 0;
        ListNode now = head;
        while (now != null) {
            lSize++;
            now = now.next;
        }

        int randIndex = (int) (Math.random() * lSize);

        ListNode target = head;
        for (int i = 0; i < randIndex; i++) {
            target = target.next;
        }

        return target.val;
    }

    /*
     * Time: O(N)
     * Space: O(1)
     */
    public int getRandom_sol2() {
        int count = 0;
        int result = 0;
        ListNode curr = head;

        while (curr != null) {
            // Reservoir sampling
            count++;
            if ((int) (Math.random() * count) == 0) {
                result = curr.val;
            }
            curr = curr.next;
        }

        return result;
    }

    public static void main(String[] args) {
        int answer;
        ListNode head = ListNode.generate(new Integer[]{1, 2, 3});
        Solution382 solution382 = new Solution382(head);
        for (int i = 0; i < 10; i++) {
            answer = solution382.getRandom();
        }
    }
}
