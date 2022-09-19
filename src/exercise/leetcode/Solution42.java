package exercise.leetcode;

public class Solution42 {

	/*
	 * n == height.length
	 * 1 <= n <= 2 * 10^4
	 * 0 <= height[i] <= 10^5
	 * 
	 * { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 } = 14
	 * { 0, 1, 1, 2, 2, 2, 2, 3, 2, 2, 2, 1 } = 20 
	 * 20 - 14 = 6
	 * 
	 * { 5, 4, 3, 2, 1 } = 15
	 * { 5, 4, 3, 2, 1 } = 15
	 * 15 - 15 = 0
	 */
	public int trap(int[] height) {
		
		int unfilledTrap = 0;
		for (int i = 0; i < height.length; i++) {
			unfilledTrap += height[i];
		}
		
		int beforeHeight = -1;
		
		for (int i = 0; i < height.length; i++) {
			if(beforeHeight <= height[i]) { // up
				// fill nothing
			} else { // down
				// fill if there are height higher or same
				// O(n) : check by every height element
				// O(1) : check by cumulative sum
			}
		}
		
		int filledTrap = 0;
		for (int i = 0; i < height.length; i++) {
			filledTrap += height[i];
		}
		
		return filledTrap - unfilledTrap;
	}

	public static void main(String[] args) {
		Solution42 solution42 = new Solution42();
		System.out.println(solution42.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(solution42.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
		System.out.println(solution42.trap(new int[] { 0, 1, 0, 2, 1 }));
	}
}
