package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public class MyController extends CommonController {

		private HashMap<String, Command> commandMap;

		/**
		 * Constructor
		 * 
		 * @param v
		 * @param m
		 */
		public MyController(View v, Model m) {
			super(v, m);
			this.commandMap = new HashMap<String, Command>();
			this.commandMap.put("dir", new Dir(this));
			this.commandMap.put("generate", new Generate3dMaze(this));
			this.commandMap.put("displayCrossSectionBy", new DisplayCrossSectionBy(this));
			this.commandMap.put("display", new Display(this));
			this.commandMap.put("save", new SaveMaze(this));
			this.commandMap.put("load", new Load_Maze(this));
			this.commandMap.put("solve", new Solve(this));
			this.commandMap.put("exit", new Exit(this));

			view.setCommand(commandMap);
		}


		/**
		 * This method is used to create maze3d by Recursive Backtracker algorithm
		 * according to model that start this method.
		 * 
		 * @param nameMaze
		 * @param y
		 * @param x
		 * @param z
		 */
		@Override
		public void generate(String nameMaze, int floors, int rows, int cols) {
		
			model.generate(nameMaze, floors, rows, cols);
		}

		/**
		 * This method is used to get cross section by y / x / z axis according to
		 * model that start this method.
		 * 
		 * @param by
		 * @param nameMaze
		 * @param index
		 */
		@Override
		public void displayCrossSectionBy(String by, String nameMaze, int index) {
			model.displayCrossSectionBy(by, nameMaze, index);
		}

		/**
		 * This method is used to save the maze into a file according to model that
		 * start this method.
		 * 
		 * @param nameMaze
		 * @param fileName
		 */
		@Override
		public void saveMaze(String nameMaze, String fileName) {
			model.saveMaze(nameMaze, fileName);
		}

		/**
		 * This method is used to load the maze from a file according to model that
		 * start this method.
		 * 
		 * @param nameMaze
		 * @param fileName
		 */
		@Override
		public void loadMaze(String fileName, String nameMaze) {
			model.loadMaze(fileName, nameMaze);
		}

		/**
		 * This method is used to solve the maze by some algorithm according to
		 * model that start this method.
		 * 
		 * @param nameMaze
		 * @param nameAlgorithms
		 */
		@Override
		public void solveMaze(String nameMaze, String nameAlgorithms) {
			model.solveMaze(nameMaze, nameAlgorithms);
		}

		/**
		 * This method is used to display the solution of chosen algorithm according
		 * to model that start this method.
		 * 
		 * @param nameMaze
		 */
		@Override
		public void displaySolution(String nameMaze) {
			model.displaySolution(nameMaze);
		}

		/**
		 * This method is used to close the project orderly according to model and
		 * view that start this method.
		 */
		@Override
		public void exit() {
			model.exit();
			view.exit();

		}





		
		
}