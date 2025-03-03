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
    static long Answer;
    static long[][] AnswerDP;

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

    /**
     * Time: O(4^(M*N)) with Dynamic Programming
     * Space: O(M*N)
     */
    static long findByDfs_1(int r, int c) {
        if (r == M - 1 && c == N - 1) {
            return AnswerDP[r][c]; // 1
        }

        Visited[r][c] = true;
        long tempAnswer = 0;
        for (int d = 0; d < 4; d++) {
            int nr = r + Dir[d][0];
            int nc = c + Dir[d][1];
            if (inMatrix(nr, nc) && !Visited[nr][nc] && Map[r][c] > Map[nr][nc]) {
                // memoization
                if (AnswerDP[nr][nc] == -1) {
                    AnswerDP[nr][nc] = findByDfs_1(nr, nc);
                }
                tempAnswer += AnswerDP[nr][nc];
            }
        }
        AnswerDP[r][c] = tempAnswer;
        Visited[r][c] = false;

        return AnswerDP[r][c];
    }

    /**
     * Time: O(4^(M*N)) with Dynamic Programming
     * Space: O(M*N)
     */
    static long findByBfs_2() {
        // TODO use priority Queue
        //  https://www.acmicpc.net/board/view/149729
        return 0L;
    }

    static boolean inMatrix(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N;
    }

    public static void main(String[] args) throws IOException {
        // read from txt
        InputStream is = Main1520.class.getClassLoader().getResourceAsStream("baekjoon/1520_1.txt");
        System.setIn(is);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // initialize
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Map = new int[M][N];
        Visited = new boolean[M][N];
        Answer = 0;
        AnswerDP = new long[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                AnswerDP[i][j] = -1;
            }
        }
        AnswerDP[M - 1][N - 1] = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long answer = findByDfs_1(0, 0);

        System.out.println(answer);
    }
}
