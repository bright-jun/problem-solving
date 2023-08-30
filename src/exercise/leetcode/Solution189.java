package exercise.leetcode;

public class Solution189 {
    /**
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     */
    public void rotate(int[] nums, int k) {
        rotate_1(nums, k);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public void rotate_1(int[] nums, int k) {
        int kk = k % nums.length;
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = nums[(nums.length + i - kk) % nums.length];
        }

        System.arraycopy(answer, 0, nums, 0, nums.length);
    }


    public static void main(String[] args) {
        Solution189 solution189 = new Solution189();
        int[] nums;
        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        solution189.rotate(nums, 3); // [5,6,7,1,2,3,4]
        nums = new int[]{-1, -100, 3, 99};
        solution189.rotate(nums, 2); // [3,99,-1,-100]
    }
}
