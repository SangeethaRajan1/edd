package pom_iAdmin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class App_theme extends Base_page {

	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab; // app config tab to mouse hover and to
										// select the app theme
	@FindBy(xpath = "//a[.='App Theme']")
	// App theme option from app config tab
	private WebElement apptheme;

	@FindBy(xpath = "//input[@id='BGThemeColor']")
	private WebElement bg_theme_color;// click on the bg theme field

	@FindBy(xpath="(//input[@value='SAVE'])[1]")
	private WebElement save_theme; // click on the save button to save the theme

	public App_theme(WebDriver driver) {
		super(driver);
	}

	public void Extend_app_config() throws InterruptedException {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		Visiblityof(15, app_config_tab);
		GMaction media_library = new GMaction(); // action class to do mouse
													// hover action
		media_library.Movetoelement(driver, app_config_tab); // mouse hover
																// to
																// app_config
																// text

	}

	public void apptheme_page() throws InterruptedException {
		elementtobeclickable(15, apptheme);
		GMaction movetomedialib = new GMaction();
		movetomedialib.Movetoelement(driver, apptheme);
		apptheme.click();
	}

	public void select_theme() {
		elementtobeclickable(15, bg_theme_color);
		bg_theme_color.sendKeys(Keys.CONTROL +"a");
		bg_theme_color.sendKeys(Keys.DELETE);
		bg_theme_color.sendKeys("84C467");
		bg_theme_color.sendKeys(Keys.ENTER);
		elementtobeclickable(15,save_theme);
		save_theme.click();
		System.out.println("app theme updated with bg color as green");
		driver.navigate().refresh();
	}

}
