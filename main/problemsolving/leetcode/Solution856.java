package problemsolving.leetcode;

import java.util.Stack;

public class Solution856 {

	public int coverRange(String s) {
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				st.add(c);
			}
			if (c == ')') {
				if (st.peek() == '(') {
					st.pop();
					if (st.isEmpty()) {
						return i;
					}
				}
			}
		}
		return -1;
	}

	// divide and conquer
	public int scoreOfParentheses(String s) {
		// find cover range
		int cover = coverRange(s);
		if (cover == s.length() - 1) { // full cover
			if (s.equals("()")) {
				return 1;
			}
			if (s.length() > 2) {
				return 2 * scoreOfParentheses(s.substring(1, s.length() - 1));
			}
		} else { // less cover
			return scoreOfParentheses(s.substring(0, cover + 1)) + scoreOfParentheses(s.substring(cover + 1));
		}
		return -1;
	}

	public static void main(String[] args) {
		Solution856 solution856 = new Solution856();
		System.out.println(solution856.scoreOfParentheses("()")); // 1
		System.out.println(solution856.scoreOfParentheses("(())")); // 2
		System.out.println(solution856.scoreOfParentheses("()()")); // 1+1
		System.out.println(solution856.scoreOfParentheses("()(())")); // 1+2
		System.out.println(solution856.scoreOfParentheses("((()))(())")); // 4+2
		System.out.println(solution856.scoreOfParentheses("(((()))(()))")); // (4+2)*2
		System.out.println(solution856.scoreOfParentheses("(((()))()(()))")); // (4+1+2)*2
		System.out.println(solution856.scoreOfParentheses("()(((()))()(()))")); // 1+(4+1+2)*2
		System.out.println(solution856.scoreOfParentheses("(())(((()))()(()))")); // 2+(4+1+2)*2
		System.out.println(solution856.scoreOfParentheses("(())((((()))()(())))")); // 2+(4+1+2)*2*2
	}
}
