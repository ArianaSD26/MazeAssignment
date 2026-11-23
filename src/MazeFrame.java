
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeFrame extends JFrame{
	private Maze maze;
	private Timer t1, t2;
	
	public MazeFrame(Maze m) {
		maze = m;
		MazeGenerator g = new MazeGenerator(maze);
		MazeSolver s = new MazeSolver(maze);
		MazeCanvas c = new MazeCanvas(maze, g, s);
		
		setTitle("My Perfect Maze!");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		
		t1 = new Timer(100, new ActionListener() {
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
					
					t2 = new Timer(100, new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							s.solve();
							c.repaint();
						}
					});
					
					t2.start();
				}
			}
		});
		
		t1.start();
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze(10, 10);
		new MazeFrame(maze).setVisible(true);
	}
}
