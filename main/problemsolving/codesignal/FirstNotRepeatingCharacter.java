package problemsolving.codesignal;

import java.util.HashMap;
import java.util.Map;

public class FirstNotRepeatingCharacter {
    char solution(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return '_';
    }

    char solution2(String s) {
        char[] c = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(c[i]) == s.lastIndexOf(c[i]))
                return c[i];
        }
        return '_';
    }

    public static void main(String[] args) {
        FirstNotRepeatingCharacter firstNotRepeatingCharacter = new FirstNotRepeatingCharacter();
        System.out.println(firstNotRepeatingCharacter.solution("abacabad"));
        System.out.println(firstNotRepeatingCharacter.solution("abacabaabacaba"));
    }
}
