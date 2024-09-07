package problemsolving.leetcode;

import java.util.List;

public class Solution218 {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        return null;
    }

    public static void main(String[] args) {
        Solution218 solution218 = new Solution218();
        List<List<Integer>> answer;
        answer = solution218
            .getSkyline(new int[][]{{2, 9, 10}, {3, 7, 15}, {5, 12, 12}, {15, 20, 10}, {19, 24, 8}});
        answer = solution218.getSkyline(new int[][]{{0, 2, 3}, {2, 5, 3}});
        return;
    }
}
