package exercise.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution916 {
	/*
	 * 1 <= words1.length, words2.length <= 10^4
	 * 1 <= words1[i].length, words2[i].length <= 10
	 * words1[i] and words2[i] consist only of lowercase English letters.
	 * All the strings of words1 are unique.
	 */
	public List<String> wordSubsets(String[] words1, String[] words2) {

		List<String> answer = new ArrayList<String>();
		List<int[]> alphabetList1 = new ArrayList<int[]>();
		for (String word1 : words1) {

			int[] alphabet = new int['z' - 'a' + 1];
			for (char c : word1.toCharArray()) {
				alphabet[c - 'a']++;
			}
			alphabetList1.add(alphabet);
		}

		// Reduce to Single Word in B
		// O(N^2) -> O(2N)
		List<int[]> alphabetList2 = new ArrayList<int[]>();
		for (String word2 : words2) {

			int[] alphabet = new int['z' - 'a' + 1];
			for (char c : word2.toCharArray()) {
				alphabet[c - 'a']++;
			}
			alphabetList2.add(alphabet);
		}

		int[] singleAlphabet2 = new int['z' - 'a' + 1];
		for (int[] alphabet2 : alphabetList2) {
			for (int i = 0; i < 'z' - 'a' + 1; i++) {
				singleAlphabet2[i] = Math.max(singleAlphabet2[i], alphabet2[i]);
			}
		}

		for (int i = 0; i < words1.length; i++) {
			if (!isSubset(alphabetList1.get(i), singleAlphabet2)) {
				continue;
			}
			answer.add(words1[i]);
		}

		return answer;
	}

	// is 'b' subset of 'a'
	public boolean isSubset(int[] a, int[] b) {
		for (int i = 0; i < 'z' - 'a' + 1; i++) {
			if (a[i] < b[i]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Solution916 solution916 = new Solution916();
		
		List<String> answer;
		answer = solution916.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"e", "o"});
		answer = solution916.wordSubsets(new String[] {"amazon","apple","facebook","google","leetcode"}, new String[] {"l", "e"});
		// TLE
		
		return;
	}
}
