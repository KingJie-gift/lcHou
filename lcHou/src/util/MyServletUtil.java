package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;

public class MyServletUtil extends ServletUtilities {
	
	public static String save(JFreeChart chart, int width, int height,String path)
			throws IOException {

		if (chart == null) {
			throw new IllegalArgumentException("Null 'chart' argument.");
		}
		ServletUtilities.createTempDir();
		String prefix = "jfreechart-onetime-";
		
		File tempFile = File.createTempFile(prefix, ".png", new File(path));
		ChartUtilities.saveChartAsPNG(tempFile, chart, width, height, null);

		return tempFile.getName();
	}
}
