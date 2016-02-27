/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.*;

/**
 *
 * @author 1960681
 */
public class XMLParser {
    
    public void parse(File directory, ArrayList<WeatherYear> yearsList)
    {      
        SAXBuilder builder = new SAXBuilder();
        try
        {
            int fileIndex = 0;
            while(fileIndex < directory.listFiles().length)
            {
                File file = directory.listFiles()[fileIndex];
                fileIndex++;
                Document document = builder.build(file);
                Element root = document.getRootElement();
                String fileName = file.getName();
                String temp = fileName.split("-")[0];
                int yearNum = Integer.parseInt(temp);

                WeatherYear tempYear = new WeatherYear(yearNum);

                for(int monthIndex = 0; monthIndex < 12; monthIndex++)
                {
                    WeatherMonth tempMonth = new WeatherMonth(monthIndex);

                    Calendar cal = new GregorianCalendar(tempYear.year, tempMonth.month, 1);

                    int daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

                    for(int dayIndex = 0; dayIndex < daysInMonth; dayIndex++)
                    {
                        WeatherDay tempDay = new WeatherDay(dayIndex);

                        List<Element> weatherList = root.getChildren();
                        for ( int j = 0; j < 96; j++ )
                        {
                            Element weather = weatherList.get(j);
                            WeatherData data = new WeatherData(weather);
                            data.year = yearNum;
                            data.month = monthIndex;
                            data.day = dayIndex;
                            tempDay.data.add(data);
                        }
                        for (int k = 0; k < tempDay.data.size(); k++) {
                            tempDay.meanTemp = tempDay.meanTemp + tempDay.data.get(k).temperature;
                            tempDay.meanWindSpeed = tempDay.meanWindSpeed + tempDay.data.get(k).windSpeed;
                            tempDay.totalRainfall = tempDay.totalRainfall + tempDay.data.get(k).rainfall;
                            tempMonth.meanTemp = tempMonth.meanTemp + tempDay.data.get(k).temperature;
                            tempMonth.meanWindSpeed = tempMonth.meanWindSpeed + tempDay.data.get(k).windSpeed;
                            tempMonth.totalRainfall = tempMonth.totalRainfall + tempDay.data.get(k).rainfall;
                            tempYear.meanTemp = tempYear.meanTemp + tempDay.data.get(k).temperature;
                            tempYear.meanWindSpeed = tempYear.meanWindSpeed + tempDay.data.get(k).windSpeed;
                            tempYear.totalRainfall = tempYear.totalRainfall + tempDay.data.get(k).rainfall;
                            
                            
                            if(tempDay.highTemp < tempDay.data.get(k).temperature) {
                                tempDay.highTemp = tempDay.data.get(k).temperature;
                                tempDay.highDate = tempDay.data.get(k).date;
                                tempDay.highTime = tempDay.data.get(k).time;
                               
                            }
                            if(tempMonth.highTemp < tempDay.data.get(k).temperature){
                                tempMonth.highTemp = tempDay.data.get(k).temperature;
                                tempMonth.highDate = tempDay.data.get(k).date;
                                tempMonth.highTime = tempDay.data.get(k).time;
                                
                            
                               
                            }
                            if(tempYear.highTemp < tempDay.data.get(k).temperature){
                                tempYear.highTemp = tempDay.data.get(k).temperature;
                                tempYear.highDate = tempDay.data.get(k).date;
                                tempYear.highTime = tempDay.data.get(k).time;

                            }
                            
                            if(tempDay.lowTemp > tempDay.data.get(k).temperature){
                                tempDay.lowTemp = tempDay.data.get(k).temperature;
                                tempDay.lowDate = tempDay.data.get(k).date;
                                tempDay.lowTime = tempDay.data.get(k).time;
                            }
                            if(tempMonth.lowTemp > tempDay.data.get(k).temperature){
                                tempMonth.lowTemp = tempDay.data.get(k).temperature;
                                tempMonth.lowDate = tempDay.data.get(k).date;
                                tempMonth.lowTime = tempDay.data.get(k).time;
                            }
                            if(tempYear.lowTemp > tempDay.data.get(k).temperature){
                                tempYear.lowTemp = tempDay.data.get(k).temperature;
                                tempYear.lowDate = tempDay.data.get(k).date;
                                tempYear.lowTime = tempDay.data.get(k).time;
                            }
                            
                            if(tempDay.maxWindSpeed < tempDay.data.get(k).windSpeed){
                                tempDay.maxWindSpeed = tempDay.data.get(k).windSpeed;
                                tempDay.windSpeedDate = tempDay.data.get(k).date;
                                tempDay.windSpeedTime = tempDay.data.get(k).time;
                            }
                            if(tempMonth.maxWindSpeed < tempDay.data.get(k).windSpeed){
                                tempMonth.maxWindSpeed = tempDay.data.get(k).windSpeed;
                                tempMonth.windSpeedDate = tempDay.data.get(k).date;
                                tempMonth.windSpeedTime = tempDay.data.get(k).time;
                            }
                            if(tempYear.maxWindSpeed < tempDay.data.get(k).windSpeed){
                                tempYear.maxWindSpeed = tempDay.data.get(k).windSpeed;
                                tempYear.windSpeedDate = tempDay.data.get(k).date;
                                tempYear.windSpeedTime = tempDay.data.get(k).time;
                            }
                            
                            
                        }
                        
                        tempMonth.days.add(tempDay);
                        tempYear.days.add(tempDay); 
                    }
                    
                    if(fileIndex < directory.listFiles().length)
                    {
                        tempMonth.meanTemp = 
                                tempMonth.meanTemp / tempMonth.days.size();
                        tempMonth.meanWindSpeed = 
                                tempMonth.meanWindSpeed / tempMonth.days.size();
                        tempMonth.totalRainfall = 
                                tempMonth.totalRainfall / tempMonth.days.size();
                        
                        tempYear.months.add(tempMonth);
                        file = directory.listFiles()[fileIndex];
                        fileIndex++;
                        document = builder.build(file);
                        root = document.getRootElement();
                    }
                    
                    
                }
               
                processWeeks(tempYear);
                
                tempYear.meanTemp = tempYear.meanTemp / tempYear.days.size();
                tempYear.meanWindSpeed = 
                        tempYear.meanWindSpeed / tempYear.days.size();
                tempYear.totalRainfall = 
                        tempYear.totalRainfall / tempYear.days.size();
                
                yearsList.add(tempYear);
            }
        }
        catch ( Exception e)
        {
            System.out.println( e.toString() );
        }
    }
    
