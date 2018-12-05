package controller;

import view.*;
import model.*;

public class Main { 
 
	public static void main(String[] args) throws Exception {
		DataStorage dataStorage = new DataStorage();
		  
		CommPortFinder commPort = new CommPortFinder();				
		ArduinoCommunictation serial = new ArduinoCommunictation(commPort.getCommPort(), dataStorage);
		serial.readIntput(); 
		    
		DewPoint dewPoint = new DewPoint(); 
		 
		Frame fenetre = new Frame(serial, dataStorage);
		
		PopUp popUp = new PopUp(dataStorage.getPopUpFont());
		
		DisplayLoop loop = new DisplayLoop(dewPoint, fenetre.getPanel().getButton().getGraphic(), popUp, dataStorage, fenetre);
		loop.Loop();
	}
}
