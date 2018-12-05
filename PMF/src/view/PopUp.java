package view;

import java.awt.Font;

import javax.swing.JFrame;

public class PopUp extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Font font;

	
	/**
	 * Constructor of the class PopUp. 
	 */
	public PopUp(Font font) {
		this.font = font;
		this.setTitle("Attention !"); 
		this.setSize(300, 100);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Graphic.HIDE_ON_CLOSE);
		this.setResizable(false);
	}

	/**
	 * Create a new CondensationPanel, set the JPanel to this JFrame and set the
	 * windows visible.
	 */ 
	public void condensation() {
		CondensationPanel condensationPanel = new CondensationPanel(font);
		this.setContentPane(condensationPanel);
		this.setVisible(true); 
	}  
  
	/** 
	 * Create a new OpenedDoorPanel, set the JPanel to this JFrame and set the
	 * windows visible. 
	 */
	public void porte() {
		OpenedDoorPanel openedDoorPanel = new OpenedDoorPanel(font);
		this.setContentPane(openedDoorPanel);
		this.setVisible(true);
	}
}