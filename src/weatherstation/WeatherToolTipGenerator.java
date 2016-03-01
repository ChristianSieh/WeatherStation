/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author 1960681
 */
public class WeatherToolTipGenerator implements XYToolTipGenerator
{
    @Override
    public String generateToolTip(XYDataset xyDataset, int series, int item)
    {
        String windDirection;
        
        DecimalFormat form = new DecimalFormat("00.0");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm");
        Number time = xyDataset.getX(series, item);
        windDirection = checkWindDirection((int)xyDataset.getYValue(9, item));
        
        return ("<html>" + sdf.format(time) + "<br>"
        + " Temperature: " + form.format(xyDataset.getYValue(0, item)) + "<br>"
        + "Humidity: " + form.format(xyDataset.getYValue(1, item)) + "<br>"
        + "Barometric Pressure: " + form.format(xyDataset.getYValue(2, item)) + "<br>"
        + "Wind Speed: " + form.format(xyDataset.getYValue(3, item)) + "<br>"
        + "Wind Chill: " + form.format(xyDataset.getYValue(4, item)) + "<br>"
        + "Heat Index: " + form.format(xyDataset.getYValue(5, item)) + "<br>"
        + "UV Index: " + form.format(xyDataset.getYValue(6, item)) + "<br>"
        + "Rainfall: " + form.format(xyDataset.getYValue(7, item)) + "<br>"
        + "Wind Gust: " + form.format(xyDataset.getYValue(8, item)) + "<br>"
        + "Wind Direction: " + windDirection + "</html>");
    }
    
    public String checkWindDirection(int windValue) {
        String windDirection;
        
        if (windValue == -1){
            windDirection = "None";
            return windDirection;
        } 
        
        WindDirection test = WindDirection.values()[windValue];
        windDirection = test.name();

        return windDirection;
    } 
}
