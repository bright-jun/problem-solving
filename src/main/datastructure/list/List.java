package datastructure.list;

import java.util.ArrayList;
import java.util.LinkedList;

public class List {
    // ref https://www.youtube.com/watch?v=5dscMs2hnDI

    // which is faster
    // Add		First	: ArrayList << LinkedList
    // Add		Last	: ArrayList >> LinkedList - need time to reach last index
    // Remove 	First	: ArrayList << LinkedList
    // Remove 	Last	: ArrayList =< LinkedList - need time to reach last index && structural benefit
    public static void test(int total, int targetIndex) {
        System.out.printf("total : %d, targetIndex : %d\n", total, targetIndex);

        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        final long startAddStartAL = System.nanoTime();
        for (int i = 0; i < total; i++) {
            arrayList.add(0, i);
        }
        final long endAddStartAL = System.nanoTime();
        final long totalAddStartAL = endAddStartAL - startAddStartAL;

        final long startAddStartLL = System.nanoTime();
        for (int i = 0; i < total; i++) {
            linkedList.add(0, i);
        }
        final long endAddStartLL = System.nanoTime();
        final long totalAddStartLL = endAddStartLL - startAddStartLL;

        final long startAddEndAL = System.nanoTime();
        for (int i = 0; i < total; i++) {
            arrayList.add(i, i);
        }
        final long endAddEndAL = System.nanoTime();
        final long totalAddEndAL = endAddEndAL - startAddEndAL;

        final long startAddEndLL = System.nanoTime();
        for (int i = 0; i < total; i++) {
            linkedList.add(i, i);
        }
        final long endAddEndLL = System.nanoTime();
        final long totalAddEndLL = endAddEndLL - startAddEndLL;

        final long startRemoveAL = System.nanoTime();
        arrayList.remove(targetIndex);
        final long endRemoveAL = System.nanoTime();
        final long totalRemoveAL = endRemoveAL - startRemoveAL;

        final long startRemoveLL = System.nanoTime();
        linkedList.remove(targetIndex);
        final long endRemoveLL = System.nanoTime();
        final long totalRemoveLL = endRemoveLL - startRemoveLL;

        System.out.printf("ArrayList\taddStart\t\taddEnd\t\tremove\n");
        System.out.printf("\t\t%s\t\t%s\t\t%s\n", totalAddStartAL, totalAddEndAL, totalRemoveAL);

        System.out.printf("LinkedList\taddStart\t\taddEnd\t\tremove\n");
        System.out.printf("\t\t%s\t\t%s\t\t%s\n", totalAddStartLL, totalAddEndLL, totalRemoveLL);

    }

    public static void main(String[] args) {
        test(1000, 1);
        test(1000, 999);
        test(10000, 1);
        test(10000, 9999);
        test(100000, 1);
        test(100000, 99999);
        test(1000000, 1);
        test(1000000, 999999);
        test(10000000, 1);
        test(10000000, 9999999);
    }
}
