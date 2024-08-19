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
        addNum1(num);
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
    }
}
