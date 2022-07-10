package exercise.leetcode;

public class Solution746 {
	public int minCostClimbingStairs(int[] cost) {

		cost[1] = Math.min(cost[0] + cost[1], 0 + cost[1]);

		for (int i = 2; i < cost.length; i++) {
			cost[i] += Math.min(cost[i - 1], cost[i - 2]);
		}

		return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
	}

	public static void main(String[] args) {
		Solution746 solution746 = new Solution746();
		int answer;
		answer = solution746.minCostClimbingStairs(new int[] { 10, 15, 20 });
		answer = solution746.minCostClimbingStairs(new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 });
		answer = solution746.minCostClimbingStairs(new int[] { 1, 5 });

		return;
	}
}
