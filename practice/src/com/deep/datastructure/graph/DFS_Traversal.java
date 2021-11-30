package com.deep.datastructure.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class DFS_Traversal {
    int V;
    LinkedList<Integer> adj[];

    public DFS_Traversal(int n) {
        V = n;
        adj = new  LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int d) {
        adj[s].add(d);
    }

    private void DFS(int  n, boolean[] visited) {
        visited[n] = true;
        System.out.print(n + " ");

        Iterator<Integer> iterator = adj[n].iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if(!visited[next]) {
                DFS(next, visited);
            }
        }
    }

    public void getDfs() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i])
                DFS(i, visited);
        }
    }
    public static void main(String[] args) {
        DFS_Traversal dfs_traversal = new DFS_Traversal(4);
        dfs_traversal.addEdge(0, 1);
        dfs_traversal.addEdge(0, 2);
        dfs_traversal.addEdge(1, 2);
        dfs_traversal.addEdge(2, 0);
        dfs_traversal.addEdge(2, 3);
        dfs_traversal.addEdge(3, 3);
        dfs_traversal.getDfs();

    }
}
