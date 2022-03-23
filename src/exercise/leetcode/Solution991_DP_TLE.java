package exercise.leetcode;

import java.util.HashMap;

public class Solution991_DP_TLE {
    /*
     * 1 <= x, y <= 10^9
     * 
     * O(N) -> dynamic programming -> TLE
     * NEED O(1)     
     *     
     */

    public static HashMap<Integer, Integer> Hm;

    public void findStep(int now, int step, int target) {
        int origin = Hm.getOrDefault(now, Integer.MAX_VALUE);
        if (step < origin) {
            Hm.put(now, Math.min(origin, step));
        } else {
            // no need to find more way
            return;
        }
        if (now == target) {
            // find target
            return;
        }

        if (now < target) {
            // if now bigger than target, no need to multiply
            // {2 -> 4 -> 3}.
            // {5 -> 4 -> 8}.
            // {3 -> 6 -> 5 -> 10}.
        	int next1 = now * 2;
            findStep(next1, step + 1, target);
        }

        if (target/2 < now) {
            // if now is bigger than target/2, subtract. if not, multiply is better
            // {2 -> 4 -> 3}.
            // {5 -> 4 -> 8}.
            // {3 -> 6 -> 5 -> 10}.
        	int next2 = now - 1;
            findStep(next2, step + 1, target);
        }
    }

    public int brokenCalc(int startValue, int target) {
        Hm = new HashMap<>(); // value, step

        findStep(startValue, 0, target);

        return Hm.get(target);
    }

    public static void main(String[] args) {
        Solution991_DP_TLE solution991 = new Solution991_DP_TLE();
        System.out.println(solution991.brokenCalc(2, 3));
        System.out.println(solution991.brokenCalc(5, 8));
        System.out.println(solution991.brokenCalc(3, 10));
        System.out.println(solution991.brokenCalc(3, 10000000));
    }
}
