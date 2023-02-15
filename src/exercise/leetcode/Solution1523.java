package exercise.leetcode;

public class Solution1523 {
	/*
	 * 0 <= low <= high <= 10^9
	 */
	/*
	 * Time: O(1)
	 * Space: O(1)
	 */
	public int countOdds(int low, int high) {
		// count low if odd
		int answer = (low % 2);
		// mid = high - low = [low + 1, high]
		int mid = high - low;
		if ((low + 1) % 2 == 1) {
			// odd even odd ...
			answer += (mid + 1) / 2; // ceil
		} else {
			// even odd even ...
			answer += mid / 2;
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution1523 solution1523 = new Solution1523();
		int answer;
		answer = solution1523.countOdds(3, 7);
		answer = solution1523.countOdds(8, 10);
	}
}
