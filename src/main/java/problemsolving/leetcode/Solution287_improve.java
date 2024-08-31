package problemsolving.leetcode;

import java.util.HashSet;

public class Solution287_improve {
    /*
     * 1 <= n <= 10^5
     * nums.length == n + 1
     * 1 <= nums[i] <= n
     * All the integers in nums appear only once except for precisely one integer which appears two or more times.
     */
    /*
     * ref : https://leetcode.com/problems/find-the-duplicate-number/discuss/1892921/Java-6-Approaches-Count-%2B-Hash-%2B-Sort-%2B-Binary-Search-%2B-Bit-%2B-Fast-Slow-Pointers
     */
    public int findDuplicate(int[] nums) {
//		not Constant space
//		Time Complexity: O(n)
//		Space Complexity: O(n)
        HashSet<Integer> hs = new HashSet<Integer>();
        for (int num : nums) {
            if (hs.contains(num)) {
                return num;
            } else {
                hs.add(num);
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution287_improve solution287 = new Solution287_improve();
        System.out.println(solution287.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(solution287.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
