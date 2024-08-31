package problemsolving.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution989 {
    /*
     * 1 <= num.length <= 10^4
     * 0 <= num[i] <= 9
     * num does not contain any leading zeros except for the zero itself.
     * 1 <= k <= 10^4
     */
    public List<Integer> addToArrayForm(int[] num, int k) {
        return addToArrayForm_sol1(num, k);
    }

    /*
     * Time: O(N)
     * Space: O(1)
     */
    public List<Integer> addToArrayForm_sol1(int[] num, int k) {
        List<Integer> answer = new LinkedList<Integer>();
        int nLen = num.length;

        int carry = k;
        int sum;
        int i = 0;
        while (nLen - 1 - i >= 0 || carry > 0) {
            if (nLen - 1 - i >= 0) {
                sum = num[nLen - 1 - i] + carry;
            } else {
                sum = carry;
            }
            carry = sum / 10;
            answer.add(0, sum % 10);
            i++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution989 solution989 = new Solution989();
        List<Integer> answer;
        answer = solution989.addToArrayForm(new int[]{1, 2, 0, 0}, 34);
        answer = solution989.addToArrayForm(new int[]{2, 7, 4}, 181);
        answer = solution989.addToArrayForm(new int[]{2, 1, 5}, 806);
        // digits of num < digits of k
        answer = solution989.addToArrayForm(new int[]{0}, 10000);
    }
}
