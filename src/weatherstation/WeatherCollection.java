/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.util.ArrayList;
import org.jfree.data.time.Minute;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;

/**
 *
 * @author 1960681
 */
public class WeatherCollection extends TimeSeriesCollection
{
    private TimeSeries temperatureSeries;
    private TimeSeries humiditySeries;
    private TimeSeries barometricSeries;
    private TimeSeries windSpeedSeries;
    private TimeSeries windChillSeries;
    private TimeSeries heatIndexSeries;
    private TimeSeries uvIndexSeries;
    private TimeSeries rainfallSeries;
    
    public WeatherCollection()
    {
        temperatureSeries = new TimeSeries("Temperature");
        humiditySeries = new TimeSeries("Humidity");
        barometricSeries = new TimeSeries("Barometric Pressure");
        windSpeedSeries = new TimeSeries("Wind Speed");
        windChillSeries = new TimeSeries("Wind Chill");
        heatIndexSeries = new TimeSeries("Heat Index");
        uvIndexSeries = new TimeSeries("UV Index");
        rainfallSeries = new TimeSeries("Rainfall");
    }
    
    public void updateSeries(ArrayList<WeatherYear> yearsList,
            int year, int month, int day, String display)
    {
        temperatureSeries.clear();
        humiditySeries.clear();
        barometricSeries.clear();
        windSpeedSeries.clear();
        windChillSeries.clear();
        heatIndexSeries.clear();
        uvIndexSeries.clear();
        rainfallSeries.clear();
        
        if(display == "Year")
        {
            for(int i = 0; i < yearsList.get(year).days.size(); i++)
            {
                for(int j = 0; j < yearsList.get(year).days.get(i).data.size(); j++)
                {
                    temperatureSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).temperature));
                    humiditySeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).humidity));
                    barometricSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).barometer));
                    windSpeedSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).windSpeed));
                    windChillSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).windChill));
                    heatIndexSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).heatIndex));
                    uvIndexSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).uvIndex));
                    rainfallSeries.add(null, Integer.parseInt(yearsList.get(year).days.get(i).data.get(j).rainfall));
                }
            }
        }
        
        else if(display == "Month")
        {
            for(int i = 0; i < yearsList.get(year).months.get(month).days.size(); i++)
            {
                for(int j = 0; j < yearsList.get(year).months.get(month).days.get(i).data.size(); j++)
                {
                    temperatureSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).temperature));
                    humiditySeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).humidity));
                    barometricSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).barometer));
                    windSpeedSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).windSpeed));
                    windChillSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).windChill));
                    heatIndexSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).heatIndex));
                    uvIndexSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).uvIndex));
                    rainfallSeries.add(null, Integer.parseInt(yearsList.get(year).months.get(month).days.get(i).data.get(j).rainfall));
                }
            }
        }
        
        else if(display == "Week")
        {
            return;
        }
        
        else if(display == "Day")
        {
            WeatherDay tempDay = yearsList.get(year).months.get(month).days.get(day);
            
            for(int i = 0; i < tempDay.data.size(); i++)
            {
                WeatherData tempData = tempDay.data.get(i);
                Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day, tempData.month, tempData.year);
                temperatureSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).temperature));
                humiditySeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).humidity));
                barometricSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).barometer));
                windSpeedSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).windSpeed));
                windChillSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).windChill));
                heatIndexSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).heatIndex));
                uvIndexSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).uvIndex));
                rainfallSeries.add(minuteType, Integer.parseInt(yearsList.get(year).months.get(month).days.get(day).data.get(i).rainfall));
            }
        }
    }
    
    public void addSeries(String label)
    {
        Series temp = Series.valueOf(label);
        
        switch (temp) {
            case temperature:
                addSeries(temperatureSeries);
                break;
            
            case humidity:
                addSeries(humiditySeries);
                break;
                
            case barometricPressure:
                addSeries(barometricSeries);
                break;
                
            case windSpeed:
                addSeries(windSpeedSeries);
                break;
                
            case windChill:
                addSeries(windChillSeries);
                break;
                
            case heatIndex:
                addSeries(heatIndexSeries);
                break;
                
            case uvIndex:
                addSeries(uvIndexSeries);
                break;
                
            case rainfall:
                addSeries(rainfallSeries);
                break;
        }
    }
    
    public void removeSeries(String label)
    {
        int index = getSeriesIndex(label);
        removeSeries(index);
    }
    
    private enum Series{
        temperature,
        humidity,
        barometricPressure,
        windSpeed,
        windChill,
        heatIndex,
        uvIndex,
        rainfall
    }
}
