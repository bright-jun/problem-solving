package problemsolving.leetcode;

import java.util.Stack;

public class Solution921 {
    /**
     * 1 <= s.length <= 1000
     * s[i] is either '(' or ')'.
     */
    public int minAddToMakeValid(String s) {
        return minAddToMakeValid2(s);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        if (s.length() == 0) {
            return 0;
        }

        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(c);
            } else {
                Character top = stack.peek();
                if (top == '(' && c == ')') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.size();
    }

    /**
     * Time: O(N)
     * Space: O(1)
     */
    public int minAddToMakeValid2(String s) {
        if (s.length() == 0) {
            return 0;
        }

        int left = 0;
        int right = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } else { // c == ')'
                if (left > 0) {
                    left--;
                } else {
                    right++;
                }
            }
        }

        return left + right;
    }

    public static void main(String[] args) {
        Solution921 solution921 = new Solution921();
        int answer;
        String s;
        s = "())";
        answer = solution921.minAddToMakeValid(s);
        s = "(((";
        answer = solution921.minAddToMakeValid(s);
    }
}
