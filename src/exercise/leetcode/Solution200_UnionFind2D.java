package exercise.leetcode;

public class Solution200_UnionFind2D {

	public static int[][] Dir = new int[][] { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	public static int R;
	public static int C;

	public static int[][][] Parent;

	public void makeSet(int r, int c) {
		Parent[r][c] = new int[] { -1, -1 };
	}

	public int[] findParent(int r, int c) {
		if (Parent[r][c][0] < 0 && Parent[r][c][1] < 0) {
			return new int[] { r, c };
		}
		// path compression
		Parent[r][c] = findParent(Parent[r][c][0], Parent[r][c][1]);
		return Parent[r][c];
	}

	public void unionSet(int r1, int c1, int r2, int c2) {
		int[] root1 = findParent(r1, c1);
		int[] root2 = findParent(r2, c2);

		int[] rank1 = Parent[root1[0]][root1[1]];
		int[] rank2 = Parent[root2[0]][root2[1]];

		if (root1[0] == root2[0] && root1[1] == root2[1]) {
			return;
		}

		// u1 <- u2
		Parent[root2[0]][root2[1]] = new int[] { root1[0], root1[1] };
	}

	public int numIslands(char[][] grid) {
		R = grid.length;
		C = grid[0].length;
		Parent = new int[R][C][2];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (grid[i][j] == '1') {
					makeSet(i, j);
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
							unionSet(i, j, nr, nc);
						}
					}
				}
			}
		}

		int answer = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (Parent[i][j][0] < 0) {
					answer++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution200_UnionFind2D solution200 = new Solution200_UnionFind2D();

		System.out.println(solution200.numIslands(new char[][] { { '1', '1', '1', '1', '0' },
				{ '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		System.out.println(solution200.numIslands(new char[][] { { '1', '1', '0', '0', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
		System.out.println(solution200.numIslands(new char[][] { { '0' } }));
		System.out.println(solution200.numIslands(new char[][] { { '1' } }));
	}
}
