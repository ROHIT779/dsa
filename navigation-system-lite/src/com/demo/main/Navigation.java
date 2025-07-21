package com.demo.main;

import java.util.Scanner;

public class Navigation {
    private static NavigationHandler handler = new NavigationHandler();
    private static String prompt = ">>> ";
    private static String QUIT = "quit";
    private static String EXIT = "exit";
    private static String INTRO_MESSAGE = "***** Navigation System Started *****";
    private static String INSTRUCTIONS = "commands supported:\n" +
            "add-node: to add a new node to the graph                           |    syntax: add-node {node-name} {node-index}                           |   usage: add-node Paris 0\n" +
            "add-edge: to add weighted directed edge to the graph               |    syntax: add-edge {from-node-index} {to-node-index} {edge-weight}    |   usage: add-edge 0 1 5\n" +
            "view: to view the graph                                            |    syntax: view                                                        |   usage: view\n" +
            "shortest-path: to find the shortest paths from a source node       |    syntax: shortest-path {source-node-index}                           |   usage: shortest-path 1\n" +
            "shortest-path: to find the shortest paths between all the nodes    |    syntax: shortest-path                                               |   usage: shortest-path\n" +
            "add-blockage: to add a blockage in a route between 2 nodes         |    syntax: add-blockage {from-node-index} {to-node-index}              |   usage: add-blockage 1 2\n" +
            "remove-blockage: to remove a blockage in a route between 2 nodes   |    syntax: remove-blockage {from-node-index} {to-node-index}           |   usage: remove-blockage 1 2\n" +
            "exit: to quit the application                                      |    syntax: exit                                                        |   usage: exit\n" +
            "quit: to quit the application                                      |    syntax: quit                                                        |   usage: quit\n";

    public static void main(String[] args) {
        printIntro();
        Scanner scanner = new Scanner(System.in);
        String input = "";
        do {
            System.out.print("\n" + prompt);
            input = scanner.nextLine();
            String[] argsNew = input.split(" ");
            input = handler.followCommand(argsNew);
        } while(!input.equals(QUIT) && !input.equals(EXIT));

    }

    public static void printIntro() {
        System.out.println(INTRO_MESSAGE);
        System.out.println();
        System.out.println(INSTRUCTIONS);
    }
}