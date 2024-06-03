package exercise.leetcode;

public class Solution209 {
    /*
     * 1 <= target <= 10^9
     * 1 <= nums.length <= 10^5
     * 1 <= nums[i] <= 10^5
     * which the sum is greater than or equal to target
     */
    public int minSubArrayLen(int target, int[] nums) {
        return minSubArrayLen_0(target, nums);
    }

    /**
     * Time: O(N^2)
     * Space: O(1)
     */
    public int minSubArrayLen_0(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        // cumulative sum
        // [2, 3, 1, 2, 4, 3], 7
        // [2, 5, 6, 8, 12, 15], 7
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int from = 0; from < nums.length; from++) {
            for (int to = from + 1; to <= nums.length; to++) {
                if (sum(from, to, nums) >= target) {
                    answer = Math.min(answer, to - from);
                }
            }
        }
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int minSubArrayLen_1(int target, int[] nums) {
        int answer = Integer.MAX_VALUE;

        // cumulative sum (non-decreasing array)
        // [2, 3, 1, 2, 4, 3], 7
        // [2, 5, 6, 8, 12, 15], 7
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        // two pointer & sliding window
        int from = 0;
        int to = 1;
        int sum = sum(from, to, nums); // [from, to)
        while (true) {
            if (sum < target) {
                to++;
                if (to > nums.length) { // OutOfIndexError [0, n]
                    break;
                }
                sum = sum(from, to, nums);
            } else { // (sum >= target)
                answer = Math.min(answer, to - from); // [1,4) -> 3, [0,5) -> 5
                from++;
                if (from >= to) { // [n, n) -> answer = -1
                    break;
                }
                sum = sum(from, to, nums);
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }


    /**
     * Time: O(logN) ~ O(logN!) == O(NlogN)
     * Space: O(1)
     */
    public int minSubArrayLen_2(int target, int[] nums) {
        // finding with binarySearch
        return -1;
    }

    private int sum(int from, int to, int[] culumativeSums) {
        if (from == 0) {
            return culumativeSums[to - 1];
        } else {
            return culumativeSums[to - 1] - culumativeSums[from - 1];
        }
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int answer;
        answer = solution209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}); // 2
        answer = solution209.minSubArrayLen(4, new int[]{1, 4, 4}); // 1
        answer = solution209.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}); // 0
        answer = solution209.minSubArrayLen(11, new int[]{1, 2, 3, 4, 5}); // 3
        answer = solution209.minSubArrayLen(15, new int[]{1, 2, 3, 4, 5}); // 5
    }
}
