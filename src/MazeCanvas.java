
import java.awt.*;

public class MazeCanvas extends Canvas {
	private Maze maze;
	
	public MazeCanvas(Maze m) {
		maze = m;
	}
	
	private void drawCell(Graphics g, Cell c, int top, int left, int cd) {
		top = top + 5;
		left = left + 5;
		
		if(c.getTop())
			g.drawLine(left, top, left+cd, top);
		if(c.getBottom())
			g.drawLine(left, top+cd, left+cd, top+cd);
		if(c.getLeft())
			g.drawLine(left,  top,  left, top+cd);
		if(c.getRight())
			g.drawLine(left+cd,  top,  left+cd, top+cd);
	}
	
	@Override
	public void paint(Graphics g) {
		int w = getWidth();
		int h = getHeight();
		
		int cell_dim;
		if(w < h)
			cell_dim = w/maze.getN();
		else
			cell_dim = h/maze.getM();
		
		for(int i=0; i<maze.getN(); i++) {
			for(int j=0; j<maze.getM(); j++) {
				drawCell(g, maze.getCell(i,j), i*cell_dim, j*cell_dim, cell_dim);
			}
		}
	}
}
