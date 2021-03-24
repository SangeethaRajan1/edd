package pom_iAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;
import GenericMethods.SelectGM;

public class Layer_menu extends Base_page {
	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab; // app config tab to mouse hover and to
										// select the layer menu
	@FindBy(xpath = "//a[.='Layer Menu']")
	private WebElement layer_menu;// Click on the layer menu from app config
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement Select_appmenu_drpdown;// Click on the app menu drop down
												// from layer menu page
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement Select_submenu_drpdown;// Click on the sub menu drop down
												// from layer menu page
	@FindBy(xpath = "(//select[@class='form-control'])[3]")
	private WebElement Select_layermenu_drpdown;// Click on the layer menu
												// dropdown from layer menu page
	@FindBy(xpath = "//input[@id='savePageURLBtn']")
	private WebElement Save_layermenu; // Save the layer menu action
	
	@FindBy(xpath = "//h2[.='Layer Menu ']")
	private WebElement layer_menu_confirmation; 

	public Layer_menu(WebDriver driver) {
		super(driver);

	}

	public void Extend_app_config() throws InterruptedException {
		Visiblityof(15, app_config_tab);
		Thread.sleep(3000);
		GMaction layer_appconfi_mh = new GMaction(); // action class to do mouse
														// hover action
		layer_appconfi_mh.Movetoelement(driver, app_config_tab); // mouse hover
																	// to
																	// app_config
																	// text
		Thread.sleep(3000);
	}

	public void Layer_menu_page() throws InterruptedException {
		
		
		GMaction layer_menu_clcik = new GMaction(); // action class to do click
													// action of layer menu
		
		layer_menu_clcik.Movetoelement(driver, layer_menu);
		elementtobeclickable(15, layer_menu);
		GMaction layer_menu_clcik2 = new GMaction();
		layer_menu_clcik2.Click(driver, layer_menu); // click on layer_menu from app config
		Thread.sleep(3000);
		
		String current_url=driver.getCurrentUrl();
		System.out.println(current_url);
		String displayed_url ="http://qaiadmin.icentapp.com/AppFactory/Layer3MenuConfig";
		if(current_url.equalsIgnoreCase(displayed_url))
		{
			System.out.println("Navigated to the layer menu page successfully");
		}
		else
		{
			System.out.println("Not Navigated to the layer menu page successfully");
			driver.navigate().refresh();
			Visiblityof(15, app_config_tab);
			Thread.sleep(3000);
			GMaction layer_appconfi_mh = new GMaction(); // action class to do mouse
															// hover action
			layer_appconfi_mh.Movetoelement(driver, app_config_tab); // mouse hover
																		// to
																		// app_config
																		// text
			Thread.sleep(3000);
			elementtobeclickable(15, layer_menu);
			
			GMaction layer_menu_clcik1 = new GMaction(); // action class to do click
														// action of layer menu
			
			
			layer_menu_clcik1.Click(driver, layer_menu); // click on layer_menu from app config
			Thread.sleep(3000);
			
		}
}

	public void app_menu_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		elementtobeclickable(15, Select_appmenu_drpdown);
		SelectGM drp1_selection = new SelectGM();// dropdown to select the first
													// element in the page
		drp1_selection.Selectbyindex(Select_appmenu_drpdown, 1); // select the
																	// first
																	// element
																	// from the
																	// drop down

	}

	public void sub_menu_dropdown() {
		elementtobeclickable(15, Select_submenu_drpdown);
		SelectGM drp2_selection = new SelectGM();// dropdown to select the sub
													// menu
		drp2_selection.Selectbyindex(Select_submenu_drpdown, 1);// select the
																// first
																// element
																// from the
																// sub menu
																// drop down
	}

	public void layer_menu_dropdown() throws InterruptedException {
		
		SelectGM drp3_selection = new SelectGM();// dropdown to select the layer
													// menu
		/*drp3_selection.SelectbyvisibleText(Select_layermenu_drpdown,
				"Notification");// select the notification as action */
		Thread.sleep(4000);
		elementtobeclickable(30, Select_layermenu_drpdown);
		Thread.sleep(4000);
		drp3_selection.Selectbyvalue(Select_layermenu_drpdown, "Notification");
	}

	public void save_layer_menu() throws InterruptedException {
		
		Boolean save_button_visible = Save_layermenu.isDisplayed();
		if(save_button_visible)
		{
			elementtobeclickable(15, Save_layermenu);
		Save_layermenu.click();
		System.out.println("Layer menu has been saved");
		driver.navigate().refresh();
		Thread.sleep(4000);
		}
		else
		{
			driver.navigate().refresh();
			Thread.sleep(4000);
		}
	}

}
