package exercise.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution454 {
	// brute force => n^4 -> 200^4 -> 8*10^8 -> time limit
	// pruning with sort
		// sort solution
	
	// O(n) -> O(1) by HashMap

	public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
		int answer = 0;
		
		HashMap<Integer, Integer> numsMap1 = new HashMap<Integer, Integer>(); // (value, count)
		for (int i = 0; i < nums1.length; i++) {
			numsMap1.put(nums1[i], numsMap1.getOrDefault(nums1[i], 0) + 1);
		}
		HashMap<Integer, Integer> numsMap2 = new HashMap<Integer, Integer>(); // (value, count)
		for (int i = 0; i < nums2.length; i++) {
			numsMap2.put(nums2[i], numsMap2.getOrDefault(nums2[i], 0) + 1);
		}
		HashMap<Integer, Integer> numsMap3 = new HashMap<Integer, Integer>(); // (value, count)
		for (int i = 0; i < nums3.length; i++) {
			numsMap3.put(nums3[i], numsMap3.getOrDefault(nums3[i], 0) + 1);
		}
		HashMap<Integer, Integer> numsMap4 = new HashMap<Integer, Integer>(); // (value, count)
		for (int i = 0; i < nums4.length; i++) {
			numsMap4.put(nums4[i], numsMap4.getOrDefault(nums4[i], 0) + 1);
		}
		HashMap<Integer, Integer> numsMapSum = new HashMap<Integer, Integer>(); // (value, count)
		for (int value2 : numsMap2.keySet()) {
			for (int value1 : numsMap1.keySet()) {
				numsMapSum.put(value1 + value2, numsMapSum.getOrDefault(value1 + value2, 0) + numsMap1.get(value1) * numsMap2.get(value2)); 
			}
		}
		for (int value4 : numsMap4.keySet()) {
			for (int value3 : numsMap3.keySet()) {
				answer += numsMapSum.getOrDefault(-(value3 + value4), 0) * numsMap3.get(value3) * numsMap4.get(value4); 
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution454 solution454 = new Solution454();
		System.out.println(solution454.fourSumCount(new int[] { 1, 2 }, new int[] { -2, -1 }, new int[] { -1, 2 },
				new int[] { 0, 2 }));
		System.out.println(solution454.fourSumCount(
				new int[] { -11, 4, 9, -2, -21, -17, -13, 10, -20, -18, 0, -29, -25, -26, -29, -17, -27, -2, -15, -8,
						-19, -21, 5, -11, -2, -1, -31, 2, -21, -32, -28, -11, -29, 8, -17, -27, -5, 0, 3, 6, 6, -32, 10,
						9, -10, -19, -11, -32, 8, -23, -10, -7, -4, -3, 8, 2, 9, 4, -22, -26, -32, -12, 0, -22, -11, 4,
						0, -18, -10, -11, 4, 8, -16, -3, -32, -3, -24, -5, 2, 7, -27, -12, -7, -14, 2, -29, -7, -21, -8,
						1, -25, -22, -16, -28, -27, -22, -30, -12, -26, -19 },
				new int[] { -23, -18, -19, -7, -23, -31, -12, -9, -24, -7, -21, -5, -8, -15, -4, 1, 8, -16, -7, -32,
						-10, 8, -21, -17, -30, -19, -11, -28, -9, 7, -18, -5, 8, 4, -21, -8, 4, -24, -32, -17, -8, 7, 9,
						10, -20, -24, -27, -27, 1, 3, -4, -7, -21, -23, -5, -26, -10, 1, -6, -18, 7, -6, 3, 8, -20, -23,
						-8, -10, -22, 3, -32, -18, -29, -13, -29, -1, -10, -3, -28, -30, -17, 9, -20, 1, -15, -8, -7,
						-10, -27, -31, -5, 1, 3, -28, -16, -22, -18, -14, 0, 1 },
				new int[] { -2, -7, -18, -23, -13, 7, -18, 3, -28, -32, -7, 3, -22, -10, -23, -1, -3, -30, -14, 2, -27,
						5, 3, -28, -1, 0, 7, -9, -20, -20, -24, -29, -18, -13, -27, 3, -4, -25, -4, -5, -7, 5, -8, -4,
						-13, -14, -12, 4, -13, 10, -7, -21, -18, -12, -10, -29, 4, -8, 1, 4, -4, -4, -15, 8, -7, -19,
						-13, -30, -31, -32, -24, -30, -10, -18, 8, -32, -20, 5, -10, -8, -26, -20, -19, -8, -28, -19,
						-15, -24, -31, 0, -18, -1, -18, -5, -6, -2, 7, -24, -17, 6 },
				new int[] { -9, 4, 5, 5, -17, -26, 5, -18, 9, -6, -10, -13, -32, -9, -22, -11, -3, -16, -31, -4, -13,
						-8, -16, -15, -10, -13, -12, -22, -12, 2, -28, -3, -11, -3, -17, -23, -5, -9, -29, -17, -15, -5,
						-26, -27, -1, -14, 6, 6, 2, -23, 10, 10, -11, -7, 7, -10, -20, -3, -19, -28, -8, -11, -28, -20,
						-2, 2, -18, -18, 0, -20, 8, -12, -20, -28, -28, 4, -31, -25, 4, -2, 0, 6, -28, 5, -32, 10, -31,
						5, 9, -21, -16, -9, 0, -20, -26, 8, -3, -16, 1, -24 }));
		System.out
				.println(solution454.fourSumCount(new int[] { 1 }, new int[] { -1 }, new int[] { 0 }, new int[] { 1 }));
	}
}
