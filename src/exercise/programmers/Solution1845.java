package exercise.programmers;

public class Solution1845 {
	
	/*
	 * nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
	 * nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
	 * 폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
	 * 가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.
	 */
	public int solution(int[] nums) {
		// use Array instead of HashSet
		int[] pNum = new int[200001];

		int answer = 0;

		for (int num : nums) {
			if (++pNum[num] == 1) {
				answer++;
			}
		}
		return Math.min(answer, nums.length / 2);
	}

	public static void main(String[] args) {
		Solution1845 solution1845 = new Solution1845();
		int answer;
		answer = solution1845.solution(new int[] { 3, 1, 2, 3 });
		answer = solution1845.solution(new int[] { 3, 3, 3, 2, 2, 4 });
		answer = solution1845.solution(new int[] { 3, 3, 3, 2, 2, 2 });
	}
}
