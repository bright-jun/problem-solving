package exercise.leetcode;

public class Solution134 {
    /**
     * n == gas.length == cost.length
     * 1 <= n <= 10^5
     * 0 <= gas[i], cost[i] <= 10^4
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return canCompleteCircuit_0(gas, cost);
    }

    /*
     * Time: O(N^2) ... TODO TLE
     * Space: O(N)
     */
    public int canCompleteCircuit_0(int[] gas, int[] cost) {
        int n = gas.length;
        int[] moveCost = new int[n];
        boolean checkIsAnswer = true;
        for (int i = 0; i < n; i++) {
            moveCost[i] = gas[i] - cost[i];
        }
        int[] cumulativeMoveCost = new int[n];
        cumulativeMoveCost[0] = moveCost[0];
        for (int i = 0; i < n; i++) {
            cumulativeMoveCost[i] = (i == 0 ? 0 : cumulativeMoveCost[i - 1]) + moveCost[i];
            checkIsAnswer &= (cumulativeMoveCost[i] >= 0);
        }

        if (cumulativeMoveCost[n - 1] < 0) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (checkIsAnswer) {
                return i;
            }
            checkIsAnswer = true;
            for (int j = 0; j < n; j++) {
                cumulativeMoveCost[j] -= moveCost[i];
                checkIsAnswer &= (cumulativeMoveCost[j] >= 0);
                // -2 -2 -2 3 3
                // -2 -4 -6 -3 0
                //    -2 -4 -1 2 0 (-(-2))
                //       -2 1 4 2 0 (-(-2))
                //          3 6 4 2 0 (-(-2))
                //            3 1 -1 -3 0 (-(-2))
            }
        }
        return -1;
    }

    private boolean isAnswer(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        int answer;
        answer = solution134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        answer = solution134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        answer = solution134.canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2});
    }
}
