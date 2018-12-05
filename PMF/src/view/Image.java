package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.DataStorage;

public class Image extends JPanel {
 
	/**
	 * 
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	private JLabel backgroundLabel; 
	private JLabel dropLabel; 
	private JLabel lineLabel;  
	private JLabel outThermLabel; 
	private JLabel inThermLabel; 
	private JLabel exiaLabel; 

 
	private ImageIcon outThermIcon = new ImageIcon("image/outside.png");
	private ImageIcon inThermIcon = new ImageIcon("image/inside.png");
	private ImageIcon dropIcon = new ImageIcon("image/hum.png");
	private ImageIcon lineIcon = new ImageIcon("image/line.png");
	private ImageIcon backgroundIcon = new ImageIcon("image/blackback.jpg");
	private ImageIcon exiaIcon = new ImageIcon("image/exia.png");

	
	private DataStorage dataStorage;


	/**
	 * The constructor of the class Image. 
	 * 
	 *  
	 * @param dataStorage
	 * @param panel 
	 */
	public Image(DataStorage dataStorage, Panel panel) {

		this.dataStorage = dataStorage;
		
		// exia icon
		exiaLabel = new JLabel(exiaIcon);  
		this.exiaLabel.setBounds(10, 270, 100, 100); 
		panel.add(exiaLabel);
		
		/**
		 * The image used for the humidity.
		 */
		dropLabel = new JLabel(dropIcon);  
		this.dropLabel.setBounds(400, 270, 100, 100); 
		panel.add(dropLabel);
  
		/**  
		 * The image used for the separation in the middle. 
		 */
		lineLabel = new JLabel(lineIcon);
		this.lineLabel.setBounds(300, 60, 10, 300);
		panel.add(lineLabel);
   
		/**
		 * The image used for the outside temperature.
		 */
		outThermLabel = new JLabel(outThermIcon);
		this.outThermLabel.setBounds(10, 270, 100, 100);
		panel.add(outThermLabel);
 
		/**  
		 * The image used for the inside temperature.
		 */ 
		inThermLabel = new JLabel(); 
		this.inThermLabel.setBounds(20, 100, 140, 140);
		panel.add(inThermLabel);

 
		/**  
		 * The image used for the background. 
		 */
		backgroundLabel = new JLabel(backgroundIcon);
		this.backgroundLabel.setSize(600, 400);
		panel.add(backgroundLabel);
	} 
 
	/**
	 * Method used to update the image of the inside thermometer.
	 */
	public void updateImage() {
		if (this.dataStorage.getInsideTemperature() <= this.dataStorage.getOrder()-2) {
			inThermIcon = new ImageIcon("image/inside.png");
			this.inThermLabel.setIcon(inThermIcon);
		}   
   
		else if ((this.dataStorage.getInsideTemperature() > this.dataStorage.getOrder()-2) && (dataStorage.getInsideTemperature() < this.dataStorage.getOrder()+2)) {
			inThermIcon = new ImageIcon("image/inside.png"); 
			this.inThermLabel.setIcon(inThermIcon);
		}  
   
		else if (this.dataStorage.getInsideTemperature() >= this.dataStorage.getOrder()+2) {
			inThermIcon = new ImageIcon("image/inside.png");
			this.inThermLabel.setIcon(inThermIcon);
		}
 
		else {
			System.out.println("Error in updateImage");
		}
	}
}