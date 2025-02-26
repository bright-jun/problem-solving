package problemsolving.leetcode;

/**
 * cells.length == 8
 * cells[i] is either 0 or 1.
 * 1 <= n <= 10^9
 */
public class Solution957 {
    public int[] prisonAfterNDays(int[] cells, int n) {
        return prisonAfterNDays_0(cells, n);
    }

    /**
     * Time: O(8*N) ... TLE
     * Space: O(8)
     */
    public int[] prisonAfterNDays_0(int[] cells, int n) {
        /**
         * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
         * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
         * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
         * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
         * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
         * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
         * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
         * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
         */
        int[] currentCells = cells;
        for (int i = 0; i < n; i++) {
            int[] nextCells = new int[8];
            for (int j = 0; j < 8; j++) {
                nextCells[j] = state_0(currentCells, j);
            }
            currentCells = nextCells;
        }
        return currentCells;
    }

    private int state_0(int[] cells, int index) {
        if (index == 0 || index == 7) {
            return 0;
        }

        return (cells[index - 1] == cells[index + 1]) ? 1 : 0;
    }


    public static void main(String[] args) {
        Solution957 solution957 = new Solution957();
        int[] answer;
//        answer = solution957.prisonAfterNDays(new int[]{0, 1, 0, 1, 1, 0, 0, 1}, 100); // [0,0,1,1,0,0,0,0]
        answer = solution957.prisonAfterNDays(new int[]{1, 0, 0, 1, 0, 0, 1, 0}, 1000000000); // [0,0,1,1,1,1,1,0]
    }
}
