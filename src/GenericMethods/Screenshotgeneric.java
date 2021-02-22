package GenericMethods;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Screenshotgeneric implements Auto_constant{
public static String Screenshot(WebDriver driver)
{
	
	Date date1= new Date();
	String date2 = date1.toString();
	String date = date2.replace(":", "-");
	//String path1=Photo_path+date+".png";
	String path = System.getProperty("user.dir")+"/Photos/"+date+".png";
TakesScreenshot ts=(TakesScreenshot)driver;	
File src=ts.getScreenshotAs(OutputType.FILE);
File dest = new File(path);
try {
	//FileUtils.copyFile(src, dest);
	FileHandler.copy(src, dest);
	} catch (IOException e) {
	// TODO Auto-generated catch block
	Reporter.log("failed to take screenshot");
}
return path;
	}
}

