package exercise.leetcode;

public class Solution496 {
    /**
     * 1 <= nums1.length <= nums2.length <= 1000
     * 0 <= nums1[i], nums2[i] <= 104
     * All integers in nums1 and nums2 are unique.
     * All the integers of nums1 also appear in nums2.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        return nextGreaterElement_0(nums1, nums2);
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

    public static void main(String[] args) {
        Solution496 solution496 = new Solution496();
        int[] answer;
        answer = solution496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        answer = solution496.nextGreaterElement(new int[]{2, 4}, new int[]{1, 2, 3, 4});
    }
}
