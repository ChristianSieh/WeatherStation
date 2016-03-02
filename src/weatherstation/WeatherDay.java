/******************************************************************************
 * File: WeatherDay.java                                                      *
 ******************************************************************************/
package weatherstation;

import java.util.ArrayList;

/*=====================================================================
 Class: WeatherDay
 
 Extends/Implements: None
 
 Description: 
    This class defines a constructor and fields for a weather day.
======================================================================*/
public class WeatherDay {
    
    public int month;
    public int week;
    public int day;
    public double meanTemp = 0;
    public double highTemp = -10000000;
    public double lowTemp = 100000000;
    public String highDate;
    public String lowDate;
    public String highTime;
    public String lowTime;
    public double meanWindSpeed = 0;
    public double maxWindSpeed = 0;
    public String windSpeedDate;
    public String windSpeedTime;
    public String windDirection;
    public int windDirectionValue = -1;
    public double totalRainfall = 0;
    ArrayList<WeatherData> data;
    
	/*==========================================================================
        Function: WeatherDay()
    
        Description: 
            This function is a constructor for the WeatherDay class, it 
        instantiates an ArrayList for the current weather data. 
    
        Parameters: int month - The month value for the current weather day.
    
        Returns: None
    ==========================================================================*/
    WeatherDay()
    {
        data = new ArrayList<WeatherData>();
    }
}
