package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class Solution406 {
	
	/*
	 * 1 <= people.length <= 2000
	 * 0 <= hi <= 10^6
	 * 0 <= ki < people.length
	 * It is guaranteed that the queue can be reconstructed.
	 */
	public int[][] reconstructQueue(int[][] people) {

		int n = people.length;

		// HashMap<Integer, Integer> cntHm = new HashMap<Integer, Integer>();

		ArrayList<int[]> tempAl = new ArrayList<int[]>();
		ArrayList<int[]> answerAl = new ArrayList<int[]>();
		for (int[] p : people) {
			tempAl.add(p);
		}
		// O(NlogN)
		tempAl.sort((o1, o2) -> {
			if (o1[0] != o2[0]) {
				return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
			} else {
				return Integer.valueOf(o2[1]).compareTo(Integer.valueOf(o1[1]));
			}
		});

		/*
		// O(N^2) <= 4*10^6
		for (int i = 0; i < n; i++) {
			for (int[] a : tempAl) {
				if (a[1] == 0) {
					answerAl.add(a);
					tempAl.remove(a);
					cntHm.put(a[0], 1);
					break;
				} else {
					if (a[1] != getSumHigher(cntHm, a[0])) {
						continue;
					} else {
						answerAl.add(a);
						tempAl.remove(a);
						cntHm.put(a[0], cntHm.getOrDefault(a[0], 0) + 1);
						break;
					}
				}
			}
		}
		*/
		// O(N)
		int[][] answer = new int[n][2];
		for (int i = 0; i < n; i++) {
			answer[i] = tempAl.get(i);
		}

		return answer;
	}

	public int getSumHigher(HashMap<Integer, Integer> cntHm, int k) {
		int sum = 0;
		for (int key : cntHm.keySet()) {
			if (key >= k) {
				sum += cntHm.get(key);
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Solution406 solution406 = new Solution406();
		int[][] answer;
		answer = solution406.reconstructQueue(new int[][] {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
		// [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
		answer = solution406.reconstructQueue(new int[][] {{6,0},{5,0},{4,0},{3,2},{2,2},{1,4}});
		// [[4,0],[5,0],[2,2],[3,2],[1,4],[6,0]]
		// TLE
	}
}
