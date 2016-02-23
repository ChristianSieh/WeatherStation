/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherstation;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

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
        TimePanel = new JPanel();
        dayComboBox = new JComboBox<String>();
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
        WeekLabel = new JLabel();
        DayLabel = new JLabel();
        weekComboBox = new JComboBox<String>();
        monthComboBox = new JComboBox<String>();
        MenuBar = new JMenuBar();
        FileMenu = new JMenu();
        OpenMenuItem = new JMenuItem();

        fileChooser.setFileFilter(new xmlFilter());
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Station");

        dayComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] 
            { "Item 1", "Item 2", "Item 3", "Item 4" }));

        DayLabel.setText("Day");

        GroupLayout TimePanelLayout = new GroupLayout(TimePanel);
        TimePanel.setLayout(TimePanelLayout);
        TimePanelLayout.setHorizontalGroup(
            TimePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TimePanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(DayLabel)
                .addGap(18, 18, 18)
                .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, 
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TimePanelLayout.setVerticalGroup(
            TimePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TimePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(dayComboBox, GroupLayout.PREFERRED_SIZE, 
                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addComponent(DayLabel))
        );

        plotPanel.setBackground(new java.awt.Color(254, 254, 254));
        plotPanel.setPreferredSize(new java.awt.Dimension(10, 0));
        plotPanel.setVerifyInputWhenFocusTarget(false);

        TemperatureBtn.setIcon(new ImageIcon(
                getClass().getResource("/weatherstation/icons/temperature.png")));
        TemperatureBtn.setToolTipText("Temperature");
        TemperatureBtn.setFocusPainted(false);
        TemperatureBtn.setPreferredSize(new Dimension(66, 66));
        TemperatureBtn.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
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

        yearComboBox.setModel(new DefaultComboBoxModel<>(new Integer[] { 1, 2, 3, 4 }));

        YearLabel.setText("Year");

        MonthLabel.setText("Month");

        WeekLabel.setText("Week");

        weekComboBox.setModel(new DefaultComboBoxModel(
                new String[] { "Week 1", "Week 2", "Week 3", "Week 4" }));

        monthComboBox.setModel(new DefaultComboBoxModel(
                new String[] { "January", "February", "March", "April", "May",
                    "June", "July", "Augest", "September", "October",
                    "November", "December" }));

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
                        .addComponent(WeekLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(weekComboBox, GroupLayout.PREFERRED_SIZE,
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
                        .addComponent(WeekLabel)
                        .addComponent(weekComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(monthComboBox, GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
            File file = fileChooser.getSelectedFile();
        } 
        else {
            System.out.println("File access cancelled by user.");
        }
    }

    private void TemperatureBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void HumidityBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void HeatIndexBtnActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void FileMenuActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

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
    private JComboBox<String> dayComboBox;
    private JFileChooser fileChooser;
    private JLabel YearLabel;
    private JLabel MonthLabel;
    private JLabel WeekLabel;
    private JLabel DayLabel;
    private JComboBox<String> monthComboBox;
    private JComboBox<String> weekComboBox;
    private JComboBox<Integer> yearComboBox;
    private ChartPanel plotPanel;
    private JFreeChart plotChart;
}
