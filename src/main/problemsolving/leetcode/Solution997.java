package problemsolving.leetcode;

public class Solution997 {
    /**
     * 1 <= n <= 1000
     * 0 <= trust.length <= 10^4
     * trust[i].length == 2
     * All the pairs of trust are unique.
     * ai != bi
     * 1 <= ai, bi <= n
     */
    public int findJudge(int n, int[][] trust) {
        /**
         * If the town judge exists, then:
         *
         * 1. The town judge trusts nobody.
         * 2. Everybody (except for the town judge) trusts the town judge.
         * 3. There is exactly one person that satisfies properties 1 and 2.
         */
        return findJudge1(n, trust);
    }

    /**
     * Time: O(N^2)
     * Space: O(N^2)
     */
    public int findJudge0(int n, int[][] trust) {
        int[][] trustArray = new int[n][n];
        for (int[] t : trust) {
            trustArray[t[0] - 1][t[1] - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            // 1. The town judge trusts nobody.
            boolean condition1 = true;
            for (int j = 0; j < n; j++) {
                if (trustArray[i][j] == 1) {
                    condition1 = false;
                    break;
                }
            }
            if (!condition1) {
                continue;
            }

            // 2. Everybody (except for the town judge) trusts the town judge.
            boolean condition2 = true;
            for (int j = 0; j < n; j++) {
                if (i != j && trustArray[j][i] == 0) {
                    condition2 = false;
                    break;
                }
            }
            if (!condition2) {
                continue;
            }

            return i + 1;
        }

        return -1;
    }

    /**
     * Time: O(N) = 3*(N-1)
     * Space: O(N^2)
     */
    public int findJudge1(int n, int[][] trust) {
        boolean[][] trustArray = new boolean[n][n];
        for (int[] t : trust) {
            trustArray[t[0] - 1][t[1] - 1] = true;
        }

        int candidate = 0;
        for (int i = 1; i < n; i++) {
            // if candidate doesn't trust i
            // i can't be judge.
            if (!trustArray[candidate][i]) {
                continue;
            }
            // if candidate trust i
            // candidate can't be judge.
            if (trustArray[candidate][i]) {
                // so far, 1 to i-1 can't be judge.
                // candidate can't be judge.
                // check if i can be judge
                candidate = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            // condition 1 && condition 2
            if (trustArray[candidate][i] || !trustArray[i][candidate]) return -1;
        }
        return candidate + 1;
    }

    public static void main(String[] args) {
        Solution997 solution997 = new Solution997();
        int answer;
        /**
         * 0 1
         * 0 0
         */
        answer = solution997.findJudge(2, new int[][]{{1, 2}}); // 2
        /**
         * 0 0 1
         * 0 0 1
         * 0 0 0
         */
        answer = solution997.findJudge(3, new int[][]{{1, 3}, {2, 3}}); // 3
        /**
         * 0 0 1
         * 0 0 1
         * 1 0 0
         */
        answer = solution997.findJudge(3, new int[][]{{1, 3}, {2, 3}, {3, 1}}); // -1
        /**
         * 0 1 1
         * 0 0 0
         * 1 1 0
         */
        answer = solution997.findJudge(3, new int[][]{{1, 2}, {1, 3}, {3, 1}, {3, 2}}); // 2
    }
}
