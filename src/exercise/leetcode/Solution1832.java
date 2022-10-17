package exercise.leetcode;

import java.util.HashSet;

public class Solution1832 {
	/*
	 * 1 <= sentence.length <= 1000
	 * sentence consists of lowercase English letters.
	 */
	public boolean checkIfPangram(String sentence) {
		HashSet<Character> hs = new HashSet<Character>();
		for (char c : sentence.toCharArray()) {
			hs.add(c);
			if (hs.size() == 26) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution1832 solution1832 = new Solution1832();
		boolean answer;
		answer = solution1832.checkIfPangram("thequickbrownfoxjumpsoverthelazydog");
		answer = solution1832.checkIfPangram("leetcode");
		return;
	}
}
