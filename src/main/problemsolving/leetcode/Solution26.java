package problemsolving.leetcode;

public class Solution26 {
    /**
     * 1 <= nums.length <= 3 * 10^4
     * -100 <= nums[i] <= 100
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
            if (allocatedIdx == 0 || num != nums[allocatedIdx - 1]) {
                nums[allocatedIdx++] = num;
            }
        }
        return allocatedIdx;
    }

    public static void main(String[] args) {
        Solution26 solution26 = new Solution26();
        int answer;
        answer = solution26.removeDuplicates(new int[]{1, 1, 2}); // answer: 2, [1,2,_]
        answer = solution26.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}); // answer: 5, [0,1,2,3,4,_,_,_,_,_]
    }
}
