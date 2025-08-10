package GroupProject2_Reservation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PatientMenu {
	public static void menuP(Patient patient,Calender calender) {
		JFrame frame = new JFrame("PatientMenu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(300, 400));

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel patientNameLabel = new JLabel("Name: " + patient.getName());
		patientNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		patientNameLabel.setBounds(20, 20, 270, 30);panel.add(patientNameLabel);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();

		for (Appointment appointment : calender.getAppList()) {
		    
			if (appointment.getPatient().getName().equals(patient.getName())) {
				String content = appointment.getDateTime().toString();
				
				listModel.addElement("Appointment: " + content);
			}
			
		}

		JList<String> appointmentList = new JList<>(listModel);
		appointmentList.setFont(new Font("Arial", Font.BOLD, 15));
		JScrollPane scrollPane = new JScrollPane(appointmentList);
		
		scrollPane.setBounds(20, 60, 260, 250);panel.add(scrollPane);

        
		
		JButton logoutbtn = new JButton("Logout");
		panel.add(logoutbtn);
		logoutbtn.setFont(new Font("Arial", Font.BOLD, 15));
		logoutbtn.setBounds(190, 20, 100, 30);
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility.logout(frame,calender);
		}});
		
		JButton addAppointmentbtn = new JButton("Add Appointment");
		addAppointmentbtn.setFont(new Font("Arial", Font.BOLD, 15));
		panel.add(addAppointmentbtn);
		addAppointmentbtn.setBounds(20, 360, 200, 30);
		addAppointmentbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.out.println("Addition");
				CalenderGUI.calendarView(patient, calender);
				
		}});
		
		frame.pack();
		frame.setVisible(true);
	}
	
	
}