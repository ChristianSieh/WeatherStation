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
    public int month;                   //Month of the chosen day
    public int week;                    //Week of the chosen day
    public double meanTemp = 0;         //Mean temperature
    public double highTemp = -10000000; //Max temperature
    public double lowTemp = 100000000;  //Min temperature
    public String highDate;             //Date of max temperature
    public String lowDate;              //Date of min temperature
    public String highTime;             //Time of max temperature
    public String lowTime;              //Time of min temperature
    public double meanWindSpeed = 0;    //Mean wind speed
    public double maxWindSpeed;         //Max wind speed
    public String windSpeedDate;        //Date of max wind speed
    public String windSpeedTime;        //Time of max wind speed
    public String windDirection;        //Wind direction
    public int windDirectionValue = -1; //Initial value for wind direction
    public double totalRainfall = 0;    //Total rainfall
    ArrayList<WeatherData> data;        //Weather data for the particular day.
   
    /*==========================================================================
        Function: WeatherDay()
    
        Description: 
            This function is a constructor for the WeatherDay class, it 
        instantiates an ArrayList for the current weather data. 
    
        Parameters: int month - The month value for the current weather day.
    
        Returns: None
    ==========================================================================*/
    WeatherDay(int month)
    {
        data = new ArrayList<WeatherData>();
    }
}
