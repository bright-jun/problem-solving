package problemsolving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 세로의 크기 M과 가로의 크기 N
 * M과 N은 각각 500이하의 자연수이고, 각 지점의 높이는 10000이하의 자연수이다.
 */
public class Main1520 {

    static int[][] Dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    static int M;
    static int N;
    static int[][] Map;
    static boolean[][] Visited;
    static int Answer;

    /**
     * Time: O(4^(M*N)) search all possible path ... TLE
     * Space: O(M*N)
     */
    static void findByDfs_0(int r, int c) {
        if (r == M - 1 && c == N - 1) {
            Answer++;
            return;
        }

        Visited[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + Dir[d][0];
            int nc = c + Dir[d][1];
            if (inMatrix(nr, nc) && !Visited[nr][nc] && Map[r][c] > Map[nr][nc]) {
                findByDfs_0(nr, nc);
            }
        }
        Visited[r][c] = false;
    }

    static boolean inMatrix(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    public static void main(String[] args) throws IOException {
        // read from txt
        InputStream is = Main1520.class.getClassLoader().getResourceAsStream("baekjoon/1520.txt");
        System.setIn(is);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // initialize
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Map = new int[M][N];
        Visited = new boolean[M][N];
        Answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findByDfs_0(0, 0);

        System.out.println(Answer);
    }
}
