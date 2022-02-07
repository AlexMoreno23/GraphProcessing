package test_example.by.morunov;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Alex Morunov
 */
class Graph {
    int V;
    ArrayList<ArrayList<GraphProcessing.ListNode>> adj;

    Graph(int V) {
        this.V = V;
        adj = new ArrayList<>(V);

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    void addEdge(int u, int v, int weight) {
        GraphProcessing.ListNode node = new GraphProcessing.ListNode(v, weight);
        adj.get(u).add(node);
    }

    void topologicalSortUtil(int v, boolean[] mark,
                             Stack<Integer> stack) {
        mark[v] = true;
        for (int i = 0; i < adj.get(v).size(); i++) {
            GraphProcessing.ListNode node = adj.get(v).get(i);
            if (!mark[node.getV()])
                topologicalSortUtil(node.getV(), mark, stack);
        }
        stack.push(v);
    }

    void longestPath(int s) {
        Stack<Integer> stack = new Stack<>();
        int[] dist = new int[V];

        boolean[] mark = new boolean[V];
        for (int i = 0; i < V; i++)
            mark[i] = false;

        for (int i = 0; i < V; i++)
            if (!mark[i])
                topologicalSortUtil(i, mark, stack);

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MIN_VALUE;

        dist[s] = 0;


        while (!stack.isEmpty()) {
            int u = stack.peek();
            stack.pop();

            if (dist[u] != Integer.MIN_VALUE) {
                for (int i = 0; i < adj.get(u).size(); i++) {
                    GraphProcessing.ListNode node = adj.get(u).get(i);
                    if (dist[node.getV()] < dist[u] + node.getWeight())
                        dist[node.getV()] = dist[u] + node.getWeight();
                }
            }
        }

        for (int i = 0; i < V; i++)
            if (dist[i] == Integer.MIN_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
    }
}
