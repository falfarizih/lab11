import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class GraphReader {
    public WeightedGraph readGraph(String filePath) throws IOException {
        WeightedGraph graph = new WeightedGraph();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String fromVertex = parts[0];

                for (int i = 1; i < parts.length; i++) {
                    String[] edgeParts = parts[i].split(",");
                    String toVertex = edgeParts[0];
                    int weight = Integer.parseInt(edgeParts[1]);

                    graph.addEdge(fromVertex, toVertex, weight);
                }
            }
        }

        return graph;
    }
}
