package exercise.programmers;

import java.util.ArrayList;
import java.util.List;

public class Solution42885 {
	public int solution(int[] people, int limit) {

		List<Integer> l = new ArrayList<Integer>();

		for (int person : people) {
			l.add(person);
		}

		// descending
		l.sort((o1, o2) -> o2.compareTo(o1));

		int answer = 0;
		return answer;
	}

	public static void main(String[] args) {
		Solution42885 solution42885 = new Solution42885();
		int answer;
		answer = solution42885.solution(new int[] { 70, 50, 80, 50 }, 100);
		answer = solution42885.solution(new int[] { 70, 80, 50 }, 100);

		return;
	}
}
