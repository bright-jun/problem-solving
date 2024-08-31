package problemsolving.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Solution316 {

    /*
     * 1 <= s.length <= 10^4
     *
     */

    public String removeDuplicateLetters(String s) {

        Map<Character, Integer> hs = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            hs.put(c, hs.getOrDefault(c, 0) + 1);
        }

        LinkedList<Integer> usingIndexList = new LinkedList<Integer>();

        int upperIndex = s.length() - 1;
        for (char i = 'a'; i <= 'z'; i++) {
            int count = hs.getOrDefault(i, 0);
            if (count == 0) {
                continue;
            } else if (count == 1) {
                for (int j = 0; j < s.length(); j++) {
                    if (s.charAt(j) == i) {
                        usingIndexList.add(j);
                        upperIndex = j;
                        break;
                    }
                }
            } else {
                // find ascending max case
                boolean found = false;
                for (int j = upperIndex; j < s.length(); j++) {
                    if (s.charAt(j) == i) {
                        usingIndexList.add(j);
                        upperIndex = j;
                        found = true;
                        break;
                    }
                }
                if (found) {
                    continue;
                }
                // cant find ascending max case
                for (int j = 0; j < upperIndex; j++) {
                    if (s.charAt(j) == i) {
                        usingIndexList.add(j);
                        upperIndex = j;
                        found = true;
                        break;
                    }
                }
            }
        }

        // bcabc
        // b
        // bc
        // bca
        // if greedy -> wrong answer
        // cab
        // abc

        // bcabc
        // a
        // ab
        // abc
        // find alphabetically
        // as located as front -> make more coverage

        // basically if answer sorted by ascending order, best.
        usingIndexList.sort(new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return o1 - o2;
            }
        });

        String answer = "";
        for (int i : usingIndexList) {
            answer += s.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution316 solution316 = new Solution316();
        System.out.println(solution316.removeDuplicateLetters("bcabc"));
        System.out.println(solution316.removeDuplicateLetters("cbacdcbc"));
        System.out.println(solution316.removeDuplicateLetters("dcbaabcd"));
        System.out.println(solution316.removeDuplicateLetters("dcbadcba"));
    }
}
