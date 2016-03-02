/**
 * ****************************************************************************
 * File: XMLParser.java *
 *****************************************************************************
 */
package weatherstation;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.jdom2.input.SAXBuilder;
import org.jdom2.*;

/*==============================================================================
 Class: XMLParser
	
 Extends/Implements: None
	
 Description: 
 This class defines an XML parser to retrieve weather data.
 ==============================================================================*/
public class XMLParser {

    /*==========================================================================
     Function: parse()
    
     Description: 
     This function parses the XML file from the chosen directory.
    
     Parameters: File directory - Current directory
                    
     ArrayList<WeatherYear> yearsList - List of years we can 
     access
    
     Returns: None
     ==========================================================================*/
    public void parse(File directory, ArrayList<WeatherYear> yearsList) {
        SAXBuilder builder = new SAXBuilder();
        try {
            //try to parse the directory file list
            int fileIndex = 0;
            File[] files = directory.listFiles();
            Arrays.sort(files);
            File file = files[fileIndex];
            fileIndex++;
            Document document = builder.build(file);
            Element root = document.getRootElement();

            while (fileIndex < files.length) {
                String fileName = file.getName();
                String temp = fileName.split("-")[0];
                int yearNum = Integer.parseInt(temp);

                String yearString = "NULL";
                int yearWindDirectionValue = -1;
                WeatherYear tempYear = new WeatherYear(yearNum);

                // counters for prevailing winds 
                // there has to be a better way! 
                int yearNCounter = 0;
                int yearNNECounter = 0;
                int yearNECounter = 0;
                int yearENECounter = 0;
                int yearECounter = 0;
                int yearESECounter = 0;
                int yearSECounter = 0;
                int yearSSECounter = 0;
                int yearSCounter = 0;
                int yearSSWCounter = 0;
                int yearSWCounter = 0;
                int yearWSWCounter = 0;
                int yearWCounter = 0;
                int yearWNWCounter = 0;
                int yearNWCounter = 0;
                int yearNNWCounter = 0;
                int yearHighest = 0;

                String monthString = "NULL";
                int monthWindDirectionValue = -1;
                for (int monthIndex = 0; monthIndex < 12; monthIndex++) {
                    // check for lat index
                    if (yearNum == 2015 && monthIndex == 11) {
                        int test = 0;
                    }
                    WeatherMonth tempMonth = new WeatherMonth(monthIndex);
                    int monthNCounter = 0;
                    int monthNNECounter = 0;
                    int monthNECounter = 0;
                    int monthENECounter = 0;
                    int monthECounter = 0;
                    int monthESECounter = 0;
                    int monthSECounter = 0;
                    int monthSSECounter = 0;
                    int monthSCounter = 0;
                    int monthSSWCounter = 0;
                    int monthSWCounter = 0;
                    int monthWSWCounter = 0;
                    int monthWCounter = 0;
                    int monthWNWCounter = 0;
                    int monthNWCounter = 0;
                    int monthNNWCounter = 0;
                    int monthHighest = 0;

                    String dayString = "NULL";
                    int dayWindDirectionValue = -1;
                    List<Element> weatherList = root.getChildren(); // new spot
                    int XMLDayCounter = 0;
                    boolean monthFlag = true;

                    while (monthFlag == true) {
                        WeatherDay tempDay = new WeatherDay();

                        int dayNCounter = 0;
                        int dayNNECounter = 0;
                        int dayNECounter = 0;
                        int dayENECounter = 0;
                        int dayECounter = 0;
                        int dayESECounter = 0;
                        int daySECounter = 0;
                        int daySSECounter = 0;
                        int daySCounter = 0;
                        int daySSWCounter = 0;
                        int daySWCounter = 0;
                        int dayWSWCounter = 0;
                        int dayWCounter = 0;
                        int dayWNWCounter = 0;
                        int dayNWCounter = 0;
                        int dayNNWCounter = 0;
                        int dayHighest = 0;
                        boolean dayFlag = true;
                        String[] tempDate;

                        //flag for if the data changes to stop reading in data for the day
                        while (dayFlag == true) // probably 95
                        {
                            try {
                                // Try to get data for the day and catch it 
                                // if it fails and move on
                                Element weather = weatherList.get(XMLDayCounter);
                                Element nextWeather = weatherList.get(XMLDayCounter + 1);
                                WeatherData data = new WeatherData(weather);
                                WeatherData next = new WeatherData(nextWeather);
                                tempDate = data.date.split("/");
                                data.year = yearNum;
                                data.month = monthIndex;
                                data.day = Integer.parseInt(tempDate[1]);
                                tempDay.data.add(data);
                                XMLDayCounter += 1;
                                if (!next.date.equals(data.date)) {
                                    tempDate = next.date.split("/");
                                    tempDay.day = data.day;
                                    dayFlag = false;
                                }
                            } catch (java.lang.IndexOutOfBoundsException err) {
                                tempDay.day = tempDay.data.get(0).day;
                                monthFlag = false;
                                break;
                            }
                        }

                        // a large set of loops for finding the correct wind direction
                        for (int k = 0; k < tempDay.data.size(); k++) {
                            // if a wind direction string matchs the wind direction
                            if (null != tempDay.data.get(k).windDirection) // add to counter for tooltip display later
                            {
                                switch (tempDay.data.get(k).windDirection) {
                                    case "N":
                                        dayNCounter += 1;
                                        if (dayNCounter > dayHighest) {
                                            dayHighest = dayNCounter;
                                            dayString = "N";
                                            dayWindDirectionValue = 0;
                                        }
                                        break;
                                    case "NNE":
                                        dayNNECounter += 1;
                                        if (dayNNECounter > dayHighest) {
                                            dayHighest = dayNNECounter;
                                            dayString = "NNE";
                                            dayWindDirectionValue = 1;
                                        }
                                        break;
                                    case "NE":
                                        dayNECounter += 1;
                                        if (dayNECounter > dayHighest) {
                                            dayHighest = dayNECounter;
                                            dayString = "NE";
                                            dayWindDirectionValue = 2;
                                        }
                                        break;
                                    case "ENE":
                                        dayENECounter += 1;
                                        if (dayENECounter > dayHighest) {
                                            dayHighest = dayENECounter;
                                            dayString = "ENE";
                                            dayWindDirectionValue = 3;
                                        }
                                        break;
                                    case "E":
                                        dayECounter += 1;
                                        if (dayECounter > dayHighest) {
                                            dayHighest = dayECounter;
                                            dayString = "E";
                                            dayWindDirectionValue = 4;
                                        }
                                        break;
                                    case "ESE":
                                        dayESECounter += 1;
                                        if (dayESECounter > dayHighest) {
                                            dayHighest = dayESECounter;
                                            dayString = "ESE";
                                            dayWindDirectionValue = 5;
                                        }
                                        break;
                                    case "SE":
                                        daySECounter += 1;
                                        if (daySECounter > dayHighest) {
                                            dayHighest = daySECounter;
                                            dayString = "SE";
                                            dayWindDirectionValue = 6;
                                        }
                                        break;
                                    case "SSE":
                                        daySSECounter += 1;
                                        if (daySSECounter > dayHighest) {
                                            dayHighest = daySSECounter;
                                            dayString = "SSE";
                                            dayWindDirectionValue = 7;
                                        }
                                        break;
                                    case "S":
                                        daySCounter += 1;
                                        if (daySCounter > dayHighest) {
                                            dayHighest = daySCounter;
                                            dayString = "S";
                                            dayWindDirectionValue = 8;
                                        }
                                        break;
                                    case "SSW":
                                        daySSWCounter += 1;
                                        if (daySSWCounter > dayHighest) {
                                            dayHighest = daySSWCounter;
                                            dayString = "SSW";
                                            dayWindDirectionValue = 9;
                                        }
                                        break;
                                    case "SW":
                                        daySWCounter += 1;
                                        if (daySWCounter > dayHighest) {
                                            dayHighest = daySWCounter;
                                            dayString = "SW";
                                            dayWindDirectionValue = 10;
                                        }
                                        break;
                                    case "WSW":
                                        dayWSWCounter += 1;
                                        if (dayWSWCounter > dayHighest) {
                                            dayHighest = dayWSWCounter;
                                            dayString = "WSW";
                                            dayWindDirectionValue = 11;
                                        }
                                        break;
                                    case "W":
                                        dayWCounter += 1;
                                        if (dayWCounter > dayHighest) {
                                            dayHighest = dayWCounter;
                                            dayString = "W";
                                            dayWindDirectionValue = 12;
                                        }
                                        break;
                                    case "WNW":
                                        dayWNWCounter += 1;
                                        if (dayWNWCounter > dayHighest) {
                                            dayHighest = dayWNWCounter;
                                            dayString = "WNW";
                                            dayWindDirectionValue = 13;
                                        }
                                        break;
                                    case "NW":
                                        dayNWCounter += 1;
                                        if (dayNWCounter > dayHighest) {
                                            dayHighest = dayNWCounter;
                                            dayString = "NW";
                                            dayWindDirectionValue = 14;
                                        }
                                        break;
                                    case "NNW":
                                        dayNNWCounter += 1;
                                        if (dayNNWCounter > dayHighest) {
                                            dayHighest = dayNNWCounter;
                                            dayString = "NNW";
                                            dayWindDirectionValue = 15;
                                        }
                                        break;
                                }
                            }

                            // do the various calculations required to process
                            // the data for the boxs at the bottom of the Gui
                            tempDay.meanTemp = tempDay.meanTemp + tempDay.data.get(k).temperature;
                            tempDay.meanWindSpeed = tempDay.meanWindSpeed + tempDay.data.get(k).windSpeed;
                            tempDay.totalRainfall = tempDay.totalRainfall + tempDay.data.get(k).rainfall;

                            tempMonth.totalRainfall = tempMonth.totalRainfall + tempDay.data.get(k).rainfall;

                            tempYear.totalRainfall = tempYear.totalRainfall + tempDay.data.get(k).rainfall;

                            if (tempDay.highTemp < tempDay.data.get(k).temperature) {
                                tempDay.highTemp = tempDay.data.get(k).temperature;
                                tempDay.highDate = tempDay.data.get(k).date;
                                tempDay.highTime = tempDay.data.get(k).time;
                            } 
                            if (tempMonth.highTemp < tempDay.data.get(k).temperature) {
                                tempMonth.highTemp = tempDay.data.get(k).temperature;
                                tempMonth.highDate = tempDay.data.get(k).date;
                                tempMonth.highTime = tempDay.data.get(k).time;
                            } 
                            if (tempYear.highTemp < tempDay.data.get(k).temperature) {
                                tempYear.highTemp = tempDay.data.get(k).temperature;
                                tempYear.highDate = tempDay.data.get(k).date;
                                tempYear.highTime = tempDay.data.get(k).time;
                            } 
                            if (tempDay.lowTemp > tempDay.data.get(k).temperature) {
                                tempDay.lowTemp = tempDay.data.get(k).temperature;
                                tempDay.lowDate = tempDay.data.get(k).date;
                                tempDay.lowTime = tempDay.data.get(k).time;
                            } 
                            if (tempMonth.lowTemp > tempDay.data.get(k).temperature) {
                                tempMonth.lowTemp = tempDay.data.get(k).temperature;
                                tempMonth.lowDate = tempDay.data.get(k).date;
                                tempMonth.lowTime = tempDay.data.get(k).time;
                            } 
                            if (tempYear.lowTemp > tempDay.data.get(k).temperature) {
                                tempYear.lowTemp = tempDay.data.get(k).temperature;
                                tempYear.lowDate = tempDay.data.get(k).date;
                                tempYear.lowTime = tempDay.data.get(k).time;
                            } 
                            if (tempDay.maxWindSpeed < tempDay.data.get(k).windGust) {
                                tempDay.maxWindSpeed = tempDay.data.get(k).windGust;
                                tempDay.windSpeedDate = tempDay.data.get(k).date;
                                tempDay.windSpeedTime = tempDay.data.get(k).time;
                            } 
                            if (tempMonth.maxWindSpeed < tempDay.data.get(k).windGust) {
                                tempMonth.maxWindSpeed = tempDay.data.get(k).windGust;
                                tempMonth.windSpeedDate = tempDay.data.get(k).date;
                                tempMonth.windSpeedTime = tempDay.data.get(k).time;
                            } 
                            if (tempYear.maxWindSpeed < tempDay.data.get(k).windGust) {
                                tempYear.maxWindSpeed = tempDay.data.get(k).windGust;
                                tempYear.windSpeedDate = tempDay.data.get(k).date;
                                tempYear.windSpeedTime = tempDay.data.get(k).time;
                            }

                        }

                        // repeat for month and year
                        // this is very ineffective big O and code look wise
                        tempDay.windDirection = dayString;
                        tempDay.windDirectionValue = dayWindDirectionValue;

                        tempDay.meanTemp
                                = tempDay.meanTemp / tempDay.data.size();
                        tempDay.meanWindSpeed
                                = tempDay.meanWindSpeed / tempDay.data.size();

                        tempMonth.meanTemp = tempMonth.meanTemp + tempDay.meanTemp;
                        tempMonth.meanWindSpeed = tempMonth.meanWindSpeed + tempDay.meanWindSpeed;

                        tempYear.meanTemp = tempYear.meanTemp + tempDay.meanTemp;
                        tempYear.meanWindSpeed = tempYear.meanWindSpeed + tempDay.meanWindSpeed;

                        if (null != tempDay.windDirection) {
                            switch (tempDay.windDirection) {
                                case "N":
                                    monthNCounter += 1;
                                    if (monthNCounter > monthHighest) {
                                        monthHighest = monthNCounter;
                                        monthString = "N";
                                        monthWindDirectionValue = 0;
                                    }
                                    break;
                                case "NNE":
                                    monthNNECounter += 1;
                                    if (monthNNECounter > monthHighest) {
                                        monthHighest = monthNNECounter;
                                        monthString = "NNE";
                                        monthWindDirectionValue = 1;
                                    }
                                    break;
                                case "NE":
                                    monthNECounter += 1;
                                    if (monthNECounter > monthHighest) {
                                        monthHighest = monthNECounter;
                                        monthString = "NE";
                                        monthWindDirectionValue = 2;
                                    }
                                    break;
                                case "ENE":
                                    monthENECounter += 1;
                                    if (monthENECounter > monthHighest) {
                                        monthHighest = monthENECounter;
                                        monthString = "ENE";
                                        monthWindDirectionValue = 3;
                                    }
                                    break;
                                case "E":
                                    monthECounter += 1;
                                    if (monthECounter > monthHighest) {
                                        monthHighest = monthECounter;
                                        monthString = "E";
                                        monthWindDirectionValue = 4;
                                    }
                                    break;
                                case "ESE":
                                    monthESECounter += 1;
                                    if (monthESECounter > monthHighest) {
                                        monthHighest = monthESECounter;
                                        monthString = "ESE";
                                        monthWindDirectionValue = 5;
                                    }
                                    break;
                                case "SE":
                                    monthSECounter += 1;
                                    if (monthSECounter > monthHighest) {
                                        monthHighest = monthSECounter;
                                        monthString = "SE";
                                        monthWindDirectionValue = 6;
                                    }
                                    break;
                                case "SSE":
                                    monthSSECounter += 1;
                                    if (monthSSECounter > monthHighest) {
                                        monthHighest = monthSSECounter;
                                        monthString = "SSE";
                                        monthWindDirectionValue = 7;
                                    }
                                    break;
                                case "S":
                                    monthSCounter += 1;
                                    if (monthSCounter > monthHighest) {
                                        monthHighest = monthSCounter;
                                        monthString = "S";
                                        monthWindDirectionValue = 8;
                                    }
                                    break;
                                case "SSW":
                                    monthSSWCounter += 1;
                                    if (monthSSWCounter > monthHighest) {
                                        monthHighest = monthSSWCounter;
                                        monthString = "SSW";
                                        monthWindDirectionValue = 9;
                                    }
                                    break;
                                case "SW":
                                    monthSWCounter += 1;
                                    if (monthSWCounter > monthHighest) {
                                        monthHighest = monthSWCounter;
                                        monthString = "SW";
                                        monthWindDirectionValue = 10;
                                    }
                                    break;
                                case "WSW":
                                    monthWSWCounter += 1;
                                    if (monthWSWCounter > monthHighest) {
                                        monthHighest = monthWSWCounter;
                                        monthString = "WSW";
                                        monthWindDirectionValue = 11;
                                    }
                                    break;
                                case "W":
                                    monthWCounter += 1;
                                    if (monthWCounter > monthHighest) {
                                        monthHighest = monthWCounter;
                                        monthString = "W";
                                        monthWindDirectionValue = 12;
                                    }
                                    break;
                                case "WNW":
                                    monthWNWCounter += 1;
                                    if (monthWNWCounter > monthHighest) {
                                        monthHighest = monthWNWCounter;
                                        monthString = "WNW";
                                        monthWindDirectionValue = 13;
                                    }
                                    break;
                                case "NW":
                                    monthNWCounter += 1;
                                    if (monthNWCounter > monthHighest) {
                                        monthHighest = monthNWCounter;
                                        monthString = "NW";
                                        monthWindDirectionValue = 14;
                                    }
                                    break;
                                case "NNW":
                                    monthNNWCounter += 1;
                                    if (monthNNWCounter > monthHighest) {
                                        monthHighest = monthNNWCounter;
                                        monthString = "NNW";
                                        monthWindDirectionValue = 15;
                                    }
                                    break;
                            }
                        }

                        tempMonth.days.add(tempDay);
                        tempYear.days.add(tempDay);
                    }

                    if (fileIndex <= files.length) {
                        tempMonth.windDirection = monthString;
                        tempMonth.windDirectionValue = monthWindDirectionValue;
                        tempMonth.meanTemp
                                = tempMonth.meanTemp / tempMonth.days.size();
                        tempMonth.meanWindSpeed
                                = tempMonth.meanWindSpeed / tempMonth.days.size();

                        tempYear.months.add(tempMonth);

                        if (null != tempMonth.windDirection) switch (tempMonth.windDirection) {
                            case "N":
                                yearNCounter += 1;
                                if (yearNCounter > yearHighest) {
                                    yearHighest = yearNCounter;
                                    yearString = "N";
                                    yearWindDirectionValue = 0;
                                    
                                }   break;
                            case "NNE":
                                yearNNECounter += 1;
                                if (yearNNECounter > yearHighest) {
                                    yearHighest = yearNNECounter;
                                    yearString = "NNE";
                                    yearWindDirectionValue = 1;
                            }   break;
                            case "NE":
                                yearNECounter += 1;
                                if (yearNECounter > yearHighest) {
                                    yearHighest = yearNECounter;
                                    yearString = "NE";
                                    yearWindDirectionValue = 2;
                                }   break;
                            case "ENE":
                                yearENECounter += 1;
                                if (yearENECounter > yearHighest) {
                                    yearHighest = yearENECounter;
                                    yearString = "ENE";
                                    yearWindDirectionValue = 3;
                                }   break;
                            case "E":
                                yearECounter += 1;
                                if (yearECounter > yearHighest) {
                                    yearHighest = yearECounter;
                                    yearString = "E";
                                yearWindDirectionValue = 4;
                                }   break;
                            case "ESE":
                                yearESECounter += 1;
                                if (yearESECounter > yearHighest) {
                                    yearHighest = yearESECounter;
                                    yearString = "ESE";
                                    yearWindDirectionValue = 5;
                                }   break;
                            case "SE":
                                yearSECounter += 1;
                                if (yearSECounter > yearHighest) {
                                    yearHighest = yearSECounter;
                                    yearString = "SE";
                                    yearWindDirectionValue = 6;
                                }   break;
                            case "SSE":
                                yearSSECounter += 1;
                                if (yearSSECounter > yearHighest) {
                                    yearHighest = yearSSECounter;
                                    yearString = "SSE";
                                    yearWindDirectionValue = 7;
                                }   break;
                            case "S":
                                yearSCounter += 1;
                                if (yearSCounter > yearHighest) {
                                    yearHighest = yearSCounter;
                                yearString = "S";
                                yearWindDirectionValue = 8;
                                }   break;
                            case "SSW":
                                yearSSWCounter += 1;
                                if (yearSSWCounter > yearHighest) {
                                    yearHighest = yearSSWCounter;
                                yearString = "SSW";
                                yearWindDirectionValue = 9;
                                }   break;
                            case "SW":
                                yearSWCounter += 1;
                                if (yearSWCounter > yearHighest) {
                                    yearHighest = yearSWCounter;
                                    yearString = "SW";
                                    yearWindDirectionValue = 10;
                                }   break;
                            case "WSW":
                                yearWSWCounter += 1;
                                if (yearWSWCounter > yearHighest) {
                                    yearHighest = yearWSWCounter;
                                    yearString = "WSW";
                                    yearWindDirectionValue = 11;
                                }   break;
                            case "W":
                                yearWCounter += 1;
                                if (yearWCounter > yearHighest) {
                                    yearHighest = yearWCounter;
                                    yearString = "W";
                                    yearWindDirectionValue = 12;
                                }   break;
                            case "WNW":
                                yearWNWCounter += 1;
                                if (yearWNWCounter > yearHighest) {
                                yearHighest = yearWNWCounter;
                                yearString = "WNW";
                                yearWindDirectionValue = 13;
                                }   break;
                            case "NW":
                                yearNWCounter += 1;
                                if (yearNWCounter > yearHighest) {
                                    yearHighest = yearNWCounter;
                                    yearString = "NW";
                                    yearWindDirectionValue = 14;
                                }   break;
                            case "NNW":
                                yearNNWCounter += 1;
                                if (yearNNWCounter > yearHighest) {
                                yearHighest = yearNNWCounter;
                                yearString = "NNW";
                                yearWindDirectionValue = 15;
                            }   break;
                        }

                        if (fileIndex < files.length) {
                            file = files[fileIndex];
                            fileIndex++;
                            document = builder.build(file);
                            root = document.getRootElement();
                        }
                    }
                }
                processWeeks(tempYear);

                tempYear.windDirection = yearString;
                tempYear.windDirectionValue = yearWindDirectionValue;
                tempYear.meanTemp = tempYear.meanTemp / tempYear.days.size();
                tempYear.meanWindSpeed
                        = tempYear.meanWindSpeed / tempYear.days.size();

                yearsList.add(tempYear);
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /*==========================================================================
     Function: processWeeks()
    
     Description: 
     This function processes "week" data.
    
     Parameters: WeatherYear year - Current year of data we are accessing.
    
     Returns: None
     ==========================================================================*/
    public void processWeeks(WeatherYear year) {

        WeatherWeek tempWeek = new WeatherWeek(1);
        int weekCounter = 1;
        int weekNCounter = 0;
        int weekNNECounter = 0;
        int weekNECounter = 0;
        int weekENECounter = 0;
        int weekECounter = 0;
        int weekESECounter = 0;
        int weekSECounter = 0;
        int weekSSECounter = 0;
        int weekSCounter = 0;
        int weekSSWCounter = 0;
        int weekSWCounter = 0;
        int weekWSWCounter = 0;
        int weekWCounter = 0;
        int weekWNWCounter = 0;
        int weekNWCounter = 0;
        int weekNNWCounter = 0;
        int weekHighest = 0;

        for (int i = 0; i < year.days.size(); i++) {
            Calendar c = Calendar.getInstance();
            Date tempDate = new Date(year.year, year.days.get(i).month, year.days.get(i).day);
            c.setTime(tempDate);

            //Gets which week this day belongs to for that year
            int weekOfYear = c.get(Calendar.WEEK_OF_YEAR);

            //Set the day to have that week so we can use the week number for 
            //displaying in the GUI
            year.days.get(i).week = weekOfYear;

            if (weekCounter == weekOfYear) {
                tempWeek.days.add(year.days.get(i));
            }
            if (weekCounter != weekOfYear) {
                year.weeks.add(tempWeek);
                tempWeek = new WeatherWeek(weekOfYear);
                tempWeek.days.add(year.days.get(i));
                weekCounter = weekOfYear;
            }

        }

        for (int i = 0; i < year.weeks.size(); i++) {
            String weekString = "NULL";
            int weekWindDirectionValue = -1;
            for (int j = 0; j < year.weeks.get(i).days.size(); j++) {

                if (null != year.weeks.get(i).days.get(j).windDirection) switch (year.weeks.get(i).days.get(j).windDirection) {
                    case "N":
                        weekNCounter += 1;
                        if (weekNCounter > weekHighest) {
                            weekHighest = weekNCounter;
                            weekString = "N";
                            weekWindDirectionValue = 0;
                        }   break;
                    case "NNE":
                        weekNNECounter += 1;
                        if (weekNNECounter > weekHighest) {
                            weekHighest = weekNNECounter;
                            weekString = "NNE";
                            weekWindDirectionValue = 1;
                        }   break;
                    case "NE":
                        weekNECounter += 1;
                        if (weekNECounter > weekHighest) {
                            weekHighest = weekNECounter;
                            weekString = "NE";
                            weekWindDirectionValue = 2;
                    }   break;
                    case "ENE":
                        weekENECounter += 1;
                        if (weekENECounter > weekHighest) {
                            weekHighest = weekENECounter;
                            weekString = "ENE";
                            weekWindDirectionValue = 3;
                        }   break;
                    case "E":
                        weekECounter += 1;
                        if (weekECounter > weekHighest) {
                            weekHighest = weekECounter;
                            weekString = "E";
                            weekWindDirectionValue = 4;
                        }   break;
                    case "ESE":
                        weekESECounter += 1;
                        if (weekESECounter > weekHighest) {
                            weekHighest = weekESECounter;
                            weekString = "ESE";
                        weekWindDirectionValue = 5;
                        }   break;
                    case "SE":
                        weekSECounter += 1;
                        if (weekSECounter > weekHighest) {
                            weekHighest = weekSECounter;
                            weekString = "SE";
                            weekWindDirectionValue = 6;
                        }   break;
                    case "SSE":
                        weekSSECounter += 1;
                        if (weekSSECounter > weekHighest) {
                            weekHighest = weekSSECounter;
                            weekString = "SSE";
                            weekWindDirectionValue = 7;
                        }   break;
                    case "S":
                        weekSCounter += 1;
                        if (weekSCounter > weekHighest) {
                            weekHighest = weekSCounter;
                        weekString = "S";
                        weekWindDirectionValue = 8;
                        }   break;
                    case "SSW":
                        weekSSWCounter += 1;
                        if (weekSSWCounter > weekHighest) {
                            weekHighest = weekSSWCounter;
                        weekString = "SSW";
                        weekWindDirectionValue = 9;
                        }   break;
                    case "SW":
                        weekSWCounter += 1;
                        if (weekSWCounter > weekHighest) {
                            weekHighest = weekSWCounter;
                        weekString = "SW";
                        weekWindDirectionValue = 10;
                        }   break;
                    case "WSW":
                        weekWSWCounter += 1;
                        if (weekWSWCounter > weekHighest) {
                            weekHighest = weekWSWCounter;
                            weekString = "WSW";
                            weekWindDirectionValue = 11;
                        }   break;
                    case "W":
                        weekWCounter += 1;
                        if (weekWCounter > weekHighest) {
                            weekHighest = weekWCounter;
                            weekString = "W";
                            weekWindDirectionValue = 12;
                        }   break;
                    case "WNW":
                        weekWNWCounter += 1;
                        if (weekWNWCounter > weekHighest) {
                            weekHighest = weekWNWCounter;
                            weekString = "WNW";
                            weekWindDirectionValue = 13;
                        }   break;
                    case "NW":
                        weekNWCounter += 1;
                        if (weekNWCounter > weekHighest) {
                            weekHighest = weekNWCounter;
                            weekString = "NW";
                            weekWindDirectionValue = 14;
                        }   break;
                    case "NNW":
                        weekNNWCounter += 1;
                        if (weekNNWCounter > weekHighest) {
                        weekHighest = weekNNWCounter;
                        weekString = "NNW";
                        weekWindDirectionValue = 15;
                    }   break;
                }

                year.weeks.get(i).windDirection = weekString;
                year.weeks.get(i).windDirectionValue = weekWindDirectionValue;
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

            year.weeks.get(i).meanTemp
                    = (year.weeks.get(i).meanTemp / year.weeks.get(i).days.size());
            year.weeks.get(i).meanWindSpeed
                    = (year.weeks.get(i).meanWindSpeed / year.weeks.get(i).days.size());
            year.weeks.get(i).totalRainfall
                    = (year.weeks.get(i).totalRainfall / year.weeks.get(i).days.size());

        }

    }

}
