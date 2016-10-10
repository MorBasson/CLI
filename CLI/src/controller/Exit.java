package controller;

/**
 * The Exit program 
 * 
 *
 */
public class Exit extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Exit(Controller controller) {
		super(controller);
	}

	@Override
	public void doCommand(String command) {
		controller.exit();
	}

}