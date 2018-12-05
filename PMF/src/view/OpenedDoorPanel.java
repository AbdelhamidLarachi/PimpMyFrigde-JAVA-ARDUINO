package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class OpenedDoorPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel text;
 
    /**
     * Constructor of the class OuverturePortePan el.
 	 * 
     * @param font 
     */    
    public OpenedDoorPanel(Font font) {
        text = new JLabel ();
        this.text.setBounds(20, 150, 400, 50);
        this.text.setText("Porte ouverte!");
        this.text.setForeground(Color.BLACK);
        this.text.setFont(font);
        this.add(text);
    }
}