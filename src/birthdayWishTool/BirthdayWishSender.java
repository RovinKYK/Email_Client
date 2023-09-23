package birthdayWishTool;

import java.util.*;
import objectManage.EmailManager;
import recipientSet.Friend;


public class BirthdayWishSender {
	
	private static final BirthdayWishSender instance = new BirthdayWishSender();
	private static String lastWishedDate = "";
	private BirthdayList birthdayList = BirthdayList.getInstance();
	private EmailManager emailManager = EmailManager.getInstance();
	
	private BirthdayWishSender() {}
	
	public static BirthdayWishSender getInstance() {
		return instance;
	}
	
	public static void setLastWishedDate(String date) {
		lastWishedDate = date;
	}
	
	public static String getLastWishedDate( ) {
		return lastWishedDate;
	}
	
	public void wishForBirthdays(String date) {
		if (!lastWishedDate.matches(date)) {
			System.out.println("\nSending birthday wishes.");
			
			if (birthdayList.containsDate(date)) {
				List<Friend> todayBorn = birthdayList.getBornOnDate(date);
				
				for (Friend friend: todayBorn) {
					String birthdayWish= friend.birthdayWish();
					emailManager.newEmail(friend.getEmail(), "Birthday wish", birthdayWish);
				}
			System.out.println("Birthday wishes sent successfully.");
			}
			else {
				System.out.println("No recipients having birthdays today.");
			}
			lastWishedDate = date;
		}
	}
}
