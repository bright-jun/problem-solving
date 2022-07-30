package exercise.leetcode;

import java.util.List;

public class Solution916 {
	/*
	 * 1 <= words1.length, words2.length <= 10^4
	 * 1 <= words1[i].length, words2[i].length <= 10
	 * words1[i] and words2[i] consist only of lowercase English letters.
	 * All the strings of words1 are unique.
	 */
	public List<String> wordSubsets(String[] words1, String[] words2) {
		
		return null;
	}

	public static void main(String[] args) {
		Solution916 solution916 = new Solution916();
		
		List<String> answer;
		answer = solution916.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e", "o"});
		answer = solution916.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l", "e"});
		
		return;
	}
}
