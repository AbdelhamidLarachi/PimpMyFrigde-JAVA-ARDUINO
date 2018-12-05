package view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DataStorage;

public class Label extends JPanel {

	/**
	 * Declaration of the variables used in order to create the labels
	 */
	private static final long serialVersionUID = 1L; 
	private JLabel titleLabel;
	private JLabel humidityLabel;
	private JLabel orderLabel;
	private JLabel inTempLabel;
	private JLabel outTempLabel;

	private DataStorage dataStorage;

	/**
	 * Properties of all the label used in the interface. It uses :
	 * 
	 * @param dataStorage
	 * @param panel
	 */
	public Label(DataStorage dataStorage, Panel panel) {

		this.dataStorage = dataStorage; 
 
		/**
		 * The label for the title of the frame
		 */  
		this.titleLabel = new JLabel();
		this.titleLabel.setBounds(1, 1, 250, 12); 
		this.titleLabel.setText("@author:Abdelhamid");
		this.titleLabel.setForeground(Color.DARK_GRAY);
		this.titleLabel.setFont(dataStorage.getTitleFont());
		panel.add(titleLabel); 
  
		/** 
		 * The label that displays the inside temperature. 
		 */
		this.inTempLabel = new JLabel();
		this.inTempLabel.setBounds(10, 50, 400, 50); 
		this.inTempLabel.setText("Inside Temp °C ");
		this.inTempLabel.setForeground(Color.BLACK); 
		this.inTempLabel.setFont(dataStorage.getClassicFont());
		panel.add(inTempLabel);

		/**   
		 * The label that displays the outside temperature.
		 */ 
		this.outTempLabel = new JLabel();
		this.outTempLabel.setBounds(10, 230, 400, 50);
		this.outTempLabel.setText("Outside Temp °C ");
		this.outTempLabel.setForeground(Color.BLACK);
		this.outTempLabel.setFont(dataStorage.getClassicFont());
		panel.add(outTempLabel);  

		/** 
		 * The label that displays the order.
		 */
		this.orderLabel = new JLabel();
		this.orderLabel.setBounds(400, 35, 300, 80); // CHANGER VALEUR
		this.orderLabel.setText("Consigne");
		this.orderLabel.setForeground(Color.BLACK);
		this.orderLabel.setFont(dataStorage.getClassicFont());
		panel.add(orderLabel); 

		/**
		 * The label that displays the humidity. 
		 */
		this.humidityLabel = new JLabel();
		this.humidityLabel.setBounds(400, 215, 300, 80);
		this.humidityLabel.setText("Humidity %");
		this.humidityLabel.setForeground(Color.BLACK);
		this.humidityLabel.setFont(dataStorage.getClassicFont());
		panel.add(humidityLabel);

		/**
		 * The label that displays the value of the inside temperature.
		 */  
		dataStorage.setInTempValueLabel(new JLabel());
		dataStorage.getInTempValueLabel().setBounds(160, 130, 400, 70);
		dataStorage.getInTempValueLabel().setText(String.valueOf(dataStorage.getInsideTemperature()) + "°C ");
		dataStorage.getInTempValueLabel().setForeground(Color.BLACK);
		dataStorage.getInTempValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getInTempValueLabel());
 
		/**
		 * The label that displays the value of the outside temperature.
		 */
		dataStorage.setOutTempValueLabel(new JLabel());
		dataStorage.getOutTempValueLabel().setBounds(160, 230, 300, 200);
		dataStorage.getOutTempValueLabel().setText(String.valueOf(dataStorage.getOutsideTemperature()) + "°C ");
		dataStorage.getOutTempValueLabel().setForeground(Color.BLACK);
		dataStorage.getOutTempValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getOutTempValueLabel());

		/**
		 * The label that displays the value of the order.  
		 */ 
		dataStorage.setOrderValueLabel(new JLabel());
		dataStorage.getOrderValueLabel().setBounds(500, 125, 350, 80);
		dataStorage.getOrderValueLabel().setText(String.valueOf(dataStorage.getOrder()) + "°C ");
		dataStorage.getOrderValueLabel().setForeground(Color.BLACK); 
		dataStorage.getOrderValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getOrderValueLabel());
 
		/**  
		 * The label that displays the value of the humidity. 
		 */ 
		dataStorage.setHumidityValueLabel(new JLabel());
		dataStorage.getHumidityValueLabel().setBounds(500, 300, 400, 50);
		dataStorage.getHumidityValueLabel().setText(String.valueOf(dataStorage.getHumidity()) + "%");
		dataStorage.getHumidityValueLabel().setForeground(Color.BLACK);
		dataStorage.getHumidityValueLabel().setFont(dataStorage.getTempFont());
		panel.add(dataStorage.getHumidityValueLabel()); 
	}
 
	/** 
	 * Update the display of the labels.
	 */
	public void updateLabels() {
		this.dataStorage.getHumidityValueLabel().setText(String.valueOf(dataStorage.getHumidity()));
		this.dataStorage.getOutTempValueLabel().setText(String.valueOf(dataStorage.getOutsideTemperature()));
		this.dataStorage.getInTempValueLabel().setText(String.valueOf(dataStorage.getInsideTemperature()));
	}
}
