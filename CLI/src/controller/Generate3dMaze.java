package controller;
/**
 * Generate3dMaze class - extends the CommonComand
 * manage the create of maze3d, ask from the model to create the maze
 */

public class Generate3dMaze extends CommonCommand {

	/**
	 * Constructor
	 * @param controller
	 */
	public Generate3dMaze(Controller controller) {
		super(controller);
	}
/*
	@Override
	public void doCommand(String str) {
		String[] parm = str.split(" ");
		
		if(parm.length != 6)
			controller.display("Invalid Command");
		else{
			int x = 0,y = 0,z = 0;
			try{
				x = Integer.parseInt(parm[3]);
				y = Integer.parseInt(parm[4]);
				z = Integer.parseInt(parm[5]);
			}
			catch (NumberFormatException e){
				controller.display("Invalid Command");
			}
			
			controller.getModel().generate(parm[2], x, y, z);
			
		}
	}*/


	@Override
	public void doCommand(String command) {
		String[] tempArr = command.split(" ");
		if (tempArr.length >5) {
			if ((tempArr[0].equals("3d") || tempArr[0].equals("3D"))) {
				if ((tempArr[1].equals("maze") || tempArr[1].equals("Maze"))) {
					int y = 0, x = 0, z = 0;
					try {
						y = Integer.parseInt(tempArr[3]);
						x = Integer.parseInt(tempArr[4]);
						z = Integer.parseInt(tempArr[5]);
						controller.generate(tempArr[2], y, x, z);
					} catch (NumberFormatException e) {
						controller.display("Invalid parameters");
					}
				}
			}
		} else {
			controller.display("Invalid length");
		}
	}
	
	}


