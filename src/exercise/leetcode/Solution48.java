package exercise.leetcode;

public class Solution48 {
	/*
	 * n == matrix.length == matrix[i].length
	 * 1 <= n <= 20
	 * -1000 <= matrix[i][j] <= 1000
	 */
	public void rotate(int[][] matrix) {

	}
	
	public void swap(int ai, int aj, int bi, int bj, int[][] matrix) {
		int temp = matrix[ai][aj];
		matrix[ai][aj] = matrix[bi][bj];
		matrix[bi][bj] = temp;
	}

	public static void main(String[] args) {
		Solution48 solution48 = new Solution48();
		
		int[][] matrix;
		matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		solution48.rotate(matrix);
		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		solution48.rotate(matrix);
		
		return;
	}
}
