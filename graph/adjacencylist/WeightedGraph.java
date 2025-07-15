package adjacencylist;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class WeightedGraph {
    List<WeightedGraphNode> nodes;

    public WeightedGraph(List<WeightedGraphNode> nodes) {
        this.nodes = nodes;
    }

    public void addUndirectedEdge(int i, int j) {
        WeightedGraphNode node1 = nodes.get(i);
        WeightedGraphNode node2 = nodes.get(j);
        node1.addNeighbor(node2);
        node2.addNeighbor(node1);
    }

    public void addDirectedEdge(int i, int j) {
        nodes.get(i).addNeighbor(nodes.get(j));
    }

    public void printGraph() {
        for(WeightedGraphNode node : nodes) {
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
        for(WeightedGraphNode node : nodes) {
            node.isVisited = false;
        }
    }

    public void BFS(WeightedGraphNode node) {
        System.out.println("Printing BFS from " + node.name);
        //Queue
        List<WeightedGraphNode> queue = new ArrayList<>();
        queue.add(node);
        while(!queue.isEmpty()) {
            WeightedGraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(WeightedGraphNode neighbor : currentNode.neighbors) {
                if(!neighbor.isVisited && !queue.contains(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void DFS(WeightedGraphNode node) {
        System.out.println("Printing DFS from " + node.name);
        //Stack
        List<WeightedGraphNode> stack = new ArrayList<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            WeightedGraphNode currentNode = stack.remove(stack.size() - 1);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for(WeightedGraphNode neighbor : currentNode.neighbors) {
                if(!neighbor.isVisited && !stack.contains(neighbor)) {
                    stack.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void topologicalSort() {
        Stack<WeightedGraphNode> stack = new Stack<>();
        for(WeightedGraphNode node : nodes) {
            if(!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }
        while(!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
        System.out.println();
    }

    public void topologicalVisit(WeightedGraphNode node, Stack<WeightedGraphNode> stack) {
        for(WeightedGraphNode neighbor : node.neighbors) {
            if(!neighbor.isVisited) {
                topologicalVisit(neighbor, stack);
            }
        }

        node.isVisited = true;
        stack.push(node);
    }

    //BFS to find Single Source Shortest Path
    public void BFSForSSSPP(WeightedGraphNode source) {
        List<WeightedGraphNode> queue = new ArrayList<>();
        queue.add(source);
        while(!queue.isEmpty()) {
            WeightedGraphNode node = queue.remove(0);
            node.isVisited = true;
            for(WeightedGraphNode neighbor : node.neighbors) {
                if(!neighbor.isVisited && !queue.contains(neighbor)) {
                    neighbor.setParent(node);
                    queue.add(neighbor);
                }
            }
        }
    }

    public void pathPrint(WeightedGraphNode node) {
        if(node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }
    public void dijkstra() {
        PriorityQueue<WeightedGraphNode> queue = new PriorityQueue<>();
        queue.addAll(nodes);
        while(!queue.isEmpty()) {
            WeightedGraphNode currentNode = queue.remove();
            for(WeightedGraphNode neighbor : currentNode.neighbors) {
                if(neighbor.distance > (currentNode.distance + currentNode.weightMap.get(neighbor))) {
                    neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    neighbor.parent = currentNode;
                    queue.remove(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        for(WeightedGraphNode nodeToCheck : nodes) {
            System.out.println("Node: " + nodeToCheck.name + " Distance: " + nodeToCheck.distance + " Path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    public void addWeightedDirectedEdge(int i, int j, int weight) {
        WeightedGraphNode first = nodes.get(i);
        WeightedGraphNode second = nodes.get(j);
        first.neighbors.add(second);
        first.weightMap.put(second, weight);
    }
}