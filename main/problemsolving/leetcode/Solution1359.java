package problemsolving.leetcode;

public class Solution1359 {

    public static final int Mod = 1000000007;

    public int sigma(int n) {
        return n * (n + 1) / 2;
    }

    public int countOrders(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans = ((ans % Mod) * (sigma(2 * i - 1) % Mod)) % Mod;
        }

        // 1
        // (P1, D1)
        // (P2, D2)
        // [0] P1 [1] D1 [2]
        // P2 at [0] , D2 at [0~2] : 3
        // P2 at [1] , D2 at [1~2] : 2
        // P2 at [2] , D2 at [2] : 1
        // 3 + 2 + 1
        // 2
        // (P1,P2,D1,D2), (P1,P2,D2,D1), (P1,D1,P2,D2), (P2,P1,D1,D2), (P2,P1,D2,D1),
        // (P2,D2,P1,D1)
        // 5 + 4 + 3 + 2 + 1 = 15

        // int -> 2^32 * 250000 -> max : 10^15 ? range over -> miss calculate
        // long -> 9223372036854775807 -> 10^20 cover max range
        return (int) ans;
    }

    public static void main(String[] args) {
        Solution1359 solution1359 = new Solution1359();
        System.out.println(solution1359.countOrders(1)); // 1
        System.out.println(solution1359.countOrders(2)); // 6
        System.out.println(solution1359.countOrders(3)); // 90
        System.out.println(solution1359.countOrders(4)); // 2520
        System.out.println(solution1359.countOrders(5)); // 113400
        System.out.println(solution1359.countOrders(6)); // 7484400
        System.out.println(solution1359.countOrders(7)); // 681080400
        System.out.println(solution1359.countOrders(8)); // 729647433 ?? 125269376
        System.out.println(solution1359.countOrders(9)); // 636056472 ?? 986345337
        System.out.println(solution1359.countOrders(10)); // 850728840 ?? -572946987
        System.out.println(solution1359.countOrders(500)); // 764678010
    }
}
