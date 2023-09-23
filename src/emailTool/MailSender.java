package emailTool;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailSender{
	private static final MailSender instance = new MailSender(); 
	private Session session;
	
	private MailSender() {
		final String username = "emailclient200543U@gmail.com";
	    final String password = "baafqygjomxcsmzp";
	
	    Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.port", "587");
	    prop.put("mail.smtp.auth", "true");
	    prop.put("mail.smtp.starttls.enable", "true"); //TLS
	    
	    session = Session.getInstance(prop,
	            new javax.mail.Authenticator() {
	                protected PasswordAuthentication getPasswordAuthentication() {
	                    return new PasswordAuthentication(username, password);
	                }
	            });
		}

	public static MailSender getInstance( ) {
		return instance;
	}
	
	public void sendMail(Email email) {
		try {
			Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("emailclient200543U@gmail.com"));
	        message.setRecipients(
	                Message.RecipientType.TO,
	                InternetAddress.parse(email.getReceiver())
	        );
	        message.setSubject(email.getSubject());
	        message.setText(email.getContent());
	        Transport.send(message);
		} 
		catch (MessagingException e) {}
	}
}