package models;

import java.util.ArrayList;
import java.util.List;

// represents a single cell in the grid
public class Cell {
    // different terrain types with their movement costs
    public enum TerrainType {
        NORMAL(1.0),      // white, normal cost
        SAND(2.0),        // yellowish, bit slower
        WATER(5.0),       // blue, much slower
        MOUNTAIN(10.0),   // brown, really slow
        WALL(Double.POSITIVE_INFINITY);  // black, can't pass through

        private final double cost;

        TerrainType(double cost) {
            this.cost = cost;
        }

        public double getCost() {
            return cost;
        }
    }

    private final int row;
    private final int col;

    private TerrainType terrain;
    private boolean wall;  // is this cell a wall?
    private boolean visited;  // have we checked this cell yet?
    private boolean inOpenSet;  // waiting to be explored
    private boolean inClosedSet;  // already explored
    private boolean inPath;  // part of the final path

    private Cell parent;  // where we came from
    private double distance;  // cost to reach this cell
    
    // stores connections to neighboring cells with weights
    private List<Edge> edges;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.terrain = TerrainType.NORMAL;  // start as normal terrain
        this.edges = new ArrayList<>();
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isWall() {
        return wall;
    }

    public void setWall(boolean wall) {
        this.wall = wall;
        if (wall) {
            this.terrain = TerrainType.WALL;
        }
    }

    public TerrainType getTerrain() {
        return terrain;
    }

    public void setTerrain(TerrainType terrain) {
        this.terrain = terrain;
        this.wall = (terrain == TerrainType.WALL);
    }

    public double getTerrainCost() {
        return terrain.getCost();
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isInOpenSet() {
        return inOpenSet;
    }

    public void setInOpenSet(boolean inOpenSet) {
        this.inOpenSet = inOpenSet;
    }

    public boolean isInClosedSet() {
        return inClosedSet;
    }

    public void setInClosedSet(boolean inClosedSet) {
        this.inClosedSet = inClosedSet;
    }

    public boolean isInPath() {
        return inPath;
    }

    public void setInPath(boolean inPath) {
        this.inPath = inPath;
    }

    public Cell getParent() {
        return parent;
    }

    public void setParent(Cell parent) {
        this.parent = parent;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    public void clearEdges() {
        this.edges.clear();
    }

    // clears all the search-related stuff so we can run a new search
    public void resetSearchState() {
        visited = false;
        inOpenSet = false;
        inClosedSet = false;
        inPath = false;
        parent = null;
        distance = Double.POSITIVE_INFINITY;
    }

}
