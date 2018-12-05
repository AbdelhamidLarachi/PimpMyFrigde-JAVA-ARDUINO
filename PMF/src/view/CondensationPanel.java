package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class CondensationPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel textField; 
   
    /** 
     * Constructor of the class CondensationPanel. 
     */ 
    public CondensationPanel(Font font) { 
        textField = new JLabel ();
        this.textField.setBounds(150, 150, 400, 50);
        this.textField.setText("Condesation Risque!");
        this.textField.setFont(font);
        this.textField.setForeground(Color.BLACK);
        this.add(textField);
    }
}