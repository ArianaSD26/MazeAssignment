
/**
 * A data structure to represent a 2D grid of cells 
 */
public class Maze {
	/**
	 * Declares variables for the number of rows and columns of the grid and the grid itself
	 */
	private int N, M;
	private Cell[][] grid;
	
	/**
	 * Constructs the maze with rows and columns and initializes the grid with cells
	 * @param n the number of rows in the maze
	 * @param m the number of columns in the maze
	 */
	public Maze(int n, int m) {
		N = n;
		M = m;
		
		grid = new Cell[N][M];
		
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				grid[i][j] = new Cell(i, j);
			}
		}
	}
	
	/**
	 * Gets the rows
	 * @return the number of rows in the maze
	 */
	public int getN() {
		return N;
	}
	
	/**
	 * Gets the columns
	 * @return the number of columns in the maze
	 */
	public int getM() {
		return M;
	}
	
	/**
	 * Gets a specific cell in the maze
	 * @param r the row position of the cell
	 * @param c the column position of the cell
	 * @return the cell at position (r, c)
	 */
	public Cell getCell(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return null;
		}
		
		return grid[r][c];
	}
}
