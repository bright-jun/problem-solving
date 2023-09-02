package exercise.leetcode;

public class Solution122 {
    /**
     * 1 <= prices.length <= 3 * 10^4
     * 0 <= prices[i] <= 10^4
     */
    public int maxProfit(int[] prices) {
        return maxProfit_1(prices);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int maxProfit_1(int[] prices) {
        int answer = 0;

        for (int i = 1; i < prices.length; i++) {
            int increase = prices[i] - prices[i - 1];
            if (increase > 0) {
                answer += increase;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution122 solution122 = new Solution122();
        int answer;
        answer = solution122.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 7
        answer = solution122.maxProfit(new int[]{1, 2, 3, 4, 5}); // 4
        answer = solution122.maxProfit(new int[]{7, 6, 4, 3, 1}); // 0
    }
}
