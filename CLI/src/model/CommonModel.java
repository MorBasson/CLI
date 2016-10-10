package model;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.Solution;
import controller.Controller;

/**
 * The CommonModel program implements an application that organize all
 * the common methods of model methods and implement the methods of the Model interface.
 * @author Mor Basson & Reut Sananes 
 * 
 * 
 */

public abstract class CommonModel implements Model{
	

	protected Controller controller;
	protected HashMap<String, Maze3d> hashMaze;
	protected HashMap<String, Solution<Position>> hashSolution;
	protected ExecutorService threadPool;
	
	private HashMap<String,String> errors=new HashMap<String,String>();
		
	/**
	 * Constructor
	 */
	public CommonModel() {
		this.hashMaze=new HashMap<String, Maze3d>();
		this.setHashSolution(new HashMap<String, Solution<Position>>());
		this.setThreadPool(Executors.newCachedThreadPool());
	}
	
	public abstract void generate(String nameMaze, int y, int x,int z);
	public abstract void displayMaze(String nameMaze);
	public abstract void displayCrossSectionBy(String by, String nameMaze, int index);
	public abstract void saveMaze(String nameMaze, String fileName);
	public abstract void loadMaze(String fileName, String nameMaze);
	public abstract void solveMaze(String nameMaze, String nameAlgorithms);
	public abstract void displaySolution(String nameMaze);
	public abstract void exit();

	/**
	 * This method is use to get controller.
	 * @returnvController
	 */
	public Controller getController() {
		return controller;
	}
	/**
	 * This method is use to set controller.
	 * @param controller
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * This method is use to get hashMaze.
	 * @return HashMap
	 */
	public HashMap<String, Maze3d> getHashMaze() {
		return hashMaze;
	}

	/**
	 * This method is use to set hashMaze.
	 * @param hashMaze
	 */
	public void setHashMaze(HashMap<String, Maze3d> hashMaze) {
		this.hashMaze = hashMaze;
	}

	public HashMap<String, Solution<Position>> getHashSolution() {
		return hashSolution;
	}

	public void setHashSolution(HashMap<String, Solution<Position>> hashSolution) {
		this.hashSolution = hashSolution;
	}

	protected ExecutorService getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(ExecutorService executorService) {
		this.threadPool = executorService;
	}

	public HashMap<String,String> getErrors() {
		return errors;
	}

	public void setErrors(HashMap<String,String> errors) {
		this.errors = errors;
	}

	 
}