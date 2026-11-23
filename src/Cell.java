
import java.awt.*;
import java.util.*;

public class Cell {
	private boolean top, bottom, left, right, visited;
	private int row, col;
	private Maze maze;
	private Cell parent;
	
	public Cell(int r, int c) {
		top = bottom = left = right = true;
		visited = false;
		row = r;
		col = c;
	}
	
	public boolean getTop() {
		return top;
	}
	
	public void setTop(boolean t) {
		top = t;
	}
	
	public boolean getBottom() {
		return bottom;
	}
	
	public void setBottom(boolean b) {
		bottom = b;
	}
	
	public boolean getLeft() {
		return left;
	}
	
	public void setLeft(boolean l) {
		left = l;
	}
	
	public boolean getRight() {
		return right;
	}
	
	public void setRight(boolean r) {
		right = r;
	}
	
	public boolean getVisited() {
		return visited;
	}
	
	public void setVisited(boolean v) {
		visited = v;
	}
	
	public int getRow() {
		return row;
	}
	
	public void setRow(int r) {
		row = r;
	}
	
	public int getCol() {
		return col;
	}
	
	public void setCol(int c) {
		col = c;
	}
	
	public Cell getParent() {
		return parent;
	}
	
	public void setParent(Cell p) {
		parent = p;
	}
	
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
