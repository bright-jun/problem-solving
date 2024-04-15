package exercise.leetcode;

public class Solution503 {
    /**
     * 1 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     */
    public int[] nextGreaterElements(int[] nums) {
        return nextGreaterElements_0(nums);
    }

    /**
     * Time: O(N^2), almost TLE
     * Space: O(N)
     */
    public int[] nextGreaterElements_0(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (nums[i] < nums[(i + j) % n]) {
                    answer[i] = nums[(i + j) % n];
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] answer;
        answer = solution503.nextGreaterElements(new int[]{1, 2, 1});
        answer = solution503.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        answer = solution503.nextGreaterElements(new int[]{5, 4, 3, 2, 1});
    }
}
