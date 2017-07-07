package AdminPortal.com.AdminPortal;

public class BusinessComponent 
{
	
	public static void APLogin(String usrnm, String passwd)
	{
		Utility.input_value("id","j_username",usrnm);
		
		Utility.input_value("id","j_password",passwd);
	    	    
		Utility.click_object("id","button1");	   
	}
	
	public static void APLogout()
	{
		Utility.click_object("id","profilebox");		
		Utility.custom_wait("elementToBeClickable","partialLinkText","Logout");
		Utility.click_object("partialLinkText","Logout");			   
	}
		
}
