package view;

import java.io.IOException;

import javax.swing.JFrame;

import model.DataStorage;
import model.ArduinoCommunictation;

public class Frame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Panel panel;

	/**  
	 * Constructor of the class Frame.
	 *  
	 * @param arduinoCommunication
	 * @param dataStorage   
	 * @throws IOException 
	 */
	public Frame(ArduinoCommunictation arduinoCommunication, DataStorage dataStorage) throws IOException {
		this.setTitle("PimpMyFridge");
		this.setSize(600, 400);    
		this.setResizable(false);   
		this.setLocation(70, 70);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setAlwaysOnTop(true);
		panel = new Panel(arduinoCommunication, dataStorage);
		this.setContentPane(panel); 
		// this.setUndecorated(true);
		this.setVisible(true); 
	}
 
	/** 
	 * Getter of panel. 
	 * 
	 * @return panel
	 */
	public Panel getPanel() {
		return panel;
	}
}