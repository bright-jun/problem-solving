package datastructure.list;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4, 5}, 3));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4, 5}, 5));
        System.out.println(Arrays.binarySearch(new int[]{1, 2, 3, 4, 5}, -1));
    }
}
