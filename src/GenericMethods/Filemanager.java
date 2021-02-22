package GenericMethods;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Reporter;

public class Filemanager {
	
	public static String getapplnurl() {
		String url="";
		
		try{
Properties pr = new Properties();
FileInputStream fis= new FileInputStream("./config.properties");
pr.load(fis);
url = pr.getProperty("url");
}
		catch(Exception e)
		{
			Reporter.log("Failed to read url",true);
		}
		return url;
		}
	public static String  getgeckodriverkey(){
		String gecko_key="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		gecko_key=pr.getProperty("gecko_key_firefox");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read gecko_key",true);
		}
		
		return gecko_key;
	}
	public static String  getgeckodrivervalue(){
		String gecko_value ="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		gecko_value =pr.getProperty("gecko_value_firefox");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read gecko_value ",true);
		}
		
		return gecko_value ;
	} // firefoc driver values
	
	public static String  getchromedriverkey(){
		String chrome_key="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		chrome_key=pr.getProperty("key_chrome");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read key_chrome",true);
		}
		
		return chrome_key;
	}
	public static String  getchromedrivervalue(){
		String chrome_value ="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		chrome_value =pr.getProperty("value_chrome");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read value_chrome ",true);
		}
		
		return chrome_value ;
	} // chrome driver values

	
	public static String  getiedriverkey(){
		String ie_key="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		ie_key=pr.getProperty("key_ie");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read key_ie",true);
		}
		
		return ie_key;
	}
	public static String  getiedrivervalue(){
		String ie_value ="";
		try{
		Properties pr = new Properties();
		FileInputStream fis= new FileInputStream("./config.properties");
		pr.load(fis);
		ie_value =pr.getProperty("value_ie");
		}
		catch(Exception e)
		{
			Reporter.log("Failed to read value_ie ",true);
		}
		
		return ie_value ;
	} // Ie brower values

}


