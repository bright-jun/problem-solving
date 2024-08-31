package problemsolving.leetcode;

import java.util.Stack;

public class Solution946 {
    /*
     * simulation
     */

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushIdx = 0;
        int popIdx = 0;
        Stack<Integer> st = new Stack<Integer>();

        while (pushIdx < pushed.length && popIdx < popped.length) {

            st.add(pushed[pushIdx]);
            pushIdx++;

            while (!st.isEmpty() && st.peek() == popped[popIdx]) {
                st.pop();
                popIdx++;
            }
        }

        return st.isEmpty();
    }

    public static void main(String[] args) {
        Solution946 solution946 = new Solution946();
        System.out
                .println(solution946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out
                .println(solution946.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(solution946.validateStackSequences(new int[]{1}, new int[]{1}));
        System.out.println(solution946.validateStackSequences(new int[]{1}, new int[]{2}));
        System.out.println(solution946.validateStackSequences(new int[]{2, 0, 3, 1}, new int[]{3, 1, 0, 2}));
    }
}
