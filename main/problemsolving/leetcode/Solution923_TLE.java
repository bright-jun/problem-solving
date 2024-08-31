package problemsolving.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution923_TLE {
    /*
     * 3 <= arr.length <= 3000
     * 0 <= arr[i] <= 100
     * 0 <= target <= 300
     */
    public static long MOD = (long) 1e9 + 7;
    public static long[] Facto;

    public static int Answer;
    public static int Target;
    public static int KeyN;
    public static List<Integer> KeyList;
    public static int[] Tuple;
    public static Map<Integer, Integer> ArrHm;
    public static Map<Integer, Integer> AnsHm;

    public static long comb(int n, int r) {
        // nCr

        long bottom = (Facto[r] * Facto[n - r]) % MOD;
        bottom = pow(bottom, MOD - 2);
        return (Facto[n] * bottom) % MOD;
    }

    private static long pow(long a, long b) {
        if (b == 0) {
            return 1;
        } else if (b == 1) {
            return a;
        }

        if (b % 2 == 0) {
            long tmp = pow(a, b / 2);
            return (tmp * tmp) % MOD;
        }

        long tmp = pow(a, b - 1) % MOD;
        return (tmp * a) % MOD;
    }

    public void DFS(int n, int flag, int sum) {
        if (n == 3) {
            if (sum == Target) {
                int temp = 1;
                for (int key : AnsHm.keySet()) {
                    if (AnsHm.get(key) > 0) {
                        temp = (int) ((temp * comb(ArrHm.get(key), AnsHm.get(key))) % MOD);
                    }
                }
                Answer = (int) ((Answer + temp) % MOD);
            }
        }

        for (int i = flag; i < KeyN; i++) {
            int now = KeyList.get(i);
            if (AnsHm.get(now) < ArrHm.get(now)) { // usable
                if (sum + now <= Target) { // less than target
                    // use
                    AnsHm.put(now, AnsHm.getOrDefault(now, 0) + 1);
                    DFS(n + 1, i, sum + now);
                    // reset
                    AnsHm.put(now, AnsHm.getOrDefault(now, 0) - 1);
                } else {
                    break;
                }
            }
        }
    }

    public int threeSumMulti(int[] arr, int target) {
        // calculate FACTORIAL
        Facto = new long[3000 + 1];
        Facto[0] = 1; // 1! = 1
        Facto[1] = 1; // 1! = 1
        for (int i = 2; i <= 3000; i++) {
            Facto[i] = (Facto[i - 1] * i) % MOD;
        }

        Answer = 0;
        Target = target;
        Tuple = new int[3];
        ArrHm = new HashMap<Integer, Integer>();

        for (int i : arr) {
            ArrHm.put(i, ArrHm.getOrDefault(i, 0) + 1);
        }
        KeyN = ArrHm.size();
        KeyList = ArrHm.keySet().stream().sorted((o1, o2) -> o1.compareTo(o2)).collect(Collectors.toList());
        AnsHm = new HashMap<Integer, Integer>();
        KeyList.stream().forEach(key -> AnsHm.put(key, 0));
        // make tuple
        DFS(0, 0, 0);
        // calculate comb

        return Answer;
    }

    public static void main(String[] args) {
        Solution923_TLE solution923 = new Solution923_TLE();
//		Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
//		Output: 20
        System.out.println(solution923.threeSumMulti(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8));
//		Input: arr = [1,1,2,2,2,2], target = 5
//		Output: 12
        System.out.println(solution923.threeSumMulti(new int[]{1, 1, 2, 2, 2, 2}, 5));
//		Output: 6
        System.out.println(solution923.threeSumMulti(new int[]{0, 0, 0, 0, 5}, 5));
//		[33,2,78,17,71,16,97,73,55,68,64,45,47,8,1,69,39,52,30,86,1,30,7,28,78,4,80,62,44,96,100,16,72,67,64,20,66,40,67,33,67,34,23,76,1,15,42,87,29,3,98,11,29,46,44,31,3,63,13,24,84,86,51,10,21,3,74,10,22,32,85,59,28,14,12,60,100,37,40,26,93,93,26,79,17,31,42,74,28,64,98,96,18,19,32,18,6,8,98,63]
//		137
//		Output: 1162 TLE
        System.out.println(solution923.threeSumMulti(new int[]{33, 2, 78, 17, 71, 16, 97, 73, 55, 68, 64, 45, 47, 8, 1, 69, 39, 52, 30, 86, 1, 30, 7, 28, 78, 4, 80, 62, 44, 96, 100, 16, 72, 67, 64, 20, 66, 40, 67, 33, 67, 34, 23, 76, 1, 15, 42, 87, 29, 3, 98, 11, 29, 46, 44, 31, 3, 63, 13, 24, 84, 86, 51, 10, 21, 3, 74, 10, 22, 32, 85, 59, 28, 14, 12, 60, 100, 37, 40, 26, 93, 93, 26, 79, 17, 31, 42, 74, 28, 64, 98, 96, 18, 19, 32, 18, 6, 8, 98, 63}, 137));
    }
}
