package problemsolving.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class Solution347 {
    /*
     * 1 <= nums.length <= 10^5 k is in the range [1, the number of unique elements
     * in the array]. It is guaranteed that the answer is unique.
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int num : nums) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }
        int[][] frequent = new int[hm.size()][2]; // {num, frequent}
        int idx = 0;
        for (int key : hm.keySet()) {
            frequent[idx++] = new int[]{key, hm.get(key)};
        }
        Arrays.sort(frequent, (o1, o2) -> o2[1] - o1[1]);

        int[] answer = new int[k];
        for (int i = 0; i < k; i++) {
            answer[i] = frequent[i][0];
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
//		Input: nums = [1,1,1,2,2,3], k = 2
//		Output: [1,2]
        System.out.println(Arrays.toString(solution347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
//		Input: nums = [1], k = 1
//		Output: [1]
        System.out.println(Arrays.toString(solution347.topKFrequent(new int[]{1}, 1)));
//		[4,1,-1,2,-1,2,3] 2
        System.out.println(Arrays.toString(solution347.topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }
}
