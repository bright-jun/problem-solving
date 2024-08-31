package problemsolving.leetcode;

public class Solution718 {
	/*
	 * 1 <= nums1.length, nums2.length <= 1000
	 * 0 <= nums1[i], nums2[i] <= 100
	 */
	public int findLength(int[] nums1, int[] nums2) {

		int max = Integer.MIN_VALUE;
		// O(M*N*min(M,N))
		int temp = 0;
		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				if (i + j < nums1.length) {
					if (nums1[i + j] == nums2[j]) {
						temp++;
					} else {
						max = Math.max(max, temp);
						temp = 0;
					}
				}
			}
			max = Math.max(max, temp);
			temp = 0;
		}
		
		return max;
	}

	public static void main(String[] args) {
		Solution718 solution718 = new Solution718();
		int answer;

		answer = solution718.findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 });
		answer = solution718.findLength(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 });
		// need to slide both side
		answer = solution718.findLength(new int[] { 1, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 1 });

		return;
	}
}
