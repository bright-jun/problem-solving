package problemsolving.leetcode.datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class N_Ary_Node {
	public int val;
	public List<N_Ary_Node> children;

	public N_Ary_Node() {
	}

	public N_Ary_Node(int _val) {
		val = _val;
	}

	public N_Ary_Node(int _val, List<N_Ary_Node> _children) {
		val = _val;
		children = _children;
	}

	/**
	 * Generate N_Ary_Node.
	 *
	 * Nary-Tree input serialization is represented in their level order traversal,
	 * each group of children is separated by the null value
	 * 
	 * @param elements the elements
	 * @return the tree node
	 * @author Myungjun Kim
	 */
	public static N_Ary_Node generate(Integer[] elements) {

		if (elements.length == 0) {
			return null;
		}

		Queue<List<Integer>> adjacencyLists = new LinkedList<List<Integer>>();
		List<Integer> adjacencyList = null;

		for (Integer element : elements) {
			if (element == null) {
				adjacencyLists.add(adjacencyList);
				adjacencyList = null;
			} else {
				if (adjacencyList == null) {
					adjacencyList = new ArrayList<Integer>();
				}
				adjacencyList.add(element);
			}
		}
		if (adjacencyList != null) {
			adjacencyLists.add(adjacencyList);
		}

		N_Ary_Node root = new N_Ary_Node();
		N_Ary_Node now;
		
		Queue<N_Ary_Node> childs = new LinkedList<N_Ary_Node>();
		childs.add(root);
		
		while(!childs.isEmpty() && !adjacencyLists.isEmpty()) {
			now = childs.poll();
			List<Integer> children = adjacencyLists.poll();
			if (children != null) {
				now.children = children.stream()
						.map(N_Ary_Node::integerToN_Ary_Node)
						.collect(Collectors.toList());
				childs.addAll(now.children);
			}
		}

		return root.children.get(0);
	}

	/**
	 * Integer to N_Ary_Node.
	 *
	 * @param element the element
	 * @return the tree node
	 * @author Myungjun Kim
	 */
	public static N_Ary_Node integerToN_Ary_Node(Integer element) {
		if (element == null) {
			return null;
		} else {
			return new N_Ary_Node(element, new ArrayList<N_Ary_Node>());
		}
	}

	public static void main(String[] args) {
		// test
		N_Ary_Node root;
		root = N_Ary_Node.generate(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		root = N_Ary_Node.generate(new Integer[] { 1, null, 2, 3, 4, 5, null, null, 6, 7, null, 8, null, 9, 10, null,
				null, 11, null, 12, null, 13, null, null, 14 });
		return;
	}
}
