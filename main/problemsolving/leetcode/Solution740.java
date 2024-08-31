package problemsolving.leetcode;

public class Solution740 {
    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001];

        for (int num : nums) {
            count[num]++;
        }

        int ans = 0;

        int[][] dp = new int[10001][2];

        // dp
		/*
		dp[1][0] = 1 * 0;
		dp[1][1] = 1 * count[1];
		
		// from o, x
		dp[2][0] = Math.max(dp[1][0], dp[1][1]) + 2 * 0;
		// from x
		dp[2][1] = dp[1][0] + 2 * count[2];
		*/

        for (int i = 1; i < 10001; i++) {
            // from o, x
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]) + i * 0;
            // from x
            dp[i][1] = dp[i - 1][0] + i * count[i];
        }

        // ? ? ? o
        // ? ? o x


        return Math.max(dp[10000][0], dp[10000][1]);
    }

    public static void main(String[] args) {
        Solution740 solution740 = new Solution740();
        System.out.println(solution740.deleteAndEarn(new int[]{3, 4, 2}));
        System.out.println(solution740.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }
}
