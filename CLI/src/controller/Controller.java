package controller;

import model.Model;

public interface Controller {


	/**
	 * The Controller Responsible for transferring commands between them
	 * 
	 * @author Mor Basson & Reut Sananes
	 * @version 1.0
	 */
	public void displayArr(String[] arr);
	public void displayByteArr(byte[] b);
	public void displayMaze(String message);
	public void generate(String nameMaze, int x, int y, int z);
	public void displayCrossSectionBy(String by, String nameMaze, int index);
	public void saveMaze(String nameMaze, String fileName);
	public void loadMaze(String fileName, String nameMaze);
	public void solveMaze(String nameMaze, String nameAlgorithms);
	public void displaySolution(String nameMaze);
	public void exit();
	public void display(String nameMaze);
	public Model getModel();

	

	
}
