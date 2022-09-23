package exercise.leetcode;

public class Solution1680 {

	public static long MOD = 1000000000 + 7; // leetcode can't recognize 10_9 signature

	/*
	 * 1 <= n <= 10^5
	 */
	public int concatenatedBinary(int n) {
		long answer = 0;
		// 1 = 1
		// 1 10 = ((1) << 2) + 2
		// 1 10 11 = (((1 << 2) + 2) << 2) + 3
		for (int i = 1; i <= n; i++) {
			answer = (answer << binaryDigit(i)) % MOD + i;
			answer %= MOD;
		}
		return (int) answer;
	}

	public int binaryDigit(int n) {
		int digit = 0;
		while (n > 0) {
			n /= 2;
			digit++;
		}
		return digit;
	}

	public static void main(String[] args) {
		Solution1680 solution1680 = new Solution1680();
		int answer;
		answer = solution1680.concatenatedBinary(1);
		answer = solution1680.concatenatedBinary(2);
		answer = solution1680.concatenatedBinary(3);
		answer = solution1680.concatenatedBinary(12);
		answer = solution1680.concatenatedBinary(100);
		answer = solution1680.concatenatedBinary(1000);
		answer = solution1680.concatenatedBinary(10000);
		answer = solution1680.concatenatedBinary(100000);
		return;
	}
}
