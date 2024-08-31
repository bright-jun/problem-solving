package problemsolving.leetcode;

public class Solution991 {
	// solution 
	// https://leetcode.com/problems/broken-calculator/discuss/1874813/JavaC%2B%2B-Recursive-and-Iterative-Solution
	/*
	public int brokenCalc(int startValue, int target) {
		int step = 0;
		while (target > startValue) {
			// if can multiply always multiply is best
			if (target % 2 == 0) {
				target /= 2;
			}
			// else subtract
			else {
				target++;
			}
			step++;
		}
		int subtractCnt = startValue - target; 
		return step + subtractCnt;
	}
	*/

	public int brokenCalc(int startValue, int target) {
		return -1;
	}
	public static void main(String[] args) {
		Solution991 solution991 = new Solution991();
		System.out.println(solution991.brokenCalc(2, 3));
		System.out.println(solution991.brokenCalc(5, 8));
		System.out.println(solution991.brokenCalc(3, 10));
		System.out.println(solution991.brokenCalc(3, 10000000));
	}
}
