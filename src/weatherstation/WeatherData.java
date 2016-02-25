/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import org.jdom2.*;

/**
 *
 * @author 1960681
 */
public class WeatherData {
    
    public String date;
    public String time;
    public String temperature;
    public String humidity;
    public String barometer;
    public String windSpeed;
    public String windDirection;
    public String windGust;
    public String windChill;
    public String heatIndex;
    public String uvIndex;
    public String rainfall;
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    
    WeatherData(Element xmlData)
    {
        Element child = xmlData.getChild("date");
        if(child != null)
        {
            date = child.getValue();
        }
        child = xmlData.getChild("time");
        if(child != null)
        {
            time = child.getValue();
            String[] temp = time.split(":");
            for(int i = 0; i < temp.length; i++)
            {
                temp[i] = temp[i].trim();
            }
            hour = Integer.parseInt(temp[0]);
            String meridiem = temp[1].substring(temp[1].length() - 1);
            minute = Integer.parseInt(temp[1].substring(0, temp[1].length() - 1));
            if(meridiem.equalsIgnoreCase("P"))
                hour += 12;
        }
        child = xmlData.getChild("temperature");
        if(child != null)
            temperature = child.getValue();
        child = xmlData.getChild("humidity");
        if(child != null)
            humidity = child.getValue();
        child = xmlData.getChild("barometer");
        if(child != null)
            barometer = child.getValue();
        child = xmlData.getChild("windspeed");
        if(child != null)
            windSpeed = child.getValue();
        child = xmlData.getChild("winddirection");
        if(child != null)
            windDirection = child.getValue();
        child = xmlData.getChild("windgust");
        if(child != null)
            windGust = child.getValue();
        child = xmlData.getChild("windchill");
        if(child != null)
            windChill = child.getValue();
        child = xmlData.getChild("heatindex");
        if(child != null)
            heatIndex = child.getValue();
        child = xmlData.getChild("uvindex");
        if(child != null)
            uvIndex = child.getValue();
        child = xmlData.getChild("rainfall");
        if(child != null)
            rainfall = child.getValue();
    }
}
