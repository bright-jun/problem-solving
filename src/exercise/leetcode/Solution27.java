package exercise.leetcode;

public class Solution27 {

    /**
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 50
     * 0 <= val <= 100
     * The order of the elements may be changed.
     */
    public int removeElement(int[] nums, int val) {
        return removeElement_1(nums, val);
    }

    /**
     * in-place
     * Time: O(N)
     * Space: O(1)
     */
    public int removeElement_1(int[] nums, int val) {
        int allocatedIdx = 0;
        for (int num : nums) {
            if (num != val) {
                nums[allocatedIdx++] = num;
            }
        }
        return allocatedIdx;
    }

    public static void main(String[] args) {
        Solution27 solution27 = new Solution27();
        int answer;
        int[] nums;
        nums = new int[]{3, 2, 2, 3};
        answer = solution27.removeElement(nums, 3); // answer: [2,2,_,_]
        nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        answer = solution27.removeElement(nums, 2); // answer: [0,1,3,0,4,_,_,_]
    }
}
