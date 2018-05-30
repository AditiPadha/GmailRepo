package utility;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class Rows {
	
String keyword;
String locatortype;
String locatorvalue;
String parameter;

public String getKeyword()
{
	return this.keyword;
}
public String getLocatorType()
{
	return this.locatortype;
}
public String getlocatorValue()
{
	return this.locatorvalue;
}
public String getparameter()
{
	return this.parameter;
}
 public Rows( String keyword, String locatortype, String locatorvalue, String parameter)
 {
	 try
	 {
	 this.keyword= keyword;
	 this.locatortype= locatortype;
	 this.locatorvalue= locatorvalue;
	 this.parameter= parameter;
	 }
	 catch(Exception ex)
	 {
		 System.out.println("================"+ex.toString());
	 }
	 
 }
}
