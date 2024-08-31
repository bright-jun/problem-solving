package problemsolving.leetcode;

public class Solution70 {
	/*
	 * 1 <= n <= 45
	 */
	public int climbStairs(int n) {

		int[] answer = new int[46];
		answer[1] = 1;
		answer[2] = 2;

		for (int i = 3; i <= n; i++) {
			answer[i] = answer[i - 1] + answer[i - 2];
		}

		return answer[n];
	}

	public static void main(String[] args) {
		Solution70 solution70 = new Solution70();
		int answer;
		for (int i = 1; i <= 45; i++) {
			answer = solution70.climbStairs(i);
			System.out.println(i + " : " + answer);
		}
	}
}
