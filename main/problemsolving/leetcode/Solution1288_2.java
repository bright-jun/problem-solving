package problemsolving.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1288_2 {
	/*
	 * 1. HashMap 2. Sort
	 */

	public int removeCoveredIntervals(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) {
					// ascending
					return o1[0] - o2[0];
				} else {
					// descending
					return o2[1] - o1[1];
				}
			}
		});

		int ans = 0;
		int right = -1;
		for (int[] interval : intervals) {
			if (interval[1] <= right) {
				// covered
				continue;
			} else {
				// new cover
				ans++;
				right = interval[1];
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution1288_2 solution1288_2 = new Solution1288_2();

		System.out.println(solution1288_2.removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } })); // 2
		System.out.println(solution1288_2.removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } })); // 1
		System.out.println(solution1288_2.removeCoveredIntervals(
				new int[][] { { 66672, 75156 }, { 59890, 65654 }, { 92950, 95965 }, { 9103, 31953 }, { 54869, 69855 },
						{ 33272, 92693 }, { 52631, 65356 }, { 43332, 89722 }, { 4218, 57729 }, { 20993, 92876 } }));
		System.out.println(solution1288_2.removeCoveredIntervals(new int[][] { { 3, 10 }, { 4, 10 }, { 5, 11 } })); // 2
		System.out.println(solution1288_2.removeCoveredIntervals(new int[][] { { 1, 2 }, { 1, 4 }, { 3, 4 } })); // 2
	}
}
