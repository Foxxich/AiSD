import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Utils {

    public static List<Edge> findAdjacentEdges(String node, Set<Edge> result, List<Edge> visitedEdges) {
        List<Edge> adjacentEdges = new LinkedList<>();
        for (Edge edge:
                result) {
            if(isEdgeAdjacent(node, edge) && isEdgeUnvisited(visitedEdges, edge)) {
                adjacentEdges.add(edge);
            }
        }
        return adjacentEdges;
    }

    private static boolean isEdgeUnvisited(List<Edge> visitedEdges, Edge edge) {
        return !visitedEdges.contains(edge);
    }

    private static boolean isEdgeAdjacent(String node, Edge edge) {
        return edge.getSource().equals(node) || edge.getDestination().equals(node);
    }

    public static String getNextNodeFromEdge(int intNode, Edge edge) {
        String node = Integer.toString(intNode);
        return getNextNodeFromEdge(node, edge);
    }

    public static String getNextNodeFromEdge(String node, Edge edge) {
        if(edge.getSource().equals(node)) {
            return edge.getDestination();
        } else {
            return edge.getSource();
        }
    }

    public static boolean isNodeNotVisited(Edge newEdge, Set<String> visitedNodes) {
        return !visitedNodes.contains(newEdge.getDestination()) || !visitedNodes.contains(newEdge.getSource());
    }
}
