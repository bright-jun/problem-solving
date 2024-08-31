package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashMap {

	private final int MAX_VALUE = 1000000;
	private final int ARR_SIZE = 100;
	private List<List<int[]>> parentList;

	public MyHashMap() {
		parentList = new ArrayList<>(ARR_SIZE);
		for (int i = 0; i < ARR_SIZE; i++) {
			parentList.add(null);
		}
	}

	public void put(int key, int value) {
		int index = key % ARR_SIZE;
		List<int[]> childList = parentList.get(index);
		if (childList == null) {
			List<int[]> list = new LinkedList<>();
			list.add(new int[] { key, value });
			parentList.set(index, list);
		} else {
			if (!childList.stream().anyMatch(p -> p[0] == key)) {
				childList.add(new int[] { key, value });
			} else {
				// overwrite
				childList.stream()
					.filter(p -> p[0] == key)
					.findFirst()
					.ifPresent(p -> p[1] = value);
			}
		}
	}

	public int get(int key) {
		int index = key % ARR_SIZE;
		List<int[]> childList = parentList.get(index);
		if (childList != null) {
			// not normal key, Integer instance representing key
			int[] find = childList.stream()
				.filter(p -> p[0] == key)
				.findFirst()
				.orElse(new int [] {-1,-1});
			return find[1];
		}
		return -1;
	}

	public void remove(int key) {
		int index = key % ARR_SIZE;
		List<int[]> childList = parentList.get(index);
		if (childList != null) {
			childList.removeIf(p -> p[0] == key); // not normal key, Integer instance representing key
		}
	}
}

public class Solution706 {
	/*
	 * 0 <= key <= 10^6 At most 10^4 calls will be made to add, remove, and
	 * contains.
	 */
	public static void main(String[] args) {
		MyHashMap myHashMap = new MyHashMap();
		/*
		 * ["MyHashMap","put","put","get","get","put","get","remove","get"]
		 * [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
		 */
		myHashMap.put(1, 1);
		myHashMap.put(2, 2);
		System.out.println(myHashMap.get(1));
		System.out.println(myHashMap.get(3));
		myHashMap.put(2, 1);
		System.out.println(myHashMap.get(2));
		myHashMap.remove(2);
		System.out.println(myHashMap.get(2));
		return;
	}
}
