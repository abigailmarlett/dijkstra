package a5;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node>{

    public int compare(Node n1, Node n2){
        int c;
        if(n1.getDist() - n2.getDist() < 0){
            c = (int) Math.floor(n1.getDist() - n2.getDist());
        }
        else{
            c = (int) Math.ceil(n1.getDist() - n2.getDist());
        }
        return c;
    }

}
