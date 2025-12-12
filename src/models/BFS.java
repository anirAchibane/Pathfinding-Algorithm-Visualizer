package models;

import java.util.*;

// breadth first search - explores level by level
public class BFS implements Pathfinding{
    private Grid grid;
    private Cell startCell;
    private Cell endCell;
    LinkedList<Cell> queue;  // fifo queue for bfs
    private boolean finished;
    private boolean pathFound;

    @Override
    public void init(Grid grid, Cell start, Cell goal){
        this.grid = grid;
        this.startCell = start;
        this.endCell = goal;

        queue=new LinkedList<>();
        queue.add(startCell);

        finished = false;
        pathFound = false;

        startCell.setVisited(true);
        startCell.setInOpenSet(true);

    }
    @Override
    public boolean step() {
        if (finished) return true;

        // no more cells to check, no path exists
        if (queue.isEmpty()) {
            finished = true;
            pathFound = false;
            return true;
        }

        // grab the next cell from front of queue
        Cell current = queue.removeFirst();
        current.setInOpenSet(false);
        current.setInClosedSet(true);

        // found it!
        if (current == endCell) {
            finished = true;
            pathFound = true;
            markPath();
            return true;
        }

        for (Cell neighbor : grid.getNeighbors(current)) {
            if (!neighbor.isVisited() && !neighbor.isWall()) {
                neighbor.setVisited(true);
                neighbor.setInOpenSet(true);
                neighbor.setParent(current);
                queue.add(neighbor);
            }
        }

        return false; // not finished yet
    }
    @Override
    public boolean isFinished() {
        return finished;
    }

    @Override
    public boolean hasPath() {
        return pathFound;
    }

    @Override
    public List<Cell> getPath() {
        if (!pathFound) return Collections.emptyList();

        List<Cell> path = new ArrayList<>();
        Cell current = endCell;
        while (current != null) {
            path.add(current);
            current = current.getParent();
        }
        Collections.reverse(path);
        return path;
    }

    private void markPath() {
        for (Cell cell : getPath()) {
            cell.setInPath(true);
        }
    }
}
