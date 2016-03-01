/******************************************************************************
 * File: WeatherData.java                                                     *
 ******************************************************************************/

package weatherstation;

import org.jdom2.*;     //For parsing xml elements

/*==============================================================================
    Class: WeatherData

    Extends/Implements: None

    Description: 
        This class defines a constructor and fields for an element of 
    weather data.
==============================================================================*/
public class WeatherData {
    
    public String date;                     //Date of weather data
    public String time;                     //Time of weather data
    public Double temperature;              
    public Double humidity;
    public Double barometer;
    public Double windSpeed;
    public String windDirection;
    public double windDirectionValue = -1;
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
        //Get date child
        Element child = xmlData.getChild("date");
        
        //If the date field has data
        if(child != null)
        {
            //Parse the date
            date = child.getValue().trim();
        }
        
        //Get time child
        child = xmlData.getChild("time");
        
        //If the time field has data
        if(child != null)
        {
            //Parse the time
            time = child.getValue().trim();
            String[] temp = time.split(":");
           
            //Trim each side of the time string
            for(int i = 0; i < temp.length; i++)
                temp[i] = temp[i].trim();
           
            //Fill temp with the hour
            hour = Integer.parseInt(temp[0]);
            String meridiem = temp[1].substring(temp[1].length() - 1);
            
            //Fill temp with the minute
            minute = Integer.parseInt(temp[1].substring(0, temp[1].length() - 1));
            
            //Special case for noon 
            if(meridiem.equalsIgnoreCase("P") && hour != 12)
                hour += 12;
            
            //Special case for midnight
            if(meridiem.equalsIgnoreCase("A") && hour == 12)
                hour = 0;
        }
        
        //Get temperature child
        child = xmlData.getChild("temperature");
        
        //If the temperature field has data
        if(child != null)
            //Retrieve temperature data
            temperature = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise initialize temperature to zero
            temperature = 0.0;
        
        //Get humidity child
        child = xmlData.getChild("humidity");
        
        //If the humidity field has data 
        if(child != null)
            //Retrieve humidity data
            humidity = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise initialize humidity to zero
            humidity = 0.0;
        
        //Get barometer child
        child = xmlData.getChild("barometer");
        
        //If the barometer field has data
        if(child != null)
            //Retrieve barometer data
            barometer = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise intitialize barometer to zero
            barometer = 0.0;
        
        //Get windspeed child
        child = xmlData.getChild("windspeed");
        
        //If the windspeed field has data
        if(child != null)
            //Retreive windspeed data
            windSpeed = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise intitialize windspeed to zero 
            windSpeed = 0.0;
        
        //Get winddirection child
        child = xmlData.getChild("winddirection");
        
        //If the winddirection field has data
        if(child != null) {
            //Retrive the data and parse it into windDirectionValue
            windDirection = child.getValue().trim();
            WindDirection val = WindDirection.valueOf(windDirection);
            windDirectionValue = val.value;
        }
        else
            //Otherwise set wind direction to none
            windDirection = "None";
        
        //Get windgust child
        child = xmlData.getChild("windgust");
  
        //If the windgust field has data
        if(child != null)
            //Retrieve the data 
            windGust = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise set wind gust to zero
            windGust = 0.0;
        
        //Get windchill child
        child = xmlData.getChild("windchill");
        
        //If the windchill field has data
        if(child != null)
            //Retrieve the data
            windChill = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise set wind chill to zero
            windChill = 0.0;
       
        //Get heatindex child
        child = xmlData.getChild("heatindex");
        
        //If the heatindex field has data
        if(child != null)
            //Retrieve the data
            heatIndex = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise set heatindex to zero
            heatIndex = 0.0;
        
        //Get uvindex child
        child = xmlData.getChild("uvindex");
        
        //If the uvindex field has data
        if(child != null)
            //Retrieve the data
            uvIndex = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise set uvindex to zero
            uvIndex = 0.0;
        
        //Get rainfall child
        child = xmlData.getChild("rainfall");
        
        //if the rainfall field has data
        if(child != null)
            //Retrieve the data
            rainfall = Double.parseDouble(child.getValue().trim());
        else
            //Otherwise set rainfall to zero
            rainfall = 0.0;
        
    }
}
