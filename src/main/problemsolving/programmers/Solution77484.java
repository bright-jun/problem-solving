package problemsolving.programmers;

public class Solution77484 {

    public int[] solution(int[] lottos, int[] win_nums) {
        // use Array instead of HashSet
        int[] lottoArr = new int[46];

        for (int win_num : win_nums) {
            lottoArr[win_num]++;
        }

        int zero = 0;
        int win = 0;

        for (int lotto : lottos) {
            if (lotto == 0) {
                zero++;
            }
            if (lottoArr[lotto] == 1) {
                win++;
            }
        }
        return new int[]{getGrade(win + zero), getGrade(win)};
    }

    public int getGrade(int winCnt) {
        switch (winCnt) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            case 1:
                return 6;
            default:
                return 6;
        }
    }

    public static void main(String[] args) {
        Solution77484 solution77484 = new Solution77484();
        int[] answer;
        // [3, 5]
        answer = solution77484.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        // [1, 6]
        answer = solution77484.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25});
        // [1, 1]
        answer = solution77484.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35});

        return;
    }
}
