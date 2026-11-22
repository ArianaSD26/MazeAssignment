
public class MazeGenerator {
	private Cell current;
	private Maze maze;
	
	public MazeGenerator(Maze m) {
		maze = m;
		current = m.getCell(0, 0);
	}
	
	public void generate() {
		current.setVisited(true);
		Cell neighbour = current.getNeighbour(maze);
		if(neighbour != null) {
			neighbour.setVisited(true);
			current = neighbour;
		} 
	}
	
}
