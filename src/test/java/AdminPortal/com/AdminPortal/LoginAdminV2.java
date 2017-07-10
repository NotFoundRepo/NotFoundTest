package AdminPortal.com.AdminPortal;

import org.testng.annotations.Test;

public class LoginAdminV2 {
	@Test
	public static void TestLogin()
	{			
		
		Utility.Init_Env();
		Utility.InvokeBrowser(Utility.read_data("Browser"), Utility.read_data("URL"));
		BusinessComponent.APLogin(Utility.read_data("VSU_Username"), Utility.read_data("VSU_Password"));	
		BusinessComponent.APLogout();
		Utility.CloseBrowser();
	}
}
