package GroupProject2_Reservation;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EmployeeMenu {
	public static void menuE(Employee empolyee,Calender calendar) {
		JFrame frame = new JFrame("Employee Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(300, 400));

		JPanel panel = new JPanel();
		frame.add(panel);
		panel.setLayout(null);
		
		JLabel patientNameLabel = new JLabel("Name: " + empolyee.getName());
		patientNameLabel.setFont(new Font("Arial", Font.BOLD, 20));
		patientNameLabel.setBounds(20, 20, 270, 30);panel.add(patientNameLabel);
		
		DefaultListModel<String> listModel = new DefaultListModel<>();

		for (Appointment appointment : calendar.getAppList()) {
		    
			String content = appointment.getDateTime().toString();
				
			listModel.addElement("Appointment for " + appointment.getPatient().getName() + "\n at " + content);
			
			
		}

		JList<String> appointmentList = new JList<>(listModel);
		appointmentList.setFont(new Font("Arial", Font.BOLD, 13));
		JScrollPane scrollPane = new JScrollPane(appointmentList);
		
		scrollPane.setBounds(20, 60, 260, 250);panel.add(scrollPane);

        
		
		JButton logoutbtn = new JButton("Logout");
		panel.add(logoutbtn);
		logoutbtn.setFont(new Font("Arial", Font.BOLD, 15));
		logoutbtn.setBounds(190, 20, 100, 30);
		logoutbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Utility.logout(frame,calendar);
		}});
		
		frame.pack();
		frame.setVisible(true);
	}
}
