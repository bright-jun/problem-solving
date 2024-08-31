package problemsolving.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003 {
	/*
	 * two pointer
	 */
	/*
	 * 1<= A[x] <= 30,000 N(1 ≤ N ≤ 10,000) M(1 ≤ M ≤ 300,000,000)
	 */

	public static void main(String[] args) throws IOException {
//		System.setIn(new FileInputStream("res/Baekjoon/2003.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] nums = new int[n]; // weight, value

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int start = 0;
		int end = 0;

		int answer = 0;

		int sum = nums[0];
		// nums[end] - nums[start] : sum[start,end)
		while (true) {
			if (sum < m) {
				end++;
				if (end == nums.length) { // no more answer
					break;
				}
				sum += nums[end];
			} else if (sum == m) {
				answer++;
				sum -= nums[start];
				start++;
			} else {
				sum -= nums[start];
				start++;
			}
		}

		System.out.println(answer);
	}
}
