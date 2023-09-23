package inputValidityCheck;

import javax.mail.internet.*;

public abstract class EmailValidityChecker {

	public static boolean checkEmailValidity(String email) {
		try {
			InternetAddress emailAddress = new InternetAddress(email);
			emailAddress.validate();
			return true;
		} 
		catch (AddressException e) {
			System.out.println("Invalid email!");
			return false;
		}
	}
}
