package exercise.leetcode;

public class Solution238 {
    /**
     * 2 <= nums.length <= 10^5
     * -30 <= nums[i] <= 30
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */
    public int[] productExceptSelf(int[] nums) {
        return productExceptSelf_1(nums);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int[] productExceptSelf_1(int[] nums) {
        int zeros = 0;
        int products = 1;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else {
                products *= num;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeros > 0) {
                if (nums[i] == 0 && zeros == 1) {
                    nums[i] = products;
                } else {
                    nums[i] = 0;
                }
            } else {
                nums[i] = products / nums[i];
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution238 solution238 = new Solution238();
        int[] answer;
        answer = solution238.productExceptSelf(new int[]{1, 2, 3, 4});
        answer = solution238.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
    }
}
