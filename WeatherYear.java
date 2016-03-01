/******************************************************************************
 * File: WeatherYear.java                                                     *
 ******************************************************************************/

package weatherstation;

import java.util.ArrayList;

/*=====================================================================
 Class: WeatherYear

 Extends/Implements: None

 Description: 
    This class defines a constructor and fields for a weather year.
======================================================================*/
public class WeatherYear {
    public int year;                    //Year of weather chosen
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
    public String windDirection;        //Direction of wind
    public int windDirectionValue = -1; //Initial value for wind direction
    public double totalRainfall = 0;    //Total Rainfall
    ArrayList<WeatherMonth> months;     //Months the weather year covers
    ArrayList<WeatherWeek> weeks;       //Weeks the weather year covers
    ArrayList<WeatherDay> days;         //Days the weather year covers
    
    /*==========================================================================
        Function: WeatherYear()
    
        Description: 
            This function is a constructor for the WeatherYear class, it
    instantiates ArrayLists for months, weeks, days and an integer for the year. 
    
        Parameters: int yearValue - The year chosen by user.
    
        Returns: None
    ==========================================================================*/
    WeatherYear(int yearValue)
    {
        year = yearValue;
        months = new ArrayList<WeatherMonth>();
        weeks = new ArrayList<WeatherWeek>(53);
        days = new ArrayList<WeatherDay>();
    }
}
