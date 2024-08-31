package problemsolving.leetcode;

import java.util.Arrays;

public class Solution1029 {
    /*
     * 2 * n == costs.length
     * 2 <= costs.length <= 100
     * costs.length is even.
     * 1 <= aCosti, bCosti <= 1000
     */
    /*
     * 2^100 -> 100C50 : TLE
     *
     *
     */
    public int twoCitySchedCost(int[][] costs) {
        int cityA_cost = 0;
        for (int[] cost : costs) {
            cityA_cost += cost[0];
        }

        Arrays.sort(costs, (o1, o2) -> {
            // cost change cityA -> cityB
            return (o1[1] - o1[0]) - (o2[1] - o2[0]);
        });

        int answer = cityA_cost;
        for (int i = 0; i < costs.length / 2; i++) {
            answer += (costs[i][1] - costs[i][0]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1029 solution1029 = new Solution1029();
        System.out.println(solution1029.twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
        System.out.println(solution1029.twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}));
        System.out.println(solution1029.twoCitySchedCost(new int[][]{{515, 563}, {451, 713}, {537, 709}, {343, 819}, {855, 779}, {457, 60}, {650, 359}, {631, 42}}));
    }
}
