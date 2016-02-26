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
    ArrayList<WeatherDay> days;
    
    WeatherMonth(int monthValue, int daysInMonth)
    {
           month = monthValue;
           days = new ArrayList<WeatherDay>(daysInMonth);
    }
    
    
}
