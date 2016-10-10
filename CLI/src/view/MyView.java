package view;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import controller.Command;
/**
 * The MyView program implements an application that realize the methods from
 *abstract CommonView.
 * 
 * @author Mor Basson & Reut Sananes
 *
 */
public class MyView extends CommonView {

	private CLI cli;

	/**
	 * Constructor
	 * 
	 * @param in
	 * @param out
	 */
	public MyView(BufferedReader in, PrintWriter out) {
		super(in, out);
	}

	/**
	 * This method is use to begin the project
	 */
	@Override
	public void start() {
		cli.start();
	}

	/**
	 * This method is use to display an array of Strings.
	 * 
	 * @param string
	 */
	@Override
	public void displayArr(String[] string) {
		if (string != null) {
			for (int i = 0; i < string.length; i++) {
				out.println(string[i] + " ");
			}
			out.flush();
		} else {
			out.println("null");
			out.flush();
		}
	}

	/**
	 * This method is use to display string massage. 
	 * @param massage
	 */
	@Override
	public void display(String message) {
		if (message != null) {
			out.println(message);
			out.flush();
		} else {
			out.println("Error");
			out.flush();
		}
	}


	/**
	 * This method is use to display byte array.
	 * 
	 * @param b
	 */
	@Override
	public void displayByteArr(byte[] b) {
		ByteArrayInputStream bArr = new ByteArrayInputStream(b);
		DataInputStream data = new DataInputStream(bArr);
		try {
			int floors = data.readInt();
			int rows = data.readInt();
			int cols = data.readInt();
			
			System.out.println("The start position: " + data.readInt() + "," + data.readInt() + "," + data.readInt());
			System.out.println("The goal position: " + data.readInt() + "," + data.readInt() + "," + data.readInt());
			System.out.println("Maze size: " + floors + "," + rows + "," + cols);
			System.out.println();
			
			for (int i = 0; i <floors; i++) {
				for (int j = 0; j < rows; j++) {
					for (int k = 0; k < cols; k++) {
						System.out.print(data.read());
					}
					System.out.println();
				}
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is use to update the HashMap and initialize The CLI.
	 * 
	 * @param commandMap
	 */
	@Override
	public void setCommand(HashMap<String, Command> commandMap) {
		cli = new CLI(in, out, commandMap);
	}

	/**
	 * This method is use to close the project orderly.
	 */
	@Override
	public void exit() {
		out.println("Everything successfully closed");
		out.flush();
	}


}
