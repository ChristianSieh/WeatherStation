/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author 1960681
 */
public class WeatherFrame extends javax.swing.JFrame {

    /**
     * Creates new form WeatherFrame
     */
    public WeatherFrame() {
        initComponents();
    }
    
    private void initComponents() {

        fileChooser = new JFileChooser();
        xmlParser = new XMLParser();
        TimePanel = new JPanel();
        dayComboBox = new JComboBox<Integer>();
        plotChart = createChart();
        collection = new XYSeriesCollection();
        plotPanel = new ChartPanel(plotChart);
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
        monthComboBox = new JComboBox<Integer>();
        MenuBar = new JMenuBar();
        FileMenu = new JMenu();
        OpenMenuItem = new JMenuItem();
        yearsList = new ArrayList<WeatherYear>();

        //fileChooser.setFileFilter(new xmlFilter());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Station");

        plotPanel.setBackground(new java.awt.Color(254, 254, 254));
        plotPanel.setPreferredSize(new java.awt.Dimension(10, 0));
        plotPanel.setVerifyInputWhenFocusTarget(false);

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

        HumidityBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/humidity.png")));
        HumidityBtn.setToolTipText("Humidity");
        HumidityBtn.setFocusPainted(false);
        HumidityBtn.setPreferredSize(new Dimension(66, 66));
        HumidityBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HumidityBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(HumidityBtn);

        BarometricPressureBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/pressure.png")));
        BarometricPressureBtn.setToolTipText("Barometric Pressure");
        BarometricPressureBtn.setFocusPainted(false);
        BarometricPressureBtn.setPreferredSize(new Dimension(66, 66));
        ButtonPanel.add(BarometricPressureBtn);

        WindSpeedBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/windspeed2.png")));
        WindSpeedBtn.setToolTipText("Wind Speed");
        WindSpeedBtn.setFocusPainted(false);
        WindSpeedBtn.setPreferredSize(new Dimension(66, 66));
        ButtonPanel.add(WindSpeedBtn);

        WindChillBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/windchill2.png")));
        WindChillBtn.setToolTipText("Wind Chill");
        WindChillBtn.setFocusPainted(false);
        WindChillBtn.setPreferredSize(new Dimension(66, 66));
        ButtonPanel.add(WindChillBtn);

        HeatIndexBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/heatindex.png")));
        HeatIndexBtn.setToolTipText("Heat Index");
        HeatIndexBtn.setFocusPainted(false);
        HeatIndexBtn.setPreferredSize(new Dimension(66, 66));
        HeatIndexBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HeatIndexBtnActionPerformed(evt);
            }
        });
        ButtonPanel.add(HeatIndexBtn);

        UVIndexBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/uvindex.png")));
        UVIndexBtn.setToolTipText("UV Index");
        UVIndexBtn.setFocusPainted(false);
        UVIndexBtn.setPreferredSize(new Dimension(66, 66));
        ButtonPanel.add(UVIndexBtn);

        RainfallBtn.setIcon(new javax.swing.ImageIcon(
                getClass().getResource("/weatherstation/icons/rainfall.png")));
        RainfallBtn.setToolTipText("Rainfall");
        RainfallBtn.setFocusPainted(false);
        RainfallBtn.setPreferredSize(new Dimension(66, 66));
        ButtonPanel.add(RainfallBtn);

        TempGuagelabel.setText("Down here have all the guages");

        javax.swing.GroupLayout GuagesPanelLayout = new GroupLayout(GuagesPanel);
        GuagesPanel.setLayout(GuagesPanelLayout);
        GuagesPanelLayout.setHorizontalGroup(
            GuagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GuagesPanelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(TempGuagelabel)
                .addContainerGap(631, Short.MAX_VALUE))
        );
        GuagesPanelLayout.setVerticalGroup(
            GuagesPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GuagesPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(TempGuagelabel, GroupLayout.PREFERRED_SIZE, 
                        27, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );



        YearLabel.setText("Year");

        MonthLabel.setText("Month");

        DayLabel.setText("Day");
        
        DisplayLabel.setText("Display");

        displayComboBox.setModel(new DefaultComboBoxModel(new String[]
        {"Year", "Month", "Week", "Day"}));

        yearComboBox.setModel(new DefaultComboBoxModel<>());
        
        monthComboBox.setModel(new DefaultComboBoxModel());

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel());
        
        FileMenu.setText("File");
        FileMenu.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FileMenuActionPerformed(evt);
            }
        });

        OpenMenuItem.setText("Open");
        OpenMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
        FileMenu.add(OpenMenuItem);

        MenuBar.add(FileMenu);

        setJMenuBar(MenuBar);
        
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
                        .addComponent(TimePanel, GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(TimePanel, GroupLayout.PREFERRED_SIZE,
                            GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
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

    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            xmlParser.parse(fileChooser.getSelectedFile(), yearsList);
            fillYearComboBox();
            fillMonthComboBox(yearsList.get(yearComboBox.getSelectedIndex()));
            fillDayComboBox(yearsList.get(yearComboBox.getSelectedIndex()).
                    months.get(monthComboBox.getSelectedIndex()));
        } 
        else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void TemperatureBtnActionPerformed(java.awt.event.ItemEvent evt) {
        if(evt.getStateChange() ==  ItemEvent.SELECTED)
        {
            addSeries("Temperature", list);
        }
        else if(evt.getStateChange() == ItemEvent.DESELECTED)
            removeSeries("Temperature");
    }
    private void HumidityBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void HeatIndexBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {

    }
    
    private void addSeries(String label, ArrayList<WeatherYear> list)
    {   
        XYSeries series = new XYSeries(label);
        series.add(1.0, 5.0);
        series.add(2.0, 7.0);
        series.add(3.0, 6.0);
        series.add(4.0, 8.0);
        series.add(5.0, 4.0);
        series.add(6.0, 4.0);
        series.add(7.0, 2.0);
        series.add(8.0, 1.0);
        
        collection.addSeries(series);
        updateDataset();
    }
    
    private void removeSeries(String label)
    {
        XYSeries series = new XYSeries(label);
        
        collection.removeSeries(series);
        updateDataset();
    }
    
    private void updateDataset()
    {
        dataset = collection;
        updateChart();
    }
    
    private void updateChart()
    {    
        XYPlot plot = plotChart.getXYPlot();
        plot.setDataset(dataset);
        plotPanel.setChart(plotChart);
        plotPanel.repaint();
    }

    private JFreeChart createChart()
    {
        JFreeChart chart = ChartFactory.createXYLineChart(
                null, null, null, null);
                
        chart.setBackgroundPaint(white);
        
        return chart;
    }
    
    ////////////////////////////////////////////////////////////
    private void fillYearComboBox() {
        
        for (int i = 0; i < yearsList.size(); i++)
        {
            yearComboBox.addItem(yearsList.get(i).year);
        }
    }
    
    private void fillMonthComboBox(WeatherYear year) {
        
        for (int i = 0; i < year.months.size(); i++)
        {
            monthComboBox.addItem(year.months.get(i).month + 1);
        }
    }
    
    private void fillDayComboBox(WeatherMonth month) {  
        for(int i = 0; i < month.days.size(); i++)
        {
            dayComboBox.addItem(i + 1);
        }
    }
    
    /////////////////////////////////////////////////////////
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherFrame().setVisible(true);
            }
        });
    }

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
    private JPanel TimePanel;
    private JToggleButton UVIndexBtn;
    private JToggleButton WindChillBtn;
    private JToggleButton WindSpeedBtn;
    private JFileChooser fileChooser;
    private JLabel YearLabel;
    private JLabel MonthLabel;
    private JLabel DisplayLabel;
    private JLabel DayLabel;
    private JComboBox<Integer> dayComboBox;
    private JComboBox<Integer> monthComboBox;
    private JComboBox<Integer> displayComboBox;
    private JComboBox<Integer> yearComboBox;
    private ChartPanel plotPanel;
    private JFreeChart plotChart;
    private ArrayList list;
    private XYDataset dataset;
    private XYSeriesCollection collection;
    private XMLParser xmlParser;
    private ArrayList<WeatherYear> yearsList;
}
