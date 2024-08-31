package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
	/*
	 * 2 <= nums.length <= 10^4 -10^9 <= nums[i] <= 10^9 -10^9 <= target <= 10^9
	 * Only one valid answer exists.
	 */
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, List<Integer>> hm = new HashMap<Integer, List<Integer>>(); // (value, idxList)

		// a + b = target
		// b = target - a
		for (int i = 0; i < nums.length; i++) {
			hm.computeIfAbsent(target - nums[i], k -> new ArrayList<Integer>());
			hm.get(target - nums[i]).add(i);
			// what's difference between get.add and getOrDefault.add
//			hm.getOrDefault(target - nums[i], new ArrayList<Integer>()).add(i);
		}

		int[] answer = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (hm.get(nums[i]) == null) {
				continue;
			}

			int j = hm.get(nums[i]).get(0);
			if (i != j) {
				answer[0] = i;
				answer[1] = j;
			} else {
				if (hm.get(nums[i]).size() > 1) {
					j = hm.get(nums[i]).get(1);
					answer[0] = i;
					answer[1] = j;
				} else {
					continue;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution1 solution1 = new Solution1();
		System.out.println(Arrays.toString(solution1.twoSum(new int[] { 2, 7, 11, 15 }, 9))); // [0,1]
		System.out.println(Arrays.toString(solution1.twoSum(new int[] { 3, 2, 4 }, 6))); // [1,2]
		System.out.println(Arrays.toString(solution1.twoSum(new int[] { 3, 3 }, 6))); // [0,1]
	}
}
