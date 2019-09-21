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

public class LineChartDemo {
	// ���ݲɼ� �������ã�
	public static CategoryDataset createDataset(List<interview> list) {
		DefaultCategoryDataset localDefaultCategoryDataset = new DefaultCategoryDataset();
		
		
		for (int i = 0; i < list.size(); i++) {
			localDefaultCategoryDataset.addValue(list.get(i).getJieshao(),  "���ҽ���", "no"+(i+1));
			localDefaultCategoryDataset.addValue(list.get(i).getProblem(), "��������", "no"+(i+1));
			 
		}
		
		return localDefaultCategoryDataset;
	}

	/**
	 * ��������ͼ�������ã�
	 * 
	 * @param chartTitle
	 *            ͼ�ı���
	 * @param x
	 *            �������
	 * @param y
	 *            �������
	 * @param dataset
	 *            ���ݼ�
	 * @return
	 */
	private static JFreeChart createChart(String chartTitle, String x,
			String y, CategoryDataset dataset) {
		// ����һ��chart
		JFreeChart chart = ChartFactory.createLineChart(chartTitle,// ͼ�ı���
				x, // x�����
				y, // y�����
				dataset,// ���ݵ�
				PlotOrientation.VERTICAL, true, true, false);
		// ��������
		chart.setTextAntiAlias(false);
		// ���ñ�����ɫ
		chart.setBackgroundPaint(Color.WHITE);

		// ����ͼ���������
		Font font = new Font("����", Font.BOLD, 25);
		chart.getTitle().setFont(font);

		// �����������
		Font labelFont = new Font("SansSerif", Font.TRUETYPE_FONT, 12);
		// ����ͼʾ������
		chart.getLegend().setItemFont(labelFont);

		CategoryPlot categoryplot = (CategoryPlot) chart.getPlot();
		// x�� // �����������Ƿ�ɼ�
		categoryplot.setDomainGridlinesVisible(true);
		// y�� //�����������Ƿ�ɼ�
		categoryplot.setRangeGridlinesVisible(true);
		categoryplot.setRangeGridlinePaint(Color.gray);// ����ɫ��
		categoryplot.setDomainGridlinePaint(Color.gray);// ����ɫ��
		categoryplot.setBackgroundPaint(Color.WHITE);// ����ͼ�ı�����ɫ

		// ����������֮��ľ���
		// categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

		// ���� x
		CategoryAxis domainAxis = categoryplot.getDomainAxis();
		domainAxis.setLabelFont(labelFont);// �����
		domainAxis.setTickLabelFont(labelFont);// ����ֵ
		// domainAxis.setLabelPaint(Color.BLUE);//��������ɫ
		// domainAxis.setTickLabelPaint(Color.BLUE);//����ֵ����ɫ

		// ���� lable ��λ�� �����ϵ� Lable 45����б DOWN_45
		domainAxis.setCategoryLabelPositions(CategoryLabelPositions.STANDARD);

		// ���þ���ͼƬ��˾���
		domainAxis.setLowerMargin(0.0);
		// ���þ���ͼƬ�Ҷ˾���
		domainAxis.setUpperMargin(0.0);

		// ���� y
		NumberAxis numberaxis = (NumberAxis) categoryplot.getRangeAxis();
		numberaxis.setLabelFont(labelFont);
		numberaxis.setTickLabelFont(labelFont);
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		numberaxis.setAutoRangeIncludesZero(true);

		// ���renderer ע���������������͵�lineandshaperenderer����
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot
				.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true); // series �㣨�����ݵ㣩�ɼ�
		lineandshaperenderer.setBaseLinesVisible(true); // series �㣨�����ݵ㣩�������߿ɼ�

		// ��ʾ�۵�����
		lineandshaperenderer
				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
		lineandshaperenderer.setBaseItemLabelsVisible(true);

		return chart;
	}

	// ��ȡJFreeChart
	public static JFreeChart createDemoPanel(List<interview> list) {
		CategoryDataset database = createDataset(list);
		JFreeChart localJFreeChart = createChart("ģ������", "����", "����", database);

		return localJFreeChart;
	}

}
