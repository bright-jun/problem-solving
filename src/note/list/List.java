package note.list;

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

		final long startAddAL = System.nanoTime();
		for (int i = 0; i < total; i++) {
			arrayList.add(i, i);
		}
		final long endAddAL = System.nanoTime();
		final long totalAddAL = endAddAL - startAddAL;

		final long startAddLL = System.nanoTime();
		for (int i = 0; i < total; i++) {
			linkedList.add(i, i);
		}
		final long endAddLL = System.nanoTime();
		final long totalAddLL = endAddLL - startAddLL;

		final long startRemoveAL = System.nanoTime();
		arrayList.remove(targetIndex);
		final long endRemoveAL = System.nanoTime();
		final long totalRemoveAL = endRemoveAL - startRemoveAL;

		final long startRemoveLL = System.nanoTime();
		linkedList.remove(targetIndex);
		final long endRemoveLL = System.nanoTime();
		final long totalRemoveLL = endRemoveLL - startRemoveLL;

		System.out.printf("ArrayList\tadd\t\tremove\n");
		System.out.printf("\t\t%s\t\t%s\n", totalAddAL, totalRemoveAL);

		System.out.printf("LinkedList\tadd\t\tremove\n");
		System.out.printf("\t\t%s\t\t%s\n", totalAddLL, totalRemoveLL);

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
