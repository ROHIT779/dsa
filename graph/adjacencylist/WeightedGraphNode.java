package adjacencylist;

import java.util.*;

public class WeightedGraphNode implements Comparable<WeightedGraphNode> {
    public String name;
    public int index;
    public List<WeightedGraphNode> neighbors;
    public boolean isVisited;
    public WeightedGraphNode parent;
    public Map<WeightedGraphNode, Integer> weightMap;
    public Integer distance;

    public WeightedGraphNode(String name, int index) {
        this.name = name;
        this.index = index;
        this.neighbors = new ArrayList<>();
        this.isVisited = false;
        this.parent = null;
        this.weightMap = new HashMap<>();
        this.distance = Integer.MAX_VALUE;
    }

    public void addNeighbor(WeightedGraphNode neighbor) {
        this.neighbors.add(neighbor);
    }

    public void setParent(WeightedGraphNode parent) {
        this.parent = parent;
    }

    public WeightedGraphNode getParent() {
        return this.parent;
    }

    public int compareTo(WeightedGraphNode node) {
        return this.distance - node.distance;
    }
}