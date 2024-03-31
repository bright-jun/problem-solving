package exercise.leetcode;

public class Solution13 {
    /**
     * 1 <= s.length <= 15
     * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
     * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
     */
    public int romanToInt(String s) {
        return romanToInt_0(s);
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int romanToInt_0(String s) {
        int n = s.length();
        int answer = 0;
        int index = 0;
        char[] chars = s.toCharArray();
        while (index < n) {
            switch (chars[index]) {
                case 'I':
                    if (index + 1 < n && chars[index + 1] == 'V') {
                        answer += 4;
                        index++;
                    } else if (index + 1 < n && chars[index + 1] == 'X') {
                        answer += 9;
                        index++;
                    } else {
                        answer += 1;
                    }
                    break;
                case 'V':
                    answer += 5;
                    break;
                case 'X':
                    if (index + 1 < n && chars[index + 1] == 'L') {
                        answer += 40;
                        index++;
                    } else if (index + 1 < n && chars[index + 1] == 'C') {
                        answer += 90;
                        index++;
                    } else {
                        answer += 10;
                    }
                    break;
                case 'L':
                    answer += 50;
                    break;
                case 'C':
                    if (index + 1 < n && chars[index + 1] == 'D') {
                        answer += 400;
                        index++;
                    } else if (index + 1 < n && chars[index + 1] == 'M') {
                        answer += 900;
                        index++;
                    } else {
                        answer += 100;
                    }
                    break;
                case 'D':
                    answer += 500;
                    break;
                case 'M':
                    answer += 1000;
                    break;
            }
            index++;
        }
        return answer;
        // Symbol       Value
        // I            1
        // IV           4
        // V            5
        // IX           9
        // X            10
        // XL           40
        // L            50
        // XC           90
        // C            100
        // CD           400
        // D            500
        // CM           900
        // M            1000
        // I can be placed before V (5) and X (10) to make 4 and 9.
        // X can be placed before L (50) and C (100) to make 40 and 90.
        // C can be placed before D (500) and M (1000) to make 400 and 900.
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int answer;
        answer = solution13.romanToInt("III"); // 3
        answer = solution13.romanToInt("LVIII"); // 58
        answer = solution13.romanToInt("MCMXCIV"); // 1994
    }
}
