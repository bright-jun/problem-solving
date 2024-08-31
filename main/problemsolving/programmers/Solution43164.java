package problemsolving.programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;

public class Solution43164 {
	public static int TN;
	public static int[] Used;
	public static int CN;
	public static boolean[] Visited;
	public static String[][] Tickets;
	HashMap<String, Integer> HmCityIndex;
	public static boolean AllVisited;

	public void DFS(int depth, String nowCity) {
		if (depth == TN) { // all tickets used -> end

			AllVisited = true;
			for (boolean visited : Visited) {
				AllVisited &= visited;
			}

			return;
		}

		for (int i = 0; i < TN; i++) {
			// 사용안한티켓 & 사용 가능한 티켓(from 기준) & 사용 가능한 티켓(to 기준 -> 중복되도 상관없음)
			if (Used[i] == -1 && Tickets[i][0].equals(nowCity)) {
				int beforeUsed = Used[i];
				Used[i] = depth;
				Visited[HmCityIndex.get(Tickets[i][1])] = true;

				DFS(depth + 1, Tickets[i][1]);
				if (AllVisited) {
					return; // all tickets used -> end
				}

				// reset
				Used[i] = beforeUsed;
				Visited[HmCityIndex.get(Tickets[i][1])] = false;
			}
		}
	}

	public String[] solution(String[][] tickets) {
		// reset
		TN = tickets.length;
		Used = new int[TN];
		Arrays.fill(Used, -1);
		AllVisited = false;

		// get sorted city array
		HashSet<String> hsCity = new HashSet<String>();

		for (String[] ticket : tickets) {
			hsCity.add(ticket[0]);
			hsCity.add(ticket[1]);
		}

		String[] arCity = new String[hsCity.size()];

		int idx = 0;
		for (String city : hsCity) {
			arCity[idx++] = city;
		}

		CN = arCity.length;
		Visited = new boolean[CN];

		Arrays.sort(arCity, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o1.compareTo(o2);
			}
		});

		// city-index map
		HashMap<String, Integer> hmCityIndex = new HashMap<String, Integer>();

		for (int i = 0; i < arCity.length; i++) {
			hmCityIndex.put(arCity[i], i);
		}

		HmCityIndex = hmCityIndex;

		// 모든 항공권을 사용해야하므로
		// city 기준(matrix - DFS/BFS)이아니라
		// ticket 기준(adj Link - DFS/BFS)으로 탐색해야 함

		Arrays.sort(tickets, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				// TODO Auto-generated method stub

				if (o1[0].equals(o2[0])) {
					return o1[1].compareTo(o2[1]);
				} else {
					return o1[0].compareTo(o2[0]);
				}
			}
		});

		Tickets = tickets;

		// from - to, depth, visited
		// 항상 "ICN" 공항에서 출발합니다
		Visited[HmCityIndex.get("ICN")] = true;
		DFS(0, "ICN");

		String[] answer = new String[Used.length + 1];
		answer[0] = "ICN";
		
		HashMap <Integer, String> hmUsedNumberCity = new HashMap<Integer, String>();
		
		for (int i = 0; i < Used.length; i++) {
			hmUsedNumberCity.put(Used[i], tickets[i][1]);
		}
		
		for (int i = 0; i < Used.length; i++) {
			answer[i+1] = hmUsedNumberCity.get(i);
		}
		
		return answer;
	}

	public static void main(String[] args) {
		Solution43164 solution43164 = new Solution43164();
		System.out.println(Arrays.toString(
				solution43164.solution(new String[][] { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } })));
		System.out.println(Arrays.toString(solution43164.solution(new String[][] { { "ICN", "SFO" }, { "ICN", "ATL" },
				{ "SFO", "ATL" }, { "ATL", "ICN" }, { "ATL", "SFO" } })));
	}
}
