package recipientSet;
import java.io.Serializable;

public class OfficialCloseFriend extends OfficialRecipient implements Friend, Serializable{
	private static final long serialVersionUID = 1L;
	private String birthday;
	
	public OfficialCloseFriend(String name, String email, String designation, String birthday) {
		super(name, email, designation);
		this.birthday = birthday;
	}

	public String birthdayWish() {
		return "Wish you a Happy Birthday " + getName() + "!";
	}
	
	public void printDetails() {
		System.out.println("Office_friend:" + getName() + ", " + getEmail() + ", " + getDesignation() + ", " + birthday);
	}
}
