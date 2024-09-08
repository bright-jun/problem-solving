package problemsolving.leetcode;

public class Solution135 {
    /**
     * 1 <= ransomNote.length, magazine.length <= 10^5
     * ransomNote and magazine consist of lowercase English letters.
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        return canConstruct1(ransomNote, magazine);
    }

    /**
     * Time: O(N)
     * Space: O(N)
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] ransomNoteAlphabetCount = new int['z' - 'a' + 1];
        int[] magazineAlphabetCount = new int['z' - 'a' + 1];

        for (char c : ransomNote.toCharArray()) {
            ransomNoteAlphabetCount[c - 'a']++;
        }
        for (char c : magazine.toCharArray()) {
            magazineAlphabetCount[c - 'a']++;
        }

        for (int alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (ransomNoteAlphabetCount[alphabet - 'a'] > magazineAlphabetCount[alphabet - 'a']) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution135 solution135 = new Solution135();
        String ransomNote, magazine;
        boolean answer;
        ransomNote = "a";
        magazine = "b";
        answer = solution135.canConstruct(ransomNote, magazine); // false
        ransomNote = "aa";
        magazine = "ab";
        answer = solution135.canConstruct(ransomNote, magazine); // false
        ransomNote = "aa";
        magazine = "aab";
        answer = solution135.canConstruct(ransomNote, magazine); // true
        ransomNote = "aab";
        magazine = "baa";
        answer = solution135.canConstruct(ransomNote, magazine); // true
    }
}
