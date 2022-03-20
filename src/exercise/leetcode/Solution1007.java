package exercise.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Solution1007 {
	public int minDominoRotations(int[] tops, int[] bottoms) {
		int l = tops.length;

		HashMap<Integer, Integer> topHm = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> bottomHm = new HashMap<Integer, Integer>();

		for (int v : tops) {
			topHm.put(v, topHm.getOrDefault(v, 0) + 1);
		}
		for (int v : bottoms) {
			bottomHm.put(v, bottomHm.getOrDefault(v, 0) + 1);
		}
		ArrayList<int[]> topAl = new ArrayList<int[]>();
		ArrayList<int[]> bottomAl = new ArrayList<int[]>();
		for (int i : topHm.keySet()) {
			topAl.add(new int[] { i, topHm.get(i) });
		}
		for (int i : bottomHm.keySet()) {
			bottomAl.add(new int[] { i, bottomHm.get(i) });
		}
		topAl.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});
		bottomAl.sort(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[1] - o1[1];
			}
		});

		int answer = Integer.MAX_VALUE;
		int tempAnswer;
		boolean foundAnswer;
		for (int[] i : topAl) {
			if (l <= i[1] + bottomHm.getOrDefault(i[0], 0)) {
				// possible
				// top 기준
				tempAnswer = 0;
				foundAnswer = true;
				for (int j = 0; j < l; j++) {
					if (tops[j] == i[0]) {
						continue;
					} else {
						if (bottoms[j] == i[0]) {
							tempAnswer++;
						} else {
							foundAnswer = false;
							break;
						}
					}
				}
				if (foundAnswer) {
					if (tempAnswer < answer) {
						answer = tempAnswer;
					}
				}
			}
		}
		for (int[] i : bottomAl) {
			if (l <= i[1] + topHm.getOrDefault(i[0], 0)) {
				// possible
				// top 기준
				tempAnswer = 0;
				foundAnswer = true;
				for (int j = 0; j < l; j++) {
					if (bottoms[j] == i[0]) {
						continue;
					} else {
						if (tops[j] == i[0]) {
							tempAnswer++;
						} else {
							foundAnswer = false;
							break;
						}
					}
				}
				if (foundAnswer) {
					if (tempAnswer < answer) {
						answer = tempAnswer;
					}
				}
			}
		}

		return answer == Integer.MAX_VALUE ? -1 : answer;
	}

	public static void main(String[] args) {
		Solution1007 solution1007 = new Solution1007();
		System.out.println(
				solution1007.minDominoRotations(new int[] { 2, 1, 2, 4, 2, 2 }, new int[] { 5, 2, 6, 2, 3, 2 }));
		System.out.println(solution1007.minDominoRotations(new int[] { 3, 5, 1, 2, 3 }, new int[] { 3, 6, 3, 3, 4 }));
	}
}
