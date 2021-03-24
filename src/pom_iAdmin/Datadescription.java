package pom_iAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;
import GenericMethods.SelectGM;

public class Datadescription extends Base_page {

	@FindBy(xpath = "//span[.='App Config']")
	private WebElement app_config_tab_data; // app config tab to mouse hover and
											// to
	// select the data description  menu
	@FindBy(xpath = "//a[.='Data Description']")
	private WebElement data_description_page; // select the datadescription page
	
	@FindBy(xpath = "(//select[@class='form-control'])[1]")
	private WebElement Select_appmenu_drpdown;// Click on the app menu drop down
												// from layer menu page
	
	@FindBy(xpath = "(//select[@class='form-control'])[2]")
	private WebElement Select_submenu_drpdown;// Click on the sub menu drop down
												// from data descr menu page
	@FindBy(xpath = "(//select[@class='form-control'])[3]")
	private WebElement Select_layermenu_drpdown;// Click on the layer menu
												// dropdown from data descr menu page
	@FindBy(xpath = "(//select[@class='form-control'])[4]")
	private WebElement Select_dadadwscr_menu_drpdown;// Click on the app menu drop down
												// from layer menu page
	@FindBy(xpath = "//input[@id='savePageURLBtn']")
	private WebElement Save_dadescrmenu; // Save the data descr menu action
	

	public Datadescription(WebDriver driver) {
		super(driver);

	}

	public void Extend_app_config() throws InterruptedException {
		Visiblityof(5, app_config_tab_data);
		GMaction datadescr_appconfi_mh = new GMaction(); // action class to do
															// mouse
															// hover action
		datadescr_appconfi_mh.Movetoelement(driver, app_config_tab_data); // mouse
																			// hover
		// to
		// app_config
		// text
		Thread.sleep(3000);

	}

	public void Datadescription_page() throws InterruptedException {
		Visiblityof(5, data_description_page);
		GMaction datadescr_page_click = new GMaction(); // action class to do
														// mouse
														// hover action
		datadescr_page_click.Click(driver, data_description_page); // click data
																	// description
																	// page from
																	// app
																	// config
																	// tab
		Thread.sleep(3000);
	}
	public void app_menu_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		Visiblityof(2, Select_appmenu_drpdown);
		SelectGM drp1_selection = new SelectGM();// dropdown to select the first
													// element in the page
		drp1_selection.Selectbyindex(Select_appmenu_drpdown, 1); // select the
																	// first
																	// element
																	// from the
																	// drop down

}
	public void sub_menu_dropdown() throws InterruptedException {
		elementtobeclickable(5, Select_submenu_drpdown);
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
	elementtobeclickable(5, Select_layermenu_drpdown);
		SelectGM drp3_selection = new SelectGM();// dropdown to select the layer
													// menu
		/*drp3_selection.SelectbyvisibleText(Select_layermenu_drpdown,
				"Notification");// */
		drp3_selection.Selectbyindex(Select_layermenu_drpdown, 1);
	}
	
	public void Datadescrpn_menu_dropdown() throws InterruptedException
	{
		
		SelectGM drp2_selection = new SelectGM();// dropdown to select the sub
													// menu
		Thread.sleep(4000);
		
		elementtobeclickable(30,Select_dadadwscr_menu_drpdown);
		Thread.sleep(4000);
		drp2_selection.Selectbyvalue(Select_dadadwscr_menu_drpdown, "Notification");// select the
																// first
																// element
																// from the
																// datadescr menu
																// drop down
	}
	public void save_datadescr_menu() {
		elementtobeclickable(5, Save_dadescrmenu);
		Save_dadescrmenu.click();
		System.out.println("data description menu has been saved");
		driver.navigate().refresh();
	}

}
