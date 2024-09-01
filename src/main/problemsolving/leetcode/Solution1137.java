package problemsolving.leetcode;

public class Solution1137 {
    private int[] tri = new int[38];

    /*
     * 0 <= n <= 37
     * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
     */
    public int tribonacci(int n) {
        if (tri[n] > 0) {
            return tri[n];
        } else {
            if (n == 0) {
                tri[n] = 0;
                return tri[n];
            }
            if (n == 1) {
                tri[n] = 1;
                return tri[n];
            }
            if (n == 2) {
                tri[n] = 1;
                return tri[n];
            }
            tri[n - 3] = tribonacci(n - 3);
            tri[n - 2] = tribonacci(n - 2);
            tri[n - 1] = tribonacci(n - 1);
            tri[n] = tri[n - 3] + tri[n - 2] + tri[n - 1];
            return tri[n];
        }
    }

    public static void main(String[] args) {
        Solution1137 solution1137 = new Solution1137();
        for (int i = 0; i <= 37; i++) {
            System.out.println(solution1137.tribonacci(i));
        }
    }
}