    public void processWeeks(WeatherYear year) {
        
        for (int i = 0; i < year.days.size(); i++)
        {
            Calendar c = Calendar.getInstance();
            Date tempDate = new Date(year.year, year.days.get(i).month, (i+1) );
            c.setTime(tempDate);
            //Gets which week this day belongs to for that year
            int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);
            //Set the day to have that week so we can use the week number for 
            //displaying in the GUI
	    year.days.get(i).week = weekOfYear;
	    //Push the day into that week
            year.weeks.get(year.days.get(i).week).days.add(year.days.get(i));
            
        }
        for (int i = 0; i < year.weeks.size(); i++) {
            for (int j = 0; j < year.weeks.get(i).days.size(); j++) {
                year.weeks.get(i).meanTemp = year.weeks.get(i).days.get(j).meanTemp;
                year.weeks.get(i).meanWindSpeed = year.weeks.get(i).days.get(j).meanWindSpeed;
                year.weeks.get(i).totalRainfall = year.weeks.get(i).days.get(j).totalRainfall;
                
                if (year.weeks.get(i).highTemp < year.weeks.get(i).days.get(j).highTemp) {
                    year.weeks.get(i).highTemp = year.weeks.get(i).days.get(j).highTemp;
                    year.weeks.get(i).highDate = year.weeks.get(i).days.get(j).highDate;
                    year.weeks.get(i).highTime = year.weeks.get(i).days.get(j).highTime;
                }
                
                if (year.weeks.get(i).lowTemp > year.weeks.get(i).days.get(j).lowTemp) {
                    year.weeks.get(i).lowTemp = year.weeks.get(i).days.get(j).lowTemp;
                    year.weeks.get(i).lowDate = year.weeks.get(i).days.get(j).lowDate;
                    year.weeks.get(i).lowTime = year.weeks.get(i).days.get(j).lowTime;
                }
                
                if (year.weeks.get(i).maxWindSpeed < year.weeks.get(i).days.get(j).maxWindSpeed) {
                    year.weeks.get(i).maxWindSpeed = year.weeks.get(i).days.get(j).maxWindSpeed;
                    year.weeks.get(i).windSpeedDate = year.weeks.get(i).days.get(j).windSpeedDate;
                    year.weeks.get(i).windSpeedTime = year.weeks.get(i).days.get(j).windSpeedTime;
                }
            }
            
            year.weeks.get(i).meanTemp =  
                    (year.weeks.get(i).meanTemp / year.weeks.get(i).days.size());
            year.weeks.get(i).meanWindSpeed = 
                    (year.weeks.get(i).meanWindSpeed / year.weeks.get(i).days.size());
            year.weeks.get(i).totalRainfall = 
                    (year.weeks.get(i).totalRainfall / year.weeks.get(i).days.size());
                
        }
            
    }
        
 }
