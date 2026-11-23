
import java.awt.*;

import javax.swing.*;

/**
 * Custom drawing panel that renders the maze and visual states
 */
public class MazeCanvas extends JPanel {
	/**
	 * Declares variables for maze, generator, solver and whether the program is generating or solving
	 */
	private Maze maze;
	private MazeGenerator generator;
	private MazeSolver solver;
	private boolean generate, solve;
	
	/**
	 * Constructs a canvas with the specified maze, generator and solver as well as not generating or solving
	 * @param m the maze
	 * @param g the maze generator
	 * @param s the maze solver
	 */
	public MazeCanvas(Maze m, MazeGenerator g, MazeSolver s) {
		maze = m;
		generator = g;
		solver = s;
		generate = solve = false;
	}
	
	/**
	 * Gets generate
	 * @return true if the program is generating or false if not
	 */
	public boolean getGenerate() {
		return generate;
	}
	
	/**
	 * Sets generate
	 * @param g takes in whether the program is generating
	 */
	public void setGenerate(boolean g) {
		generate = g;
	}
	
	/**
	 * Gets solve
	 * @return true if the program is solving or false if not
	 */
	public boolean getSolve() {
		return solve;
	}
	
	/**
	 * Sets solve
	 * @param s takes in whether the program is solving
	 */
	public void setSolve(boolean s) {
		solve = s;
	}
	
	/**
	 * Draws a cell of the maze
	 * @param g the graphics
	 * @param c the cell
	 * @param top the y position
	 * @param left the x position
	 * @param cd the cell dimensions
	 */
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
				g.setColor(new Color(207, 159, 255));
				g.fillRect(left, top, cd, cd);
			}
			
			if(c == solver.getCurrent()) {
				g.setColor(new Color(157, 78, 221));
				g.fillRect(left, top, cd, cd);
			}
			
			for(Cell path : solver.getPath()) {
				if(c == path) {
					g.setColor(new Color(157, 78, 221));
					g.fillOval(left+10, top+10, cd-20, cd-20);
				}
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
	
	/**
	 * Paints the maze in the GUI
	 * @param g the graphics
	 */
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
