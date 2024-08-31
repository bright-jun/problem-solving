package problemsolving.leetcode;

public class Solution200_UnionFind1D {

    public static int[][] Dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public static int R;
    public static int C;

    public static int[] Parent;

    public void makeSet(int rc) {
        Parent[rc] = -1;
    }

    public int findParent(int rc) {
        if (Parent[rc] < 0) {
            return rc;
        }
        // path compression
        Parent[rc] = findParent(Parent[rc]);
        return Parent[rc];
    }

    public void unionSet(int rc1, int rc2) {
        int root1 = findParent(rc1);
        int root2 = findParent(rc2);

        int rank1 = Parent[root1];
        int rank2 = Parent[root2];

        if (root1 == root2) {
            return;
        }

        // u1 <- u2
        Parent[root2] = root1;
    }

    public int numIslands(char[][] grid) {
        R = grid.length;
        C = grid[0].length;
        Parent = new int[R * C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    makeSet(i * C + j);
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] == '1') {
                    // UnionFind
                    for (int d = 0; d < 4; d++) {
                        int nr = i + Dir[d][0];
                        int nc = j + Dir[d][1];
                        if (nr >= 0 && nr < R && nc >= 0 && nc < C && grid[nr][nc] == '1') {
                            unionSet(i * C + j, nr * C + nc);
                        }
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (Parent[i * C + j] < 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution200_UnionFind1D solution200 = new Solution200_UnionFind1D();

        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}}));
        System.out.println(solution200.numIslands(new char[][]{{'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}}));
        System.out.println(solution200.numIslands(new char[][]{{'0'}}));
        System.out.println(solution200.numIslands(new char[][]{{'1'}}));
        System.out.println(solution200.numIslands(new char[][]{{'1'}, {'1'}}));
    }
}
