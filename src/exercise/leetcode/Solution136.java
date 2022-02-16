package exercise.leetcode;

import java.util.HashMap;
import java.util.Set;

public class Solution136 {
	/*
	 * You must implement a solution with a linear runtime complexity and use only constant extra space.
	 * 1 <= nums.length <= 3 * 10^4
	 * -3 * 10^4 <= nums[i] <= 3 * 10^4
	 */
	public int singleNumber(int[] nums) {
//		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
//		for (int num : nums) {
//			hm.put(num, hm.getOrDefault(num, 0) + 1);
//		}
//		for (Integer key : hm.keySet()) {
//			if (hm.get(key) == 1) {
//				return key;
//			}
//		}
//		return -1;
		
		/* XOR */
		int res = 0;
		for (int num : nums) {
			res ^= num;
		}
		return res;
	}

	public static void main(String[] args) {
		Solution136 solution136 = new Solution136();
		System.out.println(solution136.singleNumber(new int[] { 2, 2, 1 }));
		System.out.println(solution136.singleNumber(new int[] { 4, 1, 2, 1, 2 }));
		System.out.println(solution136.singleNumber(new int[] { 1 }));
	}
}
