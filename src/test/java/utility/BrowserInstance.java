package utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class BrowserInstance {
	
	public WebDriver Browser() {
		Properties prop = new Properties();
		InputStream stream = null;
		try {
			stream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\Initialisers\\config.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			prop.load(stream);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getDriver(prop.getProperty("browsername"));
	}
		
		
	 public WebDriver getDriver(String browsername) {
  	   
			WebDriver driver;
			if (browsername.equalsIgnoreCase("chrome")) {
				driver = initChromeDriver();
				// driver = initChromeDriverIncognito();
			} else if (browsername.equalsIgnoreCase("firefox")) {
				driver = initFirefoxDriver();
			} else if (browsername.equalsIgnoreCase("IE")) {
				driver = initIEDriver();
						}
			else {
				//invalid Browsername
				driver = new ChromeDriver();
			}
			return driver;

			
		}
		public WebDriver initIEDriver() {
			return  new InternetExplorerDriver();
			
			
		}

		public WebDriver initFirefoxDriver() {
			
			return new FirefoxDriver();
		}
	private WebDriver initChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-extensions");
		options.addArguments("--start-maximized");
		return new ChromeDriver(options);
	}
}
