package pom_iAdmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Media_Library extends Base_page {

	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab; // app config tab to mouse hover and to
										// select the media library
	@FindBy(xpath = "//a[.='Media Library']")
	// click on media library option from app config tab
	private WebElement Medialibraray;

	@FindBy(xpath = "//input[@value ='Logo']")
	private WebElement select_logo_radio; // select the radio option as logo

	@FindBy(xpath = "//input[@id='btnLogoUpload']")
	private WebElement upload_logo;// upload the logo from media library

	@FindBy(xpath = "//input[@id='MediaLibraryUploadingButton']")
	private WebElement upload_button;// upload the file from media library

	@FindBy(xpath = "//div[@id='LogoFileName']")
	private WebElement upload_filename;// image name of the uploaded file

	public Media_Library(WebDriver driver) {
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

	public void medialibrary_page() throws InterruptedException {
		GMaction movetomedialib = new GMaction();
		movetomedialib.Movetoelement(driver, Medialibraray);
		elementtobeclickable(15, Medialibraray);
		Thread.sleep(2000);
		Medialibraray.click();
		Thread.sleep(2000);
	}

	public void upload_logo() throws InterruptedException {
		elementtobeclickable(15, select_logo_radio);
		select_logo_radio.click();
		Thread.sleep(3000);
		elementtobeclickable(15, upload_logo);
		//upload_logo.click();
		 // creating object of Robot class
	    //Robot rb = new Robot();
		Thread.sleep(3000);
		driver.navigate().refresh();
		//upload_logo.sendKeys("C:\\Users\\Neel-Tech_012018_One\\Desktop\\fileupload\\Bug.jpg");
		/*StringSelection str = new StringSelection("C:\\Users\\Neel-Tech_012018_One\\Desktop\\fileupload\\Bug.jpg");
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
		 
	     // press Contol+V for pasting
	     rb.keyPress(KeyEvent.VK_CONTROL);
	     rb.keyPress(KeyEvent.VK_V);
	 
	    // release Contol+V for pasting
	   rb.keyRelease(KeyEvent.VK_CONTROL);
	    rb.keyRelease(KeyEvent.VK_V);
	 
	    // for pressing and releasing Enter
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);
	    
	    rb.keyPress(KeyEvent.VK_ENTER);
	    rb.keyRelease(KeyEvent.VK_ENTER);*/
	    
		//Thread.sleep(3000);
		/*String filename=upload_filename.getText();
		if(filename.equalsIgnoreCase(" No file chosen "))
		{
			System.out.println("no file choosen");
		
		}
		else
		{
			elementtobeclickable(15,upload_button);
			Thread.sleep(3000);
			upload_button.click();
			
		}
*/
	}
}
