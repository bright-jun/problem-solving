package exercise.leetcode;

public class Solution55 {
    /**
     * 1 <= nums.length <= 10^4
     * 0 <= nums[i] <= 10^5
     */
    public boolean canJump(int[] nums) {
        return canJump_1(nums);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public boolean canJump_1(int[] nums) {
        // sum each element of idx = maxJump
        // search greedy if you can
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i;
        }
        int max = nums.length - 1;
        int maxJump = Integer.MIN_VALUE;

        int i = 0;
        while (i < nums.length) {
            // can reach end
            if (nums[i] >= max) {
                return true;
            } else {
                // update maxJump
                maxJump = Integer.max(maxJump, nums[i]);
                if (i >= maxJump) {
                    // maxJump but end
                    return false;
                } else { // i < maxJump
                    // you can search more
                    i++;
                }
            }
        }
        return false;

        /*
         * { 2, 3, 1, 1, 4 }
         * { 0, 1, 2, 3, x }
         * +
         * { 2, 3, 1, 1, x }
         * { 2, 4, 3, 4, x }
         *
         * { 3, 2, 1, 0, 4 }
         * { 0, 1, 2, 3, x }
         * +
         * { 3, 2, 1, 0, x }
         * { 3, 3, 3, 3, x }
         *
         * { 3, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 4 }
         * { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, x }
         * +
         * { 3, 10, 3, 3, 4, 5, 6, 7, 8, 9, 10, x }
         */
    }

    public static void main(String[] args) {
        Solution55 solution55 = new Solution55();
        boolean answer;
        answer = solution55.canJump(new int[]{2, 3, 1, 1, 4});
        answer = solution55.canJump(new int[]{3, 2, 1, 0, 4});
    }
}
