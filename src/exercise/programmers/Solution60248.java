package exercise.programmers;

public class Solution60248 {

	/*
	 * W, H <= 10^8
	 */
	public long gcd(long a, long b) {
		if (a >= b) {
			if (a % b == 0) {
				return b;
			} else {
				return gcd(a % b, b);
			}
		} else {
			return gcd(b, a);
		}
	}

	public long solution(int w, int h) {
		// prevent overflow
		long lw = (long) w;
		long lh = (long) h;
		return lw * lh - (lw + lh - gcd(lw, lh));
	}

	public static void main(String[] args) {
		Solution60248 solution60248 = new Solution60248();
		System.out.println(solution60248.solution(8, 12));
	}

}
