package controller;

/**
 * The Save program 
 *
 */
public class SaveMaze extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public SaveMaze(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length != 2) {
			controller.display("Invalid parameters");
		} else {
			String nameMaze = tempArr[0];
			String fileName = tempArr[1];
			controller.saveMaze(nameMaze, fileName);
		}
	}
}