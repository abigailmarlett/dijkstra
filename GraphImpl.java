package a5;

import java.util.*;

public class GraphImpl implements Graph {
    Map<String, Node> nodes; //Do not delete.  Use this field to store your nodes.
                             // key: name of node. value: a5.Node object associated with name
    Map<String, ArrayList<Edge>> adjacencyList;

    private int num_nodes;
    private int num_edges;

    public GraphImpl(){
        nodes = new HashMap<String, Node>();
        adjacencyList = new HashMap<String, ArrayList<Edge>>();
        this.num_nodes = 0;
        this.num_edges = 0;
    }

    public Map<String, ArrayList<Edge>> getAdjList(){
        return this.adjacencyList;
    }


    @Override
    public boolean addNode(String name) {
        if (name == null) return false;
        if (nodes.containsKey(name)) return false;
        Node n = new NodeImpl(name);
        nodes.put(name, n);
        adjacencyList.put(name, new ArrayList<Edge>());
        this.num_nodes++;
        return true;
    }

    @Override
    public boolean addEdge(String src, String dest, double weight) {
        if (weight<0) {return false;}
        if (!adjacencyList.containsKey(src)) {return false;}
        if (!adjacencyList.containsKey(dest)) {return false;}
        if (adjacencyList.containsKey(src) && adjacencyList.get(src).contains(dest)) {return false;}
        for (int i=0; i< adjacencyList.get(src).size(); i++){
            if (adjacencyList.get(src).get(i).getDest().equals(dest)) {
                return false;
            }
        }
        Edge edge = new EdgeImpl(src, dest, weight);
        adjacencyList.get(src).add(edge);
        num_edges++;
        nodes.get(src).setOutEdges(dest, edge);
        return true;
    }

    @Override
    public boolean deleteNode(String name) {
        if (adjacencyList.containsKey(name)){
            HashMap<Integer, String> hashmap = new HashMap<Integer, String>();

            for (ArrayList<Edge> edges: adjacencyList.values()){
                for (int j = 0; j < edges.size(); j++){
                    if (edges.get(j).getDest().equals(name)){
                        edges.remove(j);
                        j--;
                    }
                }
            }
            adjacencyList.get(name).clear(); //clears the list of the name being deleted
            adjacencyList.remove(name);//removes the node itself
            nodes.remove(name);
            num_nodes--;
            return true; //returns true if it worked
        }
        if (!adjacencyList.containsKey(name)){
            return false;
        }
//        //Hint: Do you need to remove edges when you delete a node?

        return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public boolean deleteEdge(String src, String dest) {

        if (adjacencyList.containsKey(src)){ //if the src is in the adjacencyList...
             boolean x = false;
            Edge edge_toremove = new EdgeImpl("", "", 0.0);
             for (int i = 0; i<adjacencyList.get(src).size(); i++){
                 if (adjacencyList.get(src).get(i).getDest().equals(dest)){
                     x = true;
                     edge_toremove = adjacencyList.get(src).get(i);
                 }
             }
             if (x == false) return false;
             adjacencyList.get(src).remove(edge_toremove); //getting the ArrayList at src and removing dest
             num_edges--;
             return true; //returns if it worked
        }
        return false;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public int numNodes() {
        return this.num_nodes;
    }

    @Override
    public int numEdges() {
        return this.num_edges;
    }

    @Override
    public Map<String, Double> dijkstra(String start) {

        Map<String, Double> shortestDistanceMap = new HashMap<String, Double>(); //creates map of nodes  and shortest path lengths from start
        PriorityQueue<Node> priority_q = new PriorityQueue<>(nodes.size(), new NodeComparator()); //create a priority queue used in dijkstrtas

        nodes.get(start).setDist(0);
        priority_q.add(nodes.get(start));
        while (!priority_q.isEmpty()){
            Node currNode = priority_q.poll();
            if (!currNode.isKnown()){
                currNode.setKnown(true);
                for (Edge e : adjacencyList.get(currNode.getName())){
                    Node dst = nodes.get(e.getDest());
                    if (dst == null) {continue;}
                    if (!dst.isKnown() && (currNode.getDist() + e.getWeight()) < dst.getDist()){
                        dst.setDist(currNode.getDist() + e.getWeight());
                        priority_q.add(dst);
                    }
                }
                shortestDistanceMap.put(currNode.getName(), currNode.getDist());
            }
        }
       System.out.println(shortestDistanceMap);
        return shortestDistanceMap;
    }
}
