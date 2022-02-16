package exercise.leetcode;

public class Solution45 {
	public int jump(int[] nums) {
		int[] jumpCount = new int[nums.length];
		for (int i = 0; i < jumpCount.length; i++) {
			jumpCount[i] = Integer.MAX_VALUE;
		}
		jumpCount[0] = 1;

		// jump count to reach now idx
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j <= Integer.min(nums[i], nums.length -1 - i); j++) {
				jumpCount[i + j] = Integer.min(jumpCount[i] + 1, jumpCount[i + j]);
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			nums[i] += i;
		}
		
		for (int i = 0; i < jumpCount.length; i++) {
			// end reachable idx
			if (nums[i] >= nums.length - 1) {
				ans = Integer.min(ans, jumpCount[i]);
			}
		}

		if (nums.length == 1) {
			return 0;
		} else {
			return ans;
		}
		/*
		 * { 2, 3, 1, 1, 4 }
		 * { 0, 
		 * { 0, +1, +1 
		 * {  ,  , +2, +2, +2 
		 *         min 1
		 * 
		 * 
		 * 
		 */
	}

	public static void main(String[] args) {
		Solution45 solution45 = new Solution45();
		System.out.println(solution45.jump(new int[] { 2, 3, 1, 1, 4 })); // 2
		System.out.println(solution45.jump(new int[] { 2, 3, 0, 1, 4 })); // 2
		System.out.println(solution45.jump(new int[] { 0 })); // 0
		System.out.println(solution45.jump(new int[] { 1 })); // 0
		System.out.println(solution45.jump(new int[] { 1,1 })); // 1
		System.out.println(solution45.jump(new int[] { 1,1,1 })); // 2
		System.out.println(solution45.jump(new int[] { 1,1,1,1 })); // 3
		System.out.println(solution45.jump(new int[] { 2,1,1 })); // 1
	}
}
