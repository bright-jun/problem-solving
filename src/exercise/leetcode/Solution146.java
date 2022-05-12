package exercise.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class LRUCache {

	private int capacity;
	private Map<Integer, Integer> map = new HashMap<Integer, Integer>();
	private Queue<Integer> queue = new LinkedList<Integer>();

	public LRUCache(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * int get(int key) Return the value of the key if the key exists, otherwise
	 * return -1.
	 * 
	 * @param key
	 * @return
	 */
	public int get(int key) {
		if (queue.contains(key)) {
			// update
			queue.remove(key);
			queue.add(key);
			return map.get(key);
		} else {
			return -1;
		}
	}

	/**
	 * void put(int key, int value) Update the value of the key if the key exists.
	 * Otherwise, add the key-value pair to the cache. If the number of keys exceeds
	 * the capacity from this operation, evict the least recently used key.
	 * 
	 * @param key
	 * @param value
	 */
	public void put(int key, int value) {
		if(!map.containsKey(key)) {
			queue.add(key);
		} else {
			// update
			queue.remove(key);
			queue.add(key);
		}
		map.put(key, value);
		if (map.size() > capacity) {
			int poll = queue.poll();
			map.remove(poll);
		}
	}
}

public class Solution146 {

	/*
	 * Least Recently Used (LRU) cache. 1 <= capacity <= 3000 0 <= key <= 10^4 0 <=
	 * value <= 10^5 At most 2 * 10^5 calls will be made to get and put.
	 */
	public static void main(String[] args) {

		LRUCache lRUCache = new LRUCache(2);
//		lRUCache.put(1, 1); // cache is {1=1}
//		lRUCache.put(2, 2); // cache is {1=1, 2=2}
//		lRUCache.get(1); // return 1
//		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//		lRUCache.get(2); // returns -1 (not found)
//		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//		lRUCache.get(1); // return -1 (not found)
//		lRUCache.get(3); // return 3
//		lRUCache.get(4); // return 4

		// when put same key, avoid duplicate queue 
//		["LRUCache","put","put","get","put","put","get"]
//		[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
//		lRUCache = new LRUCache(2);
//		lRUCache.put(2, 1); // cache is {2=1}
//		lRUCache.put(2, 2); // cache is {2=2}
//		lRUCache.get(2); // return 2
//		lRUCache.put(1, 1); // cache is {1=1, 2=2}
//		lRUCache.put(4, 1); // LRU key was 2, evicts key 2, cache is {1=1, 4=1}
//		lRUCache.get(2); // returns -1 (not found)
		
		// update when put 
//		["LRUCache","put","put","put","put","get","get"]
//		[[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
//		lRUCache = new LRUCache(2);
//		lRUCache.put(2, 1); // cache is {2=1}
//		lRUCache.put(1, 1); // cache is {1=1,2=1}
//		lRUCache.put(2, 3); // cache is {1=1,2=3}
//		lRUCache.put(4, 1); // LRU key was 1, evicts key 1, cache is {2=3,4=1}
//		lRUCache.get(1); // returns -1 (not found)
//		lRUCache.get(2); // returns 3
		
		// update with value, not index
//		["LRUCache","put","put","get","get","put","get","get","get"]
//		[[2],[2,1],[3,2],[3],[2],[4,3],[2],[3],[4]]
//		lRUCache = new LRUCache(2);
//		lRUCache.put(2, 1); // cache is {2=1}
//		lRUCache.put(3, 2); // cache is {2=1,3=2}
//		lRUCache.get(3); // returns 2
//		lRUCache.get(2); // returns 1
//		lRUCache.put(4, 3); // LRU key was 3, evicts key 3, cache is {2=1,4=3}
//		lRUCache.get(2); // returns 1
//		lRUCache.get(3); // returns -1
//		lRUCache.get(4); // returns 3
		
		// TLE
		
	}
}