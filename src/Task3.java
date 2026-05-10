import java.util.*;

public class Task3 {
    static Set<Node> visitedDFS = new HashSet<>();
    static Set<Node> visitedBFS = new HashSet<>();

    public static void dfs(Graph graph, Node v) {
        visitedDFS.add(v);
        System.out.print(v.data + " ");

        LinkedList<Edge> neighbors = null;
        for (LinkedList<Edge> list : graph.alist) {
            if (list.getFirst().node == v) {
                neighbors = list;
                break;
            }
        }

        if (neighbors != null) {
            for (int i = 1; i < neighbors.size(); i++) {
                Node w = neighbors.get(i).node;
                if (!visitedDFS.contains(w)) {
                    dfs(graph, w);
                }
            }
        }
    }

    public static void bfs(Graph graph, Node s) {
        Queue<Node> queue = new LinkedList<>();
        visitedBFS.add(s);
        queue.add(s);

        while (!queue.isEmpty()) {
            Node v = queue.poll();
            System.out.print(v.data + " ");

            LinkedList<Edge> neighbors = null;
            for (LinkedList<Edge> list : graph.alist) {
                if (list.getFirst().node == v) {
                    neighbors = list;
                    break;
                }
            }

            if (neighbors != null) {
                for (int i = 1; i < neighbors.size(); i++) {
                    Node w = neighbors.get(i).node;
                    if (!visitedBFS.contains(w)) {
                        visitedBFS.add(w);
                        queue.add(w);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(new Node('A'));
        graph.addNode(new Node('B'));
        graph.addNode(new Node('C'));
        graph.addNode(new Node('D'));
        graph.addNode(new Node('E'));
        graph.addNode(new Node('F'));
        graph.addNode(new Node('G'));

        graph.addEdge(0, 2, 1);
        graph.addEdge(0, 1, 1);
        graph.addEdge(0, 3, 1);
        graph.addEdge(1, 0, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(1, 4, 1);
        graph.addEdge(1, 6, 1);
        graph.addEdge(2, 0, 1);
        graph.addEdge(2, 1, 1);
        graph.addEdge(2, 3, 1);
        graph.addEdge(3, 2, 1);
        graph.addEdge(3, 0, 1);
        graph.addEdge(4, 6, 1);
        graph.addEdge(4, 5, 1);
        graph.addEdge(4, 1, 1);
        graph.addEdge(5, 6, 1);
        graph.addEdge(5, 4, 1);
        graph.addEdge(6, 5, 1);
        graph.addEdge(6, 4, 1);

        dfs(graph, graph.alist.get(0).get(0).node);
        System.out.println();
        bfs(graph, graph.alist.get(0).get(0).node);
    }
}