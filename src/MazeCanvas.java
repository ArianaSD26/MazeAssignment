
import java.awt.*;

import javax.swing.*;

public class MazeCanvas extends JPanel {
	private Maze maze;
	private MazeGenerator generator;
	
	public MazeCanvas(Maze m, MazeGenerator g) {
		maze = m;
		generator = g;
	}
	
	private void drawCell(Graphics g, Cell c, int top, int left, int cd) {
		
		top = top + 5;
		left = left + 5;
		
		if(c.getVisited()) {
			g.setColor(new Color(214, 180, 252));
			g.fillRect(left, top, cd, cd);
		}
		
		if(c == maze.getCell(0, 0)) {
			g.setColor(new Color(255, 215, 0));
			g.fillRect(left, top, cd, cd);
		}
		
		if(c == generator.getCurrent()) {
			g.setColor(new Color(35, 0, 115));
			g.fillRect(left, top, cd, cd);
		}
		
		if(c == maze.getCell(maze.getN(), maze.getM())) {
			g.setColor(new Color(128, 0, 0));
			g.fillRect(left, top, cd, cd);
		}
		
		g.setColor(Color.BLACK);
		
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
	public void paintComponent(Graphics g) {
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
