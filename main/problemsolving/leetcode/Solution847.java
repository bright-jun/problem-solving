package problemsolving.leetcode;

public class Solution847 {
	public static int N;
	public static int AllVisited;
	public static int[][] Graph;
	// state + nowNode check
	public static int[][] VisitedStateAndNowNodeLength;

	public void dijkstra(int node, int visited, int pathLength) {
		int nowVisited = visited | (1 << node);
		int nowPathLength = pathLength + 1;

		if (VisitedStateAndNowNodeLength[nowVisited][node] <= nowPathLength) {
			// [!] '<=' instead '<' same state same node means no need to search more
			// no shortest path
			return;
		} else {
			// update shortest path
			VisitedStateAndNowNodeLength[nowVisited][node] = nowPathLength;
		}

		if (nowVisited < AllVisited) {
			// search more
			for (int nextNode : Graph[node]) {
				// dont need visited check
//				if ((nowVisited & (1 << nextNode)) == 1) {
//					// visited nextNode
//					return;
//				} else {
//					// unvisited nextNode
				dijkstra(nextNode, nowVisited, nowPathLength);
//				}
			}
		} else {
			// search end. visited all Node
			return;
		}
	}

	public int shortestPathLength(int[][] graph) {
		// reset
		Graph = graph;
		N = graph.length;
		AllVisited = (1 << N) - 1;
		VisitedStateAndNowNodeLength = new int[AllVisited + 1][N];
		for (int i = 0; i < VisitedStateAndNowNodeLength.length; i++) {
			for (int j = 0; j < N; j++) {
				VisitedStateAndNowNodeLength[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < N; i++) {
			dijkstra(i, 0, -1);
		}

		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			answer = Integer.min(answer, VisitedStateAndNowNodeLength[AllVisited][i]);
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution847 solution847 = new Solution847();
		System.out.println(solution847.shortestPathLength(new int[][] { { 1, 2, 3 }, { 0 }, { 0 }, { 0 } }));
		System.out.println(
				solution847.shortestPathLength(new int[][] { { 1 }, { 0, 2, 4 }, { 1, 3, 4 }, { 2 }, { 1, 2 } }));
		System.out.println(solution847.shortestPathLength(new int[][] { { 2 }, { 3 },
				{ 3, 4, 5, 6, 7, 8, 9, 10, 11, 0 }, { 2, 4, 5, 6, 7, 8, 9, 10, 11, 1 }, { 2, 3, 5, 6, 7, 8, 9, 10, 11 },
				{ 2, 3, 4, 6, 7, 8, 9, 10, 11 }, { 2, 3, 4, 5, 7, 8, 9, 10, 11 }, { 2, 3, 4, 5, 6, 8, 9, 10, 11 },
				{ 2, 3, 4, 5, 6, 7, 9, 10, 11 }, { 2, 3, 4, 5, 6, 7, 8, 10, 11 }, { 2, 3, 4, 5, 6, 7, 8, 9, 11 },
				{ 2, 3, 4, 5, 6, 7, 8, 9, 10 } }));
	}
}
