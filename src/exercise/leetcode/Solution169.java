package exercise.leetcode;

import java.util.HashMap;

public class Solution169 {
	public int majorityElement(int[] nums) {
		int N_2 = nums.length/2;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		
		for (int num : nums) {
			hm.put(num, hm.getOrDefault(num, 0) + 1);
			if(hm.get(num) > N_2) {
				return num;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Solution169 solution169 = new Solution169();
		System.out.println(solution169.majorityElement(new int[] {3,2,3}));
		System.out.println(solution169.majorityElement(new int[] {2,2,1,1,1,2,2}));
	}
}
