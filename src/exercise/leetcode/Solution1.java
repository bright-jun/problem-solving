package exercise.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>(); // (value, idx)
		
		// a + b = target
		// b = target - a
		for (int i = 0; i < nums.length; i++) {
			hm.put(target - nums[i], i);
		}
		
		for (int i = 0; i < nums.length; i++) {
//			hm.computeIfPresent(key, );
		}
		
		return null;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(solution1.twoSum(new int[] { 2, 7, 11, 15 }, 9));
		System.out.println(solution1.twoSum(new int[] { 3, 2, 4 }, 6));
		System.out.println(solution1.twoSum(new int[] { 3, 3 }, 6));
	}
}
