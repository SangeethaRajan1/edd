package pom_iAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Offlinedata extends Base_page {
	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab; // app config tab to mouse hover and to
										// select the app theme
	@FindBy(xpath = "//a[.='Offline Data']")
	// App theme option from app config tab
	private WebElement Offline_Data;

	@FindBy(xpath = "//button[.='Add New']")
	private WebElement add_offlinedata_button;

	@FindBy(xpath = "//h4[.='Max reached']")
	private WebElement maxreached_popup;// max reached pop up

	@FindBy(xpath = "//input[@class='btn btn-success preventTagClose']")
	private WebElement dismiss_popup; // close button of maximum reached pop up

	@FindBy(xpath = "//input[@id='Subject']")
	private WebElement offline_subject; // subject field of offline data

	@FindBy(xpath = "//select[@id='ddlDescType']")
	private WebElement offline_data_type;// select the drop down of offline type

	@FindBy(xpath = "//div[@class='col-sm-12 DescriptionDiv']")
	private WebElement CK_editor_decr;// Pass the value to description iFrame

	@FindBy(xpath = "//input[@id='saveOfflineDataBtn']")
	private WebElement save_btton; // save the offline details

	public Offlinedata(WebDriver driver) {
		super(driver);
	}

	public void Extend_app_config() throws InterruptedException {
		Visiblityof(15, app_config_tab);
		Thread.sleep(3000);
		GMaction media_library = new GMaction(); // action class to do mouse
													// hover action
		media_library.Movetoelement(driver, app_config_tab); // mouse hover
																// to
																// app_config
																// text
		Thread.sleep(3000);
	}

	public void offline_page() throws InterruptedException {
		GMaction movetomedialib = new GMaction();
		movetomedialib.Movetoelement(driver, Offline_Data);
		elementtobeclickable(15, Offline_Data);
		Offline_Data.click(); // navigate to offline data page
		Thread.sleep(2000);
	}

	public void Add_New_button_click() throws InterruptedException {
		//boolean offline_details_size =driver.findElement(By.xpath("(//tr)[5]")).isDisplayed();
		GMaction movetomedialib = new GMaction();
		movetomedialib.Movetoelement(driver, add_offlinedata_button);
		elementtobeclickable(15, add_offlinedata_button);
		add_offlinedata_button.click(); // click on add new button to add
										// offline data
		
	String	offlinepopup=driver.getWindowHandle();
		driver.switchTo().window(offlinepopup); // switch to the child
		
		boolean offlinesubject=offline_subject.isDisplayed(); // if subject field is present
		if(offlinesubject)
		{
	
			elementtobeclickable(15, offline_subject);
			offline_subject.sendKeys("Internet is slow"); 
			
			elementtobeclickable(15, offline_data_type);
			Select offline_datatype = new Select(offline_data_type);
			 offline_datatype.selectByIndex(0);// select type of descr
				driver.switchTo()
						.frame(driver.findElement(By
								.cssSelector("iframe[title='Rich Text Editor, Description']")));
				System.out.println("switched to iFrame");

				WebElement CK_editor_decr1 = driver.findElement(By.tagName("body"));
				CK_editor_decr1.click();
				CK_editor_decr1.sendKeys("offline details needs to be displayed"); // enter
																					// the
																					// description
				driver.switchTo().defaultContent(); 

				elementtobeclickable(15, save_btton);
				save_btton.click();
				System.out.println("offline data save successfully");
				driver.navigate().refresh();
				Thread.sleep(3000);
		}
		else
		{
				dismiss_popup.click(); // dismiss the pop up if it is reached the maximum
				System.out.println("Offline data : Max limit reached ");
			
		}
	
	}}

