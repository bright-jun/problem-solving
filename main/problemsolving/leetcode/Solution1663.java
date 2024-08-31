package problemsolving.leetcode;

public class Solution1663 {
	public String getSmallestString(int n, int k) {
		int left = k - n; // 27 - 3 = 24 // 73 - 5 = 68
		int digit = left / 25; // 27 / 25 = 1 // 68 / 25 = 2
		int last = left % 25; // 27 % 25 = 2 // 68 % 25 = 18

		// 0 1 2 3 4 : idx
		// 4 3 2 1 0 : len
		// {1~26}
		// 1 1 1
		// 1 1 25
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			char c = 'a';
			if ((n - 1 - i) < digit) {
				c = 'z';
			} else if ((n - 1 - i) == digit) {
				c += last;
			} else {
				// 'a'
			}
			sb.append(c);
		}

		return sb.toString();
	}

	public static void main(String[] args) {
		Solution1663 solution1663 = new Solution1663();
		System.out.println(solution1663.getSmallestString(3, 27)); // aay
		System.out.println(solution1663.getSmallestString(5, 73)); // aaszz
		System.out.println(solution1663.getSmallestString(3, 3)); // aaa
	}
}
