package exercise.leetcode;

public class Solution76 {
	/*
	 * The testcases will be generated such that the answer is unique.
	 * m == s.length
	 * n == t.length
	 * 1 <= m, n <= 10^5
	 * s and t consist of uppercase and lowercase English letters.
	 */
	public String minWindow(String s, String t) {

		int[] windowState = new int['z' - 'A' + 1]; // 'A' -> 'A' - 'A' (= 0), 'z' -> 'z' - 'A' (= 57)
		int[] answerState = new int['z' - 'A' + 1];
		for (char c : t.toCharArray()) {
			answerState[c - 'A']++;
		}

		// [start, end)
		int start = 0;
		int end = 0;
		String tempAnswer = s;
		while (end < s.length()) {
			// move end till match subset
			while (!sameState(windowState, answerState)) {
				// push
				end++;
				// move
				windowState[s.charAt(end) - 'A']++;

				if (end == s.length()) {
					break;
				}
			}
			// match subset
			if (tempAnswer.length() > s.substring(start, end).length()) {
				tempAnswer = s.substring(start, end);
			}

			// move start till unmatch(next subset letter) subset
			while (t.indexOf(s.charAt(start)) < 0) {
				// pop
				windowState[s.charAt(start) - 'A']--;
				// move
				start++;
			}
		}

		if (tempAnswer.equals(s)) {
			return "";
		} else {
			return tempAnswer;
		}
	}

	public boolean sameState(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution76 solution76 = new Solution76();
		String answer;
//		answer = solution76.minWindow("ADOBECODEBANC", "ABC");
		answer = solution76.minWindow("a", "a");
		answer = solution76.minWindow("a", "aa");
		return;
	}
}
