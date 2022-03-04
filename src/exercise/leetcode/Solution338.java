package exercise.leetcode;

import java.util.Arrays;

public class Solution338 {

	public static int[] Answer;

	// [0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2]
	// 0 1 10 11 100 101 110 111
	public int[] countBits(int n) {
		// linear
		if (Answer == null) {
			Answer = new int[100001];
			Answer[0] = 0;

			// 1~1, 2~3, 4~7,
			int power2 = 1; // 1 2 4 8 16
			while (power2 <= 100000) {
				for (int i = 0; i < power2 && i + power2 < 100001; i++) {
					Answer[i + power2] = Answer[i] + 1;
				}
				power2 = power2 << 1;
			}
		}
		int[] answer = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			answer[i] = Answer[i];
		}
		// n log n
		/*
		 * for (int i = 0; i <= n; i++) { int num = i; int cnt = 0; while (num > 0) { if
		 * ((num & 1) == 1) { cnt++; } num = num >> 1; } answer[i] = cnt; }
		 */

		return answer;
	}

	public static void main(String[] args) {
		Solution338 solution338 = new Solution338();
		System.out.println(Arrays.toString(solution338.countBits(10)));
	}
}
