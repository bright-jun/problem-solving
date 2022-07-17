package exercise.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution92334 {

	public int[] solution(String[] id_list, String[] report, int k) {

		HashSet<String> hs = new HashSet<String>();

		for (String singleReport : report) {
			hs.add(singleReport);
		}

		HashMap<String, List<String>> reporter = new HashMap<String, List<String>>();
		for (String id : id_list) {
			reporter.put(id, new ArrayList<String>());
		}
		HashMap<String, Integer> reportee = new HashMap<String, Integer>();

		for (String singleReport : hs) {
			String[] reportInfo = singleReport.split(" ");
			reporter.get(reportInfo[0]).add(reportInfo[1]);
			reportee.put(reportInfo[1], reportee.getOrDefault(reportInfo[1], 0) + 1);
		}

		int[] answer = new int[id_list.length];
		for (int i = 0; i < answer.length; i++) {
			for (String reporteeInfo : reporter.get(id_list[i])) {
				if (reportee.getOrDefault(reporteeInfo, 0) >= k) {
					answer[i]++;
				}
			}
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution92334 solution92334 = new Solution92334();
		int[] answer;
		answer = solution92334.solution(new String[] { "muzi", "frodo", "apeach", "neo" },
				new String[] { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" }, 2);
		answer = solution92334.solution(new String[] { "con", "ryan" },
				new String[] { "ryan con", "ryan con", "ryan con", "ryan con" }, 2);
	}
}
