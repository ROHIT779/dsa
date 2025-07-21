package com.demo.main;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class Node implements Comparable<Node> {
    private String name;
    private int index;
    private List<Node> neighbors;
    private boolean isVisited;
    private Node parent;
    private Map<Node, Integer> weightMap;
    private int distance;
    private Map<Node, Boolean> blockageMap;

    public Node(String name, int index) {
        this.name = name;
        this.index = index;
        this.neighbors = new ArrayList<>();
        this.isVisited = false;
        this.parent = null;
        this.weightMap = new HashMap<>();
        this.distance = Integer.MAX_VALUE;
        this.blockageMap = new HashMap<>();
    }

    public int compareTo(Node node) {
        return this.getDistance() - node.getDistance();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void addNeighbor(Node neighbor) {
        this.neighbors.add(neighbor);
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Map<Node, Integer> getWeightMap() {
        return weightMap;
    }

    public void addWeightMap(Node node, int weight) {
        this.weightMap.put(node, weight);
        this.blockageMap.put(node, false);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Map<Node, Boolean> getBlockageMap() {
        return blockageMap;
    }

    public void addBlockage(Node node) {
        this.blockageMap.put(node, true);
    }

    public void removeBlockage(Node node) {
        this.blockageMap.put(node, false);
    }
}