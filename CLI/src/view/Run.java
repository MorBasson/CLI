package view;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.io.PrintWriter;

import controller.MyController;
import model.MyModel;
import view.MyView;

public class Run {

		public static void main(String[] args){
			
			MyModel myModel= new MyModel();
			MyView myView= new MyView(new BufferedReader(new InputStreamReader(System.in)), new PrintWriter(System.out));
			MyController myController= new MyController(myView, myModel);
			
			myModel.setController(myController);
			myView.setController(myController);
			myView.start();
		}
		
		/*
		Controller controller = new MyController();
		Model model = new MyModel(controller);
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		View view = new MyView(controller, in, out);
		
		controller.setModel(model);
		controller.setView(view);
		
		view.V_start();
		
		*/

	}

