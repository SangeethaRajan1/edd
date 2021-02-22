package pom_iAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Banner extends Base_page {
	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab; // app config tab to mouse hover and to
										// select the banner
	@FindBy(xpath = "//a[.='Banner Display']")
	private WebElement banner;// banner option from app config tab

	@FindBy(xpath = "//input[@id='btnShowAddBannerModal']")
	private WebElement add_banner; // Add banner button

	@FindBy(xpath = "//select[@id='ModalBannerType']")
	private WebElement select_bannertype;// select the banner type

	@FindBy(xpath = "//select[@id='ModalBannerDuration']")
	private WebElement select_bannerduration;// select the banner duration

	@FindBy(xpath = "//select[@id='Position']")
	private WebElement select_bannerposition;// select the banner position

	@FindBy(xpath = "//input[@id='SaveBannerBtn']")
	private WebElement save_data;// save the banner

	@FindBy(xpath = "//div[.='Entry already exist']")
	private WebElement record_exist_validation; // check whther the same record
												// exist

	@FindBy(xpath = "(//input[@value='Close'])[1]")
	private WebElement close_banner_popup;// close the banner pop up if record
											// already exist

	@FindBy(xpath = "(//input[@value='Close'])[3]")
	private WebElement close_banner_popup_aftrsaving;// close the banner pop up
														// if record

	// is saved
	public Banner(WebDriver driver) {
		super(driver);
	}

	public void Extend_app_config() throws InterruptedException {
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Thread.sleep(3000);
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

	public void banner_page() throws InterruptedException {
		
		GMaction movetobanner = new GMaction();
		movetobanner.Movetoelement(driver, banner);
		elementtobeclickable(15, banner);
		banner.click(); // navigate to banner page
		Thread.sleep(2000);
	}

	public void Add_banner() {
		elementtobeclickable(15, add_banner);
		add_banner.click(); // click on add banner button
		elementtobeclickable(15, select_bannertype);
		Select bannerdrp = new Select(select_bannertype);
		bannerdrp.selectByIndex(1); // select the banner type from drop down
		elementtobeclickable(15, select_bannerduration);
		Select bannerdrp1 = new Select(select_bannerduration);
		bannerdrp1.selectByIndex(1);// select the banner duration from drop down
		elementtobeclickable(15, select_bannerposition);
		Select bannerdrp2 = new Select(select_bannerposition);
		bannerdrp2.selectByIndex(1);// select the banner position from drop down
		elementtobeclickable(15, save_data);
		save_data.click(); // save the banner
		//boolean record_exist = record_exist_validation.isDisplayed();
		//System.out.println(record_exist);
		driver.navigate().refresh();
		/*if (record_exist) {
			elementtobeclickable(15, close_banner_popup);
			close_banner_popup.click();

		}
		else
		{
			elementtobeclickable(15,close_banner_popup_aftrsaving);
			close_banner_popup_aftrsaving.click();
		}*/

	}
}
