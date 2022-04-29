package exercise.leetcode;

public class Solution4 {
	/*
	 * The overall run time complexity should be O(log (m+n)).
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		
		int m = nums1.length;
		int n = nums2.length;
		int[] mergedNums = new int[m+n];
		
		int i1 = 0;
		int i2 = 0;
		// merging -> O(n+m) -> bottleneck ... how to improve?
		for (int i = 0; i < m+n; i++) {
			if(i1 < m && i2 < n) {
				if(nums1[i1] <= nums2[i2]) {
					mergedNums[i] = nums1[i1++]; 
					continue;
				} else {
					mergedNums[i] = nums2[i2++];
					continue;
				}
			}
			if(i1 == m) {
				mergedNums[i] = nums2[i2++];
				continue;
			}
			if(i2 == n) {
				mergedNums[i] = nums1[i1++];
				continue;
			}
		}
		
		// find -> O(1) ... O(log(m+n)) by binarySearch
		if((m+n)%2 == 0) { // 0 1 2 3 : l4 -> 2
			return (double)(mergedNums[(m+n)/2] + mergedNums[((m+n)/2) - 1]) / 2;
		} else { // 0 1 2 : l3 -> 1
			return (double)mergedNums[(m+n)/2];
		}
	}

	public static void main(String[] args) {
		Solution4 solution4 = new Solution4();
		System.out.println(solution4.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
		System.out.println(solution4.findMedianSortedArrays(new int[] { 1, 2 }, new int[] { 3, 4 }));
	}
}
