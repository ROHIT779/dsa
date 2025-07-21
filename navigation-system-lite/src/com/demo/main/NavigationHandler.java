package com.demo.main;

public class NavigationHandler {
    private Graph graph;
    private static final String ADD_NODE = "add-node";
    private static final String ADD_EDGE = "add-edge";
    private static final String VIEW = "view";
    private static final String SHORTEST = "shortest-path";
    private static final String QUIT = "quit";
    private static final String EXIT = "exit";
    private static final String ADD_BLOCKAGE = "add-blockage";
    private static final String REMOVE_BLOCKAGE = "remove-blockage";

    public NavigationHandler() {
        this.graph = new Graph();
    }

    public void addNode(String name, int index) {
        this.graph.addNode(name, index);
    }

    public void addEdge(int from, int to, int weight) {
        this.graph.addEdge(from, to, weight);
    }

    public void view() {
        this.graph.viewGraph();
    }

    public void shortest(int sourceIndex) {
        graph.getNodes().get(sourceIndex).setDistance(0);
        graph.dijkstra();
        graph.resetNodes();
    }

    public void shortest() {
        graph.allPairsShortestPath();
    }

    public void addBlockage(int fromIndex, int toIndex) {
        graph.getNodes().get(fromIndex).addBlockage(graph.getNodes().get(toIndex));
    }

    public void removeBlockage(int fromIndex, int toIndex) {
        graph.getNodes().get(fromIndex).removeBlockage(graph.getNodes().get(toIndex));
    }

    public String followCommand(String[] args) {
        try {
            String command = args[0];
            switch (command) {
                case ADD_NODE:
                    String name = args[1];
                    int index = Integer.parseInt(args[2]);
                    addNode(name, index);
                    break;
                case ADD_EDGE:
                    int from = Integer.parseInt(args[1]);
                    int to = Integer.parseInt(args[2]);
                    int weight = Integer.parseInt(args[3]);
                    addEdge(from, to, weight);
                    break;
                case VIEW:
                    view();
                    break;
                case SHORTEST:
                    if(args.length > 1) {
                        int sourceIndex = Integer.parseInt(args[1]);
                        shortest(sourceIndex);
                    } else {
                        shortest();
                    }
                    break;
                case ADD_BLOCKAGE:
                    from = Integer.parseInt(args[1]);
                    to = Integer.parseInt(args[2]);
                    addBlockage(from, to);
                    break;
                case REMOVE_BLOCKAGE:
                    from = Integer.parseInt(args[1]);
                    to = Integer.parseInt(args[2]);
                    removeBlockage(from, to);
                    break;
                case QUIT:
                    return QUIT;
                case EXIT:
                    return EXIT;
                default:
                    System.out.println("Invalid: No such command exists");
            }
        } catch(Exception e) {
            System.out.println("An exception occured");
            System.out.println(e);
        }
        return "";
    }
}