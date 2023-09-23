package inputValidityCheck;

public abstract class OptionMenuInputChecker {

	public static boolean checkOptionMenuInput(String optionString) {
		try {
			int option = Integer.parseInt(optionString);
			if (option == -1 || (option >= 1 && option <= 5)) {
				return true;
			}
			System.out.println("Invalid input range!");
		}
		catch (NumberFormatException e) {
			System.out.println("Input should be an integer!");
		}
		return false;
	}
}
