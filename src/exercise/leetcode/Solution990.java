package exercise.leetcode;

public class Solution990 {
	/*
	 * 1 <= equations.length <= 500
	 * equations[i].length == 4
	 * equations[i][0] is a lowercase letter.
	 * equations[i][1] is either '=' or '!'.
	 * equations[i][2] is '='.
	 * equations[i][3] is a lowercase letter.
	 */
	public boolean equationsPossible(String[] equations) {
		Parent = new int['z' - 'a' + 1];
		for (int i = 0; i < Parent.length; i++) {
			Parent[i] = -1; // root
		}
		// union linked node
		for (String equation : equations) {
			char[] eq = equation.toCharArray();
			int left = eq[0] - 'a';
			int right = eq[3] - 'a';

			if (eq[1] == '=') {
				union(left, right);
			}
		}

		// check unlinked union
		for (String equation : equations) {
			char[] eq = equation.toCharArray();
			int left = eq[0] - 'a';
			int right = eq[3] - 'a';

			if (eq[1] == '!') {
				// if they are same union
				int leftRoot = getParent(left);
				int rightRoot = getParent(right);
				if (leftRoot == rightRoot) {
					return false;
				}
			}
		}
		return true;
	}

	public static int[] Parent;

	public int getParent(int target) {
		if (Parent[target] < 0) {
			return target;
		} else {
			Parent[target] = getParent(Parent[target]);
			return Parent[target];
		}
	}

	public void union(int target1, int target2) {
		int root1 = getParent(target1);
		int root2 = getParent(target2);
		// edge case, same target or same union
		if (root1 == root2) {
			return;
		}
		// root1 <-consume- root2
		Parent[root2] = root1;
	}

	public static void main(String[] args) {
		Solution990 solution990 = new Solution990();
		boolean answer;
		answer = solution990.equationsPossible(new String[] { "a==b", "b!=a" });
		answer = solution990.equationsPossible(new String[] { "b==a", "a==b" });
		// need to check unsigned value
		answer = solution990.equationsPossible(new String[] { "a==b", "b!=c", "c==a" });
		// stack overflow
		answer = solution990.equationsPossible(new String[] { "c==c", "b==d", "x!=z" });
		// ignore true equation, don't need to sign
		answer = solution990.equationsPossible(new String[] { "c==c", "f!=a", "f==b", "b==c" });
		// if both unsigned, don't need to sign
		answer = solution990.equationsPossible(new String[] { "e==d", "e==a", "f!=d", "b!=c", "a==b" }); // true
		// edge case, same target or same union
		answer = solution990.equationsPossible(new String[] { "f==b", "c==b", "c==b", "e!=f" }); // true
		
		return;
	}
}
