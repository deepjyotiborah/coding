package com.deep.datastructure.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS_Traversal {
    int V;
    LinkedList<Integer> adj[];

    public BFS_Traversal(int n) {
        V = n;
        adj = new LinkedList[V];
        for (int i = 0; i < V ; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int s, int d) {
        adj[s].add(d);
    }

    public void BFS(int s) {
        boolean[] visited = new boolean[V];


        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;

        queue.add(s);
        while (queue.size() != 0) {
            Integer value = queue.poll();
            System.out.print(value + " ");
            Iterator<Integer> iterator = adj[value].iterator();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

    public static void main(String[] args) {
        BFS_Traversal bfs_traversal = new BFS_Traversal(4);
        bfs_traversal.addEdge(0, 1);
        bfs_traversal.addEdge(0, 2);
        bfs_traversal.addEdge(1, 2);
        bfs_traversal.addEdge(2, 0);
        bfs_traversal.addEdge(2, 3);
        bfs_traversal.addEdge(3, 3);

        bfs_traversal.BFS(2);

    }
}
