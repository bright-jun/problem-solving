package problemsolving.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution2244 {
	/*
	 * 1 <= tasks.length <= 10^5
	 * 1 <= tasks[i] <= 10^9
	 */
	public int minimumRounds(int[] tasks) {
		int answer = 0;
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for (int task : tasks) {
			hm.put(task, hm.getOrDefault(task, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
			int count = entry.getValue();
			if (count == 1) {
				return -1;
			}
			if (count % 3 == 0) {
				answer += count / 3;
			} else {
				answer += count / 3 + 1;
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution2244 solution2244 = new Solution2244();
		int answer;
		answer = solution2244.minimumRounds(new int[] { 2, 2, 3, 3, 2, 4, 4, 4, 4, 4 });
		answer = solution2244.minimumRounds(new int[] { 2, 3, 3 });
		return;
	}
}
