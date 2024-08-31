package problemsolving.leetcode;

import problemsolving.leetcode.datastructure.Node;

import java.util.*;

public class Solution133 {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, HashSet<Integer>> adjMap = new HashMap<Integer, HashSet<Integer>>();

        // make adj list(map)

        // BFS
        boolean[] visited = new boolean[101];
        Deque<Node> q = new LinkedList<Node>();
        q.add(node);

        while (q.size() > 0) {
            Node nowNode = q.pop();
            visited[nowNode.val] = true;
            adjMap.put(nowNode.val, new HashSet<Integer>());
            for (Node neighborNode : nowNode.neighbors) {
                adjMap.get(nowNode.val).add(neighborNode.val);
                if (!visited[neighborNode.val]) {
                    q.add(neighborNode);
                }
            }
        }

        // make graph by adj list(map)
        Node[] nodeList = new Node[101];
        for (int adjMapKey : adjMap.keySet()) {
            nodeList[adjMapKey] = new Node(adjMapKey);
        }
        for (int adjMapKey : adjMap.keySet()) {
            for (int adjNodeVal : adjMap.get(adjMapKey)) {
                nodeList[adjMapKey].neighbors.add(nodeList[adjNodeVal]);
            }
        }

        return nodeList[1];
    }

    public static void main(String[] args) {
        Solution133 solution133 = new Solution133();
        // adjList = []
        Node node = new Node();
        System.out.println(solution133.cloneGraph(node));
        // adjList = [[]]
        node.val = 1;
        node.neighbors = new ArrayList<Node>();
        System.out.println(solution133.cloneGraph(node));
        // adjList = [[2,4],[1,3],[2,4],[1,3]]
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);
        System.out.println(solution133.cloneGraph(node1));
    }
}
