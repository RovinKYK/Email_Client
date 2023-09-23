package inputValidityCheck;

public abstract class DateValidityChecker {

	public static boolean checkDateValidity(String date) {
		String[] splitted = date.split("/"); 
		
		if (splitted.length == 3) {
			int month = Integer.parseInt(splitted[1]);
			int day = Integer.parseInt(splitted[2]);
			
			if (month <= 12 && day <= 31) {
				return true;
			}
		}
		System.out.println("Invalid date format!");
		return false;
	}
}
