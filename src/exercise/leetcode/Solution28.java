package exercise.leetcode;

public class Solution28 {
	/*
	 * 1 <= haystack.length, needle.length <= 10^4
	 * haystack and needle consist of only lowercase English characters.
	 */
	public int strStr(String haystack, String needle) {
		return strStr_sol1(haystack, needle);
	}

	/*
	 * Time: O(N^2)
	 * Space: O(1)
	 */
	public int strStr_sol1(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return -1;
		}

		for (int i = 0; i < haystack.length() - (needle.length() - 1); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		Solution28 solution28 = new Solution28();
		int answer;
		answer = solution28.strStr_sol1("sadbutsad", "sad");
		answer = solution28.strStr_sol1("leetcode", "leeto");
		answer = solution28.strStr_sol1("bbbbutsad", "sad");
	}
}
