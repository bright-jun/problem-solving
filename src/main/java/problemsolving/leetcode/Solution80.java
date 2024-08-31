package problemsolving.leetcode;

public class Solution80 {
    /**
     * 1 <= nums.length <= 3 * 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums is sorted in non-decreasing order.
     */
    public int removeDuplicates(int[] nums) {
        return removeDuplicates_1(nums);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int removeDuplicates_1(int[] nums) {
        int allocatedIdx = 0;
        for (int num : nums) {
            if (allocatedIdx <= 1 || num != nums[allocatedIdx - 2]) {
                nums[allocatedIdx++] = num;
            }
        }
        return allocatedIdx;
    }

    public static void main(String[] args) {
        Solution80 solution80 = new Solution80();
        int answer;
        answer = solution80.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}); // 5, nums = [1,1,2,2,3,_]
        answer = solution80.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}); // 7, nums = [0,0,1,1,2,3,3,_,_]
    }
}
