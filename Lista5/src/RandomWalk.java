import java.io.FileNotFoundException;
import java.util.*;

public class RandomWalk {

    private static final Random RANDOM = new Random();
    public static final int SIZE = 500;//max 1000
    private static long timeElapsed;

    public static void main(String args[]) throws FileNotFoundException {
        for (int k = 1; k <= 1; k++) {
            List<Edge> result = new LinkedList<>();
            List<String> allVisitedNodes = new LinkedList<>();
            GraphByEdges graph = new GraphByEdges();
            Set<String> visitedNodes = new LinkedHashSet<>();
            String startNode = "0";
            Edge lastEdge = null;

            graph.generateClique(SIZE);
            long startTime = System.nanoTime();
            while(visitedNodes.size() != SIZE) {
                visitedNodes.add(startNode);
                allVisitedNodes.add(startNode);

                List<Edge> adjacentEdges = graph.getAdjacentEdges(startNode);
                adjacentEdges.remove(lastEdge);

                lastEdge = drawEdge(adjacentEdges);
                startNode = Utils.getNextNodeFromEdge(startNode, lastEdge);

                result.add(lastEdge);
            }
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
//        System.out.println(result);
//        System.out.println("__________RESULT_________");
//        System.out.println(visitedNodes);
//        System.out.println("__________VISITED_NODES_________");
//        System.out.println(allVisitedNodes);
//        System.out.println("__________ALL_VISITED_NODES__________");
//        System.out.println(graph.toString());
//        System.out.println("__________ELEMENTS______________");
//        System.out.println(SIZE);
//        System.out.println("__________VISITED_NODE_ELEMENTS_________");
//        System.out.println(visitedNodes.size());
//        System.out.println("__________ALL_VISITED_NODES__________");
//        System.out.println(allVisitedNodes.size());
//        System.out.println("__________TIME______________");
//        System.out.println(timeElapsed+"        "+timeElapsed/1000000.);
            System.out.println(k+"   "+timeElapsed+"    "+allVisitedNodes.size());
        }
    }

    private static Edge drawEdge(List<Edge> adjacentEdges) {
        int numberOfEdges = adjacentEdges.size();
        int nextInt = RANDOM.nextInt(numberOfEdges);
        return adjacentEdges.get(nextInt);
    }
}
