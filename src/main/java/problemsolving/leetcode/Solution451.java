package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution451 {
    /*
     * 1 <= s.length <= 5 * 10^5
     * s consists of uppercase and lowercase English letters and digits.
     */
    public String frequencySort(String s) {
        int[] alphabet = new int['z' - '0' + 1];
        for (char c : s.toCharArray()) {
            alphabet[c - '0']++;
        }

        List<Character> chars = new ArrayList<Character>();
        for (int i = '0'; i <= 'z'; i++) {
            chars.add((char) i);
        }

        // descending order
        chars.sort((o1, o2) -> alphabet[o2 - '0'] - alphabet[o1 - '0']);

        StringBuilder sb = new StringBuilder();
        for (Character c : chars) {
            for (int i = 0; i < alphabet[c - '0']; i++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution451 solution451 = new Solution451();
        String answer;
        answer = solution451.frequencySort("tree");
        answer = solution451.frequencySort("cacaca");
        answer = solution451.frequencySort("Aabb");
        answer = solution451.frequencySort("2a554442f544asfasssffffasss");

        return;
    }
}
