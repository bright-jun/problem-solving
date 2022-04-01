package exercise.leetcode;

public class Solution344 {
	public void swap(char[] s, int a, int b) {
		char temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}

	public void reverseString(char[] s) {
		for (int i = 0; i < s.length / 2; i++) {
			swap(s, i, s.length - 1 - i);
		}
	}

	public static void main(String[] args) {
		Solution344 solution344 = new Solution344();
		char[] s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
		char[] s2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
		solution344.reverseString(s1);
		solution344.reverseString(s2);

		return;
	}
}
