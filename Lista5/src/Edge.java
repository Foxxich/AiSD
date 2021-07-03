public class Edge {
    private String source;
    private String destination;
    private double cost;
    private String name;

    public Edge(String source, String destination, double cost, String name) {
        this.source = source;
        this.destination = destination;
        this.cost = cost;
        this.name = name;
    }

    public Edge(int source, int destination, double cost, int name) {
        this.source = Integer.toString(source);
        this.destination = Integer.toString(destination);
        this.cost = cost;
        this.name = Integer.toString(name);
    }

    public boolean isAdjacent(String name) {
        return source.equals(name) || destination.equals(name);
    }

    public boolean isDuplicatedBy(Edge edge) {
        return destination.equals(edge.getDestination()) && source.equals(edge.getSource()) ||
            source.equals(edge.getDestination()) && destination.equals(edge.getSource());
    }

    @Override
    public String toString() {
        return name+": "+source+" - "+destination+", "+cost+"\n";
    }

    public double getCost() {
        return cost;
    }

    public String getName() {
        return name;
    }

    public String getDestination() {
        return destination;
    }

    public String getSource() {
        return source;
    }
}
