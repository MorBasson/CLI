package model;

public interface Model {
	/**
	 * The model will be responsible for the operations of the various algorithms
	 * 
	 * @author Mor Basson & Reut Sananes
	 * @version 1.0
	 */

	 public void displayMaze(String nameMaze);
	 public void displayCrossSectionBy(String by, String nameMaze, int index);
	 public void saveMaze(String nameMaze, String fileName);
	 public void loadMaze(String fileName, String nameMaze);
	 public void solveMaze(String nameMaze, String nameAlgorithms);
	 public void displaySolution(String nameMaze);
	 public void exit();
	public void generate(String mazeName, int x, int y, int z);
	public void errorMas(String string);


	
}
