package classes;


import java.io.IOException;

import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.style.Styler.ChartTheme;


public class CarbonFootprintDataVisualization {
	public CarbonFootprintDataVisualization(double[] values) {
	    createPieChart();
	}
	public void createPieChart() {
		PieChart chart = new PieChartBuilder().width(800).height(600).title("My Pie Chart").theme(ChartTheme.GGPlot2).build();
		chart.getStyler().setLegendVisible(false);

	    chart.getStyler().setPlotContentSize(.7);
	    chart.getStyler().setStartAngleInDegrees(90);
	    chart.addSeries("Prague", 2);
	    chart.addSeries("Dresden", 4);
	    chart.addSeries("Munich", 34);
	    chart.addSeries("Hamburg", 22);
	    chart.addSeries("Berlin", 29);
	    
	    new SwingWrapper(chart).displayChart();
	    
	}
	
	public static void main(String[] args) throws IOException {
		CarbonFootprintDataVisualization c = new CarbonFootprintDataVisualization(new double[5]);
	}
	
}
