package GroupProject2_Reservation;

import javax.swing.JFrame;

public class Utility {
	public void logout(JFrame frame, Calender calender) {
		frame.dispose();
		WelcomePage.login(calender);
	}
}

