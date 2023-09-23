package inputValidityCheck;

public abstract class RecipientValidityCheck {
	
	public static boolean checkTypeValidity(String recpType, String[] details) {
		if (!(recpType.matches("Official") || recpType.matches("Personal") || recpType.matches("Office_friend"))) {
			System.out.println("Invalid recipient type!");
			return false;
		}
		if (recpType.matches("Official")) {
				if (details.length != 3) {
					System.out.println("Invalid no.of details!");
					return false;
				}
				return EmailValidityChecker.checkEmailValidity(details[1]);
		}
		if(details.length != 4) {
			System.out.println("Invalid no.of details!");
			return false;
		}
		String email;
		if (recpType.matches("Personal")) {
			email = details[2];
		}
		else {
			email = details[1];
		}
		return EmailValidityChecker.checkEmailValidity(email) && DateValidityChecker.checkDateValidity(details[3]);
	}

}
