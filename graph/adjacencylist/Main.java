package adjacencylist;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        GraphNode a = new GraphNode("A", 0);
        GraphNode b = new GraphNode("B", 1);
        GraphNode c = new GraphNode("C", 2);
        GraphNode d = new GraphNode("D", 3);
        GraphNode e = new GraphNode("E", 4);

        List<GraphNode> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);

        Graph graph = new Graph(nodes);
        graph.addUndirectedEdge(0, 1);
        graph.addUndirectedEdge(0, 2);
        graph.addUndirectedEdge(0, 3);
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(2, 3);
        graph.addUndirectedEdge(3, 4);

        graph.printGraph();

        for(GraphNode node : nodes) {
            graph.BFS(node);
            graph.resetIsVisitedForAllNodes();
        }

        for(GraphNode node : nodes) {
            graph.DFS(node);
            graph.resetIsVisitedForAllNodes();
        }

        topologicalSort();
    }

    public static void topologicalSort() {
        GraphNode a = new GraphNode("A", 0);
        GraphNode b = new GraphNode("B", 1);
        GraphNode c = new GraphNode("C", 2);
        GraphNode d = new GraphNode("D", 3);
        GraphNode e = new GraphNode("E", 4);
        GraphNode f = new GraphNode("F", 5);
        GraphNode g = new GraphNode("G", 6);
        GraphNode h = new GraphNode("H", 7);

        List<GraphNode> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        nodes.add(h);

        Graph graph = new Graph(nodes);
        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(4, 7);
        graph.addDirectedEdge(5, 6);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(3, 5);

        System.out.println("***** Topological Sort *****");
        graph.topologicalSort();
    }
}