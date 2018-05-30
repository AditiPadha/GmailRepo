package model;

public class ExcelSheet {
String keyword;
String LocatorType;
String LocatorValue;

public ExcelSheet(String keyword, String LocatorType, String LocatorValue)
{
this.keyword = keyword;
this.LocatorType = LocatorType;
this.LocatorValue = LocatorValue;

}
 public String getKeyword()
{
	return this.keyword;
}
 public String getLocatorValue()
 {
	 return this.LocatorValue;
 }
 public String getLocatorType()
 {
	 return this.LocatorType;
}

}