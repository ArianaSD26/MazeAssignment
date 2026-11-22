
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MazeFrame extends JFrame{
	private Maze maze;
	
	public MazeFrame(Maze m) {
		maze = m;
		MazeGenerator g = new MazeGenerator(maze);
		MazeCanvas c = new MazeCanvas(maze);
		
		setTitle("My Perfect Maze!");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(c);
		
		Timer t = new Timer(100, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				g.generate();
				c.repaint();
			}
		});
		
		t.start();
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze(10,10);
		new MazeFrame(maze).setVisible(true);
	}
}
