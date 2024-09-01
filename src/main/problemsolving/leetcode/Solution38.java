package problemsolving.leetcode;

public class Solution38 {
    public static String[] Memoization;

    /*
     * 1 <= n <= 30
     */
    public String countAndSay(int n) {
        Memoization = new String[31];
        if (n == 1) {
            return "1";
        }

        if (Memoization[n] != null) {
            return Memoization[n];
        }

        StringBuilder sb = new StringBuilder();
        String before = countAndSay(n - 1);
        int count = 1;
        char value = '*';
        for (char c : before.toCharArray()) {
            // find new char
            if (value != c) {
                // except first case
                if (value != '*') {
                    sb.append(Integer.toString(count) + value);
                }
                value = c;
                count = 1;
            } else {
                count++;
            }
        }
        sb.append(Integer.toString(count) + value);

        Memoization[n] = sb.toString();
        return Memoization[n];
    }

    public static void main(String[] args) {
        Solution38 solution38 = new Solution38();

        String answer;
        answer = solution38.countAndSay(1);
        answer = solution38.countAndSay(2);
        answer = solution38.countAndSay(3);
        answer = solution38.countAndSay(4);
        answer = solution38.countAndSay(5);
        answer = solution38.countAndSay(6);
        answer = solution38.countAndSay(7);
        answer = solution38.countAndSay(8);

        for (int i = 9; i <= 30; i++) {
            answer = solution38.countAndSay(i);
        }

        return;
    }
}
