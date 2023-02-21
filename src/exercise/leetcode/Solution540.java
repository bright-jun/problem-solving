package exercise.leetcode;

public class Solution540 {
	/*
	 * 1 <= nums.length <= 10^5
	 * 0 <= nums[i] <= 10^5
	 */
	public int singleNonDuplicate(int[] nums) {
		return singleNonDuplicate_sol1(nums);
	}

	/*
	 * Time: O(logN)
	 * Space: O(1)
	 */
	public int singleNonDuplicate_sol1(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (mid % 2 == 0) {
				// if right exists, find right
				if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
					left = mid + 2; // skip duplicate
				}
				// if left exists, find left
				else if (mid > 0 && nums[mid] == nums[mid - 1]) {
					right = mid - 2; // skip duplicate
				} else {
					return nums[mid];
				}
			} else {
				// if right exists, find left
				if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
					right = mid - 1;
				}
				// if left exists, find right
				else if (mid > 0 && nums[mid] == nums[mid - 1]) {
					left = mid + 1;
				} else {
					return nums[mid];
				}
			}
		}
		return nums[left];
	}

	public static void main(String[] args) {
		Solution540 solution540 = new Solution540();
		int answer;
		answer = solution540.singleNonDuplicate(new int[] { 1, 1, 2, 3, 3, 4, 4, 8, 8 });
		answer = solution540.singleNonDuplicate(new int[] { 3, 3, 7, 7, 10, 11, 11 });
	}
}
