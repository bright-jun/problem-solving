package exercise.leetcode;

public class Solution274 {
    /**
     * n == citations.length
     * 1 <= n <= 5000
     * 0 <= citations[i] <= 1000
     */
    public int hIndex(int[] citations) {
        return hIndex_1(citations);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int hIndex_1(int[] citations) {
        int[] counts = new int[1001];
        for (int citation : citations) {
            counts[citation]++;
        }

        int accumulation = 0;
        for (int i = 1000; i >= 0; i--) {
            accumulation += counts[i];
            if (accumulation >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution274 solution274 = new Solution274();
        int answer;
        answer = solution274.hIndex(new int[]{3, 0, 6, 1, 5});
        answer = solution274.hIndex(new int[]{1, 3, 1});
    }
}
