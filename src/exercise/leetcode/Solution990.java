package exercise.leetcode;

public class Solution990 {
	/*
	 * 1 <= equations.length <= 500
	 * equations[i].length == 4
	 * equations[i][0] is a lowercase letter.
	 * equations[i][1] is either '=' or '!'.
	 * equations[i][2] is '='.
	 * equations[i][3] is a lowercase letter.
	 */
	public boolean equationsPossible(String[] equations) {
		// union-find
		return false;
	}

	public static void main(String[] args) {
		Solution990 solution990 = new Solution990();
		boolean answer;
		answer = solution990.equationsPossible(new String[] { "a==b", "b!=a" });
		answer = solution990.equationsPossible(new String[] { "b==a", "a==b" });
		return;
	}
}
