package controller;

/**
 * The Solve program 
 *
 */
public class Solve extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Solve(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArr[0];
			String nameAlgorithms = tempArr[1];
			controller.solveMaze(nameMaze, nameAlgorithms);
		}
	}
}