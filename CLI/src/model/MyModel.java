package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import algorithms.mazeGenerators.GrowingTreeGenerator;
import algorithms.mazeGenerators.Maze3d;
import algorithms.mazeGenerators.Position;
import algorithms.search.BFS;
import algorithms.search.DFS;
import algorithms.search.MazeAdapter;
import algorithms.search.Searchable;
import algorithms.search.Solution;
import algorithms.search.searcher;
import io.MyCompressorOutputStream;
import io.MyDecompressorInputStream;

/**
 * The MyModel program 
 */
public class MyModel extends CommonModel {
	private StringBuilder sBuild;

	/**
	 * Constructor
	 */
	public MyModel() {
		super();
		this.sBuild = new StringBuilder();
	}

	/**
	 * This method is used to create maze3d by Recursive Backtracker algorithm.
	 * 
	 * @param nameMaze
	 * @param y
	 * @param x
	 * @param z
	 */
	@Override
	public void generate(String nameMaze, int floor, int row, int col) {
	threadPool.execute(new Runnable() {

				@Override
				public void run() {
					Maze3d myMaze = new GrowingTreeGenerator().generate(floor, row, col);
					hashMaze.put(nameMaze, myMaze);
					controller.display("maze " + nameMaze + " is ready");
				}
			});
		}
	/**
	 * This method is used to display maze3d.
	 * @param nameMaze
	 */
	@Override
	public void displayMaze(String nameMaze) {
		Maze3d myMaze = getHashMaze().get(nameMaze);
		if (myMaze == null) {
			getController().display("Maze " + nameMaze + "is not exist");
		} else {
			getController().displayByteArr(myMaze.toByteArray());	
		}
	}

	/**
	 * This method is used to get cross section by y / x / z axis.
	 * 
	 * @param by
	 * @param nameMaze
	 * @param index
	 */
	@Override
	public void displayCrossSectionBy(String by, String nameMaze, int index) {
		Maze3d myMaze = getHashMaze().get(nameMaze);
		int[][] maze2d = null;
		String printMaze = "";

		if (myMaze == null) {
			getController().display("The maze is not exist");
			return;
		}

		try {
			switch (by) {
			case "Y":
				maze2d = myMaze.getCrossSectionByY(index);
				break;
			case "y":
				maze2d = myMaze.getCrossSectionByY(index);
				break;
			case "X":
				maze2d = myMaze.getCrossSectionByX(index);
				break;
			case "x":
				maze2d = myMaze.getCrossSectionByX(index);
				break;
			case "Z":
				maze2d = myMaze.getCrossSectionByZ(index);
				break;
			case "z":
				maze2d = myMaze.getCrossSectionByZ(index);
				break;
			default:
				getController().display("Invalid parameters");
				return;
			}
		} catch (IndexOutOfBoundsException e) {
			getController().display("Invalid index");
			return;
		}
		for (int i = 0; i < maze2d.length; i++) {
			for (int j = 0; j < maze2d[i].length; j++) {
				printMaze = printMaze + String.valueOf(maze2d[i][j] + " ");
			}
			printMaze = printMaze + "\n";
		}
		getController().display(printMaze);

	}

	/**
	 * This method is use to save the maze into a file.
	 * 
	 * @param nameMaze
	 * @param fileName
	 */
	@Override
	public void saveMaze(String nameMaze, String fileName) {
		Maze3d myMaze = getHashMaze().get(nameMaze);
		if (myMaze == null) {
			getController().display("Maze " + nameMaze + " is not exist");
		} else {
			try {
				OutputStream out = new MyCompressorOutputStream(new FileOutputStream(fileName));
				out.write(myMaze.toByteArray());
				out.close();
				getController().display("Maze " + nameMaze + " is saved successfully in the file " + fileName);

			} catch (FileNotFoundException e) {
				getController().display("The " + fileName + " is not exist");
			} catch (IOException e) {
				getController().display("Cannot collapse the " + nameMaze);
			}
		}
	}

	/**
	 * This method is use to load the maze from a file.
	 * 
	 * @param fileName
	 * @param nameMaze
	 */
	@Override
	public void loadMaze(String fileName, String nameMaze) {
		try {
			InputStream in = new MyDecompressorInputStream(new FileInputStream(fileName));
			byte[] bArr = new byte[34586];
			int numByte = in.read(bArr);
			in.read(bArr);
			in.close();
			byte[] newbArr = new byte[numByte];
			for (int i = 0; i < newbArr.length; i++) {
				newbArr[i] = bArr[i];
			}
			Maze3d myMaze = new Maze3d(bArr);
			getHashMaze().put(nameMaze, myMaze);
			getController().display("Maze " + nameMaze + " is loaded from " + fileName + " file");
			in.close();

		} catch (FileNotFoundException e) {
			getController().display("The file " + fileName + " is not found");
		} catch (IOException e) {
			getController().display("There is error with the new maze");
		}
	}

	/**
	 * This method is use to solve the maze by some algorithm.
	 * @param nameMaze
	 * @param nameAlgorithms
	 */
	@Override
	public void solveMaze(String nameMaze, String nameAlgorithms) {
		getThreadPool().execute(new Runnable() {

			@Override
			public void run() {
				Maze3d myMaze = getHashMaze().get(nameMaze);
				if (myMaze == null) {
					getController().display("Maze " + nameMaze + " is not exist");
				} else {
					searcher<Position> algorithms;
					Searchable<Position> mazeSearchable = new MazeAdapter(myMaze);
					switch (nameAlgorithms) {
					case "BFS":
						algorithms = new BFS<Position>();
						break;
					case "DFS":
						algorithms = new DFS<Position>();
						break;
					default:
						getController().display("Invalid algorithm");
						return;
					}
					getHashSolution().put(nameMaze, algorithms.search(mazeSearchable));
					getController().display("Solution for" + nameMaze + " is ready");
				}
			}
		});
	}

	/**
	 * This method is use to display the solution of chosen algorithm.
	 * 
	 * @param nameMaze
	 */
	@Override
	public void displaySolution(String nameMaze) {
		Solution<Position> mySolution = getHashSolution().get(nameMaze);
		if (mySolution == null) {
			getController().display("Solution for " + nameMaze + " is not exist");
		} else {
			ArrayList<Position> listSolution = mySolution.getStates();
			while (!(listSolution.isEmpty())) {
				System.out.println("Solution path:" + listSolution);
			}
			getController().display("The solution for " + nameMaze + " is:\n" + sBuild.toString());
		}
	}

	/**
	 * This method is use to close the project orderly.
	 */
	@Override
	public void exit() {
		getController().display("The system is shutting down");
		getThreadPool().shutdown();
		try {
			while (!(getThreadPool().awaitTermination(10, TimeUnit.SECONDS)))
				;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void errorMas(String name) {
		if(getErrors().containsKey(name))
			getController().display((getErrors().get(name)));

	}



}





