# Pathfinding Algorithm Visualizer (JavaFX)

A desktop **JavaFX** application that visualizes classic **pathfinding algorithms** on a **2D grid**.  
You can place **walls**, generate a **random maze**, optionally display **edge weights**, and run algorithms step-by-step with adjustable animation speed.

---

## Features

- **Interactive grid**
  - Click to toggle **walls**
  - (Optional) Shift + Click to cycle terrain (if enabled in your build)
- **Algorithms**
  - BFS (Breadth-First Search)
  - DFS (Depth-First Search)
  - Dijkstra (weighted shortest path)
  - A* (A-star) with Manhattan heuristic
- **Visualization**
  - Highlights **open set**, **closed set**, and **final path**
  - Displays **path cost** and **number of steps** when done
- **Tools**
  - **Generate Maze** (random walls ~30%)
  - **Show/Hide Weights**
  - **Reset Grid**

---

## How it works (short)

- The grid is modeled as a graph:
  - Nodes = cells `(row, col)`
  - Directed edges to the 4 neighbors (up/down/left/right)
  - Each directed edge gets a random weight in **[1, 9]**
- Algorithms run in **step-by-step mode** (one iteration per tick) using a JavaFX `Timeline`.

---

## Requirements

- **Java**: 17+ recommended  
- **JavaFX**: compatible with your Java version
- IDE: IntelliJ / Eclipse / VS Code (any)

---

## Project structure

```

src/
controllers/
MainController.java
models/
Grid.java
Cell.java
Edge.java
Pathfinding.java
BFS.java
DFS.java
Dijkstra.java
Astar.java
views/
PathApp.java

````

---

## Run the project

### Option A — From IDE
1. Open the project in your IDE.
2. Make sure JavaFX is configured in your project settings.
3. Run the main entry point:
   - `controllers.MainController`  
   *(or run `views.PathApp` if your setup allows it)*

### Option B — From command line (generic)
If you use JavaFX SDK locally, run with module path (adjust paths and version):

```bash
java --module-path /path/to/javafx/lib --add-modules javafx.controls,javafx.fxml -cp out/production/YourProject controllers.MainController
````

> If you're using Maven/Gradle, your run command depends on your build file.

---

## Usage

1. Set **Start** and **Goal** coordinates using the format:

   * `row,col` (example: `0,0`)
2. Click on cells to add/remove walls.
3. Choose an algorithm:

   * **Run BFS / DFS / Dijkstra / A***
4. Adjust the **animation speed** with the slider.
5. Optional:

   * Generate a maze
   * Show/hide weights
   * Reset the grid

---

## Notes / Limitations

* Dijkstra and A* currently use a **linear scan** over the open set (not a heap-based priority queue), so performance may drop on very large grids.
* 
---
