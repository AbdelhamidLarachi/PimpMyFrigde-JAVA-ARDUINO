package controller;

import model.DataStorage;
import view.Frame;
import view.Graphic;
import view.PopUp;

public class DisplayLoop {

	private DewPoint dewPoint;
	private Graphic graphic;
	private PopUp popUp;
	private DataStorage dataStorage;
	private Frame frame; 

	/** 
	 * Constructor of the DisplayLoop class.
	 *
	 * @param dewPoint
	 * @param graphique 
	 * @param popUp  
	 * @param dataStorage 
	 * @param frame
	 */
	public DisplayLoop(DewPoint dewPoint, Graphic graphic, PopUp popUp, DataStorage dataStorage, Frame frame) {
		this.frame = frame; 
		this.dewPoint = dewPoint;
		this.graphic = graphic; 
		this.popUp = popUp;
		this.dataStorage = dataStorage;
	}

	/**
	 * A loop that refresh all that we need.
	 * 
	 * @throws InterruptedException 
	 */
	public void Loop() throws InterruptedException {
		while (true) {

			this.refreshData();
			this.updateThermometerImage();
			this.dewPointCalculation();
			this.updateGraphicData();
			 this.printData(); 
			this.dewPointTest();
			this.doorOpenTest(); 

			Thread.sleep(1000);
		}
	}

	/**
	 * Update the value of the collected data and refresh the display of these data
	 * on the window.
	 */
	public void refreshData() {
		this.dataStorage.updateData();
		this.frame.getPanel().getLabel().updateLabels(); 
	}

	/**
	 * Calculate the dew point.
	 */
	public void dewPointCalculation() {
		this.dewPoint.dewPointTemp(this.dataStorage.getArray()[1], this.dataStorage.getArray()[2]);
	} 

	/**
	 * Update the graphic's data and then the graphic's display.
	 */
	public void updateGraphicData() {
		this.graphic.updateTable(); 
		this.graphic.updateGraphic();
	}

	/**
	 * Print the output of the Arduino card and the dew point temperature.
	 */
	public void printData() {
		for (int i = 0; i < 4; i++) {
			System.out.println(this.dataStorage.getArray()[i] + "\t\t\t");
		}
		
		System.out.println(dewPoint.getDewPointTemp());
	}
 
	/**
	 * Check if there is condensation formation, if yes, it displays a new window
	 * with a message.
	 */
	public void dewPointTest() {
		if (this.dewPoint.getDewPointTemp() > Double.parseDouble(this.dataStorage.getArray()[1])) {
			// Double.parseDouble(this.chunksCreator.getArray()[0]) >
			// Double.parseDouble(this.chunksCreator.getArray()[1])
			//
			// this.dewPoint.getDewPointTemp() >
			// Double.parseDouble(this.chunksCreator.getArray()[1])
			this.popUp.condensation(); 
		}
	}
  
	/**
	 * Check if the fridge's door is open, if yes, it displays a new window with a
	 * message.
	 */  
	public void doorOpenTest() {
		if (this.graphic.getData()[1][9] - this.graphic.getData()[1][0] > 0.5) {
			// this.graphique.getData()[0][9] - this.graphique.getData()[0][8] > 5
			this.popUp.porte();
		} 
	}  

	/** 
	 * Update the inside thermometer image.
	 */
	public void updateThermometerImage() {
		this.frame.getPanel().getImage().updateImage();
	}
}