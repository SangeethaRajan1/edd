package pom_iAdmin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class Adhoc_copy_form extends Base_page {
	@FindBy(xpath = "//span[.='Adhoc']")
	private WebElement adhoc_tab; // mouse hover to adhoc tab

	@FindBy(xpath = "//span[.='Forms']")
	private WebElement forms;// navigate to adhoc form

	@FindBy(xpath = "//input[@value='Copy Adhoc Form']")
	private WebElement adhoc_copy;// copy the adhoc form

	@FindBy(xpath = "//h4[.='Max reached']")
	private WebElement max_reached; // adhoc form max reached

	@FindBy(xpath = "//input[@class='btn btn-success preventTagClose']")
	private WebElement close_button;// close the pop up

	@FindBy(xpath = "//select[@id='ddlAdhocForm']")
	private WebElement select_existing_adhocform;// select_existing_adhocform
													// drop dowm

	@FindBy(xpath = "//input[@id='ddlNewFormName']")
	private WebElement select_new_form;// add the name of new form

	@FindBy(xpath = "(//span[@class='multiselect-selected-text'])[1]")
	private WebElement select_campus;// select the campus

	@FindBy(xpath = "//input[@id='CopyAdhocFormSaveBtn']")
	private WebElement save;// save the copy adhoc form action

	public Adhoc_copy_form(WebDriver driver) {
		super(driver);
	}

	public void Expand_adhoc() // mouse hover to the adhoc tab
	{
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String xpath = "//span[.='Adhoc']";
		visibilityofelementlocated(30, xpath);
		GMaction mouse_hover = new GMaction();
		mouse_hover.Movetoelement(driver, adhoc_tab);

	}

	public void adhoc_page() throws InterruptedException // click on forms
															// option from adhoc
															// tab and navigate
															// to adhoc form
															// page
	{

		GMaction mouse_hover_forms = new GMaction();
		mouse_hover_forms.Movetoelement(driver, forms);
		elementtobeclickable(15, forms);
		forms.click();
		Thread.sleep(3000);

	}

	public boolean isElementDisplayed(WebElement ele) {
		boolean elementDisplayed = false;

		try {
			ele.isDisplayed();
			elementDisplayed = true;
		} catch (Exception e) {
			elementDisplayed = false;
		}

		return elementDisplayed;

	}

	public void click_copy_adhoc() throws InterruptedException {
		elementtobeclickable(15, adhoc_copy);
		adhoc_copy.click();
		Thread.sleep(5000);

		try {
			if (!close_button.isDisplayed()) { // create the new form by copying some other forms
				Thread.sleep(3000);
				Select copy_drp = new Select(select_existing_adhocform);
				copy_drp.selectByVisibleText("y");
				elementtobeclickable(15, select_new_form);
				select_new_form.sendKeys("Copied automation form");
				elementtobeclickable(15, select_campus);
				select_campus.click();
				WebElement select_firstelemnt = driver.findElement(By
						.xpath("(//label[@class='checkbox'])[2]"));
				
				select_firstelemnt.click();
				elementtobeclickable(15, select_campus);
				select_campus.click();
				elementtobeclickable(15, save);
				save.click();
				WebElement copied_warning_msg = driver.findElement(By
						.xpath("(//input[@class='btn btn-success'])[7]"));
				elementtobeclickable(15, copied_warning_msg);
				copied_warning_msg.click();
			} else { // close the max reached pop up

				System.out.println("Maximum adhoc form has been created");
				Thread.sleep(3000);
				elementtobeclickable(15, close_button);
				close_button.click();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
