package problemsolving.programmers;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution43163 {

	public static HashMap<String, Integer> WordCount;

	public boolean changeable(String before, String after) {
		int cnt = 0;
		for (int i = 0; i < before.length(); i++) {
			if (before.charAt(i) != after.charAt(i)) {
				cnt++;
			}
		}
		if (cnt == 1) {
			return true;
		}
		return false;
	}

	public int solution(String begin, String target, String[] words) {
		WordCount = new HashMap<String, Integer>();
		for (String word : words) {
			WordCount.put(word, Integer.MAX_VALUE);
		}

		int count = 0;
		Deque<String> dq = new LinkedList<String>();
		dq.add(begin);

		while (dq.size() > 0) {
			count++;
			// depth search
			for (int i = 0, dqSize = dq.size(); i < dqSize; i++) {
				String beforeWord = dq.pop();
				
				for (String afterWord : WordCount.keySet()) {
					if (changeable(beforeWord, afterWord)) {
						if (count < WordCount.get(afterWord)) { // need search more
							WordCount.put(afterWord, count);
							dq.add(afterWord);
						}
					}
				}
			}
		}
		
		int answer = WordCount.getOrDefault(target, Integer.MAX_VALUE);
		
		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	public static void main(String[] args) {
		Solution43163 solution43163 = new Solution43163();
		System.out.println(
				solution43163.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(
				solution43163.solution("hit", "cog", new String[] { "hit", "dot", "dog", "lot", "log", "cog" }));
		System.out.println(solution43163.solution("hit", "cog", new String[] { "hot", "dot", "dog", "lot", "log" }));
	}
}
