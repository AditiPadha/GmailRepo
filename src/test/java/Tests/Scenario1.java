package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import PageObjects.Loginpage;
import PageObjects.InboxPage;

import utility.BrowserInstance;
import utility.FunctionsLibrary;

public class Scenario1 {
	String url = "http://www.gmail.com";
@Test

	public void test() {
	BrowserInstance browser = new BrowserInstance();
	FunctionsLibrary objFunctions = new FunctionsLibrary();
	
	WebDriver driver = browser.Browser();
	
	objFunctions.gotToUrl(driver, url);
	
	 
	Loginpage login = new Loginpage();
	login.LoginGmail(driver);
	
	InboxPage email = new InboxPage();
	email.sortandprint(driver);
	
	email.deleteall(driver);
	 email.Compose(driver);
			
	
	
	
		
	}
		
	}


