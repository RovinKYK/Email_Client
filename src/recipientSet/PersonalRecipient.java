package recipientSet;
import java.io.Serializable;

public class PersonalRecipient extends Recipient implements Friend, Serializable{
	private static final long serialVersionUID = 1L;
	private String nickname;
	private String birthday;
	
	public PersonalRecipient(String name, String nickname, String email, String birthday) {
		super(name, email);
		this.nickname = nickname;
		this.birthday = birthday;
	}
	
	public String birthdayWish() {
		return "Hugs and love on your birthday " + getName() + "!";
	}
	
	public void printDetails() {
		System.out.println("Personal: " + getName() + ", " + nickname + ", " + getEmail() + ", " + birthday);
	}

}
