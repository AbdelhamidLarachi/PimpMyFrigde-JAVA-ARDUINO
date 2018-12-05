package model;

import gnu.io.*; 
import java.util.Enumeration;

public class CommPortFinder {
	private String commPort = "";
	private CommPortIdentifier serialPortId;
	private Enumeration enumComm;

	/**  
	 * Constructor of the commPort class.
	 */ 
 
	public CommPortFinder() { 
		enumComm = CommPortIdentifier.getPortIdentifiers();
		this.initialize();  
		//System.out.println(commPort);
	}

	/**
	 * Find the commPort witch is connected to the Arduino card.
	 */
	public void initialize() {
		while (enumComm.hasMoreElements()) {
			serialPortId = (CommPortIdentifier) enumComm.nextElement();
			if (serialPortId.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				commPort = serialPortId.getName();
			}
		}
	}
 
	/**
	 * The getter of commPort.
	 * 
	 * @return commPort
	 */
	public String getCommPort() {
		return commPort;
	}
}