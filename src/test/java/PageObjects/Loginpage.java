package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.FunctionsLibrary;

public class Loginpage {
	FunctionsLibrary fun = new FunctionsLibrary();
//adding comments	
String username= "//input[@id='identifierId']";
String password = "//input[@type='password']";
String next = "//span[text()=\"Next\"]";

public void LoginGmail(WebDriver driver) {
	driver.findElement(By.xpath(username)).sendKeys("c4aditi@gmail.com");;
	driver.findElement(By.xpath(next)).click();
	fun.wait(driver, By.xpath(password));
	//fun.wait(driver, By.xpath(password));//have ti delete
	driver.findElement(By.xpath(password)).sendKeys("aditi202016");;
	driver.findElement(By.xpath(next)).click();
	
	
}
}