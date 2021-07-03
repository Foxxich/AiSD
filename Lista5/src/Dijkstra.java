import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Dijkstra {

    private static int insertCompares = 0;
    private static long timeElapsed;
    private static final String FILE = "Dijkstra.txt";

    public static void main(String[] args) throws FileNotFoundException {
        for (int k = 1; k <= 1; k++) {
            PriorityQueue priorityQueue = new PriorityQueue(Graph.V);
            Set<String> result = new LinkedHashSet<>();
            Graph graph = new Graph();
            double[] distances = new double[Graph.V];
            Arrays.fill(distances, Double.MAX_VALUE);

            priorityQueue.insert("0",0);
            for (int i = 1; i < Graph.V; i++) {
                priorityQueue.insert(Integer.toString(i), Double.MAX_VALUE);
            }
            //priorityQueue.print();
            distances[0] = 0;
            //print(result, distances);
            insertCompares++;
            long startTime = System.nanoTime();
            while (result.size() != Graph.V) {
                //priorityQueue.print();
                //System.out.println("______________________________________________________________");
                //print(result, distances);
                String node = priorityQueue.pop().name;
                result.add(node);
                double newDistance = -1;
                int nodeAsNumber  = Integer.parseInt(node);
                insertCompares++;
                for (int i = 0; i < graph.adjacentList.get(nodeAsNumber).size(); i++) { //to get number of neighbours of our element
                    Task neighbour = graph.adjacentList.get(nodeAsNumber).get(i);
                    insertCompares++;
                    if (!result.contains(neighbour.name)) {
                        insertCompares++;
                        newDistance = neighbour.priority + distances[nodeAsNumber]; //priority i wezel ktorego sasiadow badamy (droga do sasiadow - I)
                        int nodeNeighbourAsNumber = Integer.parseInt(neighbour.name);
                        if(newDistance < distances[nodeNeighbourAsNumber]) {
                            distances[nodeNeighbourAsNumber] = newDistance;
                        }
                        priorityQueue.priority(neighbour.name, distances[nodeNeighbourAsNumber]);
                    }
                }
            }
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            print(result, distances, k);
        }
    }

    private static void print(Set<String> result, double[] distances, int j) {
        for (int i = 0; i < Graph.V; i++) {
            System.out.println(i + " -> "+ distances[i]);
        }
        System.out.println("Result "+ result);
        System.out.println("For i "+ j);
        System.out.println("Compares "+ insertCompares);
        System.out.println("Time "+ timeElapsed+"\n");
        printResult(j, insertCompares, timeElapsed);
        insertCompares = 0;
    }

    private static void printResult(int j, int insertCompares, long timeElapsed) {
        try {
            FileWriter myWriter = new FileWriter(FILE,true);
            myWriter.write(j+"    "+insertCompares+"    "+timeElapsed);
            myWriter.write("\n");
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
