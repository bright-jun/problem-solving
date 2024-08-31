package problemsolving.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class MyHashSet {

    private final int MAX_VALUE = 1000000;
    private final int ARR_SIZE = 100;
    private List<List<Integer>> parentList;

    public MyHashSet() {
        parentList = new ArrayList<>(ARR_SIZE);
        for (int i = 0; i < ARR_SIZE; i++) {
            parentList.add(null);
        }
    }

    public void add(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList == null) {
            List<Integer> list = new LinkedList<>();
            list.add(key);
            parentList.set(index, list);
        } else {
            if (!childList.contains(key)) {
                childList.add(key);
            }
        }
    }

    public void remove(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = parentList.get(index);
        if (childList != null) {
            childList.remove(Integer.valueOf(key)); // not normal key, Integer instance representing key
        }
    }

    public boolean contains(int key) {
        int index = key % ARR_SIZE;
        List<Integer> childList = parentList.get(index);
        return childList != null && childList.contains(key);
    }
}

public class Solution705 {
    /*
     * 0 <= key <= 10^6 At most 10^4 calls will be made to add, remove, and
     * contains.
     */
    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.add(4);
        myHashSet.add(5);
        System.out.println(myHashSet.contains(1));
        myHashSet.remove(1);
        System.out.println(myHashSet.contains(1));
        return;
    }
}
