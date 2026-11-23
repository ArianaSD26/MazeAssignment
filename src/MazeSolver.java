
import java.util.ArrayList;

/**
 * Solves the maze using Breadth-First Search 
 */
public class MazeSolver {
	/**
	 * Declares variables for current cell, maze, neighbours, path and queue
	 */
	private Cell current;
	private Maze maze;
	private ArrayList<Cell> neighbours;
	private ArrayList<Cell> path;
	private Queue queue;
	
	/**
	 * Constructs a maze solver with a specified maze, starting on cell (0,0) and queue
	 * @param m
	 */
	public MazeSolver(Maze m) {
		maze = m;
		current = maze.getCell(0, 0);
		path = new ArrayList<Cell>();
		queue = new Queue();
	}
	
	/**
	 * Gets path
	 * @return the winning path
	 */
	public ArrayList<Cell> getPath() {
		return path;
	}
	
	/**
	 * Gets current
	 * @return the current cell
	 */
	public Cell getCurrent() {
		return current;
	}
	
	/**
	 * Solves the maze using BFS and a queue by finding neighbours and the parent cell to create a path
	 */
	public void solve() {
		current.setVisited(true);
		
		neighbours = getNeighbours(current);
		
		for(Cell neighbour : neighbours) {
			neighbour.setVisited(true);
			neighbour.setParent(current);
			queue.enqueue(neighbour);
		}
		
		if(!queue.isEmpty()) {
			current = (Cell) queue.dequeue();
		}
	}
	
	/**
	 * Gets neighbours of the current cell
	 * @param c the current cell
	 * @return list of neighbours
	 */
	private ArrayList<Cell> getNeighbours(Cell c) {
		neighbours = new ArrayList<Cell>();
		
		Cell top = maze.getCell(c.getRow()-1, c.getCol());
		Cell bottom = maze.getCell(c.getRow()+1, c.getCol());
		Cell left = maze.getCell(c.getRow(), c.getCol()-1);
		Cell right = maze.getCell(c.getRow(), c.getCol()+1);
		
		if(top != null && !top.getVisited() && !c.getTop()) {
			neighbours.add(top);
		}
		if(bottom != null && !bottom.getVisited() && !c.getBottom()) {
			neighbours.add(bottom);
		}
		if(left != null && !left.getVisited() && !c.getLeft()) {
			neighbours.add(left);
		}
		if(right != null && !right.getVisited() && !c.getRight()) {
			neighbours.add(right);
		}
		
		return neighbours;
	}
	
	/**
	 * Gets the winning path by storing the parent cells
	 */
	public void findPath() {
		Cell c = maze.getCell(maze.getN()-1, maze.getM()-1);
		
		while(c != null) {
			path.add(c);
			c = c.getParent();
		}
	}
}
