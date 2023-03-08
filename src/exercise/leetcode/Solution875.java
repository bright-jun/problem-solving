package exercise.leetcode;

public class Solution875 {
    /*
     * 1 <= piles.length <= 10^4
     * piles.length <= h <= 10^9
     * 1 <= piles[i] <= 10^9
     */
    public int minEatingSpeed(int[] piles, int h) {
        return minEatingSpeed_sol1(piles, h);
    }

    /*
     * Time:
     * Space:
     */
    public int minEatingSpeed_sol1(int[] piles, int h) {
        return -1;
    }

    public static void main(String[] args) {
        Solution875 solution875 = new Solution875();
        int answer;
        answer = solution875.minEatingSpeed(new int[]{3, 6, 7, 11}, 8);
        answer = solution875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5);
        answer = solution875.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
    }
}
