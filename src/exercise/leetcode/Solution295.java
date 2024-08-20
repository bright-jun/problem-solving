package exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * -10^5 <= num <= 10^5
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 10^4 calls will be made to addNum and findMedian.
 */
class MedianFinder {
    private final List<Integer> list;

    public MedianFinder() {
        list = new ArrayList<>();
    }

    public void addNum(int num) {
        addNum2(num);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    private void addNum1(int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }
        int lSize = list.size();
        for (int i = 0; i < lSize; i++) {
            if (list.get(i) > num) {
                list.add(i, num);
                return;
            }
        }
        list.add(lSize, num);
        return;
    }

    /**
     * Time: O(logN)
     * Space: O(1)
     */
    private void addNum2(int num) {
        if (list.size() == 0) {
            list.add(num);
            return;
        }

        if (list.get(list.size() - 1) <= num) {
            list.add(num);
            return;
        }

        // BinarySearch index which is less than or equal to `num`
        int targetIndex;

        int left = 0;
        int right = list.size() - 1;
        int mid = (left + right) / 2;
        while (true) {
            Integer midValue = list.get(mid);
            if (midValue < num) { // search right side
                left = mid + 1;
                mid = (left + right) / 2;
                if (left >= right) {
                    targetIndex = mid;
                    break;
                }
            } else if (midValue == num) {
                targetIndex = mid;
                break;
            } else { // midValue > num // search left side
                right = mid - 1;
                mid = (left + right) / 2;
                if (left >= right) {
                    targetIndex = mid;
                    break;
                }
            }
        }

        if (list.get(targetIndex) == num) {
            list.add(targetIndex, num);
        } else if (list.get(targetIndex) > num) {
            list.add(targetIndex, num);
        } else { // list.get(targetIndex) < num
            list.add(targetIndex + 1, num);
        }
        return;
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    public double findMedian() {
        int size = list.size();
        if (size % 2 == 0) {
            if (size > 0) {
                return (double) (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
            } else {
                throw new IllegalStateException("no elements exists");
            }
        } else {
            return list.get(size / 2);
        }
    }
}

public class Solution295 {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);    // arr = [1]
        medianFinder.addNum(2);    // arr = [1, 2]
        System.out.println(medianFinder.findMedian()); // return 1.5 (i.e., (1 + 2) / 2)
        medianFinder.addNum(3);    // arr[1, 2, 3]
        System.out.println(medianFinder.findMedian()); // return 2.0

        medianFinder = new MedianFinder();
        medianFinder.addNum(-1);    // arr = [-1]
        System.out.println(medianFinder.findMedian()); // return -1.0
        medianFinder.addNum(-2);    // arr = [-2, -1]
        System.out.println(medianFinder.findMedian()); // return -1.5
        medianFinder.addNum(-3);    // arr = [-3, -2, -1]
        System.out.println(medianFinder.findMedian()); // return -2.0
        medianFinder.addNum(-4);    // arr = [-4, -3, -2, -1]
        System.out.println(medianFinder.findMedian()); // return -2.5
        medianFinder.addNum(-5);    // arr = [-5, -4, -3, -2, -1]
        System.out.println(medianFinder.findMedian()); // return -3.0

        medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(5);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(0);
        System.out.println(medianFinder.findMedian());
    }
}
