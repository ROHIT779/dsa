package adjacencylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Graph {
    List<GraphNode> nodes;

    public Graph(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addUndirectedEdge(int i, int j) {
        GraphNode node1 = nodes.get(i);
        GraphNode node2 = nodes.get(j);
        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public void addDirectedEdge(int i, int j) {
        nodes.get(i).addNeighbor(nodes.get(j));
    }

    public void printGraph() {
        for(GraphNode node : nodes) {
            System.out.print(node.name + " : ");
            for(int i = 0; i < node.neighbors.size(); i++) {
                System.out.print(node.neighbors.get(i).name);
                if(i != node.neighbors.size() - 1){
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public void resetIsVisitedForAllNodes() {
        for(GraphNode node : nodes) {
            node.isVisited = false;
        }
    }

    public void BFS(GraphNode node) {
        System.out.println("Printing BFS from " + node.name);
        //Queue
        List<GraphNode> queue = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNode neighbor : currentNode.neighbors) {
                if(!neighbor.isVisited && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void DFS(GraphNode node) {
        System.out.println("Printing DFS from " + node.name);
        //Stack
        List<GraphNode> stack = new ArrayList<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            GraphNode currentNode = stack.remove(stack.size() - 1);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(GraphNode neighbor : currentNode.neighbors) {
                if(!neighbor.isVisited && !stack.contains(neighbor)) {
                    stack.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for(GraphNode node : nodes) {
            if(!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
        System.out.println();
    }

    public void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for(GraphNode neighbor : node.neighbors) {
            if(!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }

        node.isVisited = true;
        stack.push(node);
    }
}