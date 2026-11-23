
import java.util.ArrayList;

public class MazeSolver {
	private Cell current;
	private Maze maze;
	private ArrayList<Cell> neighbours;
	
	public MazeSolver(Maze m) {
		maze = m;
		current = maze.getCell(0, 0);
	}
	
	public void solve() {
		current.setVisited(true);
		
		neighbours = getNeighbours(current);
		
		for(Cell neighbour : neighbours) {
			if(neighbour != null) {
				neighbour.setVisited(true);
				current = neighbour;
			}
			
		}
	}
	
	public ArrayList<Cell> getNeighbours(Cell c) {
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
	
	public Cell getCurrent() {
		return current;
	}
}
