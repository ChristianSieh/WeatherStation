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
    public Double temperature;
    public Double humidity;
    public Double barometer;
    public Double windSpeed;
    public String windDirection;
    public Double windGust;
    public Double windChill;
    public Double heatIndex;
    public Double uvIndex;
    public Double rainfall;
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
            date = child.getValue().trim();
        }
        child = xmlData.getChild("time");
        if(child != null)
        {
            time = child.getValue().trim();
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
            temperature = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("humidity");
        if(child != null)
            humidity = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("barometer");
        if(child != null)
            barometer = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("windspeed");
        if(child != null)
            windSpeed = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("winddirection");
        if(child != null)
            windDirection = child.getValue().trim();
        child = xmlData.getChild("windgust");
        if(child != null)
            windGust = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("windchill");
        if(child != null)
            windChill = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("heatindex");
        if(child != null)
            heatIndex = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("uvindex");
        if(child != null)
            uvIndex = Double.parseDouble(child.getValue().trim());
        child = xmlData.getChild("rainfall");
        if(child != null)
            rainfall = Double.parseDouble(child.getValue().trim());
    }
}
