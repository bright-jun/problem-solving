package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution39 {
	/**
	 * biggest first search
	 */
	
	public static List<List<Integer>> Ans;
	public static int N;
	public static int[] Candidates;
	public static int[] Count;
	public static int Sum;
	public static int Target;

	public void comb(int flag) {
		if (flag == N) {
			return;
		}

		for (int i = (Target - Sum) / Candidates[flag]; i >= 0; i--) {
			Count[flag] = i;
			Sum += Candidates[flag] * Count[flag];

			if (Sum > Target) {
				// no next
			} else if (Sum == Target) {
				// find comb
				addAns();
			} else if (Sum < Target) {
				// search next candidate
				comb(flag + 1);
			}
			// reset
			Sum -= Candidates[flag] * Count[flag];
		}
	}

	public void addAns() {
		List<Integer> ansList = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < Count[i]; j++) {
				ansList.add(Candidates[i]);
			}
		}
		Ans.add(ansList);
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		// reset
		Ans = new ArrayList<List<Integer>>();
		N = candidates.length;
		Arrays.sort(candidates);
		Candidates = new int[N];
		for (int i = 0; i < candidates.length; i++) {
			Candidates[i] = candidates[N - 1 - i];
		}
		Count = new int[N];
		Sum = 0;
		Target = target;

		comb(0);

		return Ans;
	}

	public static void main(String[] args) {
		Solution39 solution39 = new Solution39();
		System.out.println(solution39.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
		System.out.println(solution39.combinationSum(new int[] { 2, 3, 5 }, 8));
	}
}
