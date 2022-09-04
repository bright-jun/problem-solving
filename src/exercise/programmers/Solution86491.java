package exercise.programmers;

public class Solution86491 {
	/*
	 * sizes의 길이는 1 이상 10,000 이하입니다.
	 * w와 h는 1 이상 1,000 이하인 자연수입니다.
	 */
	public int solution(int[][] sizes) {
		int width = sizes[0][0];
		int height = sizes[0][1];

		for (int[] size : sizes) {
			// match
			int[][] tempSize = new int[2][2];
			tempSize[0][0] = Math.max(width, size[0]);
			tempSize[0][1] = Math.max(height, size[1]);
			// rotate 90 degree and match
			tempSize[1][0] = Math.max(width, size[1]);
			tempSize[1][1] = Math.max(height, size[0]);

			if (tempSize[0][0] * tempSize[0][1] < tempSize[1][0] * tempSize[1][1]) {
				width = tempSize[0][0];
				height = tempSize[0][1];
			} else {
				width = tempSize[1][0];
				height = tempSize[1][1];
			}
		}

		return width * height;
	}

	public static void main(String[] args) {
		Solution86491 solution86491 = new Solution86491();
		int answer;
		answer = solution86491.solution(new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } }); // 4000(80x50)
		answer = solution86491.solution(new int[][] { { 10, 7 }, { 12, 3 }, { 8, 15 }, { 14, 7 }, { 5, 15 } }); // 120(8x15)
		answer = solution86491.solution(new int[][] { { 14, 4 }, { 19, 6 }, { 6, 16 }, { 18, 7 }, { 7, 11 } }); // 133(19x7)

		return;
	}
}
