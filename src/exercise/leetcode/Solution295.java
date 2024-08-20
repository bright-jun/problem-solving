package exercise.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 * -10^5 <= num <= 10^5
 * There will be at least one element in the data structure before calling findMedian.
 * At most 5 * 10^4 calls will be made to addNum and findMedian.
 */
class MedianFinder {
    private final List<Integer> list;
    private final PriorityQueue<Integer> pq;
    private final PriorityQueue<Integer> ascendingPq;
    private final PriorityQueue<Integer> descendingPq;

    public MedianFinder() {
        list = new ArrayList<>();
        pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        ascendingPq = new PriorityQueue<>();
        descendingPq = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        addNum4(num);
    }

    /**
     * Time: O(N)
     * Space: O(N)
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
     * Space: O(N)
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
     * Time: O(logN)
     * Space: O(N)
     */
    private void addNum3(int num) {
        pq.add(num);
    }

    /**
     * Time: O(logN)
     * Space: O(N)
     */
    private void addNum4(int num) {
        ascendingPq.offer(num);
        descendingPq.offer(ascendingPq.poll());

        // (k, k) or (k+1, k)
        if (ascendingPq.size() < descendingPq.size()) {
            ascendingPq.offer(descendingPq.poll());
        }
    }

    public double findMedian() {
        return findMedian3();
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    private double findMedian1() {
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

    /**
     * Time: O(N)
     * Space: O(1)
     */
    private double findMedian2() {
        int size = pq.size();
        if (size % 2 == 0) {
            if (size > 0) {
                for (int peek = 0; peek < size / 2 - 2; peek++) {
                    pq.poll();
                }
                // FIXME polling changes states of pq
                return (double) (pq.poll() + pq.poll()) / 2;
            } else {
                throw new IllegalStateException("no elements exists");
            }
        } else {
            for (int peek = 0; peek < size / 2 - 1; peek++) {
                pq.poll();
            }
            return pq.poll();
        }
    }

    /**
     * Time: O(1)
     * Space: O(1)
     */
    private double findMedian3() {
        if ((ascendingPq.size() + descendingPq.size()) % 2 == 0) {
            return (ascendingPq.peek() + descendingPq.peek()) / 2.0;
        } else {
            return ascendingPq.peek();
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
