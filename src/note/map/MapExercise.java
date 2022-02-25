package note.map;

import java.util.HashMap;
import java.util.Map;

public class MapExercise {
	public static void main(String[] args) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		hashMap.compute(0, (key, val) -> 0);
		hashMap.computeIfAbsent(1, (key) -> 1);
		hashMap.computeIfPresent(2, (key, val) -> 2);
		
		return;
	}
}
