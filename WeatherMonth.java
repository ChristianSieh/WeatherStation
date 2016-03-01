/******************************************************************************
 * File: WeatherMonth.java                                                      *
 ******************************************************************************/
package weatherstation;

import java.util.ArrayList;

/*=====================================================================
 Class: WeatherMonth

 Extends/Implements: None

 Description: 
    This class defines a constructor and fields for a weather month.
======================================================================*/
public class WeatherMonth {
    
    public int month;                   //Month of weather chosen
    public double meanTemp;             //Mean temperature
    public double highTemp;             //Max temperature
    public double lowTemp;              //Min temperature
    public String highDate;             //Date of max temperature
    public String lowDate;              //Date of min temperature
    public String highTime;             //Time of max temperature
    public String lowTime;              //Time of min temperature
    public double meanWindSpeed;        //Mean wind speed
    public double maxWindSpeed;         //Max wind speed
    public String windSpeedDate;        //Date of max wind speed
    public String windSpeedTime;        //Time of max wind speed
    public String windDirection;        //Direction of wind
    public int windDirectionValue = -1; //Initial value for wind direction
    public double totalRainfall;        //Total Rainfall
    ArrayList<WeatherDay> days;         //Days the weather month covers
    
    /*==========================================================================
        Function: WeatherMonth()
    
        Description: 
            This function is a constructor for the WeatherYear class, an int for
        the month value and instantiates an ArrayList for days.
    
        Parameters: int yearValue - The month chosen by user.
    
        Returns: None
    ==========================================================================*/
    WeatherMonth(int monthValue)
    {
           month = monthValue;
           days = new ArrayList<WeatherDay>();
    }
    
    
}
