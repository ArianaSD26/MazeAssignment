
import java.util.*;

/**
 * An individual cell in the maze
 */
public class Cell {
	/**
	 * Declares variables for cell walls, whether it was visited, position (x, y) and the cell's parent
	 */
	private boolean top, bottom, left, right, visited;
	private int row, col;
	private Cell parent;
	
	/**
	 * Constructs the cell with all four walls and not visited
	 * @param r The row of the position of the cell
	 * @param c The column of the position of the cell
	 */
	public Cell(int r, int c) {
		top = bottom = left = right = true;
		visited = false;
		row = r;
		col = c;
	}
	
	/**
	 * Gets the top wall
	 * @return true if the cell has a top wall and false if the cell doesn't have a top wall
	 */
	public boolean getTop() {
		return top;
	}
	
	/**
	 * Sets the top wall
	 * @param t takes in whether the wall exists or not
	 */
	public void setTop(boolean t) {
		top = t;
	}
	
	/**
	 * Gets the bottom wall
	 * @return true if the cell has a bottom wall and false if the cell doesn't have a bottom wall
	 */
	public boolean getBottom() {
		return bottom;
	}
	
	/**
	 * Sets the bottom wall
	 * @param t takes in whether the wall exists or not
	 */
	public void setBottom(boolean b) {
		bottom = b;
	}
	
	/**
	 * Gets the left wall
	 * @return true if the cell has a left wall and false if the cell doesn't have a left wall
	 */
	public boolean getLeft() {
		return left;
	}
	
	/**
	 * Sets the left wall
	 * @param t takes in whether the wall exists or not
	 */
	public void setLeft(boolean l) {
		left = l;
	}
	
	/**
	 * Gets the right wall
	 * @return true if the cell has a right wall and false if the cell doesn't have a right wall
	 */
	public boolean getRight() {
		return right;
	}
	
	/**
	 * Sets the right wall
	 * @param t takes in whether the wall exists or not
	 */
	public void setRight(boolean r) {
		right = r;
	}
	
	/**
	 * Gets whether the cell is visited
	 * @return true if the cell has been visited and false if not
	 */
	public boolean getVisited() {
		return visited;
	}
	
	/**
	 * Sets whether the cell is visited
	 * @param v takes in whether the cell has been visited
	 */
	public void setVisited(boolean v) {
		visited = v;
	}
	
	/**
	 * Gets the row
	 * @return the row number of the cell
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Gets the column
	 * @return the column number of the cell
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Gets the parent of the cell
	 * @return the parent cell
	 */
	public Cell getParent() {
		return parent;
	}
	
	/**
	 * Sets the parent of the cell
	 * @param p takes in the parent cell
	 */
	public void setParent(Cell p) {
		parent = p;
	}
	
	/**
	 * Gets a random neighbour of the current cell
	 * @param m takes in the maze
	 * @return a random neighbour cell or null if there are none
	 */
	public Cell getNeighbour(Maze m) {
		ArrayList<Cell> neighbours = new ArrayList<Cell>();
		Random r = new Random();
		
		Cell top = m.getCell(row-1, col);
		Cell bottom = m.getCell(row+1, col);
		Cell left = m.getCell(row, col-1);
		Cell right = m.getCell(row, col+1);
		
		if(top != null && !top.visited)
			neighbours.add(top);
		if(bottom != null && !bottom.visited)
			neighbours.add(bottom);
		if(left != null && !left.visited)
			neighbours.add(left);
		if(right != null && !right.visited)
			neighbours.add(right);
		
		if(neighbours.size() > 0) {
			int i = r.nextInt(neighbours.size());
			return neighbours.get(i);
		}
		else {
			return null;
		}
	}
}
