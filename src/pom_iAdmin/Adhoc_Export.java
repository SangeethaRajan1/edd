package pom_iAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;

public class Adhoc_Export extends Base_page {
	@FindBy(xpath = "(//input[@class='btn btn-success'])[3]")
	private WebElement adhocexport; // click on multiple adhoc export button

	@FindBy(xpath = "//h4[@id='warningMessage2']")
	private WebElement chkbox2export; // warning message to select the checkbox

	@FindBy(xpath = "//input[@class='btn btn-success preventTagClose']")
	private WebElement close; // close the warning message

	@FindBy(xpath = "(//select[@class='form-control input-sm'])[1]")
	private WebElement select_entry_count;// select the pagination filter

	@FindBy(xpath = "//input[@class='checkboxBig']")
	private WebElement All_checkbox; // select all checkbox

	@FindBy(xpath = "//input[@id='ExportOptionUser']")
	private WebElement ExportOptionUser; // select user profile option while
											// exporting

	@FindBy(xpath = "//input[@id='ExportOptionProgram']")
	private WebElement ExportOptionProgram; // select program profile option
											// while
											// exporting

	@FindBy(xpath = "//input[@id='ExportOptionArrival']")
	private WebElement ExportOptionArrival; // select arrival option while
											// exporting

	@FindBy(xpath = "//input[@id='ExportOptionNotes']")
	private WebElement ExportOptionNotes; // select program profile option while
											// exporting

	@FindBy(xpath = "//input[@id='ExportAdhocConfigSaveBtn']")
	private WebElement export_button; // select program profile option while
										// exporting

	public Adhoc_Export(WebDriver driver) {
		super(driver);
	}

	public void multiexport() { // click on multiple adhoc export button
		elementtobeclickable(15, adhocexport);
		adhocexport.click();
	}

	public void select_chkbox2export() {
		AdhocForm adhocclass = new AdhocForm(driver);
		if (adhocclass.isElementDisplayed(chkbox2export)) {// if warning message
															// to select the
															// checkbox
			elementtobeclickable(15, close); // close the warning message
			close.click();
		}
	}

	public void select_record_entry() {
		Select select_pagination = new Select(select_entry_count);
		select_pagination.selectByVisibleText("100");// select the pagination as
														// 100 to get all the
														// checkbox

	}

	public void select_record_chk() // select the half of the  checkbox and click on export
									// option
	{
		List<WebElement> all_checkbox = driver.findElements(By
				.xpath("//input[@class='checkboxBig']"));
		//int count = all_checkbox.size();
		for (int i = 0; i < 10; i++) { // maximum of 10 records can be exported at a time
			all_checkbox.get(i).click();
		}
		multiexport();

	}

	public void export_config() {
		elementtobeclickable(15, ExportOptionUser); //select user profile
		ExportOptionUser.click();

		elementtobeclickable(15, ExportOptionProgram);//select program profile
		ExportOptionProgram.click();

		elementtobeclickable(15, ExportOptionArrival);//select arrival info
		ExportOptionArrival.click();

		elementtobeclickable(15, ExportOptionNotes);//select notes
		ExportOptionNotes.click();

		elementtobeclickable(15, export_button); //click on export button
		export_button.click();
		
		WebElement email_export_success_message = driver.findElement(By.xpath("//h4[@id='warningMessage2']"));
		AdhocForm adhocclass = new AdhocForm(driver);
		if(adhocclass.isElementDisplayed(email_export_success_message))
		{
			elementtobeclickable(15,close); //click on success pop up
			close.click();
		}
	}

}
