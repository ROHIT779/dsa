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

        BFSForSSSPP();

        dijkstra();
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

    public static void BFSForSSSPP()
    {
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
        graph.addUndirectedEdge(1, 4);
        graph.addUndirectedEdge(0, 4);
        graph.addUndirectedEdge(3, 4);
        graph.addUndirectedEdge(2, 3);
        graph.resetIsVisitedForAllNodes();

        System.out.println("\nPrinting Graph before BFSForSSSPP");
        graph.printGraph();
        graph.BFSForSSSPP(a);
        for(GraphNode node : graph.nodes) {
            System.out.println("\nPrinting path from node: " + node.name);
            graph.pathPrint(node);
        }
    }

    public static void dijkstra()
    {
        WeightedGraphNode a = new WeightedGraphNode("A", 0);
        WeightedGraphNode b = new WeightedGraphNode("B", 1);
        WeightedGraphNode c = new WeightedGraphNode("C", 2);
        WeightedGraphNode d = new WeightedGraphNode("D", 3);
        WeightedGraphNode e = new WeightedGraphNode("E", 4);
        WeightedGraphNode f = new WeightedGraphNode("F", 5);
        WeightedGraphNode g = new WeightedGraphNode("G", 7);

        List<WeightedGraphNode> nodes = new ArrayList<>();
        nodes.add(a);
        nodes.add(b);
        nodes.add(c);
        nodes.add(d);
        nodes.add(e);
        nodes.add(f);
        nodes.add(g);
        WeightedGraph graph = new WeightedGraph(nodes);
        graph.addWeightedDirectedEdge(0, 1, 2);
        graph.addWeightedDirectedEdge(0, 2, 5);
        graph.addWeightedDirectedEdge(1, 2, 6);
        graph.addWeightedDirectedEdge(1, 3, 1);
        graph.addWeightedDirectedEdge(1, 4, 3);
        graph.addWeightedDirectedEdge(2, 5, 8);
        graph.addWeightedDirectedEdge(2, 4, 4);
        graph.addWeightedDirectedEdge(4, 6, 9);
        graph.addWeightedDirectedEdge(5, 6, 7);

        System.out.println("\nPrinting Dijsktra: ");
        nodes.get(0).distance = 0;
        graph.dijkstra();
    }
}