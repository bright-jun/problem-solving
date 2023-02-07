package exercise.leetcode;

import java.util.HashSet;

public class Solution904 {
	/*
	 * 1 <= fruits.length <= 10^5
	 * 0 <= fruits[i] < fruits.length
	 */
	public int totalFruit(int[] fruits) {
		return totalFruit_1(fruits);
	}

	/*
	 * Time: O(N^2)
	 * Space: O(1)
	 */
	public int totalFruit_1(int[] fruits) {
		int answer = 0;
		for (int i = 0; i < fruits.length; i++) {
			int tempAnswer = 0;
			HashSet<Integer> basket = new HashSet<Integer>();
			for (int j = i; j < fruits.length; j++) {
				if (basket.contains(fruits[j])) {
					tempAnswer++;
				} else {
					if (basket.size() < 2) {
						basket.add(fruits[j]);
						tempAnswer++;
					} else {
						break;
					}
				}
			}
			answer = Math.max(answer, tempAnswer);
		}
		return answer;
	}

	public static void main(String[] args) {
		Solution904 solution904 = new Solution904();
		int answer;
		answer = solution904.totalFruit(new int[] { 1, 2, 1 });
		answer = solution904.totalFruit(new int[] { 0, 1, 2, 2 });
		answer = solution904.totalFruit(new int[] { 1, 2, 3, 2, 2 });
	}
}
