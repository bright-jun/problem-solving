package exercise.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2178 {
	/*
	 * 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다. N, M(2 ≤ N, M ≤ 100)
	 */

	// 상 우 하 좌
	public static int[][] Dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Baekjoon/2178.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int answer = 0;
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char[] cArr = br.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = cArr[j] - '0';
			}
		}

		// DFS
		Deque<int[]> dq = new LinkedList<int[]>();

		// start
		dq.add(new int[] { 0, 0 });
		visited[0][0] = true;

		int[] next = new int[2];

		top:
		while (!dq.isEmpty()) {
			answer++;
			for (int i = 0, dqSize = dq.size(); i < dqSize; i++) {
				int[] now = dq.pollFirst();
				if (now[0] == n - 1 && now[1] == m - 1) {
					break top;
				}
				for (int d = 0; d < 4; d++) {
					next[0] = now[0] + Dir[d][0];
					next[1] = now[1] + Dir[d][1];

					// movable && not visited
					if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < m && map[next[0]][next[1]] == 1
							&& !visited[next[0]][next[1]]) {
						// move
						dq.add(new int[] { next[0], next[1] });
//						dq.add(next); // call by value(reference) -> error
						visited[next[0]][next[1]] = true;
					}
				}
			}
		}

		System.out.println(answer);
	}
}
