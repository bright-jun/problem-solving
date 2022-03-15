package exercise.leetcode;

import java.util.LinkedList;
import java.util.Stack;

public class Solution1249 {

	public static int AnswerFlag;
	public static int AnswerN;
	public static int N;
	public static char[] BraceList;

	public boolean isValid(LinkedList<Character> al) {

		Stack<Character> st = new Stack<Character>();

		for (char brace : al) {
			if (st.isEmpty()) {
				if (brace == '(') {
					st.add(brace);
				} else {
					return false;
				}
			} else {
				if (st.peek() == '(' && brace == ')') {
					st.pop();
				} else {
					st.add(brace);
				}
			}
		}
		return st.isEmpty();
	}

	public void DFS(int depth, int flag) {
		LinkedList<Character> ll = new LinkedList<Character>();

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) == 0) { // 1 : removed brace, 0 : remain brace
				ll.add(BraceList[i]);
			}
		}

		if (isValid(ll)) {
			if (depth < AnswerN) { // better
				AnswerN = depth;
				AnswerFlag = flag;
			}
		}

		if (depth == N || AnswerN < depth) {

			return;
		}

		for (int i = 0; i < N; i++) {
			if ((flag & (1 << i)) != 1) {
				DFS(depth + 1, flag | (1 << i));
				if (AnswerN < depth) {
					return;
				}
			}
		}
	}

	public String minRemoveToMakeValid(String s) {

		s += " ";

		String[] split = s.split("[()]");

		N = 0;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				N++;
			}
		}

		BraceList = new char[N];
		for (int i = 0, idx = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == ')') {
				BraceList[idx++] = s.charAt(i);
			}
		}

		AnswerN = Integer.MAX_VALUE;
		DFS(0, 0);

		String AnswerString = "";
		for (int i = 0; i < N; i++) {
			AnswerString += split[i];
			if ((AnswerFlag & (1 << i)) == 0) {
				AnswerString += BraceList[i];
			}
		}
		if (split.length == N + 1) {
			AnswerString += split[N];
		}

		return AnswerString.trim();
	}

	public static void main(String[] args) {
		Solution1249 solution1249 = new Solution1249();
		System.out.println(solution1249.minRemoveToMakeValid("(leet(c)o)de"));
		System.out.println(solution1249.minRemoveToMakeValid("lee(t(c)o)de"));
		System.out.println(solution1249.minRemoveToMakeValid("lee(t(c)o)de)"));
		System.out.println(solution1249.minRemoveToMakeValid("a)b(c)d"));
		System.out.println(solution1249.minRemoveToMakeValid("a)b()d"));
		System.out.println(solution1249.minRemoveToMakeValid("))(("));
		System.out.println(solution1249.minRemoveToMakeValid("("));
		System.out.println(solution1249.minRemoveToMakeValid(")i()()((fm(((()")); // DFS -> TLE "i()()fm()"
	}
}
