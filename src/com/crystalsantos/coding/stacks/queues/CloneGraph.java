package com.crystalsantos.coding.stacks.queues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	HashMap<Node, Node> map = new HashMap<>();

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		if (node != null && node.neighbors.size() == 0) {
			return new Node(node.val);
		}

		map.put(node, new Node(node.val, new ArrayList<>()));

		for (Node neighbor : node.neighbors) {
			if (map.containsKey(neighbor)) {
				map.get(node).neighbors.add(map.get(neighbor));
			} else {
				map.get(node).neighbors.add(cloneGraph(neighbor));
			}
		}

		return map.get(node);
	}

	private void run() {
		Node node1 = new Node(1);
		cloneGraph(node1);
	}

	public static void main(String[] args) {
		new CloneGraph().run();
	}

}
