package GroupProject2_Reservation;

import java.awt.*;
import javax.swing.*;

public class WelcomePage {

    public static void login(Calender calender) {
        JFrame frame = new JFrame("Login Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setPreferredSize(new Dimension(300, 400));
        //frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel(null);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setFont(new Font("Arial", Font.BOLD, 20));
        idLabel.setBounds(30, 50, 40, 40);
        
        JTextField idField = new JTextField();
        idField.setBounds(100,50,180, 40);

        JLabel pwLabel = new JLabel("PW:");
        pwLabel.setFont(new Font("Arial", Font.BOLD, 20));
        pwLabel.setBounds(30, 100, 40, 40);
        JTextField pwField = new JTextField();
        pwField.setBounds(100,100,180, 40);
        //JPasswordField pwField = new JPasswordField();

        JButton loginButton = new JButton("Log in");
        loginButton.setFont(new Font("Arial", Font.BOLD, 20));
        loginButton.setBounds(60, 200, 180, 40);

        panel.add(idLabel);
        panel.add(idField);
        panel.add(pwLabel);
        panel.add(pwField);
        panel.add(new JLabel()); 
        panel.add(loginButton);

        frame.add(panel);
        frame.pack();
        frame.setVisible(true);

        
        loginButton.addActionListener(e -> {
            String id = idField.getText();
            String pw = pwField.getText();

            boolean found = false;

            for (Employee employee : calender.getEmpList()) {
                if (id.equals(employee.getUsername()) && pw.equals(employee.getPassword())) {
                	frame.dispose();
                	EmployeeMenu.menuE(employee, calender);
                    found = true;
                    break;
                }
            }

            if (!found) {
                for (Patient patient : calender.getPatList()) {
                    if (id.equals(patient.getUsername()) && pw.equals(patient.getPassword())) {
                        frame.dispose();
                    	System.out.println("P"); 
                        found = true;
                        PatientMenu.menuP(patient, calender);
                        break;
                    }
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(frame, "Wrong ID or PW.");
            }
        });
    }
}
