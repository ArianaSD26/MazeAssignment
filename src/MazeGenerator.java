import java.awt.Color;

public class MazeGenerator {
	private Cell current;
	private Maze maze;
	
	public MazeGenerator(Maze m) {
		maze = m;
		current = m.getCell(0, 0);
	}
	
	public void generate() {
		current.setVisited(true);
		Cell neighbour = current.getNeighbour(maze);
		if(neighbour != null) {
			neighbour.setVisited(true);
			removeWalls(current, neighbour);
			current = neighbour;
		} 
	}
	
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
	
	public Cell getCurrent() {
		return current;
	}
	
	public void setCurrent(Cell c) {
		current = c;
	}
	
}
