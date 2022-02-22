package exercise.leetcode;

import java.util.HashMap;

public class Solution171 {
	public int titleToNumber(String columnTitle) {
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int number = 0;
		for (int i = 0; i < columnTitle.length(); i++) {
			number += Math.pow(26, columnTitle.length() - 1 - i) * (alphabet.indexOf(columnTitle.charAt(i)) + 1);
		}

		return number;
	}

	public static void main(String[] args) {
		Solution171 solution171 = new Solution171();
		System.out.println(solution171.titleToNumber("A")); // 1
		System.out.println(solution171.titleToNumber("AB")); // 26 + 2 
		System.out.println(solution171.titleToNumber("ZY")); // 26 * 26 + 25 = 676 + 25 = 701
		System.out.println(solution171.titleToNumber("FXSHRXW"));
	}
}
