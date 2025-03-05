package problemsolving.leetcode;

public class Solution2579 {
    /**
     * 1 <= n <= 10^5
     */
    public long coloredCells(int n) {
        return coloredCells0(n);
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public long coloredCells0(int n) {
        // A_n = 1(n=1) + sigma_(1 to n-1) {4n}
        if (n == 1) {
            return 1;
        }

        return 1 + 2L * (n - 1) * (n);
    }

    public static void main(String[] args) {
        Solution2579 solution2579 = new Solution2579();
        long answer;
        for (int i = 1; i <= 5; i++) {
            answer = solution2579.coloredCells(i);
            System.out.println(answer);
        }
    }
}
