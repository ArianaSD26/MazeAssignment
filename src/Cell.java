
public class Cell {
	private boolean top, bottom, left, right, visited;
	private int row, col;
	
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
}
