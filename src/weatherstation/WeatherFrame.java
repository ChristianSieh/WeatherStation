/******************************************************************************
 * File: WeatherFrame.java                                                    *
 ******************************************************************************/
package weatherstation;

import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;

/*==============================================================================
 Class: WeatherFrame
 
 Extends/Implements: JFrame
 
 Description: 
        Basically the class that is the starting point of the program. This 
    window appears when the user runs the program. The class itself defines
    fields, constructor, and methods for the main "frame" of the program.
==============================================================================*/
public class WeatherFrame extends javax.swing.JFrame {
    
    // GUI components
    private JToggleButton BarometricPressureBtn;
    private JPanel ButtonPanel;
    private JMenu FileMenu;
    private JPanel GuagesPanel;
    private JToggleButton HeatIndexBtn;
    private JToggleButton HumidityBtn;
    private JMenuBar MenuBar;
    private JMenuItem OpenMenuItem;
    private JToggleButton RainfallBtn;
    private JLabel TempGuagelabel;
    private JToggleButton TemperatureBtn;
    private JToggleButton UVIndexBtn;
    private JToggleButton WindChillBtn;
    private JToggleButton WindSpeedBtn;
    private JFileChooser fileChooser;
    private JLabel YearLabel;
    private JLabel MonthLabel;
    private JLabel DisplayLabel;
    private JLabel DayLabel;
    private JComboBox<Integer> dayComboBox;
    private JComboBox<String> monthComboBox;
    private JComboBox<Integer> displayComboBox;
    private JComboBox<Integer> yearComboBox;
    private ChartPanel plotPanel;
    private JFreeChart plotChart;
    private XYPlot plot;
    private XYItemRenderer renderer;
    private ArrayList list;
    private XYDataset dataset;
    private WeatherCollection collection;
    private XMLParser xmlParser;
    private ArrayList<WeatherYear> yearsList;
    private ArrayList<String> monthList;
    private boolean filled;
    private JButton SubmitBtn;
    private JTextField averageTemp;
    private JTextField highTemp;
    private JTextField highTempDate;
    private JTextField highTempTime;
    private JTextField lowTemp;
    private JTextField lowTempDate;
    private JTextField lowTempTime;
    private JTextField averageWindSpeed;
    private JTextField maxWindSpeed;
    private JTextField windSpeedDate;
    private JTextField windSpeedTime;
    private JTextField prevailWindDirection;
    private JTextField totalRainfall;
    private JLabel averageTempLabel;
    private JLabel highTempLabel;
    private JLabel highTempDateLabel;
    private JLabel highTempTimeLabel;
    private JLabel lowTempLabel;
    private JLabel lowTempDateLabel;
    private JLabel lowTempTimeLabel;
    private JLabel averageWindSpeedLabel;
    private JLabel maxWindSpeedLabel;
    private JLabel windSpeedDateLabel;
    private JLabel windSpeedTimeLabel;
    private JLabel prevailWindDirectionLabel;
    private JLabel totalRainfallLabel;
    
    /*=========================================================================
        Function: WeatherFrame()
    
        Description: 
            This function is the constructor for the WeatherFrame class it 
        calls initComponents(); 
        (Auto-generated from NetBeans GUI Designer). 
    
        Parameters: None 
    =========================================================================*/
    public WeatherFrame() {
        initComponents();
    }
    
