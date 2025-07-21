package com.demo.main;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Graph {
    private List<Node> nodes;

    public Graph() {
        this.nodes = new ArrayList<>();
    }

    public Graph(List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addEdge(int i, int j, int weight) {
        Node first = nodes.get(i);
        Node second = nodes.get(j);
        first.addNeighbor(second);
        first.addWeightMap(second, weight);
    }

    public void addNode(String name, int index) {
        Node node = new Node(name, index);
        this.nodes.add(node);
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void viewGraph() {
        System.out.println("*****Viewing Graph*****");
        System.out.println("Nodes: list of neighbors");
        for(Node node : nodes) {
            System.out.print(node.getName() + ": ");
            for(Node neighbor : node.getNeighbors()) {
                System.out.print(neighbor.getName() + "(");
                System.out.print(node.getWeightMap().get(neighbor) + ")");
                if(node.getBlockageMap().get(neighbor)) {
                    System.out.print("(#)");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println("(#) indicates blocked path");
        System.out.println("***********************");
    }

    public void dijkstra() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.addAll(nodes);
        System.out.println("\n\nSource Node: " + queue.peek().getName());
        while(!queue.isEmpty()) {
            Node currentNode = queue.remove();
            for(Node neighbor : currentNode.getNeighbors()) {
                if(!currentNode.getBlockageMap().get(neighbor)) {
                    int distanceCalculated = currentNode.getDistance() + currentNode.getWeightMap().get(neighbor);
                    if((neighbor.getDistance() > distanceCalculated) && (distanceCalculated > 0)) {
                        neighbor.setDistance(distanceCalculated);
                        neighbor.setParent(currentNode);
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
        for(Node node : nodes) {
            System.out.println("\nPath to Node: " + node.getName() + " with distance: " + node.getDistance());
            pathPrint(node);
        }
    }

    public void pathPrint(Node node) {
        if(node.getParent() != null) {
            pathPrint(node.getParent());
        }
        System.out.print(node.getName() + " ");
    }

    public void allPairsShortestPath() {
        for(int i = 0; i < nodes.size(); i++) {
            nodes.get(i).setDistance(0);
            dijkstra();
            resetNodes();
        }
    }

    public void resetNodes() {
        for(Node node : nodes) {
            node.setVisited(false);
            node.setParent(null);
            node.setDistance(Integer.MAX_VALUE);
        }
    }
}