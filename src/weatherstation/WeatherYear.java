/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.util.ArrayList;

/**
 *
 * @author 1960681
 */
public class WeatherYear {
    public int year;
    public double meanTemp = 0;
    public double highTemp = -10000000;
    public double lowTemp = 100000000;
    public String highDate;
    public String lowDate;
    public String highTime;
    public String lowTime;
    public double meanWindSpeed = 0;
    public double maxWindSpeed;
    public String windSpeedDate;
    public String windSpeedTime;
    public String windDirection;
    public double totalRainfall = 0;
    ArrayList<WeatherMonth> months;
    ArrayList<WeatherWeek> weeks;
    ArrayList<WeatherDay> days;
    
    WeatherYear(int yearValue)
    {
        year = yearValue;
        months = new ArrayList<WeatherMonth>();
        weeks = new ArrayList<WeatherWeek>(53);
        days = new ArrayList<WeatherDay>();
    }
}
