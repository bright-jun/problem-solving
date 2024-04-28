package exercise.leetcode;

public class Solution42 {

    /*
     * n == height.length
     * 1 <= n <= 2 * 10^4
     * 0 <= height[i] <= 10^5
     */
    public int trap(int[] height) {
        return trap_1(height);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int trap_0(int[] height) {
        int n = height.length;
        int maxHeight = Integer.MIN_VALUE;
        int maxHeightIndex = 0;
        int sumHeight = 0;
        for (int i = 0; i < n; i++) {
            if (maxHeight < height[i]) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
            sumHeight += height[i];
        }
        // [0,i] increasing, [i,n) decreasing
        int total = 0;
        int increasingHeight = Integer.MIN_VALUE;
        for (int i = 0; i <= maxHeightIndex; i++) {
            increasingHeight = Integer.max(increasingHeight, height[i]);
            total += increasingHeight;
        }
        increasingHeight = Integer.MIN_VALUE;
        for (int i = n - 1; i > maxHeightIndex; i--) {
            increasingHeight = Integer.max(increasingHeight, height[i]);
            total += increasingHeight;
        }

        return total - sumHeight;
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int trap_1(int[] height) {
        int n = height.length;
        int[] leftMaxHeight = new int[n];
        int[] rightMaxHeight = new int[n];

        leftMaxHeight[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMaxHeight[i] = Integer.max(height[i], leftMaxHeight[i - 1]);
        }
        rightMaxHeight[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            rightMaxHeight[n - 1 - i] = Integer.max(height[n - 1 - i], rightMaxHeight[n - 1 - i + 1]);
        }

        int answer = 0;
        for (int i = 1; i < n - 1; i++) {
            answer += Integer.min(leftMaxHeight[i], rightMaxHeight[i]) - height[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int answer;
        answer = solution42.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}); // 6
        answer = solution42.trap(new int[]{4, 2, 0, 3, 2, 5}); // 9
        answer = solution42.trap(new int[]{5, 2, 0, 3, 2, 4}); // 9
        answer = solution42.trap(new int[]{0, 1, 0, 2, 1}); // 1
    }
}
