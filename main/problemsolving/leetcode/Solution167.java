package problemsolving.leetcode;

import java.util.HashMap;

public class Solution167 {
    /**
     * 2 <= numbers.length <= 3 * 10^4
     * -1000 <= numbers[i] <= 1000
     * numbers is sorted in non-decreasing order.
     * -1000 <= target <= 1000
     * The tests are generated such that there is exactly one solution.
     */
    public int[] twoSum(int[] numbers, int target) {
        return twoSum_3(numbers, target);
    }

    /**
     * Time: O(N^2) ... TLE
     * Space: O(1)
     */
    public int[] twoSum_0(int[] numbers, int target) {
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i + 1, j + 1};
                }
            }
        }
        return null;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int[] twoSum_1(int[] numbers, int target) {
        int n = numbers.length;
        // value, index
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(numbers[i], i + 1);
        }

        for (int i = 0; i < n; i++) {
            Integer targetIndex = hm.get(target - numbers[i]);
            if (targetIndex != null) {
                return new int[]{i + 1, targetIndex};
            }
        }
        return null;
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int[] twoSum_2(int[] numbers, int target) {
        int n = numbers.length;
        // using numbers is sorted in non-decreasing order.
        // two-pointer

        int start = 0;
        int end = n - 1;
        int sum = numbers[start] + numbers[end];

        // [start, end]
        while (start < end) {
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                // the only way to bigger sum
                // [start++, end]
                // fix end
                //  if end is answer, only find start with increasing
                //  else, reach sum > target

                // [start, end++] ? already searched
                sum -= numbers[start];
                start++;
                sum += numbers[start];
            } else { // (sum > target)
                // then, end can't be answer
                // [start, end--]
                // [start--, end] ? already searched
                sum -= numbers[end];
                end--;
                sum += numbers[end];
            }
        }

        return null;
    }

    /**
     * Time: O(logN) ~ O(logN!) == O(NlogN)
     * Space: O(1)
     */
    public int[] twoSum_3(int[] numbers, int target) {
        int n = numbers.length;
        // using numbers is sorted in non-decreasing order.
        // two-pointer + binary search
        int start = 0;
        int end = n - 1;
        int sum = numbers[start] + numbers[end];

        // [start, end]
        while (start < end) {
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum < target) {
                // find start+n where numbers[start+n] + numbers[end] == target
                // start <= ... <= leftmost < target < rightmost <= ... <= end
                // nextStart is leftmost of border
                // already target > numbers[start] + numbers[leftmost] >= numbers[start] + numbers[rightmost]
                // so we don't pass leftmost
                int nextStart = binarySearchRight(numbers, start + 1, end - 1, target - numbers[end]);
                sum -= numbers[start];
                start = nextStart;
                sum += numbers[nextStart];
            } else { // (sum > target)
                // find end-n where numbers[start] + numbers[end-n] == target
                // start <= ... <= leftmost < target < rightmost <= ... <= end
                // nextEnd is rightmost of border
                // already numbers[start] + numbers[leftmost] <= numbers[start] + numbers[rightmost] < target
                // so we don't pass rightmost
                int nextEnd = binarySearchLeft(numbers, start + 1, end - 1, target - numbers[start]);
                sum -= numbers[end];
                end = nextEnd;
                sum += numbers[nextEnd];
            }
        }

        return null;
    }

    private int binarySearchRight(int[] numbers, int start, int end, int target) {
        // leftmost
        int mid = (start + end) / 2;
        if (mid == start) {
            return mid;
        }
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < target) { // move right
            return binarySearchRight(numbers, mid, end, target);
        } else { // (numbers[mid] > target) // move left
            return binarySearchRight(numbers, start, mid, target);
        }
    }

    private int binarySearchLeft(int[] numbers, int start, int end, int target) {
        // rightmost
        int mid = (start + end + 1) / 2;
        if (mid == end) {
            return mid;
        }
        if (numbers[mid] == target) {
            return mid;
        } else if (numbers[mid] < target) { // move right
            return binarySearchLeft(numbers, mid, end, target);
        } else { // (numbers[mid] > target) // move left
            return binarySearchLeft(numbers, start, mid, target);
        }
    }

    public static void main(String[] args) {
        Solution167 solution167 = new Solution167();
        int[] answer;
        answer = solution167.twoSum(new int[]{2, 7, 11, 15}, 9); // [1,2]
        answer = solution167.twoSum(new int[]{2, 3, 4}, 6); // [1,3]
        answer = solution167.twoSum(new int[]{-1, 0}, -1); // [1,2]
        answer = solution167.twoSum(new int[]{3, 24, 50, 79, 88, 150, 345}, 200); // [1,2]
    }
}
