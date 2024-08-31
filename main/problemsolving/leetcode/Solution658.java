package problemsolving.leetcode;

import java.util.List;

public class Solution658 {
	/*
	 * 1 <= k <= arr.length
	 * 1 <= arr.length <= 10^4
	 * arr is sorted in ascending order.
	 * -10^4 <= arr[i], x <= 10^4
	 */
	/*
	 * An integer a is closer to x than an integer b if:
	 * 
	 * |a - x| < |b - x|, or
	 * |a - x| == |b - x| and a < b
	 */
	public List<Integer> findClosestElements(int[] arr, int k, int x) {
		return null;
	}

	public static void main(String[] args) {
		Solution658 solution658 = new Solution658();
		List<Integer> answer;
		answer = solution658.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3); // [1,2,3,4]
		answer = solution658.findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1); // [1,2,3,4]
		return;
	}
}
