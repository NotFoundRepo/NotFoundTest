package AdminPortal.com.AdminPortal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility 
{
	
	static WebDriver wd;
	static WebDriverWait wdwait;
		
	public static void InvokeBrowser(String BType, String appurl)
	{
		if(BType.equalsIgnoreCase("firefox"))
		{	
			wd = new FirefoxDriver();
			wdwait= new WebDriverWait(wd,10);
			wd.navigate().to(appurl);
		}
		else if(BType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Browser\\chromedriver.exe");
			wd = new ChromeDriver();
			wdwait= new WebDriverWait(wd,10);
			wd.navigate().to(appurl);
		}
		else if(BType.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver", "C:\\Browser\\IEDriverServer.exe");
			wd = new InternetExplorerDriver();
			wdwait= new WebDriverWait(wd,10);
			wd.navigate().to(appurl);
		}		 
	}
	
	
	
	public static void CloseBrowser()
	{
		wd.close();
	}
	public static void APLogin(String usrnm, String passwd)
	{
		wd.findElement(By.id("j_username")).sendKeys(usrnm);
	    
	    wd.findElement(By.id("j_password")).sendKeys(passwd);
	    
	    wd.findElement(By.id("button1")).click();
	   
	}
	
	public static void APLogout()
	{
		wd.findElement(By.id("profilebox")).click();
		wdwait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Logout")));
		wd.findElement(By.partialLinkText("Logout")).click();	   
	}
	
	
}
