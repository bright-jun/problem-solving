package problemsolving.leetcode;

public class Solution36 {
    /**
     * 1. Each row must contain the digits 1-9 without repetition.
     * 2. Each column must contain the digits 1-9 without repetition.
     * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     * Note:
     * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
     * Only the filled cells need to be validated according to the mentioned rules.
     */
    public boolean isValidSudoku(char[][] board) {
        return isValidSudoku_0(board);
    }

    /**
     * Time: O(27)
     * Space: O(1)
     */
    public boolean isValidSudoku_0(char[][] board) {
        boolean[] numbers;
        // check horizontal
        for (int r = 0; r < 9; r++) {
            numbers = new boolean[10]; // 1~9
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int now = board[r][c] - '0';
                    if (!numbers[now]) {
                        numbers[now] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // check vertical
        for (int c = 0; c < 9; c++) {
            numbers = new boolean[10]; // 1~9
            for (int r = 0; r < 9; r++) {
                if (board[r][c] != '.') {
                    int now = board[r][c] - '0';
                    if (!numbers[now]) {
                        numbers[now] = true;
                    } else {
                        return false;
                    }
                }
            }
        }

        // check square
        // 0,0 ~ 2,2 // 0,3 ~ 2,5 // 0,6 ~ 2,8
        // 3,0 ~ 5,2 // 3,3 ~ 5,5 // 3,6 ~ 5,8
        // 6,0 ~ 8,2 // 6,3 ~ 8,5 // 6,6 ~ 8,8
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                numbers = new boolean[10]; // 1~9
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (board[r * 3 + i][c * 3 + j] != '.') {
                            int now = board[r * 3 + i][c * 3 + j] - '0';
                            if (!numbers[now]) {
                                numbers[now] = true;
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        boolean answer;
        char[][] board;
        board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        answer = solution36.isValidSudoku(board);
        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        answer = solution36.isValidSudoku(board);
    }
}
