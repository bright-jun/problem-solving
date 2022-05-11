package exercise.leetcode;

import java.util.HashSet;

public class Solution3 {
	/*
	 * 0 <= s.length <= 5 * 10^4
	 */
	public int lengthOfLongestSubstring(String s) {

		if (s.length() == 0) {
			return 0;
		}

		HashSet<Character> hs = new HashSet<Character>();

		char[] cArr = s.toCharArray();

		int answer = 1;
		// [start,end)
		int startIdx = 0;
		int endIdx = 0;
		hs.add(cArr[startIdx]);

		while (true) {
			endIdx++;
			if (endIdx >= cArr.length) {
				// final bound check
				answer = Math.max(answer, endIdx - startIdx);
				break;
			}
			if (hs.contains(cArr[endIdx])) { // till before is LongestSubstring
				answer = Math.max(answer, endIdx - startIdx);
				// move startIdx till next step
				while (true) {
					startIdx++;
					if (startIdx > endIdx) {
						break;
					}
					if (cArr[startIdx - 1] == cArr[endIdx]) {
						break;
					}
					hs.remove(cArr[startIdx - 1]);
				}
			} else {
				hs.add(cArr[endIdx]);
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution3 solution3 = new Solution3();
		System.out.println(solution3.lengthOfLongestSubstring("abcabcbb")); // 3 "abc"
		System.out.println(solution3.lengthOfLongestSubstring("bbbbb")); // 1 "b"
		System.out.println(solution3.lengthOfLongestSubstring("pwwkew")); // 3 "wke"
		System.out.println(solution3.lengthOfLongestSubstring("au")); // 2 "au"
		System.out.println(solution3.lengthOfLongestSubstring("tmmzuxt")); // 5 "mzuxt"
	}
}
