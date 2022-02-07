package test_example.by.morunov;

/**
 * @author Alex Morunov
 */
class GraphProcessing {

    static class ListNode {
        int v;
        int weight;

        public ListNode(int v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public int getV() {
            return v;
        }

        public int getWeight() {
            return weight;
        }

    }

    public static void main(String[] args) {

        Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 2, 3);
        g.addEdge(1, 3, 6);
        g.addEdge(1, 2, 4);
        g.addEdge(2, 4, 4);
        g.addEdge(2, 5, 8);
        g.addEdge(2, 3, 7);
        g.addEdge(3, 5, 1);
        g.addEdge(3, 4, 2);
        g.addEdge(4, 5, 9);

        int s = 0;
        System.out.print("Long distances from the original vertex " + s + " \n");
        g.longestPath(s);

    }
}