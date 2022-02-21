package exercise.leetcode;

import java.util.HashSet;

public class Solution1288 {
	public boolean isSameArray(int[] a1, int[] a2) {
		return a1[0] == a2[0] && a1[1] == a2[1];
	}

	public int removeCoveredIntervals(int[][] intervals) {
		HashSet<int[]> hs = new HashSet<int[]>();
		// 새로 넣은 경우 새로 넣은 애로 모든 원소들을 탐색시켜야 함.
		top: for (int[] addInterval : intervals) {
			HashSet<int[]> hsRemove = new HashSet<int[]>();
			for (int[] hsInterval : hs) {
				if (isSameArray(hsInterval, addInterval)) { // hs == add
					// next add Interval
					continue top;
				} else if (addInterval[0] <= hsInterval[0] && hsInterval[1] <= addInterval[1]) { // hs < add
					// find all another hsInterval to remove
					hsRemove.add(hsInterval);
					continue;
				} else if (hsInterval[0] <= addInterval[0] && addInterval[1] <= hsInterval[1]) { // add < hs
					// next add Interval
					continue top;
				}
			}
			hs.add(addInterval);
			if (hsRemove.size() > 0) {
				for (int[] hsRemoveInterval : hsRemove) {
					hs.remove(hsRemoveInterval);
					if (hs.size() == 0) {
						break;
					}
				}
			}
		}

		return hs.size();
	}

	public static void main(String[] args) {
		Solution1288 solution1288 = new Solution1288();

		System.out.println(solution1288.removeCoveredIntervals(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } })); // 2
		System.out.println(solution1288.removeCoveredIntervals(new int[][] { { 1, 4 }, { 2, 3 } })); // 1
		System.out.println(solution1288.removeCoveredIntervals(
				new int[][] { { 66672, 75156 }, { 59890, 65654 }, { 92950, 95965 }, { 9103, 31953 }, { 54869, 69855 },
						{ 33272, 92693 }, { 52631, 65356 }, { 43332, 89722 }, { 4218, 57729 }, { 20993, 92876 } }));
		System.out.println(solution1288.removeCoveredIntervals(new int[][] { { 3, 10 }, { 4, 10 }, { 5, 11 } })); // 2
	}
}
