package problemsolving.programmers;

public class Solution1845 {

    /*
     * nums�� ���ϸ��� ���� ��ȣ�� ��� 1���� �迭�Դϴ�.
     * nums�� ����(N)�� 1 �̻� 10,000 ������ �ڿ����̸�, �׻� ¦���� �־����ϴ�.
     * ���ϸ��� ���� ��ȣ�� 1 �̻� 200,000 ������ �ڿ����� ��Ÿ���ϴ�.
     * ���� ���� ������ ���ϸ��� �����ϴ� ����� ���� ������ ��쿡��, ������ �� �ִ� ���ϸ� ���� ������ �ִ� �ϳ��� return �ϸ� �˴ϴ�.
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
        answer = solution1845.solution(new int[]{3, 1, 2, 3});
        answer = solution1845.solution(new int[]{3, 3, 3, 2, 2, 4});
        answer = solution1845.solution(new int[]{3, 3, 3, 2, 2, 2});
    }
}
