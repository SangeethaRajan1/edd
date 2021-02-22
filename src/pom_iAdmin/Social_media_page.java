package pom_iAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Social_media_page extends Base_page {
	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab_data; // app config tab to mouse hover and
											// to
	@FindBy(xpath = "//a[.='Social Media']")
	private WebElement social_media_option;// click on social media option from
											// app config page

	@FindBy(xpath = "//input[@id='ch_fb']")
	private WebElement fb_option;// Enable the checkbox related to fb option

	@FindBy(xpath = "//input[@id='fb']")
	private WebElement input_fb_url;// pass the fb url
	
	@FindBy(xpath = "//input[@id='fb']")
	private WebElement save_social_media;// save the social media page

	public Social_media_page(WebDriver driver) {
		super(driver);
	}

	public void app_config_tab() throws InterruptedException {
		GMaction app_config = new GMaction();
		app_config.Movetoelement(driver, app_config_tab_data);
		Thread.sleep(3000);

	}

	public void social_media() throws InterruptedException {
		GMaction social_media1 = new GMaction();
		social_media1.Movetoelement(driver, social_media_option);
		elementtobeclickable(15, social_media_option);
		GMaction social_media2 = new GMaction();
		social_media2.Click(driver, social_media_option);
		Thread.sleep(3000);
	}

	public void social_media_fb_selection() throws InterruptedException
	{
		boolean fb_chkbox =fb_option.isSelected();
		if (fb_chkbox) 
		{
			Thread.sleep(3000);
			System.out.println("fb checkbox is selected already");
			elementtobeclickable(15,fb_option);
			fb_option.clear();
			Thread.sleep(3000);
			elementtobeclickable(15,save_social_media);
			save_social_media.click();
			Thread.sleep(3000);
			driver.navigate().refresh();

		} 
		else 
		{
			System.out.println("fb checkbox is not selected");
			System.out.println("else condition started");
			Thread.sleep(3000);
			elementtobeclickable(15, fb_option);
			fb_option.click();
			elementtobeclickable(15,input_fb_url);
			input_fb_url.sendKeys("https://www.fb.com");
			Thread.sleep(3000);
			elementtobeclickable(15,save_social_media);
			save_social_media.click();
			driver.navigate().refresh();
		}
	}
}
