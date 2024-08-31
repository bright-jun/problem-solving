package problemsolving.leetcode;

public class Solution12 {
    /**
     * 1 <= num <= 3999
     */
    public String intToRoman(int num) {
        return intToRoman_1(num);
    }

    /**
     * Time: O(1) - at most 15 iteration: thousand(3-MMM) + hundreds(4-DCCC) + tens(4-LXXX) + ones(4-VIII)
     * Space: O(1)
     */
    public String intToRoman_0(int num) {
        StringBuilder answer = new StringBuilder();
        while (num > 0) {
            if (num - 1000 >= 0) {
                answer.append("M");
                num -= 1000;
            } else if (num - 900 >= 0) {
                answer.append("CM");
                num -= 900;
            } else if (num - 500 >= 0) {
                answer.append("D");
                num -= 500;
            } else if (num - 400 >= 0) {
                answer.append("CD");
                num -= 400;
            } else if (num - 100 >= 0) {
                answer.append("C");
                num -= 100;
            } else if (num - 90 >= 0) {
                answer.append("XC");
                num -= 90;
            } else if (num - 50 >= 0) {
                answer.append("L");
                num -= 50;
            } else if (num - 40 >= 0) {
                answer.append("XL");
                num -= 40;
            } else if (num - 10 >= 0) {
                answer.append("X");
                num -= 10;
            } else if (num - 9 >= 0) {
                answer.append("IX");
                num -= 9;
            } else if (num - 5 >= 0) {
                answer.append("V");
                num -= 5;
            } else if (num - 4 >= 0) {
                answer.append("IV");
                num -= 4;
            } else if (num - 1 >= 0) {
                answer.append("I");
                num -= 1;
            }
        }

        return answer.toString();
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

    /**
     * Time: O(1) - just one ... but More Slow by calculation of modular and divide
     * Space: O(1)
     */
    public String intToRoman_1(int num) {
        String[] thousands = new String[]{"", "M", "MM", "MMM"};
        String[] hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] ones = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
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
        Solution12 solution12 = new Solution12();
        String answer;
        answer = solution12.intToRoman(3749); // "MMMDCCXLIX"
        answer = solution12.intToRoman(58); // "LVIII"
        answer = solution12.intToRoman(1994); // "MCMXCIV"
        answer = solution12.intToRoman(3888); // "MMMDCCCLXXXVIII"
        return;
    }
}
