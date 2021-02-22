package pom_iAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Menu_rearrangement extends Base_page {

	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab_data; // app config tab to mouse hover and
											// to
	@FindBy(xpath = "//a[.='Menu Rearrangement']")
	private WebElement menurearrangement_page;// menu rearrangement option from
												// app config tab
	@FindBy(xpath = "//h2[.='Menu Rearrangement']")
	private WebElement Page_confirmation;// confirm that the page navigated to
											// menu rearrangement page

	@FindBy(xpath = "(//div[@class='Active'])[1]")
	private WebElement Drag_element;// drag the first element

	@FindBy(xpath = "(//div[@class='Active'])[2]")
	private WebElement Drop_element;// drop in the place of second element
	
	@FindBy(xpath = "//input[@id='save']")
	private WebElement Save_menurearrangement; // Save the menu re-arrangement

	public Menu_rearrangement(WebDriver driver) {
		super(driver);
	}

	public void app_config() throws InterruptedException {
		Visiblityof(15, app_config_tab_data);
		GMaction datadescr_appconfi_mh = new GMaction(); // action class to do
															// mouse
															// hover action
		datadescr_appconfi_mh.Movetoelement(driver, app_config_tab_data); // mouse
																			// hover
		Thread.sleep(3000);
	}

	public void menurearrangement() throws InterruptedException {
		
		
		GMaction move_to_menu_rearrange = new GMaction();// action class to do
															// click action for
															// the menu
															// re-arrangement
		
		move_to_menu_rearrange.Movetoelement(driver, menurearrangement_page);
		
		elementtobeclickable(15,menurearrangement_page);
		GMaction move_to_menu_rearrange1 = new GMaction();
		move_to_menu_rearrange1.Click(driver, menurearrangement_page);
		Thread.sleep(2000);
		
	}

	public void page_confirmation() {
		Visiblityof(5,Page_confirmation);
		String currenturl=driver.getCurrentUrl();
		String displayedurl ="http://qaiadmin.icentapp.com/AppFactory/MenuRearrangement";
		//String Pageconfirmation = Page_confirmation.getText();
		if (currenturl.equalsIgnoreCase(displayedurl)) {
			System.out.println("page is navigated to menu rearrangement page"); // if
																				// the
																				// page
																				// consist
																				// of
																				// the
																				// text
																				// menu
																				// rearrangemnet
																				// then
																				// it
																				// is
																				// navigated
																				// to
																				// correct
																				// page
		} else {
			System.out
					.println("page is not navigated to menu rearrangement page");
		}
	}

	public void drag_and_drop() throws InterruptedException {
		elementtobeclickable(15,Drag_element);
		elementtobeclickable(15,Drop_element);
		Actions drag_drop = new Actions(driver);
		drag_drop.dragAndDrop(Drag_element, Drop_element).perform();
		Thread.sleep(3000);
		
	}
	public void Save_menu_rearrangemnet()
	{
		elementtobeclickable(15,Save_menurearrangement);
		Save_menurearrangement.click();
		driver.navigate().refresh();
	}

}
