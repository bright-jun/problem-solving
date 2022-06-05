package exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution52 {

	public int[][] merge(int[][] intervals) {

		ArrayList<int[]> answer = new ArrayList<int[]>();

		Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

		int start = -1;
		int end = -1;
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] > end) { // new start
				answer.add(new int[] { start, end });
				start = intervals[i][0];
				end = intervals[i][1];
			} else {
				end = Math.max(end, intervals[i][1]);
			}
		}
		answer.add(new int[] { start, end });

		answer.remove(0);

		return answer.toArray(new int[answer.size()][2]);
	}

	public static void main(String[] args) {
		Solution52 solution52 = new Solution52();
		System.out
				.println(Arrays.toString(solution52.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } })));
		System.out.println(Arrays.toString(solution52.merge(new int[][] { { 1, 4 }, { 4, 5 } })));
	}
}
