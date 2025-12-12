package models;

import java.util.List;

// basic interface that all pathfinding algos need to implement
public interface Pathfinding {

    // setup the algorithm with grid and start/end points
    void init(Grid grid, Cell start, Cell goal);

    // does one step of the search, returns true when done
    boolean step();

    // checks if we're done searching
    boolean isFinished();

    // did we actually find a path?
    boolean hasPath();

    // gets the final path if one exists
    List<Cell> getPath();
}
