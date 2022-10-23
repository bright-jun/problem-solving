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
		String tempAnswer = null;
		while (end < s.length()) {
			// move end till match subset
			while (end < s.length() && !sameState(windowState, answerState)) {
				// push
				end++;
				// move & change state
				windowState[s.charAt(end - 1) - 'A']++;
			}

			if (sameState(windowState, answerState)) {
				// match subset
				if (tempAnswer == null) {
					tempAnswer = s.substring(start, end);
				} else {
					if (tempAnswer.length() > s.substring(start, end).length()) {
						tempAnswer = s.substring(start, end);
					}
				}
			}

			// move start till unmatch(next subset letter) subset
			// FIXME find till min case if end == s.length()
 			while (start < end) {
				// move & change state
				windowState[s.charAt(start) - 'A']--;
				// pop
				start++;
				if (!(start < end)) {
					break;
				}
				if (t.indexOf(s.charAt(start - 1)) > 0) {
					break;
				}
			}
		}

		return tempAnswer;
	}

	public boolean sameState(int[] s, int[] t) {
		for (int i = 0; i < s.length; i++) {
			if (t[i] > 0) {
				if (s[i] != t[i]) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution76 solution76 = new Solution76();
		String answer;
		answer = solution76.minWindow("ADOBECODEBANC", "ABC");
		answer = solution76.minWindow("a", "a");
		answer = solution76.minWindow("a", "aa");
		return;
	}
}
