package exercise.leetcode;

import java.util.Arrays;

public class Solution2444 {
    /*
     * 2 <= nums.length <= 10^5
     * 1 <= nums[i], minK, maxK <= 10^6
     */
    public long countSubarrays(int[] nums, int minK, int maxK) {
        return countSubarrays_sol1(nums, minK, maxK);
    }

    /*
     * Time: O(N^2)
     * Space: O(1)
     */
    public long countSubarrays_sol1(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long answer = 0;
        // 2-pointer [start, end]
        int minCount;
        int maxCount;
        int start;
        for (start = 0; start < n; start++) {
            // find minimum sub-array matches condition
            // find start
            if (nums[start] >= minK && nums[start] <= maxK) {
                // remove now start count
                minCount = 0;
                maxCount = 0;
                int end;
                for (end = start; end < n; end++) {
                    if (nums[end] >= minK && nums[end] <= maxK) {
                        if (nums[end] == minK) {
                            minCount++;
                        }
                        if (nums[end] == maxK) {
                            maxCount++;
                        }
                        if (minCount > 0 && maxCount > 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (end == n) {
                    end = n - 1;
                }
                // [start, end]
                // check if sub-array matches condition
                if (minCount > 0 && maxCount > 0) {
                    // find left count available
                    int leftCount = 1;
                    int tempMinCount = minCount;
                    int tempMaxCount = maxCount;
                    for (int i = start; i < end; i++) {
                        if (nums[i] == minK) {
                            tempMinCount--;
                        }
                        if (nums[i] == maxK) {
                            tempMaxCount--;
                        }
                        if (tempMinCount > 0 && tempMaxCount > 0) {
                            leftCount++;
                        } else {
                            // next start not min, max value
                            start = i;
                            break;
                        }
                    }
                    // find right count available
                    int rightCount = 0;
                    for (int i = end; i < n; i++) {
                        if (nums[i] >= minK && nums[i] <= maxK) {
                            rightCount++;
                        } else {
                            break;
                        }
                    }
                    answer += leftCount * rightCount;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2444 solution2444 = new Solution2444();
        long answer;
//        answer = solution2444.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
//        answer = solution2444.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1);
        answer = solution2444.countSubarrays(new int[]{5, 5, 3, 1, 3, 5, 2, 5, 2, 1, 3, 5, 7, 5}, 1, 5); // 46
        // TLE
        int[] nums = new int[100];
        Arrays.fill(nums, 1);
        answer = solution2444.countSubarrays(nums, 1, 1);
    }
}
