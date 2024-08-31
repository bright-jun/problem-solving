package problemsolving.leetcode;

public class Solution567 {
    /*
     * 1 <= s1.length, s2.length <= 10^4
     * s1 and s2 consist of lowercase English letters.
     */
    /*
     * Time: O(s1.length + s2.length) = O(N)
     * Space: O(26) -> O(1)
     */
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] alphabet1 = new int['z' - 'a' + 1];
        int[] alphabet2 = new int['z' - 'a' + 1];

        for (char c : s1.toCharArray()) {
            alphabet1[c - 'a']++;
        }

        for (int i = 0; i < s1.length(); i++) {
            alphabet2[s2.charAt(i) - 'a']++;
        }

        // [0, s1.length())
        if (isInclusion(alphabet1, alphabet2)) {
            return true;
        }
        // [s1.length(), s2.length())
        for (int i = s1.length(); i < s2.length(); i++) {
            alphabet2[s2.charAt(i) - 'a']++;
            alphabet2[s2.charAt((i - s1.length())) - 'a']--;
            if (isInclusion(alphabet1, alphabet2)) {
                return true;
            }
        }

        return false;
    }

    /*
     * Time: O(26) -> O(1)
     * Space: O(26) -> O(1)
     */
    public boolean isInclusion(int[] a, int[] b) {
        // check a <= b
        for (int i = 0; i < 'z' - 'a' + 1; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution567 solution567 = new Solution567();
        boolean answer;
        answer = solution567.checkInclusion("ab", "eidbaooo");
        answer = solution567.checkInclusion("ab", "eidboaoo");
        answer = solution567.checkInclusion("adc", "dcda");
    }
}
