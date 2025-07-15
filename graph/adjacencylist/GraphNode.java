package adjacencylist;

import java.util.List;
import java.util.ArrayList;

public class GraphNode {
    public String name;
    public int index;
    public List<GraphNode> neighbors;
    public boolean isVisited;
    public GraphNode parent;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.neighbors = new ArrayList<>();
        this.isVisited = false;
        this.parent = null;
    }

    public void addNeighbor(GraphNode neighbor) {
        this.neighbors.add(neighbor);
    }

    public void setParent(GraphNode parent) {
        this.parent = parent;
    }

    public GraphNode getParent() {
        return this.parent;
    }
}