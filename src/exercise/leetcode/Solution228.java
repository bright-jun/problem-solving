package exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution228 {
	/*
	 * read condition well
	 * 
	 * null check 
	 * -2^32 ~ 2^32 > Integer range
	 */
	public List<String> summaryRanges(int[] nums) {

		List<String> ans = new ArrayList<String>();

		// null check
		if (nums.length == 0) {
			return ans;
		}

		long start = nums[0];
		long end = nums[0];
		long next = -1;
		for (int i = 0; i < nums.length; i++) {
			end = nums[i];
			if (i + 1 < nums.length) {
				next = nums[i + 1];
			} else {
				if (end == start) {
					ans.add(Long.toString(start));
				} else {
					ans.add(Long.toString(start) + "->" + Long.toString(end));
				}
			}
			if (next - end > 1) {
				if (end == start) {
					ans.add(Long.toString(start));
				} else {
					ans.add(Long.toString(start) + "->" + Long.toString(end));
				}
				start = next;
			}
		}

		return ans;
	}

	public static void main(String[] args) {
		Solution228 solution228 = new Solution228();
		System.out.println(solution228.summaryRanges(new int[] { 0, 1, 2, 4, 5, 7 }));
		System.out.println(solution228.summaryRanges(new int[] { 0, 2, 3, 4, 6, 8, 9 }));
		// null check
		System.out.println(solution228.summaryRanges(new int[] {}));
		// -2^32 ~ 2^32 > Integer range
		
		System.out.println(solution228.summaryRanges(new int[] { -2147483648, -2147483647, 2147483647 }));
	}
}
