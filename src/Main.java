import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String graphFilePath = "C:\\Users\\falfa\\Documents\\Uni\\2.Semester\\Info 2\\Übungen\\lab11\\src\\bvg.txt";
        GraphReader graphReader = new GraphReader();

        try {
            WeightedGraph graph = graphReader.readGraph(graphFilePath);

            DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();
            String sourceVertex = "070201053701"; // schöneweide
            System.out.println("Computing shortest paths from " + sourceVertex + " using Dijkstra's algorithm...");

            // Compute shortest paths
            Map<String, Integer> shortestPaths = dijkstraAlgorithm.shortestPaths(graph, sourceVertex);

            // Output shortest paths
            System.out.println("Shortest paths from " + sourceVertex + ":");
            for (Map.Entry<String, Integer> entry : shortestPaths.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
