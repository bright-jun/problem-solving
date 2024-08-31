package problemsolving.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution20 {
    public boolean isValid(String s) {
        Deque<Character> dq = new LinkedList<Character>();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if (!dq.isEmpty()) {
                if (dq.peekLast() == '(' && now == ')') {
                    dq.pollLast();
                } else if (dq.peekLast() == '{' && now == '}') {
                    dq.pollLast();
                } else if (dq.peekLast() == '[' && now == ']') {
                    dq.pollLast();
                } else {
                    dq.addLast(now);
                }
            } else {
                dq.addLast(now);
            }
        }

        return dq.size() == 0;
    }

    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        System.out.println(solution20.isValid("()"));
        System.out.println(solution20.isValid("()[]{}"));
        System.out.println(solution20.isValid("(]"));
        System.out.println(solution20.isValid("({[)"));
    }
}
