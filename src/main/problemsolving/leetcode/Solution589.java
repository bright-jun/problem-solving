package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.N_Ary_Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution589 {
    public List<Integer> preorder(N_Ary_Node root) {
        List<Integer> answer = new ArrayList<Integer>();

        if (root == null) {
            return answer;
        }

        N_Ary_Node now = root;
        LinkedList<N_Ary_Node> q = new LinkedList<N_Ary_Node>();
        q.add(now);
        while (q.size() > 0) {
            now = q.pollFirst();
            answer.add(now.val);
            if (now.children.size() > 0) {
                q.addAll(0, now.children);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution589 solution589 = new Solution589();
        List<Integer> answer;
        N_Ary_Node root;
        root = N_Ary_Node.generate(new Integer[]{1, null, 3, 2, 4, null, 5, 6});
        answer = solution589.preorder(root);
        root = N_Ary_Node.generate(new Integer[]{1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null,
                null, 11, null, 12, null, 13, null, null, 14});
        answer = solution589.preorder(root);
        return;
    }
}
