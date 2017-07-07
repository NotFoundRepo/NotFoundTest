package AdminPortal.com.AdminPortal;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

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
	static File file;
	static FileInputStream fileInput;
	static Properties prop;
	public static String fpath="C:\\AutoData\\ENV_Details.properties";
	
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
	
	public static void input_value(String oType, String oProp, String oVal)
	{
		if(oType.equalsIgnoreCase("id"))
		{
			wd.findElement(By.id(oProp)).sendKeys(oVal);
		}
		else if(oType.equalsIgnoreCase("xpath"))
		{
			wd.findElement(By.xpath(oProp)).sendKeys(oVal);
		}		
	}
	
	public static void click_object(String oType, String oProp)
	{
		if(oType.equalsIgnoreCase("id"))
		{
			wd.findElement(By.id(oProp)).click();
		}
		else if(oType.equalsIgnoreCase("xpath"))
		{
			wd.findElement(By.xpath(oProp)).click();
		}
		else if(oType.equalsIgnoreCase("partialLinkText"))
		{
			wd.findElement(By.partialLinkText(oProp)).click();
		}
	}
	
	public static void custom_wait(String oExpect, String oType, String oProp)
	{
		if(oExpect.equalsIgnoreCase("elementToBeClickable"))
		{				
			if(oType.equalsIgnoreCase("id"))
			{
				wdwait.until(ExpectedConditions.elementToBeClickable(By.id(oProp)));
			}
			else if(oType.equalsIgnoreCase("xpath"))
			{
				wdwait.until(ExpectedConditions.elementToBeClickable(By.xpath(oProp)));
			}
			else if(oType.equalsIgnoreCase("partialLinkText"))
			{
				wdwait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText(oProp)));
			}
		}
	}
	
	public static String read_data(String vkey)
	{
		file = new File(fpath);
		fileInput = null;
		
		try
		{
			fileInput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInput);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
			
		return prop.getProperty(vkey);		
	}
	
}
