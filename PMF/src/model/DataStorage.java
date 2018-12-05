package model;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class DataStorage { 
  
	/**
	 * We declare all the variables that will be used in the different classes All
	 * the fonts used The inside and outside temperature, the humidity, and the order
	 * The variable used to stock the text entered by the user  
	 */
	private Font popUpFont = new Font("Consolas", Font.BOLD, 20); 
	private Font classicFont = new Font("Consolas", Font.BOLD, 20);
	private Font titleFont = new Font("Consolas", Font.ITALIC, 12);
	private Font tempFont = new Font("Consolas", Font.BOLD, 20);
	private Font minFont = new Font("Consolas", Font.BOLD, 15);
	   
	  
	private float outsideTemperature;
	private float humidity; 
	private float order = 10.00f;
	private float insideTemperature;
	
	private JTextField textField; 
	
	private JLabel orderValueLabel;	
	private JLabel inTempValueLabel;
	private JLabel outTempValueLabel;
	private JLabel humidityValueLabel;
	
	private String[] array = new String[4];

	/**
	 * Constructor of the class DataStorage.
	 */
	public DataStorage() {
		this.array[0] = "0";
		this.array[1] = "1";  
		this.array[2] = "2"; 
		this.array[3] = "10";
	} 
	
	/**
	 * Put the collected data in these variables.
	 */
	public void updateData() {
		this.outsideTemperature = Float.parseFloat(this.array[0]);
		this.insideTemperature = Float.parseFloat(this.array[1]);
		this.humidity = Float.parseFloat(this.array[2]);
	}

	/**
	 * Getter of the textField.
	 * 
	 * @return textField
	 */
	public JTextField getTextField() {
		return textField;
	} 

	/**
	 * Getter of the popUpFont. 
	 * 
	 * @return popUpFont
	 */
	public Font getPopUpFont() {
		return popUpFont;
	}
	
	/**
	 * Getter of the classicFont.
	 * 
	 * @return classicFont
	 */
	public Font getClassicFont() {
		return classicFont;
	}

	/**
	 * Getter of the minFont.
	 * 
	 * @return minFont
	 */
	public Font getMinFont() {
		return minFont;
	}

	/**
	 * Getter of the titleFont.
	 * 
	 * @return titleFont
	 */
	public Font getTitleFont() {
		return titleFont; 
	}

	/**
	 * Getter of the tempFont.
	 * 
	 * @return tempFont
	 */
	public Font getTempFont() {
		return tempFont;
	}
 
	/**
	 * Getter of the outsideTemperature.
	 * 
	 * @return outsideTemperature
	 */
	public float getOutsideTemperature() {
		return outsideTemperature;
	}

	/** 
	 * Getter of the humidity.
	 * 
	 * @return humidity
	 */
	public float getHumidity() {
		return humidity;
	}

	/**
	 * Getter of the order.
	 * 
	 * @return order
	 */
	public float getOrder() {
		return order;
	}

	/**
	 * Getter of the insideTemperature.
	 * 
	 * @return insideTemperature
	 */
	public float getInsideTemperature() {
		return insideTemperature;
	}

	/**
	 * Getter of the orderValueLabel.
	 * 
	 * @return orderLabel
	 */
	public JLabel getOrderValueLabel() {
		return orderValueLabel;
	}
	
	/**
	 * Getter of inTempValueLabel.
	 * 
	 * @return inTempValueLabel
	 */
	public JLabel getInTempValueLabel() {
		return inTempValueLabel;
	}

	/**
	 * Getter of outTempValueLabel.
	 * 
	 * @return outTempValueLabel
	 */
	public JLabel getOutTempValueLabel() {
		return outTempValueLabel;
	}
	

	/**
	 * Getter of humidityValueLabel.
	 * 
	 * @return humidityValueLabel
	 */
	public JLabel getHumidityValueLabel() {
		return humidityValueLabel;
	}

	/**
	 * Getter of array.
	 * 
	 * @return array
	 */
	public String[] getArray() {
		return array;
	}

	/**
	 * Setter of orderValueLabel.
	 * 
	 * @param orderValueLabel
	 */
	public void setOrderValueLabel(JLabel orderValueLabel) {
		this.orderValueLabel = orderValueLabel;
	}

	/**
	 * Setter of outsideTemperature.
	 * 
	 * @param outsideTemperature
	 */
	public void setOutsideTemperature(float outsideTemperature) {
		this.outsideTemperature = outsideTemperature;
	}

	/**
	 * Setter of humidity.
	 * 
	 * @param humidity
	 */
	public void setHumidity(float humidity) {
		this.humidity = humidity;
	}

	/**
	 * Setter of insideTemperature.
	 * 
	 * @param insideTemperature
	 */
	public void setInsideTemperature(float insideTemperature) {
		this.insideTemperature = insideTemperature;
	}



	/**
	 * Setter of inTempValueLabel.
	 * 
	 * @param inTempValueLabel
	 */
	public void setInTempValueLabel(JLabel inTempValueLabel) {
		this.inTempValueLabel = inTempValueLabel;
	}

	/**
	 * Setter of outTempValueLabel.
	 * 
	 * @param outTempValueLabel
	 */
	public void setOutTempValueLabel(JLabel outTempValueLabel) {
		this.outTempValueLabel = outTempValueLabel;
	}

	/**
	 * Setter of humidityValueLabel.
	 * 
	 * @param humidityValueLabel
	 */
	public void setHumidityValueLabel(JLabel humidityValueLabel) {
		this.humidityValueLabel = humidityValueLabel;
	}
	
	/**
	 * Setter for the textField.
	 * 
	 * @param textField
	 */
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
	/**
	 * Setter for the textField.
	 * 
	 * @param order 
	 */
	public void setOrder(float order) { 
		this.order = order;
	}


	/** 
	 * Setter for the array.
	 * 
	 * @param array
	 */
	public void setArray(String[] array) {
		this.array = array;
	}
}
