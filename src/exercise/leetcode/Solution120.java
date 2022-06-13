package exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution120 {
	/*
	 * 1 <= triangle.length <= 200 triangle[0].length == 1 triangle[i].length ==
	 * triangle[i - 1].length + 1 -10^4 <= triangle[i][j] <= 10^4
	 */
	public int minimumTotal(List<List<Integer>> triangle) {

		int n = triangle.size();

		// Time O(N^2)

		// Time O(N)
		int[][] arr = new int[n][n];
		
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					arr[i][j] = triangle.get(i-1).get(j);
					
				} else if (j == i) {
					arr[i][j] = triangle.get(i-1).get(j-1);
				} else {
					arr[i][j] = Math.min(triangle.get(i-1).get(j), triangle.get(i-1).get(j-1));
				}
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			answer = Math.min(answer, arr[n-1][i]);
		}
		
		// Time O(N) + SpaceO(N)

		return answer;
	}

	public static void main(String[] args) {
		Solution120 solution120 = new Solution120();
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
//		System.out.println(solution120.minimumTotal([[2],[3,4],[6,5,7],[4,1,8,3]]));
		triangle.add(Arrays.asList(2));
		triangle.add(Arrays.asList(3, 4));
		triangle.add(Arrays.asList(6, 5, 7));
		triangle.add(Arrays.asList(4, 1, 8, 3));
		System.out.println(solution120.minimumTotal(triangle));
//		System.out.println(solution120.minimumTotal([[-10]]));
	}
}
