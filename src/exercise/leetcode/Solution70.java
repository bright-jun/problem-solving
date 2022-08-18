package exercise.leetcode;

public class Solution70 {

	public int climbStairs(int n) {
		return -1;
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
