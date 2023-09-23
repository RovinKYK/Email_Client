package recipientSet;
import java.io.Serializable;

public abstract class Recipient implements Serializable{
	private static final long serialVersionUID = 1L;
	private String name;
	private String email;
	
	public Recipient(String name, String email) {
		this.name = name;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
}