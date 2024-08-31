package problemsolving.leetcode;

public class Solution97 {

	/*
	 * 0 <= s1.length, s2.length <= 100
	 * 0 <= s3.length <= 200
	 * s1, s2, and s3 consist of lowercase English letters.
	 * 
	 * Follow up: Could you solve it using only O(s2.length) additional memory space?
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		int l1 = s1.length();
		int l2 = s2.length();
		int l3 = s3.length();
		
		if(l1 + l2 != l3) {
			return false;
		}
		if (l1 == 0) {
			return s2.equals(s3);
		}
		if (l2 == 0) {
			return s1.equals(s3);
		}
		
		if (s1.charAt(0) == s3.charAt(0)) {
			boolean tempAnswer = isInterleave(s1.substring(1), s2, s3.substring(1));
			if (tempAnswer) {
				return true;
			}
		}
		if (s2.charAt(0) == s3.charAt(0)) {
			boolean tempAnswer = isInterleave(s1, s2.substring(1), s3.substring(1));
			if (tempAnswer) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Solution97 solution97 = new Solution97();
		boolean answer;
		answer = solution97.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		answer = solution97.isInterleave("aabcc", "dbbca", "aadbbbaccc");
		answer = solution97.isInterleave("", "", "");
		// EdgeCase
		answer = solution97.isInterleave("a", "", "c");
		// TLE
		// brute force -> need memoization
		answer = solution97.isInterleave(
				"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
				"babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
				"babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab");
		
		return;
	}
}
