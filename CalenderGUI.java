package GroupProject2_Reservation;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class CalenderGUI {
	public static void calendarView(Patient patient, Calender calender) {
        JFrame frame = new JFrame("Add Appointment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(300, 400));

        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel patientNameLabel = new JLabel("Add Appointment");
		patientNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		patientNameLabel.setBounds(20, 20, 270, 30);panel.add(patientNameLabel);

        int currentYear = LocalDateTime.now().getYear();
        Integer[] years = new Integer[50];
        for (int i = 0; i < 50; i++) {
            years[i] = currentYear - 25 + i;
        }
        
        JComboBox<Integer> yearBox = new JComboBox<>(years);
        yearBox.setSelectedItem(currentYear);
        panel.add(yearBox); yearBox.setBounds(170, 100, 100, 30);
        
        JLabel YearLabel = new JLabel("Year");
        YearLabel.setFont(new Font("Arial", Font.BOLD, 20));
        YearLabel.setBounds(20, 100, 100, 30);panel.add(YearLabel);

        Integer[] months = new Integer[12];
        for (int i = 0; i < 12; i++) {
            months[i] = i + 1;
        }
        JComboBox<Integer> monthBox = new JComboBox<>(months);
        monthBox.setSelectedItem(LocalDateTime.now().getMonthValue());
        panel.add(monthBox); monthBox.setBounds(170, 150, 100, 30);
        JLabel MonthLabel = new JLabel("Month");
        MonthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        MonthLabel.setBounds(20, 150, 100, 30);panel.add(MonthLabel);

        Integer[] days = new Integer[31];
        for (int i = 0; i < 31; i++) {
            days[i] = i + 1;
        }
        JComboBox<Integer> dayBox = new JComboBox<>(days);
        dayBox.setSelectedItem(LocalDateTime.now().getDayOfMonth());
        panel.add(dayBox); dayBox.setBounds(170, 200, 100, 30);
        JLabel DayLabel = new JLabel("Day");
        DayLabel.setFont(new Font("Arial", Font.BOLD, 20));
        DayLabel.setBounds(20, 200, 100, 30);panel.add(DayLabel);
        

        SpinnerNumberModel hourModel = new SpinnerNumberModel(LocalDateTime.now().getHour(), 0, 23, 1);
        JSpinner hourSpinner = new JSpinner(hourModel);
        panel.add(hourSpinner); hourSpinner.setBounds(170, 250, 100, 30);
        JLabel hourLabel = new JLabel("Hour");
        hourLabel.setFont(new Font("Arial", Font.BOLD, 20));
        hourLabel.setBounds(20, 250, 100, 30);panel.add(hourLabel);

        SpinnerNumberModel minuteModel = new SpinnerNumberModel(LocalDateTime.now().getMinute(), 0, 59, 1);
        JSpinner minuteSpinner = new JSpinner(minuteModel);
        panel.add(minuteSpinner); minuteSpinner.setBounds(170, 300, 100, 30);
        JLabel minLabel = new JLabel("Minute");
        minLabel.setFont(new Font("Arial", Font.BOLD, 20));
        minLabel.setBounds(20, 300, 100, 30);panel.add(minLabel);

        JButton submitbtn = new JButton("Submit");
        submitbtn.setBounds(100, 360, 100, 30);panel.add(submitbtn);

        submitbtn.addActionListener(e -> {
            int year = (int) yearBox.getSelectedItem();
            int month = (int) monthBox.getSelectedItem();
            int day = (int) dayBox.getSelectedItem();
            int hour = (int) hourSpinner.getValue();
            int minute = (int) minuteSpinner.getValue();
            List<Integer> AppointmentTime = new ArrayList<Integer>(Arrays.asList(year, month, day, hour, minute));


            calender.addAppointment(patient, AppointmentTime);
            frame.dispose();
            PatientMenu.menuP(patient, calender);
        });



        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}
