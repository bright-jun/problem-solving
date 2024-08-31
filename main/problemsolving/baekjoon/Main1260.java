package problemsolving.baekjoon;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main1260 {

    public static int N;
    public static int M;
    public static int V;
    public static boolean[] d_visit;
    public static int[][] adj;

    public static void DFS(int v) {

        d_visit[v] = true;
        System.out.print(v + " ");
        for (int i = 1; i <= N; i++) {
//			인접행렬에서 연결되어 있고, 방문가능한 경우
//			인접행렬 이용해야 가능한 경우 중 가장 낮은 정점으로 감.
            if (adj[v][i] == 1 && !d_visit[i]) {
                DFS(i);
            }
        }
//		모든 경로에 대해서 방문가능한 경로가 없을 경우
        return;
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("res/Baekjoon/1260.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
//		인접행렬 양방향
        adj = new int[N + 1][N + 1];
        int a, b;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            adj[a][b] = 1;
            adj[b][a] = 1;
        }

//		DFS
        d_visit = new boolean[N + 1];
        DFS(V);
        System.out.println();

//		BFS
        boolean[] b_visit = new boolean[N + 1];
        LinkedList<Integer> q = new LinkedList<>();
        q.add(V);
        b_visit[V] = true;
        int now;
        while (!q.isEmpty()) {
            now = q.poll();
            System.out.print(now + " ");
            for (int i = 1; i <= N; i++) {
//				인접행렬에서 연결되어 있고, 방문가능한 경우
//				인접행렬 이용해야 가능한 경우 중 가장 낮은 정점으로 감.
                if (adj[now][i] == 1 && !b_visit[i]) {
                    q.add(i);
                    b_visit[i] = true;
                }
            }
        }
    }
}

