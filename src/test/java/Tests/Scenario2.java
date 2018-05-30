package Tests;

import java.util.HashMap;
import java.util.function.Function;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import utility.BrowserInstance;
import utility.FunctionsLibrary;
import utility.Rows;

public class Scenario2 {
	public static HashMap<Integer, Rows> excel = new HashMap<Integer, Rows>();

	public static void main(String args[]) throws Exception {
		// String url = "http://www.gmail.com";
		BrowserInstance browser = new BrowserInstance();
		FunctionsLibrary objFunctions = new FunctionsLibrary();
		WebDriver driver = browser.Browser();
		boolean isHeader = true;
        FunctionsLibrary.readExcel("keywords.xls");
		// HashMap<Integer, rows> map = new HashMap<Integer, rows>();

		for (Rows key : excel.values()) {
			if (isHeader == true) {
				isHeader = false;

			} else {
				objFunctions.checkkeyword(driver, key);
				}

		}

		
	}
}
		// System.out.println(excel.get(1).getKeyword());
		// System.out.println(excel.get(1).getLocatorType());
		// System.out.println(excel.get(1).getlocatorValue());
		// System.out.println(excel.get(1).getparameter());
		// String expected =excel.get(1).getlocatorValue();
		// String actual = "String url";
		//

