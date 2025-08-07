package dentalCareProject;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Calender {

	
	List<Appointment> appList = new ArrayList<>();
	List<Patient> patList = new ArrayList<>();
	List<Employee> empList = new ArrayList<>();
	
	
	// Constructor
	public Calender(List<Appointment> appList, List<Patient> patList, List<Employee> empList) {
		this.appList = appList;
		this.patList = patList;
		this.empList = empList;
	}

	
	// Getters
	public List<Appointment> getAppList() {
		return appList;
	}

	public List<Patient> getPatList() {
		return patList;
	}

	public List<Employee> getEmpList() {
		return empList;
	}
	

	// Methods
	public void addAppointment(Patient pat, List<Integer> date) {
		// patient n IntegerList(bc we get the date value by Integer type)

		// change the integerList to localDataTime
		// what is the rule about Storing values?
		// Integer Data sequence : year, month, day, hour, minute;
		
		String dateTime = date.get(0).toString() + "-" + date.get(1).toString() + "-" + date.get(2).toString() +
				"T" + date.get(3).toString() + ":" + date.get(4).toString() + ":00";
		
		LocalDateTime appTime = LocalDateTime.parse(dateTime);
		
		// make a new appointment instance
		Appointment newApp = new Appointment(pat, appTime);
		
		// store it in the appList
		appList.add(newApp);
		
	}
	
	public void addPatient(String name, String username, 
			String password, String email, String address, String telephone) {
		
		// generate a new Patient instance
		Patient pat = new Patient(name, username, password, email, address, telephone);
		
		// add it to List
		patList.add(pat);
	}
	
	public void addEmployee(String name, String username, String password, String role) {
		// generate a new Employee instance
		Employee newEmp = new Employee(name, username, password, role);
		// add it to List
		empList.add(newEmp);
	}
	
	public void removeAppointment(Patient pat, LocalDateTime dateTime) {
		
		appList.removeIf(t -> t.getPatient().equals(pat) && dateTime.equals(dateTime));
		
	}
	
	public void updateDateTime(Patient pat, LocalDateTime old, LocalDateTime updated) {
		
		// find an appointment instance
		appList.forEach(t -> {
			if(t.getPatient().equals(pat) && t.getDateTime().equals(old)) {
				t.setDateTime(updated);
			}
		});
		
	}
	
	
}
