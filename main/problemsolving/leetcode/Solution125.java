package problemsolving.leetcode;

public class Solution125 {
    /**
     * 1 <= s.length <= 2 * 10^5
     * s consists only of printable ASCII characters.
     */
    public boolean isPalindrome(String s) {
        return isPalindrome_0(s);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public boolean isPalindrome_0(String s) {
        char[] chars = new char[s.length()];
        int index = -1;
        for (char c : s.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                chars[++index] = (char) (c + ('a' - 'A'));
            }
            if ('a' <= c && c <= 'z' || '0' <= c && c <= '9') {
                chars[++index] = c;
            }
        }

        int n = index + 1;
        if (n <= 1) {
            return true;
        }

        for (int i = 0; i <= n / 2; i++) {
            if (chars[i] != chars[n - 1 - i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution125 solution125 = new Solution125();
        boolean answer;
        answer = solution125.isPalindrome("A man, a plan, a canal: Panama");
        answer = solution125.isPalindrome("race a car");
        answer = solution125.isPalindrome(" ");
    }
}
