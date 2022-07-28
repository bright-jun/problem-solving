package exercise.leetcode;

public class Solution242 {
	/*
	 * 1 <= s.length, t.length <= 5 * 10^4
	 * s and t consist of lowercase English letters.
	 */
	public boolean isAnagram(String s, String t) {

		if (s.length() != t.length()) {
			return false;
		}

		int[] alphabet1 = new int['z' - 'a' + 1];
		int[] alphabet2 = new int['z' - 'a' + 1];

		for (char c : s.toCharArray()) {
			alphabet1[c - 'a']++;
		}

		for (char c : t.toCharArray()) {
			alphabet2[c - 'a']++;
		}

		for (int i = 0; i < 'z' - 'a' + 1; i++) {
			if (alphabet1[i] != alphabet2[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution242 solution242 = new Solution242();
		solution242.isAnagram("anagram", "nagaram");
		solution242.isAnagram("rat", "car");
	}
}
