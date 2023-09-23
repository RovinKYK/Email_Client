package objectManage;

import emailTool.*;
import java.util.*;
import dateInput.DateInputProvider;
import inputValidityCheck.*;

public class EmailManager {
	private static final EmailManager instance = new EmailManager();
	private static Map<String, List<Email>> emailList = new HashMap<String, List<Email>>();
	private MailSender mailSender = MailSender.getInstance();
	
	private EmailManager() {}
	
	public static EmailManager getInstance() {
		return instance;
	}
	
	public static Map<String, List<Email>> getEmailList() {
		return emailList;
	}
	
	public static void setEmailList(Map<String, List<Email>> inputList) {
		emailList = inputList;
	}
	
	public boolean newEmail(String receiver, String subject, String content) {
		if (EmailValidityChecker.checkEmailValidity(receiver)) {
			Email email = new Email(receiver, subject, content);
			String date = DateInputProvider.getDateString();
			
			if (emailList.containsKey(date)) {
	        	emailList.get(date).add(email);
			}
			else {
				List<Email> temp = new ArrayList<Email>();
				temp.add(email);
				emailList.put(date, temp);
			}
	  	  	mailSender.sendMail(email);	
			return true;
		}
		return false;
	}	
	
	public boolean printEmailsOnDate(String date) {
		if (DateValidityChecker.checkDateValidity(date)) {
			
			if (emailList.containsKey(date)){
				System.out.println("\nEmails sent on " + date + ":\n");
				List<Email> sentToday = emailList.get(date);
				
				for (Email email: sentToday) {
					email.printDetails();
				}
			}
			else {
				System.out.println("\nNo emails sent on " + date + ".");
			}
			return true;
		}
		return false;
	}
}
