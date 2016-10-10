package controller;

import java.io.File;

import controller.Controller;


	public class Dir extends CommonCommand {

		/**
		 * Constructor
		 * @param controller
		 */
		public Dir(Controller controller) {
			super(controller);
		}

		@Override
		public void doCommand(String command) {
			if (command == null) {
				controller.display("Invalid parameters");
			} else {
				try {
					File file = new File(command);
					if (file.list().length == 0) {
						controller.display("The file is not exist");
					} else {
						controller.displayArr(file.list());
					}
				} catch (NullPointerException e) {
					controller.display("Invalid path");
				}
			}
		}
		
		
		}