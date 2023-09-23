package birthdayWishTool;

import recipientSet.Friend;
import java.util.*;
import inputValidityCheck.DateValidityChecker;


public class BirthdayList {
	private static final BirthdayList instance = new BirthdayList();
	private static Map<String, List<Friend>> birthdayList = new HashMap<String, List<Friend>>();
	
	private BirthdayList() {}
	
	public static BirthdayList getInstance() {
		return instance;
	}
	
	public void addBirthday(String birthday, Friend friend) {
		if (birthdayList.containsKey(birthday)) {
			birthdayList.get(birthday).add(friend);
		}
		else {
			List<Friend> temp = new ArrayList<Friend>();
			temp.add(friend);
			birthdayList.put(birthday, temp);
		}
	}
	
	public List<Friend> getBornOnDate(String date) {
		return birthdayList.get(date);
	}
	
	public boolean containsDate(String date) {
		return birthdayList.containsKey(date);
	}
	
	public boolean printBornOnDate(String date) {
		if (DateValidityChecker.checkDateValidity(date)) {
			String[] splitted = date.split("/");
	  	  	String formattedDate = splitted[1] + splitted[2];
			
	  	  	if (birthdayList.containsKey(formattedDate)) {
				System.out.println("\nRecipients having birthdays on " + date + ":\n");
				List<Friend> todayBorn = getBornOnDate(formattedDate);
				
				for (Friend friend: todayBorn) {
					friend.printDetails();
				}
			}
	  	  	else {
				System.out.println("\nNo receipients having birthdays on " + date + ".");
			}
			return true;
		}
		return false;
	}
}
