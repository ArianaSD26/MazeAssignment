
public class Maze {
	private int N, M;
	private Cell[][] grid;
	
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
	
	public int getN() {
		return N;
	}
	
	public void setN(int n) {
		N = n;
	}
	
	public int getM() {
		return M;
	}
	
	public void setM(int m) {
		M = m;
	}
	
	public Cell getCell(int r, int c) {
		if (r < 0 || c < 0 || r >= N || c >= M) {
			return null;
		}
		
		return grid[r][c];
	}
}
