package problemsolving.leetcode;

public class Solution121 {
    /**
     * 1 <= prices.length <= 10^5
     * 0 <= prices[i] <= 10^4
     */
    public int maxProfit(int[] prices) {
        return maxProfit_2(prices);
    }

    /**
     * Time: O(N^2) - TLE
     * Space: O(1)
     */
    public int maxProfit_1(int[] prices) {
        int answer = 0;
        for (int left = 0; left < prices.length; left++) {
            for (int right = left + 1; right < prices.length; right++) {
                answer = Math.max(answer, prices[right] - prices[left]);
            }
        }
        return answer;
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int maxProfit_2(int[] prices) {
        int answer = 0;
        int left = prices[0];
        int right = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (left > prices[i]) {
                // found new minimum spot
                answer = Math.max(answer, right - left);
                left = prices[i];
                right = prices[i];
            } else if (right < prices[i]) {
                right = prices[i];
            }
        }
        answer = Math.max(answer, right - left);
        return answer;
    }

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();
        int answer;
        answer = solution121.maxProfit(new int[]{7, 1, 5, 3, 6, 4}); // 5
        answer = solution121.maxProfit(new int[]{7, 6, 4, 3, 1}); // 0
        answer = solution121.maxProfit(new int[]{4, 5, 1, 5, 7}); // 6
        answer = solution121.maxProfit(new int[]{1, 5, 3, 6, 5}); // 5
    }
}
