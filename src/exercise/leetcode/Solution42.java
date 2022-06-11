package exercise.leetcode;

public class Solution42 {

	public int trap(int[] height) {
		
		int beforeHeight = -1;
		
		for (int i = 0; i < height.length; i++) {
			if(beforeHeight <= height[i]) { // up
				// fill nothing
			} else { // down
				// fill if there are height higher or same
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		Solution42 solution42 = new Solution42();
		System.out.println(solution42.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
		System.out.println(solution42.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
		System.out.println(solution42.trap(new int[] { 0, 1, 0, 2, 1 }));
	}
}
