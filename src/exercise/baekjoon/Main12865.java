package exercise.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12865 {
	/*
	 * Knapsack
	 */
	/*
	 * N(1 ≤ N ≤ 100) K(1 ≤ K ≤ 100,000) W(1 ≤ W ≤ 100,000) V(0 ≤ V ≤ 1,000)
	 */
	/*
	 * https://chanhuiseok.github.io/posts/improve-6/
	 */

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Baekjoon/12865.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] prod = new int[n + 1][2]; // weight, value

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			prod[i][0] = Integer.parseInt(st.nextToken());
			prod[i][1] = Integer.parseInt(st.nextToken());
		}

		// dp[i][j]
		// 처음부터 i번째까지의 물건을 살펴보고, 배낭의 용량이 j였을 때 배낭에 들어간 물건의 가치합의 최댓값
		int[][] dp = new int[n + 1][k + 1];
		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < k + 1; j++) {
				if (j - prod[i][0] >= 0) { // i번째 물건을 넣을 수 있다면?
					// 용량이 j인 배낭에 i번째 물건을 넣지 않았을 때
					// vs
					// 용량이 j인 배낭에 i번째 물건을 넣었을 때
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - prod[i][0]] + prod[i][1]);
				} else { // i번째 물건을 넣을 수 없다면, 배낭 용량은 같고 넣지 않았을 때의 값으로 초기화
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
