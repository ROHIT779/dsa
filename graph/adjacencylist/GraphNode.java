package adjacencylist;

import java.util.List;
import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public List<GraphNode> neighbors;
    public boolean isVisited;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.neighbors = new ArrayList<>();
        this.isVisited = false;
    }

    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }
}