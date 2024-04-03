package exercise.leetcode;

import java.util.ArrayDeque;

public class Solution79 {
    static int[][] DIR = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /**
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board and word consists of only lowercase and uppercase English letters.
     */
    public boolean exist(char[][] board, String word) {
        return exist_DFS(board, word);
    }

    public static class Search {
        int r;
        int c;
        int count;
        char[][] board;

        public Search(int r, int c, int count, char[][] board) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.board = board;
        }
    }

    /**
     * Time: O(M*N)
     * Space: O((M*N)^2)
     */
    public boolean exist_BFS(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] words = word.toCharArray();
        int k = words.length;

        ArrayDeque<Search> queue = new ArrayDeque<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == words[0]) {
                    queue.addFirst(new Search(r, c, 1, copy(board)));
                    while (!queue.isEmpty()) {
                        Search now = queue.pollLast();
                        if (now.count == k) {
                            return true;
                        }
                        now.board[now.r][now.c] = '*';
                        for (int d = 0; d < 4; d++) {
                            int nr = now.r + DIR[d][0];
                            int nc = now.c + DIR[d][1];
                            if (nr >= 0 && nr < m && nc >= 0 && nc < n && now.board[nr][nc] != '*' && now.board[nr][nc] == words[now.count]) {
                                queue.addFirst(new Search(nr, nc, now.count + 1, copy(now.board)));
                            }
                        }
                    }
                }
            }
        }

        return false;
    }

    public static boolean Answer;
    public static int M;
    public static int N;
    public static int K;
    public static char[][] Board;
    public static boolean[][] Visited;
    public static char[] Words;

    /**
     * Time: O(M*N)
     * Space: O(M^N)
     */
    public boolean exist_DFS(char[][] board, String word) {
        Answer = false;
        M = board.length;
        N = board[0].length;
        Board = copy(board);
        Visited = new boolean[M][N];
        Words = word.toCharArray();
        K = Words.length;

        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                if (Board[r][c] == Words[0]) {
                    Visited[r][c] = true;
                    dfs(r, c, 1);
                    Visited[r][c] = false;
                    if (Answer) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void dfs(int r, int c, int count) {
        if (count == K) {
            Answer = true;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nr = r + DIR[d][0];
            int nc = c + DIR[d][1];
            if (nr >= 0 && nr < M && nc >= 0 && nc < N && !Visited[nr][nc] && Board[nr][nc] == Words[count]) {
                Visited[nr][nc] = true;
                dfs(nr, nc, count + 1);
                Visited[nr][nc] = false;
                if (Answer) {
                    return;
                }
            }
        }
    }

    private char[][] copy(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        char[][] copy = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                copy[i][j] = board[i][j];
            }
        }
        return copy;
    }


    public static void main(String[] args) {
        Solution79 solution79 = new Solution79();
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        boolean answer;
        answer = solution79.exist(board, "ABCCED");
        answer = solution79.exist(board, "SEE");
        answer = solution79.exist(board, "ABCB");
    }
}
