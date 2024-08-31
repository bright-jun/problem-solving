package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution18 {
	// brute force => 200C4 = 8*10^8/12 = 10*8
	// pruning with sort
	// distinct -> how ? -> hashMap
	static List<List<Integer>> AnswerList;
	static HashMap<Integer, Integer> ValCount;
	static int[] Answer;
	static int Target;
	static int N;
	static int[] Nums;
	static int HN;
	static int[] HNums;

	public void BF(int n, int flag) {
		if (n == 4) {
			if (HNums[Answer[0]] + HNums[Answer[1]] + HNums[Answer[2]] + HNums[Answer[3]] == Target) {
				List<Integer> tempList = new ArrayList<Integer>();
				tempList.add(HNums[Answer[0]]);
				tempList.add(HNums[Answer[1]]);
				tempList.add(HNums[Answer[2]]);
				tempList.add(HNums[Answer[3]]);
				AnswerList.add(tempList);
			}
			return;
		}

		for (int i = flag; i < HN; i++) {
			if (ValCount.get(HNums[i]) > 0) {
				// valCount > 0
				Answer[n] = i;
				ValCount.put(HNums[i], ValCount.get(HNums[i]) - 1);
				// pruning
//				int tempSum = 0;
//				for (int j = 0; j <= n; j++) {
//					tempSum += HNums[Answer[j]];
//				}
//				if (tempSum > Target) {
//					// reset
//					ValCount.put(HNums[i], ValCount.get(HNums[i]) + 1);
//					return;
//				}
				BF(n + 1, i);
				// reset
				ValCount.put(HNums[i], ValCount.get(HNums[i]) + 1);
			} else {
				// valCount == 0
				continue;
			}
		}
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		// reset
		Answer = new int[4];
		Target = target;
		N = nums.length;
		Arrays.sort(nums);
		Nums = nums;
		AnswerList = new ArrayList<List<Integer>>();

		ValCount = new HashMap<Integer, Integer>();
		for (int num : nums) {
			ValCount.put(num, ValCount.getOrDefault(num, 0) + 1);
		}

		HN = ValCount.keySet().size();
		HNums = new int[HN];
		int idx = 0;
		for (int num : ValCount.keySet()) {
			HNums[idx++] = num;
		}

		Arrays.sort(HNums);

		BF(0, 0);

		return AnswerList;
	}

	public static void main(String[] args) {
		Solution18 solution18 = new Solution18();
		System.out.println(solution18.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
		System.out.println(solution18.fourSum(new int[] { 2, 2, 2, 2, 2 }, 8));
		// pruning exception
		System.out.println(solution18.fourSum(new int[] { 1, -2, -5, -4, -3, 3, 3, 5 }, -11));
		// TLE
		System.out.println(solution18.fourSum(new int[] { -489, -487, -471, -464, -451, -421, -414, -405, -396, -355,
				-354, -350, -336, -335, -334, -307, -298, -296, -295, -287, -267, -256, -247, -231, -170, -130, -120,
				-109, -96, -80, -78, -71, -63, -56, -44, -43, -13, 2, 9, 18, 31, 36, 39, 43, 49, 49, 50, 61, 68, 73, 99,
				107, 112, 113, 120, 121, 173, 180, 185, 190, 203, 210, 233, 246, 258, 296, 319, 340, 345, 370, 371, 378,
				395, 418, 436, 444, 447, 451, 460, 485 }, 2926));

	}
}
