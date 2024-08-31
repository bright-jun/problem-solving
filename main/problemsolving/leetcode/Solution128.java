package problemsolving.leetcode;

import java.util.HashMap;

public class Solution128 {

    /*
     * 0 <= nums.length <= 10^5
     * -10^9 <= nums[i] <= 10^9
     * You must write an algorithm that runs in O(n) time.
     */
    public int longestConsecutive(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        int answer = Integer.MIN_VALUE;

        // how to present (start~end)
        // now, parent (Union)
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

        for (int num : nums) {
            hm.computeIfAbsent(num, (key) -> key);

            // num - 1 -> num
            if (hm.containsKey(num - 1)) {
                hm.put(num - 1, hm.get(num));
            }
            // num -> num + 1
            if (hm.containsKey(num + 1)) {
                hm.put(num, hm.get(num + 1));
            }
        }

        for (int key : hm.keySet()) {

            answer = Math.max(answer, getParent(hm, key) - key);
        }

        return answer + 1;
    }

    public int getParent(HashMap<Integer, Integer> hm, int now) {
        if (hm.get(now) == now) {
            return now;
        } else {
            int parent = getParent(hm, hm.get(now));
            hm.put(now, parent);
            return hm.get(now);
        }
    }

    public static void main(String[] args) {
        Solution128 solution128 = new Solution128();
        int answer;
        answer = solution128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        answer = solution128.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});

        return;
    }
}
