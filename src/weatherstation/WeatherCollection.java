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
        barometricSeries = new TimeSeries("BarometricPressure");
        windSpeedSeries = new TimeSeries("WindSpeed");
        windChillSeries = new TimeSeries("WindChill");
        heatIndexSeries = new TimeSeries("HeatIndex");
        uvIndexSeries = new TimeSeries("UVIndex");
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
                WeatherDay tempDay = yearsList.get(year).days.get(i);
                
                for(int j = 0; j < yearsList.get(year).days.get(i).data.size(); j++)
                {
                    WeatherData tempData = tempDay.data.get(j);
                    Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day, tempData.month + 1, tempData.year);
                    temperatureSeries.add(minuteType, tempData.temperature);
                    humiditySeries.add(minuteType, tempData.humidity);
                    barometricSeries.add(minuteType, tempData.barometer);
                    windSpeedSeries.add(minuteType, tempData.windSpeed);
                    windChillSeries.add(minuteType, tempData.windChill);
                    heatIndexSeries.add(minuteType, tempData.heatIndex);
                    uvIndexSeries.add(minuteType, tempData.uvIndex);
                    rainfallSeries.add(minuteType, tempData.rainfall);
                }
            }
        }
        
        else if(display == "Month")
        {
            WeatherMonth tempMonth = yearsList.get(year).months.get(month);
            
            for(int i = 0; i < tempMonth.days.size(); i++)
            {
                WeatherDay tempDay = tempMonth.days.get(i);
                
                for(int j = 0; j < tempDay.data.size(); j++)
                {
                    WeatherData tempData = tempDay.data.get(j);
                    Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day, tempData.month + 1, tempData.year);
                    temperatureSeries.add(minuteType, tempData.temperature);
                    humiditySeries.add(minuteType, tempData.humidity);
                    barometricSeries.add(minuteType, tempData.barometer);
                    windSpeedSeries.add(minuteType, tempData.windSpeed);
                    windChillSeries.add(minuteType, tempData.windChill);
                    heatIndexSeries.add(minuteType, tempData.heatIndex);
                    uvIndexSeries.add(minuteType, tempData.uvIndex);
                    rainfallSeries.add(minuteType, tempData.rainfall);
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
                Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day + 1, tempData.month + 1, tempData.year);
                temperatureSeries.add(minuteType, tempData.temperature);
                humiditySeries.add(minuteType, tempData.humidity);
                barometricSeries.add(minuteType, tempData.barometer);
                windSpeedSeries.add(minuteType, tempData.windSpeed);
                windChillSeries.add(minuteType, tempData.windChill);
                heatIndexSeries.add(minuteType, tempData.heatIndex);
                uvIndexSeries.add(minuteType, tempData.uvIndex);
                rainfallSeries.add(minuteType, tempData.rainfall);
            }
        }
    }
    
    public void addSeries(String label)
    {
        Series temp = Series.valueOf(label);
        
        switch (temp) {
            case Temperature:
                addSeries(temperatureSeries);
                break;
            
            case Humidity:
                addSeries(humiditySeries);
                break;
                
            case BarometricPressure:
                addSeries(barometricSeries);
                break;
                
            case WindSpeed:
                addSeries(windSpeedSeries);
                break;
                
            case WindChill:
                addSeries(windChillSeries);
                break;
                
            case HeatIndex:
                addSeries(heatIndexSeries);
                break;
                
            case UVIndex:
                addSeries(uvIndexSeries);
                break;
                
            case Rainfall:
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
        Temperature,
        Humidity,
        BarometricPressure,
        WindSpeed,
        WindChill,
        HeatIndex,
        UVIndex,
        Rainfall
    }
}
