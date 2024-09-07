package problemsolving.leetcode;

public class Solution835 {
    /*
     * n == img1.length == img1[i].length
     * n == img2.length == img2[i].length
     * 1 <= n <= 30
     * img1[i][j] is either 0 or 1.
     * img2[i][j] is either 0 or 1.
     */
    public int largestOverlap(int[][] img1, int[][] img2) {
        // DFS || BFS
        return -1;
    }

    public int overlap(int[][] img1, int[][] img2) {
        int sum = 0;
        for (int i = 0; i < img1.length; i++) {
            for (int j = 0; j < img1[0].length; j++) {
                if (img1[i][j] == img2[i][j]) {
                    sum++;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution835 solution835 = new Solution835();
        int answer = -1;
        answer = solution835.largestOverlap(new int[][]{{1, 1, 0}, {0, 1, 0}, {0, 1, 0}},
            new int[][]{{0, 0, 0}, {0, 1, 1}, {0, 0, 1}});
        answer = solution835.largestOverlap(new int[][]{{0}}, new int[][]{{0}});
        answer = solution835.largestOverlap(new int[][]{{1}}, new int[][]{{1}});
        return;
    }
}
