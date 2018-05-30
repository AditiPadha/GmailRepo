package PageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utility.FunctionsLibrary;

public class InboxPage {
	String email100 = "//*[contains(@class, 'UI')]//table/tbody//tr";
	String selectall = "(//div[@class=\"J-J5-Ji J-JN-M-I-Jm\"])[1]/span";
	String DeleteALL = "//div[@class=\"ar9 T-I-J3 J-J5-Ji\"]";
	String Compose = "//div[text()='COMPOSE']";
	String name = "//textarea[@name='to']";
	String subject = "//input[@name='subjectbox']";
	String message = "//div[@aria-label='Message Body']";
	String send = "//div[text()='Send']";
	
	
	
	
	public void sortandprint(WebDriver driver)
	{
		FunctionsLibrary objFunction = new FunctionsLibrary();
		objFunction.wait(driver, By.xpath(email100));
		List<WebElement> inbox = driver.findElements(By.xpath(email100));
		int size = inbox.size();
		System.out.println("Size: " + inbox.size());
		ArrayList text_of_webElements = new ArrayList();

		// Thread.sleep(5000);
		// public static <T extends Comparable<? super T>> void sort(List<T> list);
		for (WebElement inbox_new : inbox) 
		{
			String text = inbox_new.getText();

			text_of_webElements.add(text);
		}// end of for loop
		Collections.sort(text_of_webElements);
		System.out.println(Arrays.toString(text_of_webElements.toArray()));
	}
	
	public void deleteall(WebDriver driver)
	{
		FunctionsLibrary objFunction = new FunctionsLibrary();
		objFunction.wait(driver, By.xpath(email100));
		driver.findElement(By.xpath(selectall)).click();
		driver.findElement(By.xpath(DeleteALL)).click();
		System.out.println("all deleted");
			}
	public void Compose(WebDriver driver)
	{
		driver.findElement(By.xpath(Compose)).click();
		driver.findElement(By.xpath(name)).sendKeys("c4aditi@gmail.com");
		driver.findElement(By.xpath(subject)).sendKeys("Testing mail");
		driver.findElement(By.xpath(message)).sendKeys("Testing1234567890");
		driver.findElement(By.xpath(send)).click();
		
		
		
	}
	
	}


