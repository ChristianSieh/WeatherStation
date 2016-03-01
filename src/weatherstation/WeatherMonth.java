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
public class WeatherMonth {
    
    public int month;
    public double meanTemp;
    public double highTemp;
    public double lowTemp;
    public String highDate;
    public String lowDate;
    public String highTime;
    public String lowTime;
    public double meanWindSpeed;
    public double maxWindSpeed;
    public String windSpeedDate;
    public String windSpeedTime;
    public String windDirection;
    public int windDirectionValue = -1;
    public double totalRainfall;
    ArrayList<WeatherDay> days;
    
    WeatherMonth(int monthValue)
    {
           month = monthValue;
           days = new ArrayList<WeatherDay>();
    }
    
    
}
