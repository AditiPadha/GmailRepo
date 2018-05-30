package Keywords;

import org.openqa.selenium.By;



public class DataEngine {
	
	private  int Keywordcol;
	private  int LocatorTypecol;
	private  int LocatorValuecol;
	private  int parameter;
	
	
	public DataEngine(int Keywordcol, int LocatorTypecol, int LocatorValuecol, int parameter )
	{
	this.Keywordcol= Keywordcol;
	this.LocatorTypecol= LocatorTypecol;
	this.LocatorValuecol=LocatorValuecol;
	this.parameter= parameter;
	}
	
	private  By GetElementLocator(String LocatorType, String LocatorValue)
	{
		By by = null;
		if (LocatorType.equalsIgnoreCase("classname")) {
			by = By.className(LocatorValue);
			}
		else if(LocatorType.equalsIgnoreCase("CssSelector")) {
			by= By.cssSelector(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("id")) {
			by = By.id(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("Linktext")) {
			by = By.linkText(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("Xpath")) {
			by =  By.xpath(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("tagname")) {
			by = By.tagName(LocatorValue);
		}
		else if(LocatorType.equalsIgnoreCase("name")) {
			by = By.name(LocatorValue);
		}
		else
		{
			System.out.println("NoSuchLocator");
		
		}
	return by;
	
}
	
	
	
}
	