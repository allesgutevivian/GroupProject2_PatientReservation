package dentalCareProject;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialization
		boolean isProgramExit = false;
		int num1 = 0; int num2 = 0; 
		
		List<Patient> patientList = new ArrayList<>();
		List<Appointment> appointmentList = new ArrayList<>();
		List<Employee> employeeList = new ArrayList<>();
		
		Calender calender = new Calender(appointmentList, patientList, employeeList);
		Scanner sc = new Scanner(System.in);
		
		Patient loginPat = null;
		Employee loginEmp = null;
		
		
		while(isProgramExit == false) {
			boolean isLogout = false;
			
			if(num1 == 0) {
			System.out.println("0. registration, 1. login, 2. close");
			num1 = sc.nextInt();
			}
			
			
			switch(num1) {
			case 0 : // registration
				// Get values by GUI
				System.out.println("0. employee, 1. patient");
				String username;
				String password;
				
				int tmp = sc.nextInt();
				if(tmp == 0) {
					System.out.println("Registration: name, username, password, role");
					String name = sc.next();
					username = sc.next();
					password = sc.next();
					String role = sc.next();
					
					// Create n Save Employee
					calender.addEmployee(name, username, password, role);
					System.out.println(calender.getEmployeeList());				
					num1 = 0; // to main menu
					break; 
					
				} else {
					System.out.println("Registration: name, username, password, email, address, telephone");
					String name = sc.next();
					username = sc.next();
					password = sc.next();
					String email = sc.next();
					String address = sc.next();
					String telephone = sc.next();
					
					// Create n Save Patient
					calender.addPatient(name, username, password, email, address, telephone);
					System.out.println(calender.getPatientList());				
					num1 = 0; // to main menu
					break;
				}
				
			case 1 : // login
				// Get values by GUI
				System.out.println("Login : username, password");
				username = sc.next();
				password = sc.next();
				

				// compare to the lists n confirm the login user is a patient or an employee.
				for(Patient t : calender.getPatientList()) {
					if(t.getPassword().equals(password) && t.getUsername().equals(username)) {
						loginPat = t;
						num1 = 3;
						break; }
					}
				for(Employee t : calender.getEmployeeList()) {
					if(t.getPassword().equals(password) && t.getUsername().equals(username)) {
						loginEmp = t;
						num1 = 4;
						break; }
					}
				if(loginPat == null && loginEmp == null) { // wrong password logic GUI
					System.out.println("Wrong username or password.");
					num1 = 1;
					break;
				}
				break;
			case 2 :
				System.out.println("Closed");
				isProgramExit = true;	
				break;
				
			case 3 : // Patient view; using loginPat instance;
				System.out.println(loginPat);
				while(isLogout == false) {
					System.out.println("Patient page : 1. appointment list, 2. new appointment, 3. cancel appointment, 4. logout");
					num2 = sc.nextInt(); // integer in a range 1~4 GUI

					switch(num2) {
					case 1 : // show appointment list
				
						System.out.println("1. appointment list");
						List<Appointment> app = calender.getAppointmentList();
						final Patient patTmp = loginPat;
						app.removeIf(t -> !t.getPatient().equals(patTmp));
						
						System.out.println(app);
						
						// show by GUI
						break;
					case 2 : // make an appointment
						System.out.println("2. new appointment");
						System.out.println("year, month, day, hour, minute");
						// get values by GUI
						List<Integer> appDate = new ArrayList<>();
						for(int i = 0; i < 5; i++) {
						appDate.add(sc.nextInt());
						}
						
						calender.addAppointment(loginPat, appDate);
						System.out.println("appointment created");
						break;
					case 3 : // cancel appointment
						System.out.println("3. cancel appointment");
						
						// get values by GUI
						System.out.println("appointment date?");
						String dateTimeStr = sc.next();
						LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
						
						// remove
						calender.removeAppointment(loginPat, dateTime);
						System.out.println("appointment deleted");
						break;
					case 4 : // logout 
						num1 = 0;
						isLogout = true; 
					}
				}
				break;
			case 4 : // Employee view
				System.out.println(loginEmp);
				
				while(isLogout == false) {
					System.out.println("Employee page : 1. patient list, 2. new appointment, 3. cancel appointment, 4. logout");
					num2 = sc.nextInt(); // integer in a range 1~4;
					
					switch(num2) {
					case 1 : // patient list
						System.out.println("1. patient list");
						System.out.println(calender.getPatientList());
						break;
					case 2 : // make an appointment
						System.out.println("2. new appointment");
						System.out.println("year, month, day, hour, minute");
						// get values by GUI(appDate, loginPat)
						
						List<Integer> appDate = new ArrayList<>();
						for(int i = 0; i < 5; i++) {
						appDate.add(sc.nextInt());
						}
						
						System.out.println(calender.getPatientList());
						loginPat = calender.getPatientList().get(sc.nextInt());
						
						// save an appointment
						calender.addAppointment(loginPat, appDate);
						System.out.println("appointment created");
						break;
					case 3 : // cancel appointment
						System.out.println("cancel appointment");
						// get values by GUI
						System.out.println("appointment date?");
						String dateTimeStr = sc.next();
						LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr);
						
						// remove
						calender.removeAppointment(loginPat, dateTime);
						System.out.println("appointment deleted");
						break;
					case 4 : // logout;
						num1 = 0;
						isLogout = true;
					}
				}
				break;
			case 5 : // logout
				System.out.println("Logout");
				isProgramExit = false;
				num1 = 0;
				break;
			
			} 
		}
		
	}

}
