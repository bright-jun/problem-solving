package exercise.leetcode;

import java.util.Arrays;

public class Solution338 {
	public int[] countBits(int n) {
		int[] answer = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			int num = i;
			int cnt = 0;
			while (num > 0) {
				if ((num & 1) == 1) {
					cnt++;
				}
				num = num >> 1;
			}
			answer[i] = cnt;
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution338 solution338 = new Solution338();
		System.out.println(Arrays.toString(solution338.countBits(10)));
	}
}
