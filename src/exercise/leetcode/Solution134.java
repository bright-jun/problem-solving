package exercise.leetcode;

public class Solution134 {
    /**
     * n == gas.length == cost.length
     * 1 <= n <= 10^5
     * 0 <= gas[i], cost[i] <= 10^4
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        return canCompleteCircuit_2(gas, cost);
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

    /*
     * Time: O(N^2) ... TODO TLE
     * Space: O(N)
     */
    public int canCompleteCircuit_1(int[] gas, int[] cost) {
        int n = gas.length;
        for (int i = 0; i < n; i++) {
            int totalFuel = 0;
            for (int j = 0; j < n; j++) {
                totalFuel += gas[(j + i) % n] - cost[(j + i) % n];
                if (totalFuel < 0) {
                    break;
                }
            }
            if (totalFuel >= 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * Time: O(N)
     * Space: O(N)
     */
    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int n = gas.length;
        int totalSurplus = 0;
        int surplus = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            totalSurplus += gas[i] - cost[i];
            surplus += gas[i] - cost[i];
            if (surplus < 0) {
                // skip starts in [now, i]
                // trip[now, i-1] >= 0 and trip[now, i] < 0
                // trip[now, now] >= 0
                // trip[now, i-1] >= trip[now+1, i-1] >= trip[now+2, i-1] ...
                // 0 > trip[now, i] >= trip[now+1, i] >= trip[now+2, i] ...
                // any starts in [now, i] will fail
                surplus = 0;
                start = i + 1;
                // start to get trip [i+1, ?]
                // if [start, start+1 .. n] >= 0
                // check if start is answer
            }
            // what about start+1 and more?
            // trip[start, start] >= 0
            // trip[start, n] >= trip[start+1, n] >= trip[start+2, n] ...
            // we can skip
        }

        /*
        1 -2 3 -4 2 0 0 0
         */
        // [start, start+1 .. n] >= 0,
        // consider [0, start-1]
        // trip[0, start-1] + trip[start, n] >= 0
        if (totalSurplus >= 0) {
            return start;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution134 solution134 = new Solution134();
        int answer;
        answer = solution134.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2});
        answer = solution134.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3});
        answer = solution134.canCompleteCircuit(new int[]{3, 1, 1}, new int[]{1, 2, 2});
        answer = solution134.canCompleteCircuit(new int[]{7, 1, 0, 11, 4}, new int[]{5, 9, 1, 2, 5});
    }
}
