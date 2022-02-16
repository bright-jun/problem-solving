package note.sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortExercise {
	public static void main(String[] args) {
		// int -> List
		int[] nums1= new int[] {1,2};
		List<Integer> numList1 = Arrays.stream(nums1).boxed().collect(Collectors.toList());
		numList1.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		});
	}
}
