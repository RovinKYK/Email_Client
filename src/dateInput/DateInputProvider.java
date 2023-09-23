package dateInput;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class DateInputProvider {
	
	public static String getDateString() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatObject = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String formattedDate = date.format(formatObject);
		return formattedDate;
	}
	
	public static String getMonthAndDate() {
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatObject = DateTimeFormatter.ofPattern("MMdd");
		String formattedDate = date.format(formatObject);
		return formattedDate;
	}
}
