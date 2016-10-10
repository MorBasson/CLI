package controller;

/**
 * The Load program
 *
 */
public class Load_Maze extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Load_Maze(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String fileName = tempArr[0];
			String nameMaze = tempArr[1];
			controller.loadMaze(fileName, nameMaze);
		}
	}
}