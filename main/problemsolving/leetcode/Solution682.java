package problemsolving.leetcode;

import java.util.ArrayList;

public class Solution682 {
	/*
	 * ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
	 */
	public int calPoints(String[] ops) {
//		An integer x - Record a new score of x.
//		"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
//		"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
//		"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
		ArrayList<Integer> al = new ArrayList<Integer>();
		int alSize;
		for (String op : ops) {
			alSize = al.size();
			switch (op) {
			case "+":
				int sumScore = al.get(alSize - 1) + al.get(alSize - 2);
				al.add(sumScore);
				break;
			case "D":
				int doubleScore = 2 * al.get(alSize - 1);
				al.add(doubleScore);
				break;
			case "C":
				al.remove(alSize - 1);
				break;
			default:
				al.add(Integer.parseInt(op));
				break;
			}
		}

		int answer = 0;
		for (int num : al) {
			answer += num;
		}

		return answer;
	}

	public static void main(String[] args) {
		Solution682 solution682 = new Solution682();
//		Input: ops = ["5","2","C","D","+"]
//		Output: 30
		System.out.println(solution682.calPoints(new String[] {"5","2","C","D","+"}));
//		Input: ops = ["5","-2","4","C","D","9","+","+"]
//		Output: 27
		System.out.println(solution682.calPoints(new String[] {"5","-2","4","C","D","9","+","+"}));
	}
}
