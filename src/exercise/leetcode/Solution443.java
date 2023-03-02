package exercise.leetcode;

public class Solution443 {
	/*
	 * 1 <= chars.length <= 2000
	 */
	public int compress(char[] chars) {
		return compress_sol(chars);
	}

	/*
	 * Time: O(N)
	 * Space: O(1)
	 */
	public int compress_sol(char[] chars) {
		int n = chars.length;
		if (n == 1) {
			return 1;
		}

		int index = 0;
		int answerIndex = 0;
		while (index < n) {
			// start
			char now = chars[index];
			chars[answerIndex++] = now;
			// count
			int count = 1;
			while (++index < n && now == chars[index]) {
				count++;
			}
			// end
			if (count != 1) {
				char[] countCharArray = Integer.toString(count).toCharArray();
				for (char c : countCharArray) {
					chars[answerIndex++] = c;
				}
			}
		}

		return answerIndex;
	}

	public static void main(String[] args) {
		Solution443 solution443 = new Solution443();
		int answer;
		char[] chars;
		chars = new char[] { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		answer = solution443.compress(chars);
		chars = new char[] { 'a' };
		answer = solution443.compress(chars);
		chars = new char[] { 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		answer = solution443.compress(chars);
		chars = new char[] { 'a', 'b', 'b' };
		answer = solution443.compress(chars);
	}
}
