
public class NewTextEvent {
	
	private String newText;
	static final private String secretMessage = "Haro was here";
	public NewTextEvent(String nt)
	{
		newText = nt;
		
		
	}
	
	
	public String getNewText()
	{
		return newText;
				
	}

	public String getSecretMessage()
	{
		
		return secretMessage;
		
	}
	
	
}
