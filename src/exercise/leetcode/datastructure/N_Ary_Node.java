package exercise.leetcode.datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

		List<List<Integer>> adjacencyLists = new ArrayList<List<Integer>>();
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

		List<N_Ary_Node> n_Ary_Nodes = new LinkedList<N_Ary_Node>();
		for (Integer element : elements) {
			if(element == null) {
				continue;
			}
			N_Ary_Node n_ary_Node = integerToN_Ary_Node(element);
			n_Ary_Nodes.add(n_ary_Node);
		}

		// FIXME 1 depth only valid
		// N_Ary_Node.generate(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		for (int i = 1; i < adjacencyLists.size(); i++) {
			List<N_Ary_Node> adjacencyN_Ary_NodeList = adjacencyLists.get(i).stream()
					.map(N_Ary_Node::integerToN_Ary_Node)
					.collect(Collectors.toList());
			n_Ary_Nodes.get(i).children.addAll(adjacencyN_Ary_NodeList);
		}

		return n_Ary_Nodes.get(1);
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
		N_Ary_Node root = N_Ary_Node.generate(new Integer[] { 1, null, 3, 2, 4, null, 5, 6 });
		return;
	}
}
