
import javax.swing.*;

public class MazeFrame extends JFrame{
	private Maze maze;
	
	public MazeFrame(Maze m) {
		maze = m;
		
		setTitle("My Perfect Maze!");
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MazeCanvas(maze));
	}
	
	public static void main(String[] args) {
		Maze maze = new Maze(10,10);
		new MazeFrame(maze).setVisible(true);
	}
}
