package view;

import javax.swing.JPanel;

import model.DataStorage;
import model.ArduinoCommunictation;

public class Panel extends JPanel{
	
	private Image image;
	private Label label;
	private Button button;
	
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor of the panel uses
	 *
	 * @param serial 
	 * @param dataStorag
	 * e
	 */
	public Panel(ArduinoCommunictation serial, DataStorage dataStorage) {
		 
		this.setLayout(null);
		
		button = new Button(dataStorage, serial, this);
		label = new Label(dataStorage, this);
		image = new Image(dataStorage, this);
	}

	/**
	 * Getter of button.
	 * 
	 * @return button
	 */
	public Button getButton() {
		return button;
	}

	/**
	 * Getter of image.
	 * 
	 * @return image
	 */
	public Image getImage() {
		return image;
	} 
	 
	/**
	 * Getter of label.
	 * 
	 * @return label
	 */
	public Label getLabel() {
		return label;
	}
}