package com.crystalsantos.coding.basic;

import java.util.Iterator;
import java.util.LinkedList;

// Time Complexity: O(V+E) where V is number of vertices in 
// the graph and E is number of edges in the graph.

//This class represents a directed graph using adjacency list
//representation
public class BreadthFirstSearch {

	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; // Adjacency Lists

	BreadthFirstSearch(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<Integer>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {
		boolean visited[] = new boolean[V];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			// Dequeue a vertex from queue and print it
			s = queue.poll();
			System.out.print(s + " ");

			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	public static void main(String args[]) {
		BreadthFirstSearch g = new BreadthFirstSearch(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}
}