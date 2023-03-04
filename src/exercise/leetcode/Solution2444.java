package exercise.leetcode;

public class Solution2444 {
    /*
     * 2 <= nums.length <= 10^5
     * 1 <= nums[i], minK, maxK <= 10^6
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        return countSubarrays_sol1(nums, minK, maxK);
    }

    /*
     * Time:
     * Space:
     */
    public long countSubarrays_sol1(int[] nums, int minK, int maxK) {
        return -1;
    }

    public static void main(String[] args) {
        Solution2444 solution2444 = new Solution2444();
        long answer;
        answer = solution2444.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
        answer = solution2444.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1);
    }
}
