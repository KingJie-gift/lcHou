package entity;

import java.awt.Color;
import java.awt.Font;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChartDemo1 {
	// 数据采集 （被调用）
	private static CategoryDataset createDataset(List<ClassTalk> list) {
		DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
		// 第一条折线数据 折线名Series 1
		for (int i = 0; i < list.size(); i++) {
			localDefaultCategoryDataset.addValue(list.get(i).getTime(), "演讲时间", "D"+(i+1));
			localDefaultCategoryDataset.addValue(list.get(i).getTaifeng(), "台风",  "D"+(i+1) );
			localDefaultCategoryDataset.addValue(list.get(i).getSmooth(), "流畅性","D"+(i+1) );
			localDefaultCategoryDataset.addValue(list.get(i).getActive(), "互动性", "D"+(i+1) );
			localDefaultCategoryDataset.addValue(list.get(i).getContent(), "内容", "D"+(i+1) );
		}
		
		return localDefaultCategoryDataset;
	}   

	/**
	 * 生成折线图（被调用）
	 * 
	 * @param chartTitle
	 *            图的标题
	 * @param x
	 *            横轴标题
	 * @param y
	 *            纵轴标题
	 * @param dataset
	 *            数据集
	 * @return
	 */
	private static JFreeChart createChart(String chartTitle, String x,
			String y, CategoryDataset dataset) {
		// 构建一个chart
		JFreeChart chart = ChartFactory.createLineChart(chartTitle,// 图的标题
				x, // x轴标题
				y, // y轴标题
				dataset,// 数据点
				PlotOrientation.VERTICAL, true, true, false);
		// 字体清晰
		chart.setTextAntiAlias(false);
		// 设置背景颜色
		chart.setBackgroundPaint(Color.WHITE);

		// 设置图标题的字体
		Font font = new Font("隶书", Font.BOLD, 25);
		chart.getTitle().setFont(font);

		// 设置面板字体
		Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
		// 设置图示的字体
		chart.getLegend().setItemFont(labelFont);

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		// x轴 // 分类轴网格是否可见
		categoryplot.setDomainGridlinesVisible(true);
		// y轴 //数据轴网格是否可见
		categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setRangeGridlinePaint(Color.gray);// 虚线色彩
		categoryplot.setDomainGridlinePaint(Color.gray);// 虚线色彩
		categoryplot.setBackgroundPaint(Color.white);// 折线图的背景颜色

		// 设置轴和面板之间的距离
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

		// 横轴 x
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setLabelFont(labelFont);// 轴标题
		domainAxis.setTickLabelFont(labelFont);// 轴数值
		// domainAxis.setLabelPaint(Color.BLUE);//轴标题的颜色
		// domainAxis.setTickLabelPaint(Color.BLUE);//轴数值的颜色

		// 横轴 lable 的位置 横轴上的 Lable 45度倾斜 DOWN_45
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

		// 设置距离图片左端距离
		domainAxis.setLowerMargin(0.0);
		// 设置距离图片右端距离
		domainAxis.setUpperMargin(0.0);

		// 纵轴 y
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setLabelFont(labelFont);
		numberaxis.setTickLabelFont(labelFont);
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);

		// 获得renderer 注意这里是下嗍造型到lineandshaperenderer！！
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true); // series 点（即数据点）可见
		lineandshaperenderer.setBaseLinesVisible(true); // series 点（即数据点）间有连线可见

		// 显示折点数据
		lineandshaperenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineandshaperenderer.setBaseItemLabelsVisible(true);

		return chart;
	}

	// 获取JFreeChart
	public static JFreeChart createDemoPanel(List<ClassTalk> list) {
		CategoryDataset database = createDataset(list);
		JFreeChart localJFreeChart = createChart("小演讲", "时间", "分数", database);

		return localJFreeChart;
	}

}
