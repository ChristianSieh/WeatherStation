/*=============================================================================
 Program: Programming Assignment #1: Weather Station Display
 
 Author: Christian Sieh, Marcus Berger, and Derek Lane
 
 Class: CSC 468 GUI Programming
 
 Instructor: Dr. John Weiss
 
 Date: 3/1/2016
 
 Description:
	This program is a Java Swing program to display weather station data
 in graphical form. The display consists of a graph, buttons to show/hide
 weather data such as temperature, barometric pressure, etc. It provides 
 controls to "zoom" between daily, weekly, monthly, and yearly data and move
 "pan to the next day/week/month/year. The user may hover over a specific 
 data point to display:
	
	-daily/weekly/monthly/yearly mean (average) temperature
	-daily/weekly/monthly/yearly high/low temperatures,
		with date/time of occurrence
 	-daily/weekly/monthly/yearly mean (average) wind speed
 	-daily/weekly/monthly/yearly maximum wind speed (gust),
		with date/time of occurrence
 	-daily/weekly/monthly/yearly prevailing wind direction
 	-daily/weekly/monthly/yearly rainfall
	
	The data this program uses is the weather station data logged every few
minutes for several years by SDSMT. The data is in XML, the file format is:

	-YYYY-MM.xml (e.g., 2015-10.xml for October 2015)

	The XML weather tags include:
	
	-date – MM/DD/YY
	-time – HH:MM followed by A (AM) or P (PM)
	-temperature – in degrees Farenheit
	-humidity – relative percent humidity
	-barometer – barometric pressure, in inches of mercury
	-windspeed – in mph
	-winddirection – one of 16 compass directions (N, NNE, NE, etc.)
	-windgust – highest wind speed since last measurement, in mph
	-windchill – computed from temperature and wind speed
	-heatindex – computed from temperature, humidity, wind speed, etc.
	-uvindex – UV radiation dose, in arbitrary units from 
						0 (lowest) to 15 (highest)
	-rainfall – amount of precipitation since last measurement, 
					to nearest 0.01 inch
=============================================================================*/
package weatherstation;

/*=============================================================================
	Class: WeatherStation
 
	Extends/Implements: None
 
	Description: 
		Starting point of the application, contains the main function where
	The visibility of the WeatherFrame form is set to true.
=============================================================================*/
public class WeatherStation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherFrame().setVisible(true);
            }
        });
    }
}
