package controller;

import controller.Controller;

public class DisplayCrossSectionBy extends CommonCommand {
	

	
	//c'tor
		public DisplayCrossSectionBy(Controller c){
			super(c);
		}

	@Override
	public void doCommand(String args) {
		String[] tempArray = args.split(" ");
		
		//if after "display" we want to cross section by x, y, z
		if(tempArray.length > 5){
			if(tempArray[0].equals("cross")){
				int index = 0;
				try{
					//casting Integet to premitive int
				index = Integer.parseInt(tempArray[4]);
				}
				catch (NumberFormatException e){
					this.controller.display("wrong input");
				}
				
				//get cross section by specific index
				String XYZ = tempArray[3];
				String mazeName = tempArray[5];
				this.controller.displayCrossSectionBy(XYZ, mazeName, index);
			}
		}

	}

}