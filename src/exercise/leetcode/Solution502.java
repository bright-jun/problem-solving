package exercise.leetcode;

import java.util.Comparator;
import java.util.LinkedList;

public class Solution502 {
	/*
	 * 1 <= k <= 10^5
	 * 0 <= w <= 10^9
	 * n == profits.length
	 * n == capital.length
	 * 1 <= n <= 10^5
	 * 0 <= profits[i] <= 10^4
	 * 0 <= capital[i] <= 10^9
	 */
	public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
		return findMaximizedCapital_sol1(k, w, profits, capital);
	}

	class Project {
		int profit;
		int capital;

		public Project(int profit, int capital) {
			this.profit = profit;
			this.capital = capital;
		}
	}

	/*
	 * Time: O(NlogN)
	 * Space: O(N)
	 */
	public int findMaximizedCapital_sol1(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;
		LinkedList<Project> projects = new LinkedList<Project>();
		for (int i = 0; i < n; i++) {
			projects.add(new Project(profits[i], capital[i]));
		}
		projects.sort(new Comparator<Project>() {
			@Override
			public int compare(Project o1, Project o2) {
				if (o1.profit == o2.profit) {
					return o1.capital - o2.capital;
				} else {
					return o2.profit - o1.profit;
				}
			}
		});

		int money = w;
		for (int i = 0; i < k; i++) {
			boolean find = false;
			for (Project p : projects) {
				if (p.capital <= money) {
					money += p.profit;
					projects.remove(p);
					find = true;
					break;
				}
			}
			if (!find) {
				break;
			}
		}

		return money;
	}

	/*
	 * Time: O(NlogN)
	 * Space: O(N)
	 */
	public int findMaximizedCapital_sol2(int k, int w, int[] profits, int[] capital) {
		int n = profits.length;
		LinkedList<int[]> projects = new LinkedList<int[]>();
		for (int i = 0; i < n; i++) {
			projects.add(new int[] { profits[i], capital[i] });
		}
		projects.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				} else {
					return o2[0] - o1[0];
				}
			}
		});

		int money = w;
		for (int i = 0; i < k; i++) {
			boolean find = false;
			for (int[] p : projects) {
				if (p[1] <= money) {
					money += p[0];
					projects.remove(p);
					find = true;
					break;
				}
			}
			if (!find) {
				break;
			}
		}

		return money;
	}

	public static void main(String[] args) {
		Solution502 solution502 = new Solution502();
		int answer;
		answer = solution502.findMaximizedCapital(2, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 1 });
		answer = solution502.findMaximizedCapital(3, 0, new int[] { 1, 2, 3 }, new int[] { 0, 1, 2 });
	}
}
