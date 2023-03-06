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
        int minCount = 0;
        int maxCount = 0;
        int start;
        int end;
        for (start = 0, end = start; start < n; start++) {
            // find minimum sub-array matches condition
            // find start
            if (nums[start] >= minK && nums[start] <= maxK) {
                int tempEnd;
                for (tempEnd = end; tempEnd < n; tempEnd++) {
                    if (nums[tempEnd] >= minK && nums[tempEnd] <= maxK) {
                        if (nums[tempEnd] == minK) {
                            minCount++;
                        }
                        if (nums[tempEnd] == maxK) {
                            maxCount++;
                        }
                        if (minCount > 0 && maxCount > 0) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (tempEnd == n) {
                    tempEnd = n - 1;
                }
                end = tempEnd;
                // [start, end]
                // check if sub-array matches condition
                if (minCount > 0 && maxCount > 0) {
                    // find left count available
                    int leftCount = 1;
                    int tempMinCount = minCount;
                    int tempMaxCount = maxCount;
                    for (int i = start; i < tempEnd; i++) {
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
                    for (int i = tempEnd; i < n; i++) {
                        if (nums[i] >= minK && nums[i] <= maxK) {
                            rightCount++;
                        } else {
                            break;
                        }
                    }
                    answer += leftCount * rightCount;
                }
                // remove now start count
                if (nums[start] == minK) {
                    minCount--;
                }
                if (nums[start] == maxK) {
                    maxCount--;
                }
            } else {
                // reset now start count
                minCount = 0;
                maxCount = 0;
                end = start + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution2444 solution2444 = new Solution2444();
        long answer;
        answer = solution2444.countSubarrays(new int[]{1, 3, 5, 2, 7, 5}, 1, 5);
        answer = solution2444.countSubarrays(new int[]{1, 1, 1, 1}, 1, 1);
        answer = solution2444.countSubarrays(new int[]{5, 5, 3, 1, 3, 5, 2, 5, 2, 1, 3, 5, 7, 5}, 1, 5); // 46
        // TLE
        int[] nums = new int[100];
        Arrays.fill(nums, 1);
        answer = solution2444.countSubarrays(nums, 1, 1);
    }
}
