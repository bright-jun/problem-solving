package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

public class Solution352_SummaryRanges_sol1 {
	/*
	 * 0 <= value <= 10^4
	 * At most 3 * 10^4 calls will be made to addNum and getIntervals.
	 */
	// ordered set
	private TreeSet<Integer> ts;

	public Solution352_SummaryRanges_sol1() {
		ts = new TreeSet<Integer>();
	}

	/*
	 * Time: O(log(N)) - binary search
	 * Space: O(N)
	 */
	public void addNum(int value) {
		ts.add(value);
	}

	/*
	 * Time: O(N)
	 * Space: O(N)
	 */
	public int[][] getIntervals() {
		if (ts.isEmpty()) {
			return new int[0][2];
		}
		ArrayList<int[]> answer = new ArrayList<int[]>();
		int start = -1;
		int end = -1;
		for (Integer value : ts) {
			if (start == -1) {
				// new start from now value
				start = value;
				end = value;
			} else if (end + 1 == value) {
				// union
				end = value;
			} else {
				answer.add(new int[] { start, end });
				// new start from now value
				start = value;
				end = value;
			}
		}
		// last component
		answer.add(new int[] { start, end });
		return answer.toArray(new int[0][2]);
	}

	public static void main(String[] args) {
		Solution352_SummaryRanges_sol1 summaryRanges = new Solution352_SummaryRanges_sol1();
		int[][] intervals;
		summaryRanges.addNum(1); // arr = [1]
		intervals = summaryRanges.getIntervals(); // return [[1, 1]]
		summaryRanges.addNum(3); // arr = [1, 3]
		intervals = summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
		summaryRanges.addNum(7); // arr = [1, 3, 7]
		intervals = summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
		summaryRanges.addNum(2); // arr = [1, 2, 3, 7]
		intervals = summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
		summaryRanges.addNum(6); // arr = [1, 2, 3, 6, 7]
		intervals = summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]
	}
}
