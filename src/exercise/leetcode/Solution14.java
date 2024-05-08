package exercise.leetcode;

public class Solution14 {
    /**
     * 1 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] consists of only lowercase English letters.
     */
    public String longestCommonPrefix(String[] strs) {
        return longestCommonPrefix_0(strs);
    }

    /**
     * Time: O(N) at most
     * Space: O(1)
     */
    public String longestCommonPrefix_0(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return strs[0];
        }

        StringBuilder answer = new StringBuilder();
        while (true) {
            int answerLength = answer.length();
            if (strs[0].length() <= answerLength) {
                return answer.toString();
            }
            char now = strs[0].charAt(answerLength);
            boolean allSame = true;
            for (int i = 1; i < n; i++) {
                if (strs[i].length() <= answerLength || now != strs[i].charAt(answerLength)) {
                    allSame = false;
                    break;
                }
            }
            if (allSame) {
                answer.append(now);
            } else {
                return answer.toString();
            }
        }
    }

    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        String answer;
        answer = solution14.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        answer = solution14.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
    }
}
