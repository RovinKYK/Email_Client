package appDataHandle;

import java.io.*;
import objectManage.RecipientManager;

public abstract class RecipientDataSaver {

	public static void saveRecipient (String entry) {
		try {
  		  FileWriter writer = new FileWriter("clientList.txt",true);
  		  BufferedWriter bufWriter = new BufferedWriter(writer);	
  		  bufWriter.append(entry + "\n");
  		  bufWriter.close();
  	  	} 
		catch(IOException e) {}
	}

	public static void loadRecipientDetails() {
		RecipientManager recipientManager = RecipientManager.getInstance();
		try {
			FileReader reader = new FileReader("clientList.txt");
			BufferedReader bufReader = new BufferedReader(reader);
			String entry = null;
			
			while ((entry = bufReader.readLine()) != null) {
				recipientManager.addRecipient(entry);
			}
			bufReader.close();
		} 
		catch (IOException e) {}
	}
}
