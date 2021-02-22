package pom_iAdmin;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Adhoc_hyperlink extends Base_page {
	@FindBy(xpath = "(//a[@href='/AdhocForm/AdhocFormManagement?formID=OTU%3D'])[1]")
	private WebElement adhoc_hyperlink; // hyper link of the adhoc record

	@FindBy(xpath = "(//a[@class='btn btn-success'])[1]")
	private WebElement click_addnew; // click on add new button to add user
										// record from admin side

	@FindBy(xpath = "//h2[@id='response']")
	private WebElement add_user_record_response; // text displayed in the add
													// user record page

	@FindBy(xpath = "(//a[@class='btn btn-success'])[1]")
	private WebElement back_2_adhoc_list; // click on adhoc button to go back to the record list

	@FindBy(xpath = "//input[@id='availableUserID']")
	private WebElement searchbyusername_id; // search bar
	
	@FindBy(xpath = "//input[@id='userSearch']")
	private WebElement search_button ; // search for the user
	
	@FindBy(xpath = "//span[@class='redSpan']")
	private WebElement mandatory_staricon; // mandatory icon
	
	public Adhoc_hyperlink(WebDriver driver) {
		super(driver);
	}

	public void Hyperlink_adhoc() { // click on the hyper link of the adhoc form
		elementtobeclickable(15, adhoc_hyperlink);
		adhoc_hyperlink.click();
	}

	public void Add_user_record() // add new user record from admin side
	{
		elementtobeclickable(15, click_addnew);
		click_addnew.click();
	}

	public void Response_add_userrecord() {
		try
		{
			AdhocForm adhoc = new AdhocForm(driver);
			
		if(adhoc.isElementDisplayed(add_user_record_response))
		{
		//elementtobeclickable(15, add_user_record_response);
		String pageResponse = add_user_record_response.getText();
		System.out.println(pageResponse);
		
		if (pageResponse.equalsIgnoreCase("Fields are not configured"))// text
																		// displayed
																		// in
																		// the
																		// add
																		// user
																		// record
																		// page
																		// when
																		// no
																		// fields
																		// are
																		// available
		{
elementtobeclickable(15,back_2_adhoc_list);
back_2_adhoc_list.click();
		} }
		else
		{
			elementtobeclickable(15,searchbyusername_id);
			searchbyusername_id.sendKeys("same@neel.co");
			Robot rb = new Robot();
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			rb.keyPress(KeyEvent.VK_DOWN);
			rb.keyRelease(KeyEvent.VK_DOWN);
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
			
			/*
			elementtobeclickable(15,search_button);
			search_button.click();
			GMaction act= new GMaction();
		WebElement	options=driver.findElement(By.xpath("(//li[@class='ui-menu-item'])[1]"));
		System.out.println();
		act.Click(driver,options );
		
			
			
	List	<WebElement> matcheditems=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
	int count=matcheditems.size();
	for(int i=0;i<=count-1;i++)
	{
	String	user =matcheditems.get(i).getText();
	System.out.println("user name"+ user);
		if(user.contains("same@neel.co"))
		{
			driver.findElement(By.xpath("//a[@id='ui-id-2']")).click();
			matcheditems.get(i).click();
		}
	}
		
		*/
			}
		
		}
		catch(Exception e)
		{
			System.out.println(e);
			}
	}

}
