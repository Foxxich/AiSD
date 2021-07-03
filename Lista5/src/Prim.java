import java.io.FileNotFoundException;
import java.util.LinkedHashSet;
import java.util.Set;

public class Prim {

    private static long timeElapsed;

    public static void main(String args[]) throws FileNotFoundException {
        for (int i = 1; i <= 50; i++) {
            PriorityQueue priorityQueue = new PriorityQueue(GraphByEdges.E_NUMBER);
            Set<Edge> result = new LinkedHashSet<>();
            GraphByEdges graph = new GraphByEdges();
            Set<String> visitedNodes = new LinkedHashSet<>();

            for (Edge edge:
                    graph.getAdjacentEdges("0")) {
                priorityQueue.insert(edge.getName(), edge.getCost());
            }
            priorityQueue.print();
            visitedNodes.add("0");
            long startTime = System.nanoTime();
            while (visitedNodes.size() != GraphByEdges.V_NUMBER) {
                Task minTask = priorityQueue.pop();
                Edge newEdge = graph.getEdgeByName(minTask.name);
                if(Utils.isNodeNotVisited(newEdge,visitedNodes)) {
                    result.add(newEdge);//dodajemy do drzewa
                    String newNode = newEdge.getSource();
                    if(!visitedNodes.add(newNode)) {
                        newNode = newEdge.getDestination();
                        visitedNodes.add(newNode);
                    }
                    for (Edge edge:
                            graph.getAdjacentEdges(newNode)) {
                        if(!result.contains(edge)) {
                            priorityQueue.insert(edge.getName(), edge.getCost());
                        }
                    }
                }
            }
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
//            System.out.println(result);
            System.out.println(i+"   "+ timeElapsed);
        }
    }
}
