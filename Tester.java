package a5;

import java.util.Map;

public class Tester {

    public void addNode(String name){
        GraphImpl graph = new GraphImpl();
        System.out.println("Test of addNode========");
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        System.out.println(graph.getAdjList());
    }

    public void addEdge(String src, String dest, double weight){
        System.out.println("Test of addNode========");
        GraphImpl graph = new GraphImpl();
        System.out.println("Test of addNode========");
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a", "b", 3.0);
        graph.addEdge("b", "c", 4.0);
        graph.addEdge("c", "d", 2.0);
        graph.addEdge("d", "a", 1.0);
        System.out.println(graph.getAdjList());
    }
    public boolean deleteNode(String name) {
        System.out.println("Test of deleteNode");
        GraphImpl graph = new GraphImpl();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a", "b", 5.0);
        graph.addEdge("a", "c", 2.0);
        graph.addEdge("c", "d", 1.0);
        graph.addEdge("d", "b", 1.0);
        System.out.println("full graph" + graph.getAdjList());
        graph.deleteNode("d");
        System.out.println("no d: " + graph.getAdjList());
        return true;
    }
    public boolean deleteEdge(String src, String dest) {
        System.out.println("Test of deleteEdge==========");
        GraphImpl graph = new GraphImpl();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a", "b", 5.0);
        graph.addEdge("a", "c", 2.0);
        graph.addEdge("c", "d", 1.0);
        graph.addEdge("d", "b", 1.0);
        graph.addEdge("c", "b", 1.0);
        System.out.println("full graph" + graph.getAdjList());
        graph.deleteEdge("c", "b");
        System.out.println("no edge from c to b: " + graph.getAdjList());
        return true;
    }

    public Map<String, Double> dijkstra(String start){
        System.out.println("Test of dijkstra==========");
        GraphImpl graph = new GraphImpl();
        graph.addNode("a");
        graph.addNode("b");
        graph.addNode("c");
        graph.addNode("d");
        graph.addEdge("a", "b", 5.0);
        graph.addEdge("a", "c", 2.0);
        graph.addEdge("c", "d", 1.0);
        graph.addEdge("d", "b", 1.0);
        graph.deleteNode("d");
        System.out.println("full graph" + graph.getAdjList());
        System.out.println("After Dijkstra");
        return graph.dijkstra("a");
    }

}
