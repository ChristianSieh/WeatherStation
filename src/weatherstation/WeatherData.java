/******************************************************************************
 * File: WeatherData.java                                                     *
 ******************************************************************************/
package weatherstation;

import org.jdom2.*;

/*==============================================================================
    Class: WeatherData
	
    Extends/Implements: None
	
    Description: 
        This class defines a constructor and fields for an element of 
    weather data.
==============================================================================*/
public class WeatherData {
    
    public String date;
    public String time;
    public double temperature;
    public double humidity = 0.0;
    public double barometer = 0.0;
    public double windSpeed = 0.0;
    public String windDirection;
    public double windDirectionValue = -1;
    public double windGust = 0.0;
    public double windChill = 0.0;
    public double heatIndex = 0.0;
    public double uvIndex = 0.0;
    public double rainfall = 0.0;
    public int year;
    public int month;
    public int day;
    public int hour;
    public int minute;
    
	/*==========================================================================
        Function: WeatherData()
    
        Description: 
            This function is a constructor for the WeatherData class, it 
        parses XML elements ( namely <weather> ) to get the weather data.
    
        Parameters: Element xmlData - The element of XML data to be parsed
    
        Returns: None
    ==========================================================================*/
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
            if(meridiem.equalsIgnoreCase("P") && hour != 12)
                hour += 12;
            if(meridiem.equalsIgnoreCase("A") && hour == 12)
            {
                hour = 0;
            }
        }
        child = xmlData.getChild("temperature");
        if(child != null)
            temperature = Double.parseDouble(child.getValue().trim());
        else
            temperature = 0.0;
        
        child = xmlData.getChild("humidity");
        if(child != null)
            humidity = Double.parseDouble(child.getValue().trim());
        else
            humidity = 0.0;
        
        child = xmlData.getChild("barometer");
        if(child != null)
            barometer = Double.parseDouble(child.getValue().trim());
        else
            barometer = 0.0;
        
        child = xmlData.getChild("windspeed");
        if(child != null)
            windSpeed = Double.parseDouble(child.getValue().trim());
        else
            windSpeed = 0.0;
        
        child = xmlData.getChild("winddirection");
        if(child != null) {
            windDirection = child.getValue().trim();
            WindDirection val = WindDirection.valueOf(windDirection);
            windDirectionValue = val.value;
        }
        else
            windDirection = "None";
        
        child = xmlData.getChild("windgust");
        if(child != null)
            windGust = Double.parseDouble(child.getValue().trim());
        else
            windGust = 0.0;
        
        child = xmlData.getChild("windchill");
        if(child != null)
            windChill = Double.parseDouble(child.getValue().trim());
        else
            windChill = 0.0;
        
        child = xmlData.getChild("heatindex");
        if(child != null)
            heatIndex = Double.parseDouble(child.getValue().trim());
        else
            heatIndex = 0.0;
        
        child = xmlData.getChild("uvindex");
        if(child != null)
            uvIndex = Double.parseDouble(child.getValue().trim());
        else
            uvIndex = 0.0;
        
        child = xmlData.getChild("rainfall");
        if(child != null)
            rainfall = Double.parseDouble(child.getValue().trim());
        else
            rainfall = 0.0;
        
    }
}
