/******************************************************************************
 * File: WeatherWeek.java                                                     *
 ******************************************************************************/

package weatherstation;

import java.util.ArrayList;

/*=====================================================================
 Class: WeatherWeek

 Extends/Implements: None

 Description: 
    This class defines a constructor and fields for a weather week.
======================================================================*/
public class WeatherWeek { 
    public int week;                    //Week of weather chosen
    public double meanTemp = 0;         //Mean weekly temperature
    public double highTemp = -10000000; //Max weekly temperature
    public double lowTemp = 100000000;  //Min weekly temperature
    public String highDate;             //Date of max weekly temperature
    public String lowDate;              //Date of min weekly temperature
    public String highTime;             //Time of max weekly temperature
    public String lowTime;              //Time of min weekly temperature
    public double meanWindSpeed = 0;    //Mean weekly wind speed
    public double maxWindSpeed;         //Max weekly wind speed
    public String windSpeedDate;        //Date of max weekly wind speed
    public String windSpeedTime;        //Time of max weekly wind speed
    public String windDirection;        //Wind direction
    public int windDirectionValue = -1; //Initial value for wind direction
    public double totalRainfall = 0;    //Total rainfall
    ArrayList<WeatherDay> days;         //Days the weather week covers
    
    /*==========================================================================
        Function: WeatherWeek()
    
        Description: 
            This function is a constructor for the WeatherWeek class, it
        instantiates an ArrayList for WeatherDays and an integer for the week. 
    
        Parameters: int weekValue - The week chosen by user.
    
        Returns: None
    ==========================================================================*/
    WeatherWeek(int weekValue)
    {
           week = weekValue;
           days = new ArrayList<WeatherDay>();
    }
}
