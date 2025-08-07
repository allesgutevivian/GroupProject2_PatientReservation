package GroupProject2_Reservation;

public class Main {

	public static void main(String[] args) {
		
		Calender calender = new Calender();
		
		// Example
		calender.addEmployee("E1", "e1234", "1234", "employee");
		calender.addEmployee("E2", "e2345", "1234", "employee");
		calender.addEmployee("E3", "e3456", "1234", "employee");
		
		calender.addPatient("P1", "p1234", "1234", "p1234@gmail.com", "Earth", "+33-686530641");
		calender.addPatient("P2", "p2345", "1234", "p2345@gmail.com", "Earth", "+33-686530642");
		calender.addPatient("P3", "p3456", "1234", "p3456@gmail.com", "Earth", "+33-686530643");
		
		WelcomePage.login(calender);
	}
}

