package exercise.leetcode;

public class Solution74 {
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
		int[] now = { r - 1, 0 };
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
		Solution74 solution74 = new Solution74();
//		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//		Output: true
		System.out.println(solution74.searchMatrix(new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));
//		Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//		Output: false
		System.out.println(solution74.searchMatrix(new int [][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13));
		
	}
}
