package problemsolving.leetcode;

public class Solution680 {

	public boolean finalValidPalindrome(String s) {
		int start = 0;
		int end = s.length() - 1;
		while (true) {
			if (start >= end) {
				// palindrome check finish
				return true;
			}

			if (s.charAt(start) == s.charAt(end)) {
				// palindrome
				start++;
				end--;
				continue;
			} else {
				return false;
			}
		}
	}

	public boolean validPalindrome(String s) {

		int start = 0;
		int end = s.length() - 1;
		while (true) {
			if (start >= end) {
				// palindrome check finish
				return true;
			}

			if (s.charAt(start) == s.charAt(end)) {
				// palindrome
				start++;
				end--;
				continue;
			} else {
				// not palindrome, remove one
				// remove start || remove end
				boolean removeStart = finalValidPalindrome(s.substring(0, start) + s.substring(start + 1));
				boolean removeEnd = finalValidPalindrome(s.substring(0, end) + s.substring(end + 1));
				return removeStart | removeEnd;
			}
		}
	}

	public static void main(String[] args) {
		Solution680 solution680 = new Solution680();
		System.out.println(solution680.validPalindrome("aba"));
		System.out.println(solution680.validPalindrome("abca"));
		System.out.println(solution680.validPalindrome("aabba")); // "abba" "aaba"
		System.out.println(solution680.validPalindrome("abc"));
	}
}
