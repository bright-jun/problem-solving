package exercise.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1766 {
	/*
	 * #위상 정렬 #topological sorting
	 * 
	 * https://ko.wikipedia.org/wiki/%EC%9C%84%EC%83%81%EC%A0%95%EB%A0%AC
	 * 
	 * 문제의 수 N(1 ≤ N ≤ 32,000) 먼저 푸는 것이 좋은 문제에 대한 정보의 개수 M(1 ≤ M ≤ 100,000)
	 */
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("res/Baekjoon/1766.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] cnt = new int[n];
		// adj List
		ArrayList<Integer>[] adjList = new ArrayList[n];
		for (int i = 0; i < adjList.length; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjList[from - 1].add(to - 1);
			cnt[to - 1]++;
		}

//		가능하면 쉬운 문제부터 풀어야 한다.
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1, o2) -> o1.compareTo(o2));

//		선행 과목 없는 경우 추가
		for (int i = 0; i < n; i++) {
			if (cnt[i] == 0) {
				pq.add(i);
			}
		}

		String answer = "";
		int now;
		int lSize;
		int nowCount;
		while (!pq.isEmpty()) {
			now = pq.poll();
			answer = Integer.toString(now + 1) + " ";
			System.out.print(answer);
			lSize = adjList[now].size();
			// 연결된 후행 과목들 cnt 제거
			for (int i = 0; i < lSize; i++) {
				cnt[adjList[now].get(i)]--;
				nowCount = cnt[adjList[now].get(i)];
				// 선행 과목 없는경우
				if (nowCount == 0) {
					pq.add(adjList[now].get(i));
				}
			}
		}
	}
}
