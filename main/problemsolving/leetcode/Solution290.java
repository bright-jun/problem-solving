package problemsolving.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution290 {
	/*
	 * 1 <= pattern.length <= 300
	 * pattern contains only lower-case English letters.
	 * 1 <= s.length <= 3000
	 * s contains only lowercase English letters and spaces ' '.
	 * s does not contain any leading or trailing spaces.
	 * All the words in s are separated by a single space.
	 */
	public boolean wordPattern2(String pattern, String s) {
		HashMap<String, Character> wordToPattern = new HashMap<String, Character>();
		Set<Character> wordSet = new HashSet<Character>();
		String[] words = s.split(" ");

		if (pattern.length() != words.length) {
			return false;
		}

		for (int i = 0; i < pattern.length(); i++) {
			if (wordToPattern.get(words[i]) == null) {
				if (wordSet.contains(pattern.charAt(i))) {
					return false;
				}
				wordSet.add(pattern.charAt(i));
				wordToPattern.put(words[i], pattern.charAt(i));
			} else {
				if (wordToPattern.get(words[i]) != pattern.charAt(i)) {
					return false;
				}
			}
		}

		return true;
	}

	public boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if (words.length != pattern.length()) {
			return false;
		}
		Map<Object, Integer> map = new HashMap<>();
		for (Integer i = 0; i < words.length; i++) {
			Integer left = map.put(pattern.charAt(i), i);
			Integer right = map.put(words[i], i);
			if (left != right) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Solution290 solution290 = new Solution290();
		boolean answer;
		answer = solution290.wordPattern("abba", "dog cat cat dog");
		answer = solution290.wordPattern("abba", "dog cat cat fish");
		answer = solution290.wordPattern("aaaa", "dog cat cat dog");
		answer = solution290.wordPattern("abba", "dog dog dog dog");
		return;
	}
}
