package problemsolving.leetcode;

public class Solution189 {
    /**
     * 1 <= nums.length <= 10^5
     * -2^31 <= nums[i] <= 2^31 - 1
     * 0 <= k <= 10^5
     */
    public void rotate(int[] nums, int k) {
        rotate_2(nums, k);
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

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public void rotate_2(int[] nums, int k) {
        int kk = k % nums.length;
        // 1234/567
        reverse(nums, 0, nums.length - 1);
        // 765/4321
        reverse(nums, 0, kk - 1);
        // 567/4321
        reverse(nums, kk, nums.length - 1);
        // 567/1234
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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
