package utility;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Tests.Scenario2;
import model.ExcelSheet;

public class FunctionsLibrary {

	public static void wait(WebDriver driver, By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public static void wait(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		element = wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void gotToUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public static void readExcel(String filename) {
		ArrayList<Double> one = new ArrayList<Double>();
		InputStream ExcelFileToRead;
		try {
			ExcelFileToRead = new FileInputStream(System.getProperty("user.dir") + "//" + filename);

			HSSFWorkbook wb = new HSSFWorkbook(ExcelFileToRead);
			HSSFSheet sheet = wb.getSheetAt(0);
			HSSFRow row;
			HSSFCell cell;
			Iterator rows = sheet.rowIterator();
			int i = 0;

			while (rows.hasNext()) {
				row = (HSSFRow) rows.next();
				

				Scenario2.excel.put(i,
						new Rows(row.getCell(0, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue(),
								row.getCell(1, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue(),
								row.getCell(2, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue(),
								(row.getCell(3, MissingCellPolicy.CREATE_NULL_AS_BLANK).getStringCellValue())));
				// }

				i++;
			}
			// wb.close();
			ExcelFileToRead.close();
		}

		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void EnterText(WebDriver driver, String keyword, String locatortype, String locatorvalue, String parameter)
			throws Exception {
		WebElement element;
		element = decideTypeOfElement(driver, locatortype, locatorvalue);

		wait(driver, element);
		element.sendKeys(parameter);
	}

	public WebElement decideTypeOfElement(WebDriver driver, String locatortype, String locatorvalue) {
		WebElement element;
		if (locatortype.equals("xpath")) {
			element = driver.findElement(By.xpath(locatorvalue));
		} else if (locatortype.equals("cssselector")) {
			element = driver.findElement(By.cssSelector(locatorvalue));
		} else if (locatortype.equals("name")) {
			element = driver.findElement(By.name(locatorvalue));
		} else if (locatortype.equals("id")) {
			element = driver.findElement(By.id(locatorvalue));
		} else if (locatortype.equals("classname")) {
			element = driver.findElement(By.className(locatorvalue));
		} else if (locatortype.equals("LinkText")) {
			element = driver.findElement(By.linkText(locatorvalue));
		} else {
			throw new NotFoundException("invalid locatortype");
		}
		return element;
	}

	public void click(WebDriver driver, String keyword, String locatortype, String locatorvalue)
			 {
		WebElement element;
		element = decideTypeOfElement(driver, locatortype, locatorvalue);
		wait(driver, element);
		element.click();
	}

	public void checkkeyword( WebDriver driver,Rows row) throws Exception
	{
		
	
		if(row.getKeyword().equals("Open"))
		{
			gotToUrl(driver,row.getlocatorValue());
		}

		else if(row.getKeyword().equals("click"))
		{
			click(driver,row.getKeyword(),row.getLocatorType(),row.getlocatorValue());
		}
		else if(row.getKeyword().equals("Enter_text"))
		{
			EnterText(driver,row.getKeyword(),row.getLocatorType(),row.getlocatorValue(),row.getparameter());
		}
		else if(row.getKeyword().equals("wait"))
		{
			wait(driver,row.getKeyword(),row.getLocatorType(),row.getlocatorValue());
		}
		else
		{
			throw new NotFoundException("invalid element");
		}
		}
		
	
		public void  wait( WebDriver driver,String Keyword, String locatortype, String locatorvalue)
		{
			WebElement element;
			WebDriverWait wait = new WebDriverWait(driver, 60);
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
		}
		}
		
	

