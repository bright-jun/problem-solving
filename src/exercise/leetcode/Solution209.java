package exercise.leetcode;

import java.util.Arrays;

public class Solution209 {
	/*
	 * 1 <= target <= 10^9
	 * 1 <= nums.length <= 10^5
	 * 1 <= nums[i] <= 10^5
	 * which the sum is greater than or equal to target
	 */

	public int sum(int from, int to, int[] nums) {
		if (from == 0) {
			return nums[to - 1];
		} else {
			return nums[to - 1] - nums[from - 1];
		}
	}
	
	public int minSubArrayLen(int target, int[] nums) {
		// sliding window
		int answer = Integer.MAX_VALUE;
		// sum [a,b)
		// ) 인 이유는 end를 0부터 시작하면 bound error 발생
		// [2, 3, 1, 2, 4, 3], 7
		for (int i = 1; i < nums.length; i++) {
			nums[i] += nums[i-1];
		}
		// [2, 5, 6, 8,12,15], 7
		// O(N^2)
		/*
		for (int from = 0; from < nums.length; from++) {
			for (int to = from + 1; to <= nums.length; to++) {
				if (sum(from, to, nums) >= target) {
					answer = Math.min(answer, to - from);
				}
			}
		}
		*/
		
		// O(NlogN)
		// TODO using binarySearch ...?
//		for (int j = 1; j < nums.length; j++) {
//			int find = Arrays.binarySearch(nums, nums[j] - target);
//			if (find == -1) {
//				continue;
//			} else if (find < j) {
//				answer = Math.min(answer, j - find);
//			}
//		}

		// O(N)
		// two pointer
		int from = 0;
		int to = 1;
		int sum = sum(from, to, nums); // [from, to)
		while(true) {
			if (sum < target) {
				to ++;
				if(to > nums.length) {
					break;
				}
				sum = sum(from, to, nums);
			} else if (sum >= target) {
				answer = Math.min(answer, to - from); // [1,4) -> 3, [0,5) -> 5
				from ++;
				if(from >= to) {
					break;
				}
				sum = sum(from, to, nums);
			}
		}
		
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public static void main(String[] args) {
		Solution209 solution209 = new Solution209();
		System.out.println(solution209.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 })); // 2
		System.out.println(solution209.minSubArrayLen(4, new int[] { 1, 4, 4 })); // 1
		System.out.println(solution209.minSubArrayLen(11, new int[] { 1, 1, 1, 1, 1, 1, 1, 1 })); // 0
		System.out.println(solution209.minSubArrayLen(11, new int[] { 1, 2, 3, 4, 5 })); // 3
		System.out.println(solution209.minSubArrayLen(15, new int[] { 1, 2, 3, 4, 5 })); // 5
	}
}
