package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.DataStorage;
import model.ArduinoCommunictation;

public class Button extends JPanel implements ActionListener {

	/**
	 * Declaration of the variables used in order to create the buttons
	 */
	private static final long serialVersionUID = 1L;
	private JButton plusButton;
	private JButton minusButton;
	private JButton graphicButton;

	private DataStorage dataStorage;
	private Graphic graphic;

	private ArduinoCommunictation arduinoCommunication;

	/**
	 * the constructor needs
	 *  
	 * @param dataStorage
	 * @param graphic 
	 * @param serial
	 * @param panel
	 *            in order to create the buttons
	 */ 
	public Button(DataStorage dataStorage, ArduinoCommunictation arduinoCommunication, Panel panel) {
		graphic = new Graphic(dataStorage);
		 
		this.dataStorage = dataStorage;
		this.arduinoCommunication = arduinoCommunication;
 
		/**
		 * The button with the image +.  
		 */
		plusButton = new JButton();
		this.plusButton.setIcon(new ImageIcon("image/pluss.png"));
		this.plusButton.setBounds(425, 190, 40, 40);
		this.plusButton.setBorderPainted(false);    
		this.plusButton.setBackground(null); 
		this.plusButton.addActionListener(this); 
		panel.add(plusButton);  
   
		/**    
		 * The button with the image -. 
		 */ 
		minusButton = new JButton();
		this.minusButton.setIcon(new ImageIcon("image/minuss.png"));
		this.minusButton.setBounds(425, 110, 40, 40); 
		this.minusButton.setBorderPainted(false);
		 this.minusButton.setBackground(null);
		this.minusButton.addActionListener(this);
		panel.add(minusButton);
 
		/** 
		 * The button that allows us to display the graphic.
		 */ 
		graphicButton = new JButton(); 
		this.graphicButton.setText("SENSORS GRAPHIQUE");
		this.graphicButton.setForeground(Color.darkGray);
		this.graphicButton.setFont(this.dataStorage.getMinFont());
		this.graphicButton.setBounds(200, 10, 200, 30);
		this.graphicButton.addActionListener(this);  
		panel.add(graphicButton);
   
		/**  
		 * This is the field in which the user can put the order.
		 */  
		    
		dataStorage.setTextField(new JTextField()); 
		dataStorage.getTextField().setBounds(425, 150, 40, 40);
		dataStorage.getTextField().setFont(dataStorage.getClassicFont());
		dataStorage.getTextField().setForeground(Color.BLACK); 
		dataStorage.getTextField().addActionListener(this);
		panel.add(dataStorage.getTextField());
 
	} 
    
	/** 
	 * Method actionPerformed that detect when a button is pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == plusButton) { 
			if (this.dataStorage.getOrder() <= 29f) {
				this.dataStorage.setOrder(this.dataStorage.getOrder() + 1f);
				this.dataStorage.getOrderValueLabel()
						.setText(String.valueOf(this.dataStorage.getOrder()) + "°C");
			} else {
				this.dataStorage.getOrderValueLabel().setText("30.0 °C ");
				this.dataStorage.setOrder(30.00f);
			}
		}
  
		else if (source == minusButton) {
			if (this.dataStorage.getOrder() >= 11f) {
				this.dataStorage.setOrder(this.dataStorage.getOrder() - 1f);
				this.dataStorage.getOrderValueLabel()
						.setText(String.valueOf(this.dataStorage.getOrder()) + "°C");
			} else {
				this.dataStorage.getOrderValueLabel().setText("10.0°C");
				this.dataStorage.setOrder(10.00f); 
			}
		}
 
		else if (source == this.dataStorage.getTextField()) {
			float a = Float.parseFloat(this.dataStorage.getTextField().getText());
			if (a > 30f) { 
				this.dataStorage.setOrder(30.00f);
			} else if (a < 10f) { 
				this.dataStorage.setOrder(10.00f); 
			} else if ((a >= 10f) && (a <= 25f)) {
				this.dataStorage.setOrder(a);  
			} else { 
				System.out.println("Error order text field.");
			} 
			this.dataStorage.getOrderValueLabel().setText(this.dataStorage.getOrder() + "°C");
		} 
 
		else if (source == graphicButton) {
			SwingUtilities.invokeLater(() -> {
				this.graphic.initUI();
				graphic.setVisible(true);
			});
		}  
		try { 
			this.arduinoCommunication.writeOutput(Float.toString(this.dataStorage.getOrder()));
		} catch (IOException e1) { 
			e1.printStackTrace();
		}
	}
 
	public Graphic getGraphic() {
		return graphic;
	}
}