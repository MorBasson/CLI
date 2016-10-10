package controller;

/**
 * The DisplaySolution program 
 * 
 *
 */


import controller.Controller;


public class DisplaySolution extends CommonCommand {
	
	//C'TOR
	public DisplaySolution(Controller controller){
		super(controller);
	}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		if (tempArray.length != 2) {
			this.controller.display("wrong input");
		} else {
			String mazeName = tempArray[1];
			this.controller.displaySolution(mazeName);
		}
	}

}