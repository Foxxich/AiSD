import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class GraphByEdges {
    private List<Edge> edgeList = new ArrayList<>();
    private int maxNumberOfEdges = 0;
    private static final int SIZE = 8;//connections
    public static final int E_NUMBER = 14;//SIZE*2 - 2
    public static final int V_NUMBER = 9;//points (connections+1)

    public GraphByEdges(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public GraphByEdges() {
        initGraph();
    }

    public void initGraph() {
//        edgeList.add(new Edge("0","1",4,"A"));
//        edgeList.add(new Edge("1","2",8,"B"));
//        edgeList.add(new Edge("2","3",7,"C"));
//        edgeList.add(new Edge("3","4",9,"D"));
//        edgeList.add(new Edge("4","5",10,"E"));
//        edgeList.add(new Edge("5","6",2,"F"));
//        edgeList.add(new Edge("6","7",1,"G"));
//        edgeList.add(new Edge("7","0",8,"H"));
//        edgeList.add(new Edge("1","7",11,"I"));
//        edgeList.add(new Edge("7","8",7,"J"));
//        edgeList.add(new Edge("2","5",4,"K"));
//        edgeList.add(new Edge("3","5",14,"L"));
//        edgeList.add(new Edge("8","6",6,"M"));
//        edgeList.add(new Edge("2","8",2,"N"));
        for (int i = 1; i <= SIZE; i++) {
            edgeList.add(new Edge(String.valueOf(i-1), String.valueOf(i), PriorityQueueMain.getRandomNumber(1,10), PriorityQueueMain.createRandomWord(5)));
        }
        for (int i = 1; i < SIZE-1; i++) {
            int number = PriorityQueueMain.getRandomNumber(0, SIZE);
            if(number == i) {
                number++;
            }
            Edge newEdge = new Edge(String.valueOf(i), String.valueOf(number), PriorityQueueMain.getRandomNumber(1,10), PriorityQueueMain.createRandomWord(5));
            if(!addUniqueEdgeToList(edgeList, newEdge)) {
                i--;
            }
        }
        System.out.println(edgeList);
        //System.out.println("SIZE "+edgeList.size());
    }

    public List<Edge> getAdjacentEdges(String source) {
        return getAdjacentEdges(source, edgeList);
    }

    public Edge getEdgeByName(String name) {
        for (Edge edge:
                edgeList) {
            if(edge.getName().equals(name)) {
                return edge;
            }
        }
        return null;
    }

    public List<Edge> getEdges() {
        return edgeList;
    }

    public void generateClique(int size) {
        List<Edge> edges = new LinkedList<>();
        maxNumberOfEdges = ((size-1) * size) / 2;
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                edges.add(new Edge(i, j, generateCostForEdge(i, j, edges), i+j));
            }
        }
        edgeList = edges;
        //System.out.println("Generation completed");
    }

    //for clique
    private double generateCostForEdge(int source, int destination, List<Edge> edges) {
        Map<String, Double> costMapForSource = obtainCostMap(source, edges);
        Map<String, Double> costMapForDestination = obtainCostMap(destination, edges);

//        System.out.println("Cost map for source ("+source+") "+costMapForSource);
//        System.out.println("Cost map for destination ("+destination+")"+costMapForDestination);

        double minCost = obtainMinimumCost(costMapForSource, costMapForDestination);
        double maxCost = obtainMaximumCost(costMapForSource, costMapForDestination);
//        System.out.println("Minimum cost: "+minCost);
//        System.out.println("Maximum cost: "+maxCost);

        if(minCost == Double.MAX_VALUE) {
            throw new IllegalStateException("minCost reached upper double bound, restart program!");
        }

        return findNewCost(minCost, maxCost);
    }
    //for clique
    private double findNewCost(double minCost, double maxCost) {
        double maxDiff = 1;
        if (maxCost == 0 && minCost == 0) {
            return ThreadLocalRandom.current().nextDouble();
        } else {
            minCost = Math.nextAfter(minCost, Double.MAX_VALUE);
            return ThreadLocalRandom.current().nextDouble(minCost, maxCost);
        }
    }
    //for clique
    private double obtainMinimumCost(Map<String, Double> costMapForSource, Map<String, Double> costMapForDestination) {
        if(costMapForSource.size() < costMapForDestination.size()) {
            return calculateMinimumCost(costMapForDestination, costMapForSource);
        } else {
            return calculateMinimumCost(costMapForSource, costMapForDestination);
        }
    }
    //for clique
    private double obtainMaximumCost(Map<String, Double> costMapForSource, Map<String, Double> costMapForDestination) {
        if(costMapForSource.size() < costMapForDestination.size()) {
            return calculateMaximumCost(costMapForDestination, costMapForSource);
        } else {
            return calculateMaximumCost(costMapForSource, costMapForDestination);
        }
    }
    //for clique
    private double calculateMinimumCost(Map<String, Double> mapToIterate, Map<String, Double> mapToCompare) {
        double minCost = 0;
        for (String node :
                mapToIterate.keySet()) {
            if(mapToCompare.containsKey(node)) {
                double newCost = Math.abs(mapToIterate.get(node) - mapToCompare.get(node));
                if(newCost > minCost) {
                    minCost = newCost;
                }
            }
        }
        return minCost;
    }

    private double calculateMaximumCost(Map<String, Double> mapToIterate, Map<String, Double> mapToCompare) {
        double maxCost = 0;
        for (String node :
                mapToIterate.keySet()) {
            if(mapToCompare.containsKey(node)) {
                double newCost = mapToIterate.get(node) + mapToCompare.get(node);
                if(newCost > maxCost) {
                    maxCost = newCost;
                }
            }
        }
        return maxCost;
    }

    private Map<String, Double> obtainCostMap(int node, List<Edge> edges) {
        Map<String, Double> result = new HashMap<>();
        for (Edge edge:
             getAdjacentEdges(node, edges)) {
            String nextNodeFromEdge = Utils.getNextNodeFromEdge(node, edge);
            result.put(nextNodeFromEdge, edge.getCost());
        }
        return result;
    }

    private List<Edge> getAdjacentEdges(int intSource, List<Edge> edgeList) {
        String source = Integer.toString(intSource);
        return getAdjacentEdges(source, edgeList);
    }

    private List<Edge> getAdjacentEdges(String source, List<Edge> edgeList) {
        List<Edge> resultList = new LinkedList<>();
        for (Edge edge:
                edgeList) {
            if(edge.isAdjacent(source)) {
                resultList.add(edge);
            }
        }
        return resultList;
    }

    private boolean addUniqueEdgeToList(List<Edge> edgeList, Edge edge) {
        if (!isEdgeAlreadyInList(edgeList, edge)) {
            edgeList.add(edge);
            return true;
        }
        return false;
    }

    private boolean isEdgeAlreadyInList(List<Edge> edgeList, Edge edge) {
        for (Edge edgeFromList:
             edgeList) {
            if(edgeFromList.isDuplicatedBy(edge)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return edgeList.toString();
    }
}
