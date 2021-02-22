package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public abstract class Base_page {
	public WebDriver driver;
	public Base_page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		public void Visiblityof(int time, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try
			{
			wait.until(ExpectedConditions.visibilityOf(element));
			element.toString();
			Reporter.log( element +" found",true);
			}
			catch(Exception e)
			{
			element.toString();
				Reporter.log(element+" not found",true);
			}
		}
		public void elementtobeclickable(int time, WebElement element)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try
			{
				element.toString();
			wait.until(ExpectedConditions.elementToBeClickable(element));
			Reporter.log(element +" is clickable",true);
			}
			catch(Exception e)
			{
				Reporter.log(element +" is not clickable",true);
			}
		}
		public void Titlecontains(int time,String title)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try
			{
			wait.until(ExpectedConditions.titleContains(title));
			Reporter.log("Title is matching",true);
			}
			catch(Exception e)
			{
				Reporter.log("Title is mismatching",true);
			}
		}
		public void alertispresent(int time)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try
			{
			wait.until(ExpectedConditions.alertIsPresent());
			Reporter.log("Alert is present",true);

			}
			catch(Exception e)
			{
				Reporter.log("Alert is not present",true);
			}
		}
		public void visibilityofelementlocated(int time,String Xpath)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try
			{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Xpath)));
			Reporter.log("Elemntlocated",true);
			}
			catch(Exception e)
			{
				Reporter.log("Elemnt not located",true);
			}}
		public void urlcontains(int time,String url)
		{
			WebDriverWait wait=new WebDriverWait(driver,time);
			try{
			wait.until(ExpectedConditions.urlContains(url));
			Reporter.log("url matching",true);
			}
			catch(Exception e)
			{
				Reporter.log("url mismatching",true);
			}
		}
		}



