
/**
 * Generates a maze using Randomized Depth-First Search with Backtracking
 */
public class MazeGenerator {
	/**
	 * Declares variables for the current cell, maze, and stack
	 */
	private Cell current;
	private Maze maze;
	private Stack stack;
	
	/**
	 * Constructs a maze generator with a specified maze, starting on cell (0,0) and a stack
	 * @param m the maze to generate
	 */
	public MazeGenerator(Maze m) {
		maze = m;
		current = m.getCell(0, 0);
		stack = new Stack();
	}
	
	/**
	 * Gets the current cell
	 * @return the current cell
	 */
	public Cell getCurrent() {
		return current;
	}
	
	/**
	 * Gets the stack
	 * @return the stack
	 */
	public Stack getStack() {
		return stack;
	}
	
	/**
	 * Generates the maze using DFS and a stack by finding random neighbours and removing walls
	 */
	public void generate() {
		current.setVisited(true);
		Cell neighbour = null;
		
		if(current != maze.getCell(maze.getN()-1, maze.getM()-1)) {
			neighbour = current.getNeighbour(maze);
		}

		if(neighbour != null) {
			neighbour.setVisited(true);
			stack.push(current);
			removeWalls(current, neighbour);
			current = neighbour;
		}
		else if (!stack.isEmpty()) {
			current = (Cell) stack.pop();
		}

	}
	
	/**
	 * Removes walls of the current and neighbouring cell
	 * @param c current cell
	 * @param n neighbouring cell
	 */
	private void removeWalls(Cell c, Cell n) {
		int row = n.getRow() - c.getRow();
		int col = n.getCol() - c.getCol();
		
		if(row == -1) {
			c.setTop(false);
			n.setBottom(false);
		}
		if(row == 1) {
			c.setBottom(false);
			n.setTop(false);
		}
		if(col == -1) {
			c.setLeft(false);
			n.setRight(false);
		}
		if(col == 1) {
			c.setRight(false);
			n.setLeft(false);
		}
	}
}
