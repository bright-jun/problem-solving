package problemsolving.programmers;

public class Solution42885 {
    public int solution(int[] people, int limit) {

        int[] weight = new int[241]; // 40 ~ 240

        for (int p : people) {
            weight[p]++;
        }

        int totalPeople = people.length;
        int answer = 0;
        int boatPeopleCnt = 0;
        int boatWeight = limit;
        top:
        while (totalPeople > 0) {

            for (int i = 240; i >= 40; i--) {
                if (weight[i] > 0) {
                    if (i <= boatWeight) {
                        // ride
                        totalPeople--;
                        weight[i]--;

                        if (boatPeopleCnt == 0) {
                            // new boat
                            answer++;
                            boatPeopleCnt++;
                            boatWeight = boatWeight - i;
                        } else if (boatPeopleCnt == 1) {
                            // need new boat
                            boatPeopleCnt = 0;
                            boatWeight = limit;
                        }

                        continue top;
                    }
                }
            }
            // need new boat
            boatPeopleCnt = 0;
            boatWeight = limit;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution42885 solution42885 = new Solution42885();
        int answer;
        answer = solution42885.solution(new int[]{70, 50, 80, 50}, 100);
        answer = solution42885.solution(new int[]{70, 80, 50}, 100);

        return;
    }
}
