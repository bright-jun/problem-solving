package problemsolving.programmers;

public class Solution92344 {
    /*
     * https://tech.kakao.com/2022/01/14/2022-kakao-recruitment-round-1/
     * 누적합
     * row, col 반복문 value 다름
     * 값 할당이 아니라 +=로 반영해줘야함
     */
    public int solution(int[][] board, int[][] skill) {
        int[][] skillBoard = new int[board.length + 1][board[0].length + 1];

        for (int[] skillInfo : skill) {
//			skillInfo[0]; // type
//			skillInfo[1]; // s_row
//			skillInfo[2]; // s_col
//			skillInfo[3]; // e_row
//			skillInfo[4]; // e_col
//			skillInfo[5]; // degree
            int value;
            if (skillInfo[0] == 1) {
                value = -skillInfo[5];
            } else {
                value = skillInfo[5];
            }
            skillBoard[skillInfo[1]][skillInfo[2]] += value;
            skillBoard[skillInfo[3] + 1][skillInfo[2]] += -value;
            skillBoard[skillInfo[1]][skillInfo[4] + 1] += -value;
            skillBoard[skillInfo[3] + 1][skillInfo[4] + 1] += value;
        }

        int debug = 1;

        // 누적 합
//		for (int i = 0; i < skillBoard.length; i++) {
//			for (int j = 0; j < skillBoard.length; j++) {
//				int up = 0;
//				int left = 0;
//				int upLeft = 0;
//				if (i - 1 >= 0) {
//					up = skillBoard[i - 1][j];
//				}
//				if (j - 1 >= 0) {
//					left = skillBoard[i][j - 1];
//				}
//				if (i - 1 >= 0 && j - 1 >= 0) {
//					upLeft = skillBoard[i - 1][j - 1];
//				}
//				skillBoard[i][j] += up + left - upLeft;
//			}
//		}
        // horizontal
        for (int i = 0; i < skillBoard.length; i++) {
            for (int j = 0; j < skillBoard[0].length; j++) {
                int left = 0;
                if (j - 1 >= 0) {
                    left = skillBoard[i][j - 1];
                }
                skillBoard[i][j] += left;
            }
        }
        // vertical
        for (int i = 0; i < skillBoard.length; i++) {
            for (int j = 0; j < skillBoard[0].length; j++) {
                int up = 0;
                if (i - 1 >= 0) {
                    up = skillBoard[i - 1][j];
                }
                skillBoard[i][j] += up;
            }
        }

        int answer = 0;
        // board + skillBoard check
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] + skillBoard[i][j] >= 1) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution92344 solution92344 = new Solution92344();
//		[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]
//		[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]
//		10
        System.out.println(solution92344.solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}}));
//		[[1,2,3],[4,5,6],[7,8,9]]
//		[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]
//		6
        System.out.println(solution92344.solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}}));
    }
}
