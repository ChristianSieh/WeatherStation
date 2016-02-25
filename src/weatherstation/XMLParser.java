/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
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

                        tempMonth.days.add(tempDay);
                        tempYear.days.add(tempDay); 
                    }
                    
                    if(fileIndex < directory.listFiles().length)
                    {
                        tempYear.months.add(tempMonth);
                        file = directory.listFiles()[fileIndex];
                        fileIndex++;
                        document = builder.build(file);
                        root = document.getRootElement();
                    }
                }
                yearsList.add(tempYear);
            }
        }
        catch ( Exception e)
        {
            System.out.println( e.toString() );
        }
    }
    
}
