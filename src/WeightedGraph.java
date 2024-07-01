import java.util.*;

public class WeightedGraph {
    private Map<String, Map<String, Integer>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(String fromVertex, String toVertex, int weight) {
        adjacencyList.computeIfAbsent(fromVertex, k -> new HashMap<>()).put(toVertex, weight);
        // Assuming undirected graph
        adjacencyList.computeIfAbsent(toVertex, k -> new HashMap<>()).put(fromVertex, weight);
    }

    public Map<String, Integer> getNeighbors(String vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyMap());
    }

    // Getters and other methods as needed

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String vertex : adjacencyList.keySet()) {
            sb.append(vertex).append(" -> ");
            sb.append(adjacencyList.get(vertex)).append("\n");
        }
        return sb.toString();
    }
}
