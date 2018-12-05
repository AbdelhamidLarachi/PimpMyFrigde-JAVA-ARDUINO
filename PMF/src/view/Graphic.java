package view;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import model.DataStorage;

/**
 * Class Graphic in which we fill and display the graphic
 */
public class Graphic extends JFrame {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;

	private XYSeries insideTemperature, outsideTemperature, humidity;
	private XYSeriesCollection graphic;
	private JFreeChart chart;
	private XYDataset dataset;

	private ChartPanel chartPanel;
 
	private float[][] data = new float[4][10];

	private int x = 0, time = 0;

	private DataStorage dataStorage;
 
	/**
	 * Constructor Graphic which uses
	 * 
	 * @param chunksCreator 
	 */
	public Graphic(DataStorage dataStorage) {
		this.dataStorage = dataStorage;
		this.graphic = new XYSeriesCollection();
	}

	/**
	 * Method to instantiate the JFrame of the graphic.
	 * 
	 */
	public void initUI() {
		this.dataset = createDataset();
		this.chart = createChart(dataset);
		this.chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.WHITE);
		add(chartPanel);
		pack(); 
		setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Graphic.HIDE_ON_CLOSE);
	} 

	public void updateGraphic() {
		this.dataset = createDataset();
		this.chart = createChart(dataset);
	}

	/**
	 * Method that create the XYDataSet and fills the 2 variables (temperature and
	 * humidity) with the data stored in the array (array) Then the 2 variables are
	 * added to the XYSeriesCollection
	 * 
	 * @return graphic
	 */
	public XYDataset createDataset() {

		insideTemperature = new XYSeries("Inside Temperature °C ");
		humidity = new XYSeries("Humidity %");
		outsideTemperature = new XYSeries("Outside Temperature °C ");

		this.insideTemperature.clear();
		this.outsideTemperature.clear();
		this.humidity.clear();

		this.graphic.removeAllSeries();
 
		for (int i = 0; i < 9; i++) {
			this.outsideTemperature.add(data[3][i], data[0][i]);
			this.insideTemperature.add(data[3][i], data[1][i]);
			this.humidity.add(data[3][i], data[2][i]);
		}

		this.graphic.addSeries(outsideTemperature);
		this.graphic.addSeries(insideTemperature);
		this.graphic.addSeries(humidity);

		time++; 

		return graphic;
	}
 
	/**
	 * Method that update the array.
	 */
	public void updateTable() {
		if (x < 10) {
			data[0][x] = Float.parseFloat(this.dataStorage.getArray()[0]);
			data[1][x] = Float.parseFloat(this.dataStorage.getArray()[1]);
			data[2][x] = Float.parseFloat(this.dataStorage.getArray()[2]);
			data[3][x] = time;
			x++; 
		}

		else {
			for (int i = 0; i < 9; i++) {
				data[0][i] = data[0][i + 1];
				data[1][i] = data[1][i + 1];
				data[2][i] = data[2][i + 1];
				data[3][i] = data[3][i + 1];
			}
			data[0][9] = Float.parseFloat(this.dataStorage.getArray()[0]);
			data[1][9] = Float.parseFloat(this.dataStorage.getArray()[1]);
			data[2][9] = Float.parseFloat(this.dataStorage.getArray()[2]);
			data[3][9] = time;
			time++;
		} 
	}
 
	/**
	 * Method that create the chart.
	 * 
	 * @param dataset
	 * @return chart
	 */ 
	private JFreeChart createChart(final XYDataset dataset) {

		JFreeChart chart = ChartFactory.createXYLineChart("Temp °C  & Humidity % Curve", "Time (secondes)", "",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();
 
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(1.4f));

		renderer.setSeriesPaint(1, Color.GREEN); 
		renderer.setSeriesStroke(1, new BasicStroke(1.4f));
  
		renderer.setSeriesPaint(2, Color.BLUE);
		renderer.setSeriesStroke(2, new BasicStroke(1.4f));
  
		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white); 

		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		plot.setRangeGridlinesVisible(true);
		plot.setRangeGridlinePaint(Color.BLACK);
		plot.setDomainGridlinesVisible(true); 
		plot.setDomainGridlinePaint(Color.BLACK);
		chart.getLegend().setFrame(BlockBorder.NONE);
		
		return chart; 
	}  

	/** 
	 * Getter of data. 
	 * 
	 * @return data
	 */
	public float[][] getData() {
		return data;
	}
}
