package exercise.leetcode;

public class Solution67 {
	/*
	 * 1 <= a.length, b.length <= 10^4
	 * a and b consist only of '0' or '1' characters.
	 * Each string does not contain leading zeros except for the zero itself.
	 */
	public String addBinary(String a, String b) {
		return addBinary_sol1(a, b);
	}

	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public String addBinary_sol1(String a, String b) {
		StringBuilder sb = new StringBuilder();

		int aLen = a.length();
		int bLen = b.length();

		int aVal = 0;
		int bVal = 0;
		int carry = 0;
		for (int i = 0; i < Math.max(aLen, bLen); i++) {
			if (aLen - 1 - i >= 0) {
				aVal = a.charAt(aLen - 1 - i) - '0';
			} else {
				aVal = 0;
			}

			if (bLen - 1 - i >= 0) {
				bVal = b.charAt(bLen - 1 - i) - '0';
			} else {
				bVal = 0;
			}

			int sum = aVal + bVal + carry;
			carry = sum / 2;
			sb.insert(0, sum % 2);
		}

		if (carry == 1) {
			sb.insert(0, 1);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution67 solution67 = new Solution67();
		String answer;
		answer = solution67.addBinary("11", "1");
		answer = solution67.addBinary("1010", "1011");
	}

}
