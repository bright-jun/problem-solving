package problemsolving.leetcode;

public class Solution164 {
    /*
     * 1 <= nums.length <= 10^5
     * 0 <= nums[i] <= 10^9
     */
    public int maximumGap(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int gap = 0;
        for (int num : nums) {
            // TODO
        }

        return gap;
    }

    public static void main(String[] args) {
        Solution164 solution164 = new Solution164();
        int answer;
        answer = solution164.maximumGap(new int[]{3, 6, 9, 1});
        answer = solution164.maximumGap(new int[]{10});

        return;
    }
}
