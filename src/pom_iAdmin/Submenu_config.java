package pom_iAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.SelectGM;

public class Submenu_config extends Base_page {
	@FindBy(xpath = "//select[@id='menus']")
	private WebElement addsubmenu;

	public Submenu_config(WebDriver driver) {
		super(driver);
	}

	public void Addsubmenu() throws InterruptedException {
		Thread.sleep(3000);
		Visiblityof(5, addsubmenu);
		SelectGM drp_appmenu = new SelectGM();
		drp_appmenu.Selectbyindex(addsubmenu, 1);
		// first element for app menu drop down
		//WebElement drp_subm = driver.findElement(By
				//.xpath("//select[@id='SubMenus']"));
		WebElement drp_submenu = driver.findElement(By
				.xpath("//select[@id='SubMenus']"));
	

		Thread.sleep(3000);
		elementtobeclickable(30,drp_submenu );
		Thread.sleep(3000);
		drp_appmenu.SelectbyvisibleText(drp_submenu, "Notification");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='savePageURLBtn']"))
		.click();
		driver.navigate().refresh();
		Thread.sleep(3000);
			}
		

		

	}


