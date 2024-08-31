package problemsolving.leetcode;

import java.util.HashMap;
import java.util.HashSet;

public class Solution904 {
    /*
     * 1 <= fruits.length <= 10^5
     * 0 <= fruits[i] < fruits.length
     */
    public int totalFruit(int[] fruits) {
        return totalFruit_2(fruits);
    }

    /*
     * Time: O(N^2)
     * Space: O(1)
     */
    public int totalFruit_1(int[] fruits) {
        int answer = 0;
        for (int i = 0; i < fruits.length; i++) {
            int tempAnswer = 0;
            HashSet<Integer> basket = new HashSet<Integer>();
            for (int j = i; j < fruits.length; j++) {
                if (basket.contains(fruits[j])) {
                    tempAnswer++;
                } else {
                    if (basket.size() < 2) {
                        basket.add(fruits[j]);
                        tempAnswer++;
                    } else {
                        break;
                    }
                }
            }
            answer = Math.max(answer, tempAnswer);
        }
        return answer;
    }

    /*
     * Time: O(N)
     * Space: O(1)
     */
    public int totalFruit_2(int[] fruits) {
        HashMap<Integer, Integer> basket = new HashMap<Integer, Integer>();
        int windowSize = 0;
        // [start, end]
        for (int start = 0; start + (windowSize - 1) < fruits.length; start++) {
            // remove
            if (start > 0) {
                basket.put(fruits[start - 1], basket.get(fruits[start - 1]) - 1);
                if (basket.get(fruits[start - 1]) == 0) {
                    basket.remove(fruits[start - 1]);
                }
            }
            for (int end = start + (windowSize - 1) + 1; end < fruits.length; end++) {
                if (basket.containsKey(fruits[end])) {
                    basket.put(fruits[end], basket.get(fruits[end]) + 1);
                } else {
                    basket.put(fruits[end], 1);
                }
                if (basket.keySet().size() > 2) {
                    break;
                }
                windowSize++;
            }
        }
        return windowSize;
    }

    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int answer;
        answer = solution904.totalFruit(new int[]{1, 2, 1});
        answer = solution904.totalFruit(new int[]{0, 1, 2, 2});
        answer = solution904.totalFruit(new int[]{1, 2, 3, 2, 2});
        answer = solution904.totalFruit(new int[]{3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4});
    }
}
