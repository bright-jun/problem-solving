package problemsolving.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution496 {
    /**
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 10^4
     * All integers in nums1 and nums2 are unique.
     * All the integers of nums1 also appear in nums2.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreaterElement_1(nums1, nums2);
    }

    /**
     * Time: O(N*M)
     * Space: O(1)
     */
    public int[] nextGreaterElement_0(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums1.length; i++) {
            int ans = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums2[j] == nums1[i]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums2[j]) {
                            ans = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
            nums1[i] = ans;
        }
        return nums1;
    }

    /**
     * Time: O(N)
     * Space: O(M)
     */
    public int[] nextGreaterElement_1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums2[0]);
        for (int i = 1; i < nums2.length; i++) {
            // take smaller stack is belong to nums2[i]
            // 7 4 3 2 5 -> (4,3,2) -> 5, except 7
            while (!stack.empty() && stack.peek() <= nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }

    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] answer;
        answer = solution496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        answer = solution496.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
        answer = solution496.nextGreaterElement(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{7, 5, 3, 2, 4, 6});
    }
}
