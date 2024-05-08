package exercise.leetcode;

public class Solution58 {
    /**
     * 1 <= s.length <= 10^4
     * s consists of only English letters and spaces ' '.
     * There will be at least one word in s.
     */
    public int lengthOfLastWord(String s) {
        return lengthOfLastWord_0(s);
    }

    /**
     * Time: O(N) at most
     * Space: O(1)
     */
    public int lengthOfLastWord_0(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int index = n - 1;
        int answer = 0;
        while (index >= 0) {
            if (chars[index] == ' ') {
                if (answer > 0) {
                    return answer;
                } else {
                    index--;
                }
            } else {
                answer++;
                index--;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        int answer;
        answer = solution58.lengthOfLastWord("Hello World");
        answer = solution58.lengthOfLastWord("   fly me   to   the moon  ");
        answer = solution58.lengthOfLastWord("luffy is still joyboy");
    }
}
