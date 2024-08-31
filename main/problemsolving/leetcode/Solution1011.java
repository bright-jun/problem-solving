package problemsolving.leetcode;

public class Solution1011 {
	/*
	 * 1 <= days <= weights.length <= 5 * 10^4
	 * 1 <= weights[i] <= 500
	 */
	public int shipWithinDays(int[] weights, int days) {
		return shipWithinDays_sol1(weights, days);
	}

	/*
	 * Time:
	 * Space:
	 */
	public int shipWithinDays_sol1(int[] weights, int days) {
		for (int i = 1; i < weights.length; i++) {
			weights[i] += weights[i - 1];
		}
		int min = 0;
		int max = weights[weights.length - 1];
		while (min < max) {
			int mid = (min + max) / 2;
			int valid = countDays(weights, mid, days);
			if (valid > 0) {
				// find in increased capacity
				min = mid + 1;
			} else if (valid < 0) {
				// find in decreased capacity
				max = mid - 1;
			} else {
				return mid;
			}
		}
		return min;
	}

	public int countDays(int[] weights, int capacity, int days) {
		int count = 0;

		int now = 0;
		while (count < days && now < weights.length) {
			count++;
			int last = findLastIndexOfCapacity(weights, capacity, now);
			if (last == now) {
				if (now == weights.length - 1) {
					// too few days
					// find in decreased capacity
					return -1;
				} else if (weights[now + 1] - weights[now] > capacity) {
					// can't ship anymore
					// find in increased capacity
					return 1;
				}
			}
			now = last + 1;
		}
		if (now == weights.length) {
			if (count < days) {
				// too few days
				// find in decreased capacity
				return -1;
			} else {
				// fit
				return 0;
			}
		} else {
			// too many days
			// find in increased capacity
			return 1;
		}
	}

	public int findLastIndexOfCapacity(int[] weights, int capacity, int start) {
		int left = start;
		int right = weights.length - 1;
		int beforeWeight = left > 0 ? weights[left - 1] : 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (weights[mid] < beforeWeight + capacity) {
				// find right
				left = mid + 1;
			} else if (weights[mid] > beforeWeight + capacity) {
				// find left
				right = mid - 1;
			} else {
				return mid;
			}
		}
		return left - 1;
	}

	public static void main(String[] args) {
		Solution1011 solution1011 = new Solution1011();
		int answer;
		answer = solution1011.shipWithinDays(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, 5);
		answer = solution1011.shipWithinDays(new int[] { 3, 2, 2, 4, 1, 4 }, 3);
		answer = solution1011.shipWithinDays(new int[] { 1, 2, 3, 1, 1 }, 4);
		answer = solution1011.shipWithinDays(new int[] { 147, 73, 265, 305, 191, 152, 192, 293, 309, 292, 182, 157, 381,
				287, 73, 162, 313, 366, 346, 47 }, 10); // 602
	}
}
