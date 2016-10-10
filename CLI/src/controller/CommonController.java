package controller;

import model.Model;
import view.View;

/**
 * The CommonController program implements an application that organize all
 * the common methods of the Command interface.
 *
 * @author Mor Basson & Reut Sananes
 *
 *
 */
public abstract class CommonController implements Controller {
	protected View view;
	protected Model model;

	/**
	 * Constructor
	 * @param view
	 * @param model
	 */
	public CommonController(View view, Model model) {
		this.view = view;
		this.model = model;
	}

	public abstract void generate(String nameMaze, int floors, int rows, int cols);
	public abstract void displayCrossSectionBy(String by, String nameMaze, int index);
	public abstract void saveMaze(String nameMaze, String fileName);
	public abstract void loadMaze(String fileName, String nameMaze);
	public abstract void solveMaze(String nameMaze, String nameAlgorithms);
	public abstract void displaySolution(String nameMaze);
	public abstract void exit();
	
	/**
	 *get a view object.
	 * @return View
	 */
	public View getView() {
		return view;
	}

	/**
	 *set a view object.
	 * @param view
	 */
	public void setView(View view) {
		this.view = view;
	}

	/**
	 * get a model object.
	 * @return Model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * set a model object.
	 * @param model
	 */
	public void setModel(Model model) {
		this.model = model;
	}

	/**
	 *apply the method displayArr by View.
	 * @param arr
	 */
	@Override
	public void displayArr(String[] arr) {
		this.view.displayArr(arr);
	}

	/**
	 *apply the method display by View.
	 * @param message
	 */
	@Override
	public void display(String message) {
		this.view.display(message);
	}

	/**
	 *apply the method displayByteArr by View.
	 * @param b
	 */
	@Override
	public void displayByteArr(byte[] b) {
		view.displayByteArr(b);
	}

	/**
	 * apply the method displayMaze by View.
	 * @param nameMaze
	 */
	@Override
	public void displayMaze(String nameMaze) {
		this.model.displayMaze(nameMaze);
	}

	public void generate1(String mazeName, int x, int y, int z) {
		this.model.generate(mazeName, x, y, z);
		
	}


}