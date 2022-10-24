package exercise.leetcode;

import java.util.Arrays;
import java.util.List;

public class Solution1239 {
	/*
	 * 1 <= arr.length <= 16
	 * 1 <= arr[i].length <= 26
	 * arr[i] contains only lowercase English letters.
	 */
	public int maxLength(List<String> arr) {
		return -1;
	}

	public static void main(String[] args) {
		Solution1239 solution1239 = new Solution1239();
		int answer = -1;
		answer = solution1239.maxLength(Arrays.asList("un","iq","ue"));
		answer = solution1239.maxLength(Arrays.asList("cha","r","act","ers"));
		answer = solution1239.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz"));
		return;
	}
}
