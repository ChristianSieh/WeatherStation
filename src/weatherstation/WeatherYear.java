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
    ArrayList<WeatherMonth> months;
    ArrayList<WeatherWeek> weeks;
    ArrayList<WeatherDay> days;
    
    WeatherYear(int yearValue)
    {
        year = yearValue;
        months = new ArrayList<WeatherMonth>();
        weeks = new ArrayList<WeatherWeek>(52);
        days = new ArrayList<WeatherDay>();
    }
}
