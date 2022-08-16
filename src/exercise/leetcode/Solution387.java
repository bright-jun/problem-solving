package exercise.leetcode;

public class Solution387 {
	/*
	 * 1 <= s.length <= 10^5
	 * s consists of only lowercase English letters.
	 */
	public int firstUniqChar(String s) {
		
		int[] alphabet = new int['z' - 'a' + 1];
		for (char c : s.toCharArray()) {
			alphabet[c - 'a']++;
		}
		
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(alphabet[c-'a'] == 1) {
				return i;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Solution387 solution387 = new Solution387();
		int answer;
		answer = solution387.firstUniqChar("leetcode");
		answer = solution387.firstUniqChar("loveleetcode");
		answer = solution387.firstUniqChar("aabb");

		return;
	}
}
