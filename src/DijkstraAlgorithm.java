import java.util.*;

public class DijkstraAlgorithm {
    public Map<String, Integer> shortestPaths(WeightedGraph graph, String source) {
        Map<String, Integer> distances = new HashMap<>();
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getDistance));
        Set<String> visited = new HashSet<>();

        // Initialize distances to infinity (Integer.MAX_VALUE) and source to 0
        for (String vertex : graph.getNeighbors(source).keySet()) {
            distances.put(vertex, Integer.MAX_VALUE);
        }
        distances.put(source, 0);
        pq.offer(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            String currentVertex = currentNode.getVertex();
            int currentDistance = currentNode.getDistance();

            if (visited.contains(currentVertex)) continue;
            visited.add(currentVertex);

            // Explore neighbors
            Map<String, Integer> neighbors = graph.getNeighbors(currentVertex);
            for (Map.Entry<String, Integer> neighborEntry : neighbors.entrySet()) {
                String neighbor = neighborEntry.getKey();
                int weight = neighborEntry.getValue();
                int newDistance = currentDistance + weight;

                if (newDistance < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                    distances.put(neighbor, newDistance);
                    pq.offer(new Node(neighbor, newDistance));
                }
            }
        }

        return distances;
    }

    private static class Node {
        private String vertex;
        private int distance;

        public Node(String vertex, int distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        public String getVertex() {
            return vertex;
        }

        public int getDistance() {
            return distance;
        }
    }
}
