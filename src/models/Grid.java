package models;
import java.util.*;

// manages the 2d grid of cells
public class Grid {
    private final int rows;
    private final int cols;
    private final Cell[][] cells;
    private final Random random;  // for generating random edge weights

    public  Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.cells= new Cell[rows][cols];
        this.random = new Random();
        // create all the cells first
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                this.cells[i][j]=new Cell(i,j);
            }
        }
        // then connect them with edges
        buildEdges();
    }
    
    // creates random weighted edges between neighboring cells
    // each edge gets a random weight from 1-10
    private void buildEdges() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                Cell cell = cells[r][c];
                
                // check all 4 directions and add edges with random weights
                // left neighbor
                if (inBounds(r, c - 1)) {
                    Cell neighbor = cells[r][c - 1];
                    int weight = random.nextInt(1,10); // Random weight 0-10
                    if (weight > 0) {
                        cell.addEdge(new Edge(neighbor, weight));
                    }
                }
                // Right
                if (inBounds(r, c + 1)) {
                    Cell neighbor = cells[r][c + 1];
                    int weight = random.nextInt(1,10); // Random weight 0-10
                    if (weight > 0) {
                        cell.addEdge(new Edge(neighbor, weight));
                    }
                }
                // Up
                if (inBounds(r - 1, c)) {
                    Cell neighbor = cells[r - 1][c];
                    int weight = random.nextInt(1,10); // Random weight 0-10
                    if (weight > 0) {
                        cell.addEdge(new Edge(neighbor, weight));
                    }
                }
                // Down
                if (inBounds(r + 1, c)) {
                    Cell neighbor = cells[r + 1][c];
                    int weight = random.nextInt(1,10); // Random weight 0-10
                    if (weight > 0) {
                        cell.addEdge(new Edge(neighbor, weight));
                    }
                }
            }
        }
    }
    
    // wipes all edges and rebuilds them from scratch
    // useful when walls change
    public void rebuildEdges() {
        // remove all current edges
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c].clearEdges();
            }
        }
        // make new ones
        buildEdges();
    }
    public int getRows() {
        return rows;
    }
    public int getCols() {
        return cols;
    }
    public Cell[][] getCells() {
        return cells;
    }
    public Cell getCell(int i, int j) {
        if(!inBounds(i,j)) return null;
        return cells[i][j];
    }

    public boolean inBounds(int i, int j) {
        return i>=0 && i<rows && j>=0 && j<cols;
    }

    // gets all 4-directional neighbors of a cell
    // used by bfs/dfs which don't use the edge system
    public List<Cell> getNeighbors(Cell cell) {

        if (inBounds(cell.getRow(), cell.getCol())){

            List<Cell> res = new ArrayList<>();
            if (inBounds( cell.getRow(), cell.getCol() - 1)) {
                res.add(cells[cell.getRow()][cell.getCol() - 1]);
            }
            if (inBounds( cell.getRow(), cell.getCol() + 1)) {
                res.add(cells[cell.getRow()][cell.getCol() + 1]);
            }
            if (inBounds( cell.getRow()-1, cell.getCol())) {
                res.add(cells[cell.getRow() - 1][cell.getCol()]);
            }
            if (inBounds( cell.getRow()+1, cell.getCol())) {
                res.add(cells[cell.getRow() + 1][cell.getCol()]);
            }
            return res;
        }
        return null;
    }
    public void resetSearchState() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                cells[r][c].resetSearchState();
            }
        }
    }



}
