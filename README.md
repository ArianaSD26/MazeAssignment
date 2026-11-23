# Data Structures and Algorithms Assignment: Maze Generation, Solving, and Visualisation
### How to Compile and Run my Application
To compile and run my application, use Eclipse IDE and import the project.

### Design Choices
- 2 dimensional array to represent a grid of cells.
- Each cell tracks:
  - Walls: top, bottom, left and right - tracks whether a wall exists
  - Visited - tracks whether cell has been visited
  - Row - row position on the grid
  - Column - column position on the grid
  - Parent - the parent cell
- Randomized Depth-First Search with Backtracking using a Stack for the Maze Generator.
- Breadth-First Search using a Queue for the Maze Solver.
- Implemented GUI using Java Swing with JFrame and JPanel and I used timers to allow for Live Animation.
