package exercise.leetcode;

class LRUCache {

	private int capacity;

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
		return key;
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

	}

	/*
	 * Least Recently Used (LRU) cache.
	 * 1 <= capacity <= 3000
	 * 0 <= key <= 10^4
	 * 0 <= value <= 10^5
	 * At most 2 * 10^5 calls will be made to get and put.
	 */
	public static void main(String[] args) {

		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		lRUCache.get(1); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		lRUCache.get(2); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		lRUCache.get(1); // return -1 (not found)
		lRUCache.get(3); // return 3
		lRUCache.get(4); // return 4
	}
}
