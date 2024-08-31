package problemsolving.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Solution881_TLE {
    /*
     * 1 <= people.length <= 5 * 10^4
     * 1 <= people[i] <= limit <= 3 * 10^4
     */
    public int numRescueBoats(int[] people, int limit) {

        // greedy : make minimum
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>(); // weight, count
        for (int peopleWeight : people) {
            hm.put(peopleWeight, hm.getOrDefault(peopleWeight, 0) + 1);
        }

        List<Integer> l = hm.keySet().stream().collect(Collectors.toList());
        l.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });

        int answer = 0;

        while (true) {
            int now;
            int left = limit;
            int onLeftCount = 2;
            for (int i = 0; i < l.size(); i++) {
                if (hm.get(l.get(i)) > 0) {
                    // unless one need, biggest one
                    now = l.get(i);
                    int leftCount = hm.get(now);
                    int divide = left / now;
                    // one ship max 2 person
                    int nowOnCount = Math.min(Math.min(leftCount, divide), onLeftCount);
                    if (nowOnCount == 0) {
                        // find biggest one among left weight
                    } else {
                        hm.put(now, hm.get(now) - nowOnCount);
                        if (hm.get(now) == 0) { // no more search this element
                            l.remove(i);
                            i--;
                        }
                        left -= now * nowOnCount;
                        if (left == 0) {
                            break;
                        }
                        onLeftCount -= nowOnCount;
                        if (onLeftCount == 0) {
                            break;
                        }
                    }
                }
            }
            // loop
            answer++;
            if (l.size() == 0) {
                // done
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution881_TLE solution881 = new Solution881_TLE();
        System.out.println(solution881.numRescueBoats(new int[]{1, 2}, 3)); // 1
        System.out.println(solution881.numRescueBoats(new int[]{3, 2, 2, 1}, 3)); // 3
        System.out.println(solution881.numRescueBoats(new int[]{3, 5, 3, 4}, 5)); // 4
        System.out.println(solution881.numRescueBoats(new int[]{3, 5, 1, 1, 2, 3, 4}, 5)); // 4
        System.out.println(solution881.numRescueBoats(new int[]{5, 1, 4, 2}, 6)); // 2, 3 is wrong - loop mistake
        System.out.println(solution881.numRescueBoats(new int[]{3, 2, 3, 2, 2}, 6)); // 3, 2 is wrong - one ship max 2 person
        System.out.println(solution881.numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)); // 11, 9 is wrong - one ship max & total 2 person
        System.out.println(solution881.numRescueBoats(new int[]{2, 49, 10, 7, 11, 41, 47, 2, 22, 6, 13, 12, 33, 18, 10, 26, 2, 6, 50, 10}, 50)); // TLE

    }
}
