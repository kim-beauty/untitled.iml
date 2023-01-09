package earthquake;
import java.awt.*;
import java.sql.Time;
import java.util.Map;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Graphik extends JFrame {
     public Graphik(Map<String, Float> value) {
       DrawGraph(value);
    }

    private JFreeChart createGraph(CategoryDataset dataset) {

        String title = "Постройте график по среднему количеству землетрясений для каждого года";
        String catAxixLabel = "Год";
        String value = "Среднее количество землятрясений в год";
        return ChartFactory.createBarChart(title, catAxixLabel, value, dataset, PlotOrientation.HORIZONTAL, true, true, true);
    }

    private void DrawGraph(Map<String, Float> average) {
        CategoryDataset dataset = createDS(average);
        JFreeChart chart = createGraph(dataset);
        chart.setBackgroundPaint(Color.white);
        chart.getTitle().setPaint(Color.black);
        ChartPanel chartPanel = new ChartPanel(chart);
        add(chartPanel);
        pack();
    }

    private CategoryDataset createDS(Map<String, Float> capitals) {
        DefaultCategoryDataset ds = new DefaultCategoryDataset();
        capitals.forEach((Time, Average) ->
               ds.setValue(Average, "Time", Time));
        return ds;}
    }
