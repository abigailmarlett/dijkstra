package a5;

public class Main {


    public static void main(String[] args) {
        Tester tst = new Tester();
        GraphImpl graph = new GraphImpl();
        String string = new String();

       // tst.addNode(string);
       // tst.addEdge(string, string, 1.0);
      // tst.deleteNode(string);
       // tst.deleteEdge(string, string);
        tst.dijkstra(string);







        //You are encouraged (but not required) to include your testing code here.

        //Hint: Try to test basic operations (e.g., adding a few nodes and edges to graphs)
        //before you implement more complex methods


    }

}
