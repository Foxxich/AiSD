import java.io.FileNotFoundException;
import java.util.*;

public class Grabby {
    public static final int SIZE = 400;//max 400

    private static int insertCompares = 0;
    private static long timeElapsed;

    public static void main(String args[]) throws FileNotFoundException {
        for (int j = 1; j <= 50; j++) {
            PriorityQueue priorityQueue = new PriorityQueue(SIZE*SIZE);
            Set<Edge> result = new LinkedHashSet<>();
            GraphByEdges graph = new GraphByEdges();
            Set<String> visitedNodes = new LinkedHashSet<>();
            graph.generateClique(SIZE);

            String source = Integer.toString(SIZE - 1);
            for (Edge edge:
                    graph.getAdjacentEdges(source)) {
                priorityQueue.insert(edge.getName(), edge.getCost());
            }
            priorityQueue.print();
            visitedNodes.add(source);
            long startTime = System.nanoTime();
            insertCompares++;
            while (visitedNodes.size() != SIZE) {
                Task minTask = priorityQueue.pop();
                Edge newEdge = graph.getEdgeByName(minTask.name);
                insertCompares++;
                if(Utils.isNodeNotVisited(newEdge,visitedNodes)) {
                    result.add(newEdge);//dodajemy do drzewa
                    String newNode = newEdge.getSource();
                    insertCompares++;
                    if(!visitedNodes.add(newNode)) {
                        newNode = newEdge.getDestination();
                        visitedNodes.add(newNode);
                    }
                    for (Edge edge:
                            graph.getAdjacentEdges(newNode)) {
                        insertCompares++;
                        if(!result.contains(edge)) {
                            priorityQueue.insert(edge.getName(), edge.getCost());
                        }
                    }
                }
            }
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
//        System.out.println(result);
            System.out.println(j + "    "+ insertCompares + "   " + timeElapsed);
            insertCompares = 0;
        }
    }
}
