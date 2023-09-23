package objectManage;

import recipientSet.*;
import birthdayWishTool.BirthdayList;
import java.util.ArrayList;
import java.util.List;
import inputValidityCheck.RecipientValidityCheck;

public class RecipientManager {
	private static final RecipientManager instance = new RecipientManager();
	private static int recipientCount = 0;
	private static List<Recipient> recipientList = new ArrayList<Recipient>();
	private BirthdayList birthdayList = BirthdayList.getInstance();
	
	private RecipientManager() {}
	
	public static RecipientManager getInstance() {
		return instance;
	}
	
	public void printRecipientCount() {
		System.out.println("\nRecipient object count = " + recipientCount);
	}
	
	public boolean addRecipient(String entry) {
		String splitted[] = entry.split(":");
  	    String details[] = splitted[1].split(",");
  	    String recpType = splitted[0].strip().substring(0, 1).toUpperCase() + splitted[0].substring(1);
  	    
  	    for (int i = 0; i < details.length; i++)
  	    	details[i] = details[i].strip();
  	    
  	    if (RecipientValidityCheck.checkTypeValidity(recpType, details)) {
  	    	String name = details[0].substring(0, 1).toUpperCase() + details[0].substring(1);
  	  	    
  	    	if (recpType.matches("Official")) {
  		  		OfficialRecipient newRecp1 = new OfficialRecipient(name, details[1], details[2]);
  		  		recipientList.add(newRecp1);
  	  	    }
  	  	    else {
  	  	    	String[] splitted3 = details[3].split("/");
	  	  		String formattedBirthday = splitted3[1] + splitted3[2];
  	  	    	
	  	  		if (recpType.matches("Office_friend")) {
  		  	  		OfficialCloseFriend newRecp2 = new OfficialCloseFriend(name, details[1], details[2], details[3]);
  		  	  		recipientList.add(newRecp2);
  		  	  		birthdayList.addBirthday(formattedBirthday,newRecp2);
  	  	    	}
  		  	  	else  {
  		  	  		PersonalRecipient newRecp3 = new PersonalRecipient(name, details[1], details[2], details[3]);
  		  	  		recipientList.add(newRecp3);
  		  	  		birthdayList.addBirthday(formattedBirthday,newRecp3);
  		  	  	}
  		  	} 
  	  	    ++recipientCount;
  	  	    return true;
  		}
  	    return false;
	}
}
