package problemsolving.leetcode;

public class Solution240 {
    /*
     * a b c d
     * e f g h
     * i j k l
     *
     * a<b<c<d
     * a<e<i
     *
     * start i
     * find up | right
     * don't need down | left
     * if up from i, target < i means i< j,k,l is out of candidate
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] now = {r - 1, 0};
        while (true) {
            if (now[0] >= 0 && now[0] < r && now[1] >= 0 && now[1] < c) {
                if (matrix[now[0]][now[1]] == target) {
                    return true;
                } else if (matrix[now[0]][now[1]] < target) {
                    // move right;
                    now[1] += 1;
                } else { // (matrix[now[0]][now[1]] > target)
                    // move up
                    now[0] -= 1;
                }
            } else {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution240 solution240 = new Solution240();
//		Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//		Output: true
        System.out.println(solution240.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 3));
//		Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//		Output: false
        System.out.println(solution240.searchMatrix(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 13));

    }
}
