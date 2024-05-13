package exercise.leetcode;

public class Solution167 {
    /**
     * 2 <= numbers.length <= 3 * 10^4
     * -1000 <= numbers[i] <= 1000
     * numbers is sorted in non-decreasing order.
     * -1000 <= target <= 1000
     * The tests are generated such that there is exactly one solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        return twoSum_0(numbers, target);
    }

    /**
     * Time: O(N^2) ... TLE
     * Space: O(1)
     */
    public int[] twoSum_0(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] answer;
        answer = solution167.twoSum(new int[]{2, 7, 11, 15}, 9); // [1,2]
        answer = solution167.twoSum(new int[]{2, 3, 4}, 6); // [1,3]
        answer = solution167.twoSum(new int[]{-1, 0}, -1); // [1,2]
    }
}
