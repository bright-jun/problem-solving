package exercise.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class Solution20 {
	public boolean isValid(String s) {
        Deque<String> dq  = new LinkedList<String>();
		return false;
    }
	public static void main(String[] args) {
		Solution20 solution20 = new Solution20();
		System.out.println(solution20.isValid("()"));
		System.out.println(solution20.isValid("()[]{}"));
		System.out.println(solution20.isValid("(]"));
	}
}
