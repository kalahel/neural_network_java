package com.ucp.DAO.neuralNetwork.charts;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import java.util.List;

public class GraphFrame extends ApplicationFrame {
    public GraphFrame(String title, List<Double> errorValues) {

        super(title);
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Error evolution",
                "Iteration", "Error Value",
                createDataset(errorValues),
                PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
        setContentPane(chartPanel);
    }

    private DefaultCategoryDataset createDataset(List<Double> errorValues) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < errorValues.size(); i++) {
            dataset.addValue(errorValues.get(i), "error", Integer.toString(i));
        }

        return dataset;
    }

}
