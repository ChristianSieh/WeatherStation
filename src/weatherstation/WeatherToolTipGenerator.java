/******************************************************************************
 * File: WeatherToolTipGenerator.java                                         *
 ******************************************************************************/
package weatherstation;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.data.xy.XYDataset;

/*==============================================================================
    Class: WeatherToolTipGenerator
    Extends/Implements: XYToolTipGenerator (From JFreeChars.org)
    Description: 
        This class helps display tool tips of the graph when the user hovers
    over a data point.
==============================================================================*/
public class WeatherToolTipGenerator implements XYToolTipGenerator
{
    @Override
    public String generateToolTip(XYDataset xyDataset, int series, int item)
    {
        //String for the wind direction
        String windDirection;
        
        //Format the data
        DecimalFormat form = new DecimalFormat("00.0");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy HH:mm");
        Number time = xyDataset.getX(series, item);
        windDirection = checkWindDirection((int)xyDataset.getYValue(9, item));
        
        //Return the formatted text for the tool tip
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
    
    /*==========================================================================
        Function: checkWindDirection()

        Description: 
            This function is a constructor for the WeatherData class, it 
        parses XML elements ( namely <weather> ) to get the weather data.

        Parameters: 
            int windValue - Value the wind direction is set at.

        Returns: windDirection
    ==========================================================================*/
    public String checkWindDirection(int windValue) {
        String windDirection;
        
        //If there is no wind direction
        if (windValue == -1){
            windDirection = "None";
            return windDirection;
        } 
        
        WindDirection windEnum = WindDirection.values()[windValue];
        windDirection = windEnum.name();

        return windDirection;
    } 
}
