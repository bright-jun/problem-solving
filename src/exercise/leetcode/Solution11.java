package exercise.leetcode;

public class Solution11 {
	/*
	 * n == height.length
	 * 2 <= n <= 10^5
	 * 0 <= height[i] <= 10^4
	 */
	public int maxArea(int[] height) {
		
		int answer = 0;
		// O(n^2) ~ TLE
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				answer = Math.max(answer, getArea(i, j, height));
			}
		}

		return answer;
	}
	
	public int getArea(int left, int right, int[] height) {
		return (right - left) * Math.min(height[left], height[right]);
	}

	public static void main(String[] args) {
		Solution11 solution11 = new Solution11();
		int answer;
		answer = solution11.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }); // 49
		answer = solution11.maxArea(new int[] { 1, 1 }); // 1
		answer = solution11.maxArea(new int[] { 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 1 }); // 10
		answer = solution11.maxArea(new int[] { 1, 2, 3, 1000, 1000, 3, 2, 1 }); // 1000

		return;
	}
}
