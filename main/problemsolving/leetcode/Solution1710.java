package problemsolving.leetcode;

import java.util.Arrays;

public class Solution1710 {

    /*
     * 1 <= boxTypes.length <= 1000
     * 1 <= numberOfBoxesi, numberOfUnitsPerBoxi <= 1000
     * 1 <= truckSize <= 10^6
     */
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> o2[1] - o1[1]);

        int left = truckSize;
        int answer = 0;
        for (int[] box : boxTypes) {
            int useCnt = Math.min(left, box[0]);
            answer += useCnt * box[1];
            left -= useCnt;
            if (left == 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution1710 solution1710 = new Solution1710();
        int answer;
        answer = solution1710.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4);
        System.out.println(answer);
        answer = solution1710.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10);
        System.out.println(answer);
    }
}
