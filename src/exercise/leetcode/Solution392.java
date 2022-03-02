package exercise.leetcode;

public class Solution392 {
	public static boolean isSubsequence(String s, String t) {
		if(s.length() == 0 && t.length() == 0) {
			return true;
		} else if(s.length() == 0 && t.length() != 0) {
			return true;
		} else if(s.length() != 0 && t.length() == 0) {
			return false;
		} else if(s.length() != 0 && t.length() != 0) {

		}			
		
		int sIdx = 0;
		
		for (int tIdx = 0; tIdx < t.length(); tIdx++) {
			if(s.charAt(sIdx) == t.charAt(tIdx)) {
				sIdx++;
				if(sIdx == s.length()) {
					return true;
				}
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		Solution392 solution392 = new Solution392();
		System.out.println(solution392.isSubsequence("abc", "ahbgdc"));
		System.out.println(solution392.isSubsequence("axc", "ahbgdc"));
		// null exception
		System.out.println(solution392.isSubsequence("", "ahbgdc"));
		// bound check
		System.out.println(solution392.isSubsequence("acb", "ahbgdc"));
	}
}
