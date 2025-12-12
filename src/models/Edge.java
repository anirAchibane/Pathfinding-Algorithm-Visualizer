package models;

// represents a connection between two cells
public class Edge {
    private final Cell destination;  // where this edge leads to
    private double weight;  // cost to traverse this edge

    public Edge(Cell destination, double weight) {
        this.destination = destination;
        this.weight = weight;
    }

    public Cell getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
