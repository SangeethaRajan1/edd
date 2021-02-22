package GenericMethods;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class Generictest implements Auto_constant {
	protected WebDriver driver;
	public static ExtentHtmlReporter htmlReporter ; 
	public static ExtentReports reports;
	public static ExtentTest test;
	@BeforeSuite
	public void setUP()
	{
	 htmlReporter = new ExtentHtmlReporter(new File("./Reports/"+System.currentTimeMillis()+".html"));
	    reports = new ExtentReports();
	   reports.attachReporter(htmlReporter);
	  
	} 
	@Parameters("browsername")
	@BeforeMethod
		public void openapp(String Browsername)
	{
		System.out.println("Browsername is : " +Browsername);
		if(Browsername.equalsIgnoreCase("firefox"))
		{
		String key=Filemanager.getgeckodriverkey();
		String value=Filemanager.getgeckodrivervalue();
		System.setProperty(key,value);
		 driver=new FirefoxDriver();
		 /*String url=Filemanager.getapplnurl();
		 driver.get(url);*/  // for parallel execution I hv moved this under @test
		}
		else if(Browsername.equalsIgnoreCase("chrome"))
		{
			String key=Filemanager.getchromedriverkey();
			String value=Filemanager.getchromedrivervalue();
			System.setProperty(key, value);
			driver= new ChromeDriver();
		}
		else if(Browsername.equalsIgnoreCase("ie"))
		{
			String key=Filemanager.getiedriverkey();
			String value = Filemanager.getiedrivervalue();
			System.setProperty(key, value);
			driver= new EdgeDriver();
		}
	}
	
	@AfterMethod
	public void closeapp(ITestResult res) throws IOException
	{
		if(ITestResult.FAILURE==res.getStatus())
		{
			System.out.println("failedtestcase:"+" "+res.getName());//to get the name of the failed test case
			Screenshotgeneric.Screenshot(driver);
			try {
				ExcelGeneric.Excelwritegm("ValidLogin", 1, 2,"failed");
				MediaEntityBuilder media = MediaEntityBuilder.createScreenCaptureFromPath(Screenshotgeneric.Screenshot(driver));
				test.fail(" Failed testcase screenshot , generic test",media.build() );
			} catch (Exception e) {
				System.out.println("failed to write generic test case status to the excel");
			}
			
		}
		else if(ITestResult.SUCCESS==res.getStatus())
		{
			Screenshotgeneric.Screenshot(driver);
			
			try {
				ExcelGeneric.Excelwritegm("ValidLogin", 1, 2,"passed");
				MediaEntityBuilder mediaModel = 
						MediaEntityBuilder.createScreenCaptureFromPath
						(Screenshotgeneric.Screenshot(driver));  //(commented by sangeetha as it was throwing error)
				test.pass("Screenshot of passed TC from generic test", mediaModel.build()); //(commented by sangeetha as it was throwing error)
				//if we give fail instead of pass then in reports it will show failed status in log
			
			} catch ( Exception e) {
				System.out.println("failed to write generic testcase status to the excel");
			}
		}
		//driver.quit();	
	}
	@AfterSuite
	public void Teardown()
	{
		reports.flush();
	} 

}
