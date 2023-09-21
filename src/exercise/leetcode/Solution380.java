package exercise.leetcode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Solution380 {
    /**
     * -2^31 <= val <= 2^31 - 1
     * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.
     * There will be at least one element in the data structure when getRandom is called.
     */
    static class RandomizedSet_1 {
        /**
         * Space: O(N)
         */
        private final Set<Integer> hashSet;

        public RandomizedSet_1() {
            hashSet = new HashSet<>();
        }

        /**
         * Time: O(1)
         */
        public boolean insert(int val) {
            if (hashSet.contains(val)) {
                return false;
            }
            hashSet.add(val);
            return true;
        }

        /**
         * Time: O(1)
         */
        public boolean remove(int val) {
            if (!hashSet.contains(val)) {
                return false;
            }
            hashSet.remove(val);
            return true;
        }

        /**
         * Time: O(N)
         */
        public int getRandom() {
            Random random = new Random();
            int n = hashSet.size();
            Iterator<Integer> iterator = hashSet.iterator();
            int k = ((random.nextInt() % n) + n) % n;
            for (int i = 0; i < k; i++) {
                iterator.next();
            }

            return iterator.next();
        }
    }

    public static void main(String[] args) {
        RandomizedSet_1 randomizedSet_1 = new RandomizedSet_1();
        int intAnswer;
        boolean booleanAnswer;
        booleanAnswer = randomizedSet_1.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        booleanAnswer = randomizedSet_1.remove(2); // Returns false as 2 does not exist in the set.
        booleanAnswer = randomizedSet_1.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        intAnswer = randomizedSet_1.getRandom(); // getRandom() should return either 1 or 2 randomly.
        booleanAnswer = randomizedSet_1.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        booleanAnswer = randomizedSet_1.insert(2); // 2 was already in the set, so return false.
        intAnswer = randomizedSet_1.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

}
