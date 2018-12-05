package controller;

public class DewPoint {

	private final static double a = 17.27;
	private final static double b = 237.7;
	private double dewPointTemp;
	private double alpha, temp, hum;
  
	/**
	 * Calculate the dew point temperature in the fridge.
	 *  
	 * @param temp
	 * @param hum
	 * 
	 */ 
	public void dewPointTemp(String temp, String hum) {
		this.temp = Double.parseDouble(temp);
  
		this.hum = Double.parseDouble(hum);
		this.hum = this.hum / 100; 
 
		alpha = ((a * this.temp) / (b + this.temp)) + Math.log(this.hum);
		dewPointTemp = (b * alpha) / (a - alpha);
	} 
 
	/**
	 * Getter of dewPointTemp.
	 * 
	 * @return dewPointTemp
	 */
	public double getDewPointTemp() {
		return dewPointTemp;
	}
}