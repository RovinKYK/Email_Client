package recipientSet;
import java.io.Serializable;

public class OfficialRecipient extends Recipient implements Serializable {
	private static final long serialVersionUID = 1L;
	private String designation;
	
	public OfficialRecipient(String name, String email, String designation) {
		super(name, email);
		this.designation = designation;
	}
	
	public String getDesignation() {
		return designation;
	}
}
