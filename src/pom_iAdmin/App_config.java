package pom_iAdmin;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class App_config extends Base_page {

	@FindBy(xpath = "//input[@id='addNewMenu']")
	private WebElement addappmenu;
	@FindBy(xpath = "//input[@id='btnMenuSave']")
	private WebElement save_app_menu;
	@FindBy(xpath = "//input[@class='btn btn-success preventTagClose']")
	private WebElement maxlimit_popup;
	@FindBy(xpath = "(//input[@class='form-control'])[2]")
	private WebElement add_menu_name;
	@FindBy(xpath = "(//img[@class='enabledIMGClass'])[last()]")
	private WebElement upload_image;
	@FindBy(xpath = "(//div[@class='SingleItem'])[1]")
	private WebElement select_image;
	@FindBy(xpath = "(//img[@class='taggingpopupctrl'])[last()]")
	private WebElement Click0n_Tag_icon;
	@FindBy(xpath = "//input[@id='txtTagInput']")
	private WebElement tag_search_bar;
	@FindBy(xpath = "//input[@id='btnTagCreate']")
	private WebElement create_tag_button;
	@FindBy(xpath = "((//input[@onchange='OnCheckboxChanged();']))[last()]")
	private WebElement tag_checkbox;
	@FindBy(xpath = "//input[@id='btnTagApply']")
	private WebElement tag_apply_btn;
	@FindBy(xpath = "(//span[@class='glyphicon glyphicon-trash tag-delete'])[last()-1]")
	private WebElement delete_tag_button;
	@FindBy(xpath = "//h4[.='Delete tag? Associated menu will lose this tag name.']")
	private WebElement delete_tag_popup;

	public App_config(WebDriver driver) {
		super(driver);
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;
	public void Clickappmmenu() throws InterruptedException
	{	
		elementtobeclickable(15,addappmenu);
		boolean add_menu1_visible = addappmenu.isDisplayed();
		if (add_menu1_visible) {
			//Visiblityof(5, addappmenu);
			//addappmenu.sendKeys(Keys.RETURN);
			
			addappmenu.click(); // click on the add button of app menu
			Thread.sleep(3000);
		} 
		else {
			//js.executeScript("arguments[0].scrollIntoView();", save_app_menu);
			System.out.println("add app menu started+ no visibility");
			js.executeScript("window.scrollBy(0, 5000)", "");
			js.executeScript("arguments[0].scrollIntoView();", save_app_menu);
			Thread.sleep(3000);
			Visiblityof(5, addappmenu);
			addappmenu.click(); // click on the add button of app menu
			System.out.println("add app menu started");
		}
	}

	public void max_limit_reached() throws InterruptedException {
		Boolean maxlimitpopup1 = maxlimit_popup.isDisplayed();
		if (maxlimitpopup1) {
			//js.executeScript("scrollBy(0, -5000)");
			elementtobeclickable(15, maxlimit_popup);
			System.out.print("pop up of app menu maximum limit is displayed");
			Thread.sleep(3000);
			GMaction limit_popup = new GMaction();
			limit_popup.Click(driver, maxlimit_popup);
			Thread.sleep(3000);
		WebElement	hyperlink=driver.findElement(
					By.xpath("(//div[@class='col-sm-2 appMenuItemClass'])[last()]"));
		elementtobeclickable(15,hyperlink);
		hyperlink.click();
			// hyperlink to navigate to submenu
		} else {
			System.out.println("Max limit of app menu is not reached");
			js.executeScript("window.scrollBy(0,600)", "");
			js.executeScript("arguments[0].scrollIntoView();", save_app_menu);

			Date date = new Date();
			String date1 = date.toString();
			String menuname_with_date = "Automation" + date1;
			elementtobeclickable(15,add_menu_name);
			add_menu_name.sendKeys(menuname_with_date);

			Thread.sleep(3000);
			elementtobeclickable(15,upload_image);
			upload_image.click();

			Thread.sleep(3000);
			elementtobeclickable(15,select_image);
			select_image.click();
             
			Thread.sleep(3000);
			elementtobeclickable(15, Click0n_Tag_icon);
			Click0n_Tag_icon.click();

			elementtobeclickable(15, tag_search_bar);
			tag_search_bar.sendKeys("Automation" + date1);

			elementtobeclickable(15, create_tag_button);
			create_tag_button.click();

			Thread.sleep(3000);
			tag_search_bar.sendKeys(Keys.CONTROL + "a"); // select the text in
															// search
															// bar
			tag_search_bar.sendKeys(Keys.DELETE); // delete the text in search
													// bar

			elementtobeclickable(15, tag_checkbox);
			tag_checkbox.click();

			elementtobeclickable(15, tag_apply_btn);
			tag_apply_btn.click();

			elementtobeclickable(5, Click0n_Tag_icon);
			GMaction tag_click2 = new GMaction();
			tag_click2.Click(driver, Click0n_Tag_icon);// click on the tag
														// button to delete
			// the
			// tag
			System.out.print("clicked on the tag button to delete the tag");

			elementtobeclickable(15, delete_tag_button);
			delete_tag_button.click();

			boolean tag_delete_popup = delete_tag_popup.isDisplayed();
			if (tag_delete_popup) {

				WebElement delete_Yes = driver.findElement(By
						.xpath("//button[.='YES']"));
				elementtobeclickable(5, delete_Yes);
				delete_Yes.click();
				WebElement close_button_of_tag = driver.findElement(By
						.xpath("//a[@class='close']"));
				elementtobeclickable(5, close_button_of_tag);
				GMaction tag_popup_close_action = new GMaction();
				tag_popup_close_action.Click(driver, close_button_of_tag);
				Thread.sleep(3000);
				// close_button_of_tag.click();
				System.out.print("tag popup closed");
			}

			elementtobeclickable(5, save_app_menu);// save the app menu
			save_app_menu.click();
			driver.navigate().refresh();
			Thread.sleep(3000);
			driver.findElement(
					By.xpath("(//div[@class='col-sm-2 appMenuItemClass'])[last()]"))
					.click();
			// hyperlink to navigate to submenu

		}
	}

}
