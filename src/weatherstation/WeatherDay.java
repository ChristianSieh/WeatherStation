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
public class WeatherDay {
    
    public int month;
    public int week;
    ArrayList<WeatherData> data;
    
    WeatherDay(int month)
    {
        data = new ArrayList<WeatherData>();
    }
}
