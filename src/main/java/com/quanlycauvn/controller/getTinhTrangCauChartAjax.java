package com.quanlycauvn.controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/chart/getTinhTrangCau")
public class getTinhTrangCauChartAjax extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OutputStream out = resp.getOutputStream(); /*
         * Get the output stream
         * from the response
         * object
         */
        try {
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            dataset.addValue(500, "Company A Revenue", "2009");
            dataset.addValue(550, "Company A Revenue", "2010");
            dataset.addValue(450, "Company A Revenue", "2011");
            dataset.addValue(650, "Company A Revenue", "2012");
            dataset.addValue(550, "Company A Revenue", "2013");
            dataset.addValue(700, "Company A Revenue", "2014");

            dataset.addValue(200, "Company B Revenue", "2009");
            dataset.addValue(450, "Company B Revenue", "2010");
            dataset.addValue(398, "Company B Revenue", "2011");
            dataset.addValue(425, "Company B Revenue", "2012");
            dataset.addValue(770, "Company B Revenue", "2013");
            dataset.addValue(810, "Company B Revenue", "2014");

            /* create chart */
            JFreeChart chart = ChartFactory.createLineChart("", "Year",
                    "Revenue in M$", dataset, PlotOrientation.VERTICAL, false,
                    true, false);

            /* Set the HTTP Response Type */
            resp.setContentType("image/png");

            /* Writes a chart to an output stream in PNG format */
            ChartUtilities.writeChartAsPNG(out, chart, 600, 500);
        } catch (Exception e) {
            System.err.println(e.toString()); /* Throw exceptions to log files */
        } finally {
            out.close();/* Close the output stream */
        }
        }
    }
