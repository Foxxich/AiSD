import java.util.*;
import java.lang.*;
import java.io.*;

class Kruskal {

    private static long timeElapsed;

    public static void main(String args[]) throws FileNotFoundException {
        for (int i = 1; i <= 1; i++) {
            PriorityQueue priorityQueue = new PriorityQueue(GraphByEdges.E_NUMBER);
            Set<Edge> result = new LinkedHashSet<>();
            GraphByEdges graph = new GraphByEdges();
            Set<String> visitedNodes = new LinkedHashSet<>();

            for (Edge edge:
                    graph.getEdges()) {
                priorityQueue.insert(edge.getName(), edge.getCost());
            }
            long startTime = System.nanoTime();
            while (visitedNodes.size() != GraphByEdges.V_NUMBER) {
                Task minTask = priorityQueue.pop();
                Edge newEdge = graph.getEdgeByName(minTask.name);
                result.add(newEdge);//dodajemy do drzewa
                if (ifGraphHasCycle(result)) {
                    result.remove(newEdge);
                }
                else {
                    visitedNodes.add(newEdge.getSource());
                    visitedNodes.add(newEdge.getDestination());
                }
            }
            long endTime = System.nanoTime();
            timeElapsed = endTime - startTime;
            System.out.println(result);
            System.out.println(i+"   "+ timeElapsed);
        }
    }

    private static boolean ifGraphHasCycle(Set<Edge> result) {
        List<String> visitedNodes = new LinkedList<>();
        List<Edge> visitedEdges = new LinkedList<>();
        if(!result.isEmpty()) {
            for (Edge edge:
                 result) {
                if(deepSearch(edge.getSource(), result, visitedNodes, visitedEdges)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean deepSearch(String node, Set<Edge> result, List<String> visitedNodes, List<Edge> visitedEdges) {
        List<Edge> adjacentEdges = Utils.findAdjacentEdges(node, result, visitedEdges);
        for (Edge edge:
             adjacentEdges) {
            String nextNode = Utils.getNextNodeFromEdge(node, edge);
            visitedEdges.add(edge);
            if(nodeWasVisited(nextNode, visitedNodes)) {
                return true;
            } else {
                visitedNodes.add(nextNode);
                deepSearch(nextNode, result, visitedNodes, visitedEdges);
            }
        }
        return false;
    }

    private static boolean nodeWasVisited(String nextNode, List<String> visitedNodes) {
        return visitedNodes.contains(nextNode);
    }
}
