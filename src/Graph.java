import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    ArrayList<LinkedList<Edge>> alist;

    Graph() {
        alist = new ArrayList<>();
    }

    public void addNode(Node node) {
        LinkedList<Edge> currentList = new LinkedList<>();
        currentList.add(new Edge(node, 0));
        alist.add(currentList);
    }

    public void addEdge(int src, int dst, int weight) {
        Node dstNode = alist.get(dst).getFirst().node;
        alist.get(src).add(new Edge(dstNode, weight));
    }

    public void print() {
        for (LinkedList<Edge> currentList : alist) {
            System.out.print(currentList.getFirst().node.data + " -> ");
            for (int i = 1; i < currentList.size(); i++) {
                System.out.print(currentList.get(i).node.data + "(" + currentList.get(i).weight + ") ");
            }
            System.out.println();
        }
    }
}

class Edge {
    Node node;
    int weight;

    Edge(Node node, int weight) {
        this.node = node;
        this.weight = weight;
    }
}