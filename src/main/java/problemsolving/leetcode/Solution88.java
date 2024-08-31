package problemsolving.leetcode;

import java.util.Arrays;

public class Solution88 {
    /**
     * nums1.length == m + n
     * nums2.length == n
     * 0 <= m, n <= 200
     * 1 <= m + n <= 200
     * -10^9 <= nums1[i], nums2[j] <= 10^9
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        merge_1(nums1, m, nums2, n);
    }

    /**
     * Time : O(m + n)
     * Space: O(1)
     */
    public void merge_1(int[] nums1, int m, int[] nums2, int n) {
        int totalIdx = m + n - 1;
        int idx1 = m - 1;
        int idx2 = n - 1;

        while (true) {
            if (idx1 >= 0 && idx2 >= 0) {
                if (nums1[idx1] > nums2[idx2]) {
                    nums1[totalIdx--] = nums1[idx1--];
                } else {
                    nums1[totalIdx--] = nums2[idx2--];
                }
            } else if (idx1 >= 0) {
                nums1[totalIdx--] = nums1[idx1--];
            } else if (idx2 >= 0) {
                nums1[totalIdx--] = nums2[idx2--];
            } else {
                break;
            }
        }
    }

    /**
     * Time : O(m + n)
     * Space: O(m + n)
     */
    public void merge_2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m + n];
        int totalIdx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while (true) {
            if (idx1 < m && idx2 < n) {
                if (nums1[idx1] < nums2[idx2]) {
                    nums[totalIdx++] = nums1[idx1++];
                } else {
                    nums[totalIdx++] = nums2[idx2++];
                }
            } else if (idx1 < m) {
                nums[totalIdx++] = nums1[idx1++];
            } else if (idx2 < n) {
                nums[totalIdx++] = nums2[idx2++];
            } else {
                break;
            }
        }
        // why reference of nums1 didn't change to nums?
        // Java uses Pass-by-Value https://stackoverflow.com/a/40523/10837658
        // this changes only the value of the nums1 reference, not the real reference value of nums1
        // nums1 = nums;
        // you need to deep copy
        for (int i = 0; i < m + n; i++) {
            nums1[i] = nums[i];
        }
    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] nums1;
        int[] nums2;
        nums1 = new int[]{1, 2, 3, 0, 0, 0};
        nums2 = new int[]{2, 5, 6};
        solution88.merge_2(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{1};
        nums2 = new int[]{};
        solution88.merge_2(nums1, 1, nums2, 0);
        System.out.println(Arrays.toString(nums1));
        nums1 = new int[]{0};
        nums2 = new int[]{1};
        solution88.merge_2(nums1, 0, nums2, 1);
        System.out.println(Arrays.toString(nums1));
        return;
    }
}
