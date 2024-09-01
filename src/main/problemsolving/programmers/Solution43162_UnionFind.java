package problemsolving.programmers;

import java.util.HashSet;

public class Solution43162_UnionFind {
    /*
     * Union-Find
     * 1 - 경로압축
     * 2 - Rank Compare
     */
    public static int[] Parent;

    public void makeSet(int n) {
        Parent[n] = -1;
    }

    public int findParent(int n) {
        if (Parent[n] < 0) {
            return n;
        }
        // 1 - 경로압축
        Parent[n] = findParent(Parent[n]);
        return Parent[n];
    }

    public void unionSet(int u1, int u2) {
        int root1 = findParent(u1);
        int root2 = findParent(u2);

        int rank1 = Parent[root1];
        int rank2 = Parent[root1];

        if (root1 == root2) {
            return;
        }
//		2 - Rank Compare
        if (rank1 < rank2) {
//			rank1 is more deep
//			consume rank
//			u1 <- u2
            Parent[root1] += Parent[root2];
            Parent[root2] = root1;
        } else {
//			consume rank
//			u2 <- u1
            Parent[root2] += Parent[root1];
            Parent[root1] = root2;
        }
    }

    public int solution(int n, int[][] computers) {
        Parent = new int[n];

        for (int i = 0; i < computers.length; i++) {
            makeSet(i);
        }

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (i == j) {
                    continue;
                }
                if (computers[i][j] == 1) {
                    unionSet(i, j);
                }
            }
        }

        HashSet<Integer> hs = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            hs.add(findParent(i));
        }

        return hs.size();
    }

    public static void main(String[] args) {
        Solution43162_UnionFind solution43162 = new Solution43162_UnionFind();
        System.out.println(solution43162.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}})); // 2
        System.out.println(solution43162.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}})); // 1
    }
}
