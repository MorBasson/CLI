package view;

import java.util.HashMap;
import controller.Command;

public interface View {
	/**
	 * The view will be responsible for user input and display for
	 * 
	 * @author Mor Basson & Reut Sananes
	 * @version 1.0
	 */
	
		 public void start();
		 public void displayArr(String[] arr);
		 public void display(String message);
		 public void displayByteArr(byte[] b);
		 public void setCommand(HashMap<String, Command> commandMap);
		 public void exit();
	
}
