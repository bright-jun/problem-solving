package problemsolving.leetcode;

import java.util.Arrays;

public class Solution1 {
    /*
     * 2 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * Only one valid answer exists.
     */
    public int[] twoSum(int[] nums, int target) {
        return twoSum1(nums, target);
    }

    /**
     * Time: O(N^2)
     * Space: O(1)
     */
    public int[] twoSum1(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(Arrays.toString(solution1.twoSum(new int[]{2, 7, 11, 15}, 9))); // [0,1]
        System.out.println(Arrays.toString(solution1.twoSum(new int[]{3, 2, 4}, 6))); // [1,2]
        System.out.println(Arrays.toString(solution1.twoSum(new int[]{3, 3}, 6))); // [0,1]
    }
}
