package exercise.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
         * Time: O(N) ... TLE
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

    static class RandomizedSet_2 {
        /**
         * Space: O(N)
         */
        private final Map<Integer, Integer> hashMap;
        private final List<Integer> arrayList;
        private final Random random = new Random();

        public RandomizedSet_2() {
            hashMap = new HashMap<>();
            arrayList = new ArrayList<>();
        }

        /**
         * Time: O(1)
         */
        public boolean insert(int val) {
            if (hashMap.containsKey(val)) {
                return false;
            }
            hashMap.put(val, arrayList.size());
            arrayList.add(val);
            return true;
        }

        /**
         * Time: O(1)
         */
        public boolean remove(int val) {
            if (!hashMap.containsKey(val)) {
                return false;
            }

            int idx = hashMap.get(val);
            int lastIdx = arrayList.size() - 1;
            if (idx < lastIdx) {
                // alter last value -> target value
                int lastVal = arrayList.get(lastIdx);
                arrayList.set(idx, lastVal);
                arrayList.remove(lastIdx);
                hashMap.put(lastVal, idx);
                hashMap.remove(val);
            } else {
                // pop last
                arrayList.remove(lastIdx);
                hashMap.remove(val);
            }

            return true;
        }

        /**
         * Time: O(1)
         */
        public int getRandom() {
            int n = arrayList.size();
            int k = ((random.nextInt() % n) + n) % n;

            return arrayList.get(k);
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

        RandomizedSet_2 randomizedSet_2 = new RandomizedSet_2();
        booleanAnswer = randomizedSet_2.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        booleanAnswer = randomizedSet_2.remove(2); // Returns false as 2 does not exist in the set.
        booleanAnswer = randomizedSet_2.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
        intAnswer = randomizedSet_2.getRandom(); // getRandom() should return either 1 or 2 randomly.
        booleanAnswer = randomizedSet_2.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
        booleanAnswer = randomizedSet_2.insert(2); // 2 was already in the set, so return false.
        intAnswer = randomizedSet_2.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

}
