package a5;

public class EdgeImpl implements Edge {
    /* You will include the implementations for any edge methods you need in this file. */

    /*Hint: Make sure you update the Edge interface in Edge.java when you add a new method implementation
    in EdgeImpl.java, and vice-versa.  getName() in Node.java and NodeImpl.java is an example.  Also, files in
    previous homeworks (e.g., BST.java and BSTImpl.java in homework 3) are good examples of
    interfaces and their implementations.
     */

    /*Also, any edge fields you want to add for the object should go in this file.  */

    private String src;
    private String dest;
    private double weight;

    public EdgeImpl(String src, String dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String getSrc() {
        return src;  //Dummy return value.  Remove when you implement!
    }

    @Override
    public String getDest() {
        return dest;
    }
    @Override
    public double getWeight() {
        return weight;
    }
    @Override
    public void setSrc(String name) {
        this.src = name;
    }
    @Override
    public void setDest(String name) {
        this.dest = name;
    }
    @Override
    public void setWeight(double weight) {
        this.weight = weight;
    }


}
