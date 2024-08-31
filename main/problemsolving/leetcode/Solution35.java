package problemsolving.leetcode;

public class Solution35 {
    /*
     * 1 <= nums.length <= 10^4
     * -10^4 <= nums[i] <= 10^4
     * nums contains distinct values sorted in ascending order.
     * -10^4 <= target <= 10^4
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        return binarySearch_1(left, right, nums, target);
    }

    /*
     * Time: O(logN)
     * Space: O(1)
     */
    public int binarySearch_1(int left, int right, int[] nums, int target) {
        // [left, right]
        if (target < nums[left]) {
            return left;
        }
        if (target == nums[left]) {
            return left;
        }
        if (nums[right] == target) {
            return right;
        }
        if (nums[right] < target) {
            return right + 1;
        }

        int mid = (left + right) / 2;
        // [left, mid)
        // (mid, right]
        if (nums[mid] == target) {
            return mid;
        } else {
            // [left, mid)
            if (target < nums[mid]) {
                if (left > mid - 1) {
                    return binarySearch_1(left, left, nums, target);
                }
                return binarySearch_1(left, mid - 1, nums, target);
            }
            // (mid, right]
            else {
                return binarySearch_1(mid + 1, right, nums, target);
            }
        }
    }

    /*
     * Time: O(logN)
     * Space: O(1)
     */
    public int binarySearch_2(int left, int right, int[] nums, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int answer;
        answer = solution35.searchInsert(new int[]{1, 3, 5, 6}, 5);
        answer = solution35.searchInsert(new int[]{1, 3, 5, 6}, 2);
        answer = solution35.searchInsert(new int[]{1, 3, 5, 6}, 7);
        answer = solution35.searchInsert(new int[]{1, 3, 5, 6}, -1);
        answer = solution35.searchInsert(new int[]{0, 100}, 50);
    }
}
