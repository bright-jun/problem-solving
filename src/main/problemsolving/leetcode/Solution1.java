package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution1 {
    /*
     * 2 <= nums.length <= 10^4
     * -10^9 <= nums[i] <= 10^9
     * -10^9 <= target <= 10^9
     * Only one valid answer exists.
     */
    public int[] twoSum(int[] nums, int target) {
        return twoSum2(nums, target);
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

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> hm = new HashMap<>(); // {value, indexes}
        for (int i = 0; i < n; i++) {
            int index = i;
            hm.compute(nums[i], (key, value) -> {
                    if (value != null) {
                        value.add(index);
                        return value;
                    } else {
                        List<Integer> newValue = new ArrayList<>();
                        newValue.add(index);
                        return newValue;
                    }
                }
            );
        }

        for (int i = 0; i < n; i++) {
            List<Integer> indexes = hm.get(target - nums[i]);
            if (indexes == null) {
                continue;
            }
            if (indexes.get(0) != i) {
                return new int[]{i, indexes.get(0)};
            } else {
                if (indexes.size() < 2) {
                    continue;
                }
                return new int[]{i, indexes.get(1)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] answer;
        answer = solution1.twoSum(new int[]{2, 7, 11, 15}, 9); // [0,1]
        answer = solution1.twoSum(new int[]{3, 2, 4}, 6); // [1,2]
        answer = solution1.twoSum(new int[]{3, 3}, 6); // [0,1]
    }
}
