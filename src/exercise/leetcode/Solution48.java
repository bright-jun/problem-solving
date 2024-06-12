package exercise.leetcode;

public class Solution48 {
    /*
     * n == matrix.length == matrix[i].length
     * 1 <= n <= 20
     * -1000 <= matrix[i][j] <= 1000
     */
    public void rotate(int[][] matrix) {
        rotate_0(matrix);
    }

    /**
     * Time: O(N^2)
     * Space: O(1)
     */
    public void rotate_0(int[][] matrix) {
        int n = matrix.length;
        double halfN = Math.ceil((double) n / 2);

        // start from left top quarter area
        for (int topR = 0; topR < halfN; topR++) {
            // if n is odd, duplicate rotation exists
            if (n % 2 == 1) {
                if (topR == halfN - 1) {
                    continue;
                }
            }
            for (int topC = 0; topC < halfN; topC++) {
                // top (1,0) = (0,0) + (+1,+0)

                // swap top -> left
                // left (3,1) = (3,0) + (-0,+1)
                int leftR = (n - 1) - topC;
                int leftC = 0 + topR;
                swap(topR, topC, leftR, leftC, matrix);
                // swap left -> bottom
                // bottom = (2,3) = (3,3) + (-1,-0)
                int bottomR = (n - 1) - topR;
                int bottomC = (n - 1) - topC;
                swap(leftR, leftC, bottomR, bottomC, matrix);
                // swap bottom -> right
                // right = (0,2) = (0,3) + (+0,-1)
                int rightR = 0 + topC;
                int rightC = (n - 1) - topR;
                swap(bottomR, bottomC, rightR, rightC, matrix);
            }
        }
    }

    private void swap(int ar, int ac, int br, int bc, int[][] matrix) {
        int temp = matrix[ar][ac];
        matrix[ar][ac] = matrix[br][bc];
        matrix[br][bc] = temp;
    }

    public static void main(String[] args) {
        Solution48 solution48 = new Solution48();

        int[][] matrix;
        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution48.rotate(matrix);
        matrix = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution48.rotate(matrix);

        return;
    }
}
