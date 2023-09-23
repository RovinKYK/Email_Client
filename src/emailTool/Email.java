package emailTool;

import java.io.Serializable;

public class Email implements Serializable {
	private static final long serialVersionUID = 1L;
	private String receiver;
	private String subject;
	private String content;

	public Email(String receiver, String subject, String content) {
		this.receiver = receiver;
		this.subject = subject;
		this.content = content;
	}

	public String getReceiver() {
		return receiver;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void printDetails() {
		System.out.println(receiver + ", " + subject + ", " + content);
	}
}
