
import java.util.ArrayList;

public class MazeSolver {
	private Cell current;
	private Maze maze;
	private ArrayList<Cell> neighbours;
	private ArrayList<Cell> path;
	private Queue queue;
	
	public MazeSolver(Maze m) {
		maze = m;
		current = maze.getCell(0, 0);
		path = new ArrayList<Cell>();
		queue = new Queue();
	}
	
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
	
	public void getWinningPath() {
		Cell c = maze.getCell(maze.getN()-1, maze.getM()-1);
		
		while(c != null) {
			path.add(c);
			c = c.getParent();
		}
	}
	
	public ArrayList<Cell> getPath() {
		return path;
	}
	
	public Cell getCurrent() {
		return current;
	}
}