	/*=========================================================================
        Function: initComponents()
    
        Description: 
            This function is called from the WeatherFrame constructor 
        initializes GUI components.
        (Auto-generated from NetBeans GUI Designer). 
    
        Parameters: None 
    =========================================================================*/
    private void initComponents() {
        
        // init Component values
        fileChooser = new JFileChooser();
        xmlParser = new XMLParser();
        dayComboBox = new JComboBox<Integer>();
        plotChart = createChart();
        collection = new WeatherCollection();
        plotPanel = new ChartPanel(plotChart);
        plot = plotChart.getXYPlot();
        renderer = plot.getRenderer();
        ButtonPanel = new JPanel();
        TemperatureBtn = new JToggleButton();
        HumidityBtn = new JToggleButton();
        BarometricPressureBtn = new JToggleButton();
        WindSpeedBtn = new JToggleButton();
        WindChillBtn = new JToggleButton();
        HeatIndexBtn = new JToggleButton();
        UVIndexBtn = new JToggleButton();
        RainfallBtn = new JToggleButton();
        GuagesPanel = new JPanel();
        TempGuagelabel = new JLabel();
        yearComboBox = new JComboBox<Integer>();
        YearLabel = new JLabel();
        MonthLabel = new JLabel();
        DisplayLabel = new JLabel();
        DayLabel = new JLabel();
        displayComboBox = new JComboBox<Integer>();
        monthComboBox = new JComboBox<String>();
        MenuBar = new JMenuBar();
        FileMenu = new JMenu();
        OpenMenuItem = new JMenuItem();
        yearsList = new ArrayList<WeatherYear>();
        monthList = new ArrayList<String>() {{
             add("January");
             add("February");
             add("March");
             add("April");
             add("May");
             add("June");
             add("July");
             add("Augest");
             add("September");
             add("October");
             add("November");
             add("December");
        }};
        filled = false;
        SubmitBtn = new JButton("Submit");
        averageTempLabel = new JLabel("    Avg. Temp");
        averageTemp = new JTextField();
        
        highTemp = new JTextField();
        highTempLabel = new JLabel("    High Temp");
        
        highTempDate = new JTextField();
        highTempDateLabel = new JLabel("    High Temp Date");
        
        highTempTime = new JTextField();
        highTempTimeLabel = new JLabel("    High Temp Time");
        
        lowTemp = new JTextField();
        lowTempLabel = new JLabel("   Low Temp");
        
        lowTempDate = new JTextField();
        lowTempDateLabel = new JLabel("    Low Temp Date");
        
        lowTempTime = new JTextField();
        lowTempTimeLabel = new JLabel("    Low Temp Time");
        
        averageWindSpeed = new JTextField();
        averageWindSpeedLabel = new JLabel("    Avg. Wind Speed");
        
        maxWindSpeed = new JTextField();
        maxWindSpeedLabel = new JLabel("    Max Wind Speed");
        
        windSpeedDate = new JTextField();
        windSpeedDateLabel = new JLabel("    Max Wind Date");
        
        windSpeedTime = new JTextField();
        windSpeedTimeLabel = new JLabel("    Max Wind Time");
        
        prevailWindDirection = new JTextField();
        prevailWindDirectionLabel = new JLabel("    Prevailing Wind Dir.");
        
        totalRainfall = new JTextField();
        totalRainfallLabel = new JLabel("    Total Rainfall");

		//Set the selected mode of the fileChooser to directories only
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

		//When the application closes it will "EXIT_ON_CLOSE"
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Station");

		/* plotPanel and ButtonPanel added here */
        plotPanel.setBackground(new java.awt.Color(254, 254, 254));
        plotPanel.setPreferredSize(new java.awt.Dimension(10, 0));
        plotPanel.setVerifyInputWhenFocusTarget(false);

		//Temperature button
        TemperatureBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/temperature.png")));
        TemperatureBtn.setToolTipText("Temperature");
        TemperatureBtn.setFocusPainted(false);
        TemperatureBtn.setPreferredSize(new Dimension(66, 66));
        TemperatureBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                TemperatureBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(TemperatureBtn);

		//Humidity button
        HumidityBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/humidity.png")));
        HumidityBtn.setToolTipText("Humidity");
        HumidityBtn.setFocusPainted(false);
        HumidityBtn.setPreferredSize(new Dimension(66, 66));
        HumidityBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HumidityBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(HumidityBtn);

		//Barometric pressure button
        BarometricPressureBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/pressure.png")));
        BarometricPressureBtn.setToolTipText("Barometric Pressure");
        BarometricPressureBtn.setFocusPainted(false);
        BarometricPressureBtn.setPreferredSize(new Dimension(66, 66));
        BarometricPressureBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                BarometricPressureBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(BarometricPressureBtn);

		//Wind speed button
        WindSpeedBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/windspeed2.png")));
        WindSpeedBtn.setToolTipText("Wind Speed");
        WindSpeedBtn.setFocusPainted(false);
        WindSpeedBtn.setPreferredSize(new Dimension(66, 66));
        WindSpeedBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                WindSpeedBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(WindSpeedBtn);

		//Wind chill button
        WindChillBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/windchill2.png")));
        WindChillBtn.setToolTipText("Wind Chill");
        WindChillBtn.setFocusPainted(false);
        WindChillBtn.setPreferredSize(new Dimension(66, 66));
        WindChillBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                WindChillBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(WindChillBtn);

		//Heat index button
        HeatIndexBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/heatindex.png")));
        HeatIndexBtn.setToolTipText("Heat Index");
        HeatIndexBtn.setFocusPainted(false);
        HeatIndexBtn.setPreferredSize(new Dimension(66, 66));
        HeatIndexBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                HeatIndexBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(HeatIndexBtn);

        // state changed 
        UVIndexBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/uvindex.png")));
        UVIndexBtn.setToolTipText("UV Index");
        UVIndexBtn.setFocusPainted(false);
        UVIndexBtn.setPreferredSize(new Dimension(66, 66));
        UVIndexBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                UVIndexBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(UVIndexBtn);

		//Rainfall button
        RainfallBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/rainfall.png")));
        RainfallBtn.setToolTipText("Rainfall");
        RainfallBtn.setFocusPainted(false);
        RainfallBtn.setPreferredSize(new Dimension(66, 66));
        RainfallBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                RainfallBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(RainfallBtn);

		//Submit button
        SubmitBtn.setPreferredSize(new Dimension(100, 25));
        SubmitBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitBtnActionPerformed(evt);
            }
        });
        
		/* Add text fields for stats */
        TempGuagelabel.setText("Down here have all the guages");

        GridLayout gridLayout = new GridLayout(0,4);
        
        GuagesPanel.setLayout(gridLayout);
        
        GuagesPanel.add(averageTempLabel);
        GuagesPanel.add(averageTemp);
        GuagesPanel.add(highTempLabel);
        GuagesPanel.add(highTemp);
        GuagesPanel.add(highTempDateLabel);
        GuagesPanel.add(highTempDate);
        GuagesPanel.add(highTempTimeLabel);
        GuagesPanel.add(highTempTime);
        GuagesPanel.add(lowTempLabel);
        GuagesPanel.add(lowTemp);
        GuagesPanel.add(lowTempDateLabel);
        GuagesPanel.add(lowTempDate);
        GuagesPanel.add(lowTempTimeLabel);
        GuagesPanel.add(lowTempTime);
        GuagesPanel.add(averageWindSpeedLabel);
        GuagesPanel.add(averageWindSpeed);
        GuagesPanel.add(maxWindSpeedLabel);
        GuagesPanel.add(maxWindSpeed);
        GuagesPanel.add(windSpeedDateLabel);
        GuagesPanel.add(windSpeedDate);
        GuagesPanel.add(windSpeedTimeLabel);
        GuagesPanel.add(windSpeedTime);
        GuagesPanel.add(prevailWindDirectionLabel);
        GuagesPanel.add(prevailWindDirection);
        GuagesPanel.add(totalRainfallLabel);
        GuagesPanel.add(totalRainfall);

        YearLabel.setText("Year");

        MonthLabel.setText("Month");

        DayLabel.setText("Day");
        
        DisplayLabel.setText("Display");

		//Combo boxes
        displayComboBox.setModel(new DefaultComboBoxModel(new String[]
        {"Year", "Month", "Week", "Day"}));

		//Year combo box
        yearComboBox.setModel(new DefaultComboBoxModel<>());
        yearComboBox.addItemListener(new ItemListener(){
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent event){
                if(filled == true) {
                    dayComboBox.removeAllItems();
                    fillDayComboBox(yearsList.get(yearComboBox.getSelectedIndex())
                        .months.get(monthComboBox.getSelectedIndex()));
                }
                
            }
        });
        
		//Month combo box
        monthComboBox.setModel(new DefaultComboBoxModel());
        monthComboBox.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(java.awt.event.ItemEvent event){
                dayComboBox.removeAllItems();
                fillDayComboBox(yearsList.get(yearComboBox.getSelectedIndex())
                        .months.get(monthComboBox.getSelectedIndex()));
            }
        });

		//Day combo box
        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel());
        
		//FileMenu 
        FileMenu.setText("File");
        FileMenu.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //FileMenuActionPerformed(evt);
            }
        });

		//Open menu item under File menu
        OpenMenuItem.setText("Open");
        OpenMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
		
		//Add the Open menu item
        FileMenu.add(OpenMenuItem);

		//Add the FileMenu menu bar
        MenuBar.add(FileMenu); 

		//Set the menu bar
        setJMenuBar(MenuBar);
        
		/* Code generated by NetBeans GUI designer */
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(GuagesPanel, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(YearLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(MonthLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DayLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, 
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(DisplayLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(displayComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SubmitBtn, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(plotPanel, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonPanel, GroupLayout.PREFERRED_SIZE,
                                168, GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(yearComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(YearLabel)
                        .addComponent(MonthLabel)
                        .addComponent(DayLabel)
                        .addComponent(DisplayLabel)
                        .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(displayComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(SubmitBtn, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(ButtonPanel, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(plotPanel, GroupLayout.DEFAULT_SIZE,
                            GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(GuagesPanel, GroupLayout.DEFAULT_SIZE,
                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }
    
    /*==========================================================================
        Function: OpenMenuItemActionPerformed()
    
        Description: 
            This function fills the year, month, and day combo box after 
        the user chooses a file
    
        Parameters: ActionEvent evt - event performed
    
        Returns: None
    ==========================================================================*/
    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            filled = false;
            xmlParser.parse(fileChooser.getSelectedFile(), yearsList);
            fillYearComboBox();
            fillMonthComboBox();
            fillDayComboBox(yearsList.get(yearComboBox.getSelectedIndex()).
                    months.get(monthComboBox.getSelectedIndex()));
            filled = true;
        } 
        else {
            System.out.println("File access cancelled by user.");
        }
    }

    /*==========================================================================
        Function: TemperatureBtnActionPerformed()
    
        Description: 
            This function populates the graph with temperature when the user
        clicks the temperature button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/
    private void TemperatureBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(0, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(0, false);
    }
    
    /*==========================================================================
        Function: HumidityBtnActionPerformed()
    
        Description: 
            This function populates the graph with humidity data when the user
        clicks the humidity button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/	
    private void HumidityBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(1, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(1, false);
    }
    
    /*==========================================================================
        Function: BarometricPressureBtnActionPerformed()
    
        Description: 
            This function populates the graph with barometric pressure data when 
        the user clicks the barometric pressure button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/	
    private void BarometricPressureBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(2, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(2, false);
    }
    
    /*==========================================================================
        Function: WindSpeedBtnActionPerformed()
    
        Description: 
            This function populates the graph with windspeed data when 
        the user clicks the windspeed button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/	
    private void WindSpeedBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(3, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(3, false);
    }
    
    /*==========================================================================
        Function: WindChillBtnActionPerformed()
    
        Description: 
            This function populates the graph with windchill data when 
        the user clicks the windchill button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/
    private void WindChillBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(4, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(4, false);
    }

    /*==========================================================================
        Function: HeatIndexBtnActionPerformed()
    
        Description: 
            This function populates the graph with heat index data when 
        the user clicks the heat index button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/
    private void HeatIndexBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(5, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(5, false);
    }
    
    /*==========================================================================
        Function: UVIndexBtnActionPerformed()
    
        Description: 
            This function populates the graph with uvindex data when 
        the user clicks the uvindex button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/	
    private void UVIndexBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(6, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(6, false);
    }
    
	/*==========================================================================
        Function: RainfallBtnActionPerformed()
    
        Description: 
            This function populates the graph with rainfall data when 
        the user clicks the rainfall button.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/
    private void RainfallBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            renderer.setSeriesVisible(7, true);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            renderer.setSeriesVisible(7, false);
    }
 
    /*==========================================================================
        Function: SubmitBtnActionPerformed()
    
        Description: 
            This function handles the actions that take place when the 
		submit button is pressed.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/ 
    private void SubmitBtnActionPerformed(java.awt.event.ActionEvent evt) {
        TemperatureBtn.setSelected(false);
        HumidityBtn.setSelected(false);
        BarometricPressureBtn.setSelected(false);
        WindSpeedBtn.setSelected(false);
        WindChillBtn.setSelected(false);
        HeatIndexBtn.setSelected(false);
        UVIndexBtn.setSelected(false);
        RainfallBtn.setSelected(false);
        
        collection.updateSeries(yearsList, yearComboBox.getSelectedIndex(),
                monthComboBox.getSelectedIndex(), 
                dayComboBox.getSelectedIndex(), displayComboBox.getSelectedItem().toString());
        updateDataset();
        getData();
    }
  
    /*==========================================================================
        Function: getData()
    
        Description: 
            This function populates the stats for the selected time frame in the, 
       GUI. Average temp, min, date, wind gust, etc.
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/  
    private void getData() {
        
        if ("Year".equals(displayComboBox.getSelectedItem().toString())) {
           averageTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).meanTemp));
           
           highTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).highTemp));
           
           highTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .highDate);
           
           highTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .highTime);
           
           lowTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).lowTemp));
           
           lowTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .lowDate);
           
           lowTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .lowTime);
           
           averageWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).meanWindSpeed));
           
           maxWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).maxWindSpeed));
           
           windSpeedDate.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .windSpeedDate);
           
           windSpeedTime.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .windSpeedTime);
           
           prevailWindDirection.setText(yearsList.get(yearComboBox.
                   getSelectedIndex()).windDirection);
           
           totalRainfall.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).totalRainfall));
           
        }
        
         if ("Month".equals(displayComboBox.getSelectedItem().toString())) {
           averageTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).meanTemp));
           
           highTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).highTemp));
           
           highTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).highDate);
           
           highTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).highTime);
           
           lowTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).lowTemp));
           
           lowTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).lowDate);
           
           lowTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).lowTime);
           
           averageWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).meanWindSpeed));
           
           maxWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).maxWindSpeed));
           
           windSpeedDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).windSpeedDate);
           
           windSpeedTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).windSpeedTime);
           
           prevailWindDirection.setText(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).windDirection);
           
           totalRainfall.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.
                           getSelectedIndex()).totalRainfall));
           
        }
        
         if ("Week".equals(displayComboBox.getSelectedItem().toString())) {
           int weekIndex = yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).week;
           
           averageTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).meanTemp));
           
           highTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).highTemp));
           
           highTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).highDate);
           
           highTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).highTime);
           
           lowTemp.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).lowTemp));
           
           lowTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).lowDate);
           
           lowTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).lowTime);
           
           averageWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).meanWindSpeed));
           
           maxWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).maxWindSpeed));
           
           windSpeedDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).windSpeedDate);
           
           windSpeedTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   weeks.get(weekIndex).windSpeedTime);
           
           prevailWindDirection.setText(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).windDirection);
           
           totalRainfall.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).weeks.get(weekIndex).totalRainfall));
           
        }
         
         if ("Day".equals(displayComboBox.getSelectedItem().toString())) {
           averageTemp.setText(String.valueOf(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).days.get(dayComboBox.getSelectedIndex()).meanTemp));
           
           highTemp.setText(String.valueOf(yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex())
                   .days.get(dayComboBox.getSelectedIndex()).highTemp));
           
           highTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex()).days
                   .get(dayComboBox.getSelectedIndex()).highDate);
           
           highTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).highTime);
           
           lowTemp.setText(String.valueOf(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).lowTemp));
           
           lowTempDate.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).lowDate);
           
           lowTempTime.setText(yearsList.get(yearComboBox.getSelectedIndex())
                   .months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).lowTime);
           
           averageWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.getSelectedIndex())
                   .days.get(dayComboBox.getSelectedIndex()).meanWindSpeed));
           
           maxWindSpeed.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.getSelectedIndex())
                   .days.get(dayComboBox.getSelectedIndex()).maxWindSpeed));
           
           windSpeedDate.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).windSpeedDate);
           
           windSpeedTime.setText(yearsList.get(yearComboBox.getSelectedIndex()).
                   months.get(monthComboBox.getSelectedIndex()).days.
                   get(dayComboBox.getSelectedIndex()).windSpeedTime);
           
           prevailWindDirection.setText(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.getSelectedIndex())
                   .days.get(dayComboBox.getSelectedIndex()).windDirection);
           
           totalRainfall.setText(String.valueOf(yearsList.get(yearComboBox.
                   getSelectedIndex()).months.get(monthComboBox.getSelectedIndex())
                   .days.get(dayComboBox.getSelectedIndex()).totalRainfall));
           
        }
        averageTemp.setEditable(false);
        highTemp.setEditable(false); 
        highTempDate.setEditable(false); 
        highTempTime.setEditable(false); 
        lowTemp.setEditable(false); 
        lowTempDate.setEditable(false);
        lowTempTime.setEditable(false);
        averageWindSpeed.setEditable(false);
        maxWindSpeed.setEditable(false);
        windSpeedDate.setEditable(false);
        windSpeedTime.setEditable(false);
        prevailWindDirection.setEditable(false);
        totalRainfall.setEditable(false);   
    }
    
	/*==========================================================================
        Function: updateDataset()
    
        Description: 
            This function updates the dataset with the collection of data we 
        currently have access to.
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/
    private void updateDataset()
    {
        dataset = collection;
        updateChart();
    }
    
    /*==========================================================================
        Function: updateChart()
    
        Description: 
            This function updates the chart based on the dataset or
        collection we have access to.
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/
    private void updateChart()
    {    
        plot.setDataset(dataset);
        XYItemRenderer xyItemRenderer = plot.getRenderer();
        WeatherToolTipGenerator weatherToolTipGenerator = new WeatherToolTipGenerator();
        xyItemRenderer.setToolTipGenerator(weatherToolTipGenerator);
        plotPanel.setChart(plotChart);
        renderer.setSeriesVisible(0, false);
        renderer.setSeriesVisible(1, false);
        renderer.setSeriesVisible(2, false);
        renderer.setSeriesVisible(3, false);
        renderer.setSeriesVisible(4, false);
        renderer.setSeriesVisible(5, false);
        renderer.setSeriesVisible(6, false);
        renderer.setSeriesVisible(7, false);
        renderer.setSeriesVisible(8, false);
        renderer.setSeriesVisible(9, false);
        plotPanel.repaint();
    }

    /*==========================================================================
        Function: createChart()
    
        Description: 
            This function creates a chart (From JFreeChart.org)
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/
    private JFreeChart createChart()
    {
        JFreeChart chart = ChartFactory.createTimeSeriesChart(
                null, null, null, dataset);
                
        chart.setBackgroundPaint(white);
        
        return chart;
    }

    /*==========================================================================
        Function: fillYearComboBox()
    
        Description: 
            This function populates the year combo box with the year data
        we obtained from the chosen directory.
    
        Parameters: ActionEvent evt - event performed.
    
        Returns: None
    ==========================================================================*/
    private void fillYearComboBox() {
        
        for (int i = 0; i < yearsList.size(); i++)
        {
            yearComboBox.addItem(yearsList.get(i).year);
        }
    }
    
    /*==========================================================================
        Function: fillMonthComboBox()
    
        Description: 
            This function populates the month combo box with the month data
        we obtained from the chosen directory.
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/
    private void fillMonthComboBox() {
        
        for (int i = 0; i < monthList.size(); i++)
        {
            monthComboBox.addItem(monthList.get(i));
        }
    }
 
    /*==========================================================================
        Function: fillDayComboBox()
    
        Description: 
            This function populates the day combo box with the day data
        we obtained from the chosen directory.
    
        Parameters: None
    
        Returns: None
    ==========================================================================*/   
    private void fillDayComboBox(WeatherMonth month) {  
        for(int i = 0; i < month.days.size(); i++)
        {
            dayComboBox.addItem(month.days.get(i).day);
        }
    }
}
