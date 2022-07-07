package exercise.leetcode;

public class Solution97 {

	/*
	 * 0 <= s1.length, s2.length <= 100
	 * 0 <= s3.length <= 200
	 * s1, s2, and s3 consist of lowercase English letters.
	 * 
	 * Follow up: Could you solve it using only O(s2.length) additional memory space?
	 */
	public boolean isInterleave(String s1, String s2, String s3) {
		
		
		
		return false;
	}

	public static void main(String[] args) {
		Solution97 solution97 = new Solution97();
		boolean answer;
		answer = solution97.isInterleave("aabcc", "dbbca", "aadbbcbcac");
		answer = solution97.isInterleave("aabcc", "dbbca", "aadbbbaccc");
		answer = solution97.isInterleave("", "", "");
		
		return;
	}
}
