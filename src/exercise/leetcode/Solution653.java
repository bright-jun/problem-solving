package exercise.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import exercise.leetcode.datastructure.TreeNode;

public class Solution653 {
	public static boolean Answer;
	/*
	 * The number of nodes in the tree is in the range [1, 10^4].
	 * -10^4 <= Node.val <= 10^4
	 * root is guaranteed to be a valid binary search tree.
	 * -10^5 <= k <= 10^5
	 */
	public boolean findTarget(TreeNode root, int k) {
		List<Integer> list = new LinkedList<Integer>();
		// Improve using hashMap
		HashSet<Integer> hs = new HashSet<Integer>();
		Answer = false;
		// inorder search -> sort in O(N)
		search(root, list, hs, k);

		/*
		int head = 0;
		int tail = list.size() - 1;

		while (head < tail) {
			int sum = list.get(head) + list.get(tail);
			if (sum < k) {
				head++;
			}
			if (sum == k) {
				return true;
			}
			if (sum > k) {
				tail--;
			}
		}
		*/
		
		return Answer;
	}

	public void search(TreeNode now, List<Integer> list, HashSet<Integer> hs, int k) {
		if (Answer) {
			return;
		}

		if (now == null) {
			return;
		}
		// inorder search -> sort in O(N)
		search(now.left, list, hs, k);
		list.add(now.val);
		if (hs.contains(k - now.val)) {
			Answer = true;
			return;
		} else {
			hs.add(now.val);
		}
		search(now.right, list, hs, k);
	}

	public static void main(String[] args) {
		Solution653 solution653 = new Solution653();
		boolean answer;
		TreeNode root;
		root = TreeNode.generate(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
		answer = solution653.findTarget(root, 9);
		root = TreeNode.generate(new Integer[] { 5, 3, 6, 2, 4, null, 7 });
		answer = solution653.findTarget(root, 28);
		return;
	}
}
