
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * GUI using Java Swing
 */
public class MazeFrame extends JFrame{
	/**
	 * Declared variables for maze and timers for generate and solver
	 */
	private Maze maze;
	private Timer t1, t2;
	
	/**
	 * Constructs a maze frame with the specified maze, generator, solver and canvas as well as timers to delay the algorithms
	 * @param m
	 */
	public MazeFrame(Maze m) {
		maze = m;
		MazeGenerator g = new MazeGenerator(maze);
		MazeSolver s = new MazeSolver(maze);
		MazeCanvas c = new MazeCanvas(maze, g, s);
		
		setTitle("My Perfect Maze!");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		
		t1 = new Timer(50, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c.setSolve(false);
				c.setGenerate(true);
				g.generate();
				c.repaint();
				
				if(g.getStack().isEmpty() && g.getCurrent().getNeighbour(maze) == null) {
					t1.stop();
					
					for(int i=0; i<maze.getN(); i++) {
						for(int j=0; j<maze.getM(); j++) {
							maze.getCell(i, j).setVisited(false);
						}
					}
					
					c.setGenerate(false);
					c.setSolve(true);
					
					t2 = new Timer(50, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							s.solve();
							c.repaint();
							
							if(s.getCurrent() == maze.getCell(maze.getN()-1, maze.getM()-1)) {
								t2.stop();
								s.findPath();
								c.repaint();
							}
						}
					});
					
					t2.start();
				}
			}
		});
		
		t1.start();
	}
	
	/**
	 * Creates the maze and displays the program
	 * @param args
	 */
	public static void main(String[] args) {
		Maze maze = new Maze(10, 10);
		new MazeFrame(maze).setVisible(true);
	}
}
