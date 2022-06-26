package exercise.leetcode;

public class Solution1423 {

	/*
	 * 1 <= cardPoints.length <= 10^5
	 * 1 <= cardPoints[i] <= 10^4
	 * 1 <= k <= cardPoints.length
	 */
	public int maxScore(int[] cardPoints, int k) {
		// 1, 2, 3, 4, 5, 6, 1
		// X  X  X  O  O  O  O
		// O  X  X  X  O  O  O
		// O  O  X  X  X  O  O
		// O  O  O  X  X  X  O
		// O  O  O  O  X  X  X
		int wSize = cardPoints.length - k;
		int sum = 0;
		for (int i = 0; i < cardPoints.length; i++) {
			sum += cardPoints[i];
		}
		int window = 0;
		for (int i = 0; i < wSize; i++) {
			window += cardPoints[i];
		}
		int minWindow = window;
		for (int i = wSize; i < cardPoints.length; i++) {
			window = window - cardPoints[i - wSize] + cardPoints[i];
			minWindow = Math.min(minWindow, window);
		}
		
		return sum - minWindow;
	}

	public static void main(String[] args) {
		Solution1423 solution1423 = new Solution1423();
		System.out.println(solution1423.maxScore(new int[] { 1, 2, 3, 4, 5, 6, 1 }, 3));
		System.out.println(solution1423.maxScore(new int[] { 2, 2 }, 2));
		System.out.println(solution1423.maxScore(new int[] { 9, 7, 7, 9, 7, 7, 9 }, 7));
		System.out.println(solution1423.maxScore(new int[] { 100, 40, 17, 9, 73, 75 }, 3)); // (100) + (75 + 73)
		// sliding window
		/* 
		 * Output
		 * 486
		 * Expected
		 * 566
		 */
		System.out.println(
				solution1423.maxScore(new int[] { 32, 69, 37, 79, 4, 33, 29, 33, 45, 1, 99, 90, 56, 24, 76 }, 10));
	}
}
