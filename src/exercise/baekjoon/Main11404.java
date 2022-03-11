package exercise.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main11404 {
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Baekjoon/11404.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int[][] bus = new int[M][]; // from, to, cost
		int from, to, cost;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			cost = Integer.parseInt(st.nextToken());
			bus[i] = new int[] { from, to, cost };
		}

		// matrix
		int[][] adj = new int[N][N];
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				adj[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int[] busInfo : bus) {
			adj[busInfo[0] - 1][busInfo[1] - 1] = Math.min(adj[busInfo[0] - 1][busInfo[1] - 1], busInfo[2]);
		}

		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				if(adj[i][j] == Integer.MAX_VALUE) {
					adj[i][j] = 0;
				}
			}
		}
		
		/*
		 * floyd warshall
		 * 모든 정점에서 모든 정점으로의 최단거리
		 * C노드를 기준으로 할 때
		 * A -> B, A -> C + C -> B
		 * 거리중 최단거리를 A->B 거리로 갱신합니다.
		 */
		for (int _mid = 0; _mid < N; _mid++) {
			for (int _from = 0; _from < N; _from++) {
				for (int _to = 0; _to < N; _to++) {
					if(_from == _to || _to == _mid || _mid == _from) {
						continue;
					}
					
					if (adj[_from][_mid] > 0 && adj[_mid][_to] > 0) { // available search
						if (adj[_from][_to] > 0) { // check minimun
							adj[_from][_to] = Math.min(adj[_from][_to], adj[_from][_mid] + adj[_mid][_to]);
						} else { // unavailable -> available
							adj[_from][_to] = adj[_from][_mid] + adj[_mid][_to];
						}
					}
				}
			}
		}
		
		
		for (int i = 0; i < adj.length; i++) {
			for (int j = 0; j < adj.length; j++) {
				System.out.printf("%d ",adj[i][j]);
			}
			System.out.println();
		}
	}
}
