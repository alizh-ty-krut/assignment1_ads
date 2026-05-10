import java.util.*;

public class Task5 {
    public static void dijkstra(Graph graph, Node startNode) {
        Map<Node, Integer> distances = new HashMap<>();
        Map<Node, Node> predecessors = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        Set<Node> visited = new HashSet<>();

        for (LinkedList<Edge> list : graph.alist) {
            distances.put(list.getFirst().node, Integer.MAX_VALUE);
        }
        distances.put(startNode, 0);
        pq.add(new Edge(startNode, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll().node;

            if (visited.contains(current)) continue;
            visited.add(current);

            LinkedList<Edge> neighbors = null;
            for (LinkedList<Edge> list : graph.alist) {
                if (list.getFirst().node == current) {
                    neighbors = list;
                    break;
                }
            }

            if (neighbors != null) {
                for (int i = 1; i < neighbors.size(); i++) {
                    Edge edge = neighbors.get(i);
                    int newDist = distances.get(current) + edge.weight;

                    if (newDist < distances.get(edge.node)) {
                        distances.put(edge.node, newDist);
                        predecessors.put(edge.node, current);
                        pq.add(new Edge(edge.node, newDist));
                    }
                }
            }
        }

        printResult(distances, predecessors);
    }

    private static void printResult(Map<Node, Integer> distances, Map<Node, Node> predecessors) {
        for (Node node : distances.keySet()) {
            System.out.println("Distance to " + node.data + " is " + distances.get(node));
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();

        Node edinburgh = new Node("Edinburgh");
        Node stirling = new Node("Stirling");
        Node glasgow = new Node("Glasgow");
        Node perth = new Node("Perth");
        Node dundee = new Node("Dundee");

        graph.addNode(edinburgh);
        graph.addNode(stirling);
        graph.addNode(glasgow);
        graph.addNode(perth);
        graph.addNode(dundee);

        graph.addEdge(0, 1, 50);
        graph.addEdge(0, 2, 70);
        graph.addEdge(0, 3, 100);
        graph.addEdge(1, 3, 40);
        graph.addEdge(1, 0, 50);
        graph.addEdge(2, 0, 70);
        graph.addEdge(2, 1, 50);
        graph.addEdge(3, 1, 40);
        graph.addEdge(3, 0, 100);
        graph.addEdge(3, 4, 60);
        graph.addEdge(4, 3, 60);

        dijkstra(graph, edinburgh);
    }
}