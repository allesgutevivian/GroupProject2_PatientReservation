package GroupProject2_Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateLabelFormatter extends AbstractFormatter {

	String datePattern;
	SimpleDateFormat dateFormatter;
	
	public Object stringToValue(String str) {
		try {
			return dateFormatter.parseObject(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return str;
		}
	}
	
	public String valueToString(Object obj) {
		return dateFormatter.format(obj);
	}
	
	
}
