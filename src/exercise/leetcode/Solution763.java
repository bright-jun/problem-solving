package exercise.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution763 {
	public List<Integer> partitionLabels(String s) {
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		if (s.length() == 1) {
			return Arrays.asList(1);
		}

		for (int i = 0; i < s.length(); i++) {
			hm.put(s.charAt(i), i);
		}

		List<Integer> answer = new ArrayList<Integer>();
		int end = hm.get(s.charAt(0));
		int start = 0;
		for (int i = 0; i < s.length(); i++) {
			if (hm.get(s.charAt(i)) < end) {
				continue;
			} else if (hm.get(s.charAt(i)) == end) {
				if (i < end) {
					continue;
				} else { // i == end
					// new start
					answer.add(end - start + 1);
					if (i + 1 == s.length()) {
						break;
					}
					end = hm.get(s.charAt(i + 1));
					start = i + 1;
				}
			} else { // hm.get(s.charAt(i)) > end
				// update end
				end = hm.get(s.charAt(i));
				if (end == s.length()-1) {
					answer.add(end - start + 1);
					break;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution763 solution763 = new Solution763();
		System.out.println(solution763.partitionLabels("ababcbacadefegdehijhklij"));
		System.out.println(solution763.partitionLabels("eccbbbbdec"));
		System.out.println(solution763.partitionLabels("a"));
		System.out.println(solution763.partitionLabels("aa"));
		System.out.println(solution763.partitionLabels("aaa"));
		System.out.println(solution763.partitionLabels("ab"));
		System.out.println(solution763.partitionLabels("abc"));
	}
}
