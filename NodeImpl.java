package a5;

import java.util.*;

public class NodeImpl implements Node {

    /* You will include the method signatures (return type, name, and arg types) for any node methods you
    need in this file. */

    /*Hint: Make sure you update the Node interface in Node.java when you add a new method implementation
    in NodeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any node fields you want to add for the object should go in this file.  */

    private String name;
    private HashMap<String, Edge> outEdges;
    private boolean known;
    private double dist;


    public NodeImpl(String name){
        this.name = name;
        outEdges = new HashMap<String, Edge>();
        known = false;
        dist = Double.POSITIVE_INFINITY;
    }

    @Override
    public String getName() {return name;}

    @Override
    public HashMap<String, Edge> getOutEdges() {return outEdges;}

    @Override
    public void setOutEdges(String str, Edge edge) {outEdges.put(str, edge);}

    @Override
    public int getOutDegree() {return outEdges.size();}

    @Override
    public boolean isKnown(){return known;}

    @Override
    public void setKnown(boolean k) {known = k;}

    @Override
    public double getDist() {return dist;}

    @Override
    public void setDist(double dist) {this.dist = dist;}

    @Override
    public void setName(String name) {this.name = name;}











}
