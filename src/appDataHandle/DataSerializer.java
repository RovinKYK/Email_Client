package appDataHandle;

import java.io.*;
import objectManage.EmailManager;
import emailTool.Email;
import birthdayWishTool.BirthdayWishSender;
import java.util.List;
import java.util.Map;

public abstract class DataSerializer {
	
	public static void saveAppData() {
		System.out.println("\nSaving app data.");
		try {
			FileOutputStream fileStream = new FileOutputStream("appData.ser");
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
			os.writeObject(EmailManager.getEmailList());
			os.writeObject(BirthdayWishSender.getLastWishedDate());
			os.close();
		} 
		catch (IOException e) {}
	}
	
	
	public static void loadAppData() {
		System.out.println("\nLoading app data.");
		try {
			FileInputStream fileStream = new FileInputStream("appData.ser");
			ObjectInputStream os = new ObjectInputStream(fileStream);
			EmailManager.setEmailList((Map<String, List<Email>>) os.readObject());
			BirthdayWishSender.setLastWishedDate((String) os.readObject());
			os.close();
		} 
		catch (IOException | ClassNotFoundException e) {}
	}

}
