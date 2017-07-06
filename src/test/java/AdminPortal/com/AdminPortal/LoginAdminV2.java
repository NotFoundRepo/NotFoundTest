package AdminPortal.com.AdminPortal;

import org.testng.annotations.Test;

public class LoginAdminV2 {
	@Test
	public static void TestLogin()
	{		
		Utility.InvokeBrowser("chrome", "https://my.qa5.vocal-qa.com/adminv2/");
		Utility.APLogin("_rlayman1", "vocal123");	
		Utility.APLogout();
		Utility.CloseBrowser();
	}
}
