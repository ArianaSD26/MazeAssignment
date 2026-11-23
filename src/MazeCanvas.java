
import java.awt.*;

import javax.swing.*;

public class MazeCanvas extends JPanel {
	private Maze maze;
	private MazeGenerator generator;
	private MazeSolver solver;
	private boolean generate, solve;
	
	public MazeCanvas(Maze m, MazeGenerator g, MazeSolver s) {
		maze = m;
		generator = g;
		solver = s;
		generate = solve = false;
	}
	
	public boolean getGenerate() {
		return generate;
	}
	
	public void setGenerate(boolean g) {
		generate = g;
	}
	
	public boolean getSolve() {
		return solve;
	}
	
	public void setSolve(boolean s) {
		solve = s;
	}
	
	private void drawCell(Graphics g, Cell c, int top, int left, int cd) {
		top = top + 5;
		left = left + 5;
		
		if(generate) {
			if(c.getVisited()) {
				g.setColor(new Color(225, 225, 225));
				g.fillRect(left, top, cd, cd);
			}
		
			if(c == generator.getCurrent()) {
				g.setColor(Color.GRAY);
				g.fillRect(left, top, cd, cd);
			}
		}
		
		if(solve) {
			if(c.getVisited()) {
				g.setColor(new Color(255, 204, 238));
				g.fillRect(left, top, cd, cd);
			}
			
			if(c == solver.getCurrent()) {
				g.setColor(new Color(255, 102, 204));
				g.fillRect(left, top, cd, cd);
			}
		}
		
		if(c == maze.getCell(0, 0)) {
			g.setColor(new Color(255, 215, 0));
			g.fillRect(left, top, cd, cd);
		}
		
		if(c == maze.getCell(maze.getN()-1, maze.getM()-1)) {
			g.setColor(Color.CYAN);
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
