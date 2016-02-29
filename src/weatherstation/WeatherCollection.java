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
    private TimeSeries windGustSeries;
    //private TimeSeries windDirectionSeries;
    
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
        windGustSeries = new TimeSeries("WindGust");
        //windDirectionSeries = new TimeSeries("WindDirection");
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
        windGustSeries.clear();
        //windDirectionSeries.clear();
        
        if(display == "Year")
        {
            for(int i = 0; i < yearsList.get(year).days.size(); i++)
            {
                WeatherDay tempDay = yearsList.get(year).days.get(i);
                
                for(int j = 0; j < yearsList.get(year).days.get(i).data.size(); j++)
                {
                    WeatherData tempData = tempDay.data.get(j);
                    Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day + 1, tempData.month + 1, tempData.year);
                    temperatureSeries.add(minuteType, tempData.temperature);
                    humiditySeries.add(minuteType, tempData.humidity);
                    barometricSeries.add(minuteType, tempData.barometer);
                    windSpeedSeries.add(minuteType, tempData.windSpeed);
                    windChillSeries.add(minuteType, tempData.windChill);
                    heatIndexSeries.add(minuteType, tempData.heatIndex);
                    uvIndexSeries.add(minuteType, tempData.uvIndex);
                    rainfallSeries.add(minuteType, tempData.rainfall);
                    windGustSeries.add(minuteType, tempData.windGust);
                    //windDirectionSeries.add(minuteType, tempData.windDirection);
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
                    Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day + 1, tempData.month + 1, tempData.year);
                    temperatureSeries.add(minuteType, tempData.temperature);
                    humiditySeries.add(minuteType, tempData.humidity);
                    barometricSeries.add(minuteType, tempData.barometer);
                    windSpeedSeries.add(minuteType, tempData.windSpeed);
                    windChillSeries.add(minuteType, tempData.windChill);
                    heatIndexSeries.add(minuteType, tempData.heatIndex);
                    uvIndexSeries.add(minuteType, tempData.uvIndex);
                    rainfallSeries.add(minuteType, tempData.rainfall);
                    windGustSeries.add(minuteType, tempData.windGust);
                    //windDirectionSeries.add(minuteType, tempData.windDirection);
                }
            }
        }
        
        else if(display == "Week")
        {
            int Week  = yearsList.get(year).months.get(month).days.get(day).week;
            System.out.print(yearsList.get(year).months.get(month).days.get(day).week);
            WeatherWeek tempWeek = yearsList.get(year).weeks.get(Week -1);
            System.out.print(' ');
            System.out.print(tempWeek.days.size());
            
            for(int i = 0; i < tempWeek.days.size(); i++)
            {
                WeatherDay tempDay = tempWeek.days.get(i);
                System.out.print(' ');
                System.out.print(tempDay.data.size());
                
                for(int j = 0; j < tempDay.data.size(); j++)
                {
                    WeatherData tempData = tempDay.data.get(j);
                    Minute minuteType = new Minute(tempData.minute, tempData.hour, tempData.day + 1, tempData.month + 1, tempData.year);
                    temperatureSeries.add(minuteType, tempData.temperature);
                    humiditySeries.add(minuteType, tempData.humidity);
                    barometricSeries.add(minuteType, tempData.barometer);
                    windSpeedSeries.add(minuteType, tempData.windSpeed);
                    windChillSeries.add(minuteType, tempData.windChill);
                    heatIndexSeries.add(minuteType, tempData.heatIndex);
                    uvIndexSeries.add(minuteType, tempData.uvIndex);
                    rainfallSeries.add(minuteType, tempData.rainfall);
                    windGustSeries.add(minuteType, tempData.windGust);
                    //windDirectionSeries.add(minuteType, tempData.windDirection);
                }
            }
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
                windGustSeries.add(minuteType, tempData.windGust);
                //windDirectionSeries.add(minuteType, tempData.windDirection);
            }
        }
        
        removeAllSeries();
        addSeries(temperatureSeries);
        addSeries(humiditySeries);
        addSeries(barometricSeries);
        addSeries(windSpeedSeries);
        addSeries(windChillSeries);
        addSeries(heatIndexSeries);
        addSeries(uvIndexSeries);
        addSeries(rainfallSeries);
        addSeries(windGustSeries);
        //addSeries(windDirectionSeries);
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
