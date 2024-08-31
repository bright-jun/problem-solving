package problemsolving.codility;

public class Lesson1 {
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	public int solution(int N) {
		// write your code in Java SE 8
		String s = Integer.toBinaryString(N);
		char[] cArr = s.toCharArray();

		int binaryGap = 0;
		int tempBinaryGap = 0;
		int idx = 0;
		top:
		while (idx < cArr.length) {
			tempBinaryGap = 0;
			if (cArr[idx] == '1') {
				while (true) {
					idx++;
					if (idx >= cArr.length) {
						break top;
					}
					if (cArr[idx] == '0') {
						tempBinaryGap++;
					}
					if (cArr[idx] == '1') {
						binaryGap = Math.max(binaryGap, tempBinaryGap);
						break;
					}
				}
			}
		}

		return binaryGap;
	}

	public static void main(String[] args) {
		Lesson1 lesson1 = new Lesson1();
		System.out.println(lesson1.solution(15));
		System.out.println(lesson1.solution(32));
		System.out.println(lesson1.solution(1041));
	}
}
