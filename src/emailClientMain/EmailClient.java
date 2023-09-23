//200543U
package emailClientMain;

import java.util.Scanner;
import appDataHandle.*;
import objectManage.*;
import birthdayWishTool.*;
import dateInput.DateInputProvider;
import inputValidityCheck.OptionMenuInputChecker;

public class EmailClient {

	public static void main(String[] args) {
		System.out.println("WELCOME TO THE EMAIL CLIENT\n");
		
		//Instantiation of necessary objects.
		Scanner scanner = new Scanner(System.in);
		RecipientManager recipientManager = RecipientManager.getInstance();
		EmailManager emailManager = EmailManager.getInstance();
		BirthdayList birthdayList = BirthdayList.getInstance();
		BirthdayWishSender birthdayWishSender = BirthdayWishSender.getInstance();
		
		//Loading app data.
		DataSerializer.loadAppData();
		RecipientDataSaver.loadRecipientDetails();
		
		//Wishing for birthdays if it is the first time logged for the day.
		birthdayWishSender.wishForBirthdays(DateInputProvider.getMonthAndDate());
		
        while(true) {
        	System.out.println("\n\nEnter option type: \n"
	              + "1 - Adding a new recipient\n"
	              + "2 - Sending an email\n"
	              + "3 - Printing out all the recipients who have birthdays\n"
	              + "4 - Printing out details of all the emails sent\n"
	              + "5 - Printing out the number of recipient objects in the appliction\n"
	              + "-1 - End");
        	
	        String optionString = scanner.nextLine();
	        
	        //Checking whether the input is a integer in the valid range.
	        if (!OptionMenuInputChecker.checkOptionMenuInput(optionString)) {
	        	continue;
	        }
	        int option = Integer.parseInt(optionString);
	        
	        switch(option){
	              case 1:
	            	  System.out.println("\nADDING A NEW RECIPIENT");
	            	  String entry1;
	            	  
	            	  //Looping till a valid input is given.
	            	  while(true) {
		            	  System.out.println("\nEnter Recipient details:\n"
		            	  		+ "(Types:- Official, Office_friend, Personal)\n"
		            	  		+ "(Format:- Type: Details separated by ',')");
		            	  entry1 = scanner.nextLine();
		            	  
		            	  if (recipientManager.addRecipient(entry1)) {
		            		  break;
		            	  }
	            	  }
	            	  RecipientDataSaver.saveRecipient(entry1);
	            	  System.out.println("\nRecipient successfully added to the list."); 
	            	  break;
	            	  
	              case 2:
	            	  System.out.println("\nSENDING AN EMAIL");
	            	  
	            	  //Looping till a valid input is given.
	            	  while(true) { 
	            		  System.out.println("\nEnter details:\n(Format:- email, subject, content)");
		            	  String[] emailDetails = scanner.nextLine().split(",");
		            	  
		            	  for (int i = 0; i < emailDetails.length; i++) {
		            		  emailDetails[i] = emailDetails[i].strip();
		            	  }
		                  if (emailManager.newEmail(emailDetails[0],emailDetails[1],emailDetails[2])) {
		            		  break;
		            	  }
	            	  }
	            	  System.out.println("\nEmail sent successfully.");
	                  break;
	                  
	              case 3:
	            	  System.out.println("\nPRINTING RECIPIENTS WITH BIRTHDAYS ON A GIVEN DATE");
	            	  
	            	  //Looping till a valid input is given.
	            	  while(true) {
	            		  System.out.println("\nEnter date:\n(Format:- yyyy/mm/dd)");
		            	  String date1 = scanner.nextLine();
		                  
		            	  if (birthdayList.printBornOnDate(date1)) {
		            		  break;
		            	  }
	            	  }
	                  break;
	             
	              case 4:
	                  System.out.println("\nPRINTING DETAILS OF EMAILS SENT ON A GIVEN DATE");
	                  
	                  //Looping till a valid input is given.
	            	  while(true) {
	            		  System.out.println("\nEnter date:\n(Format:- yyyy/mm/dd)");
	            		  String date2 = scanner.nextLine();
		                  
	            		  if (emailManager.printEmailsOnDate(date2)) {
		            		  break;
		            	  };
	            	  }
	                  break;
	              
	              case 5:
	                  System.out.println("\nPRINTING THE NO.OF RECIPIENT OBJECTS");
	            	  recipientManager.printRecipientCount();
	                  break;
	                  
	              case -1:
	            	  //Saving app data
	            	  DataSerializer.saveAppData();
	            	  scanner.close();
	            	  System.out.println("\nClosing the application.");
	            	  return;
	        }
        }
	}
}