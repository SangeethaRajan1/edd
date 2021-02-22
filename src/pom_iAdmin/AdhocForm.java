package pom_iAdmin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;
import GenericMethods.GMaction;

public class AdhocForm extends Base_page {
	@FindBy(xpath = "//span[.='Adhoc']")
	private WebElement adhoc_tab; // mouse hover to adhoc tab

	@FindBy(xpath = "//span[.='Forms']")
	private WebElement forms;// navigate to adhoc form

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	private WebElement no_records; // if there is no record exist

	@FindBy(xpath = "//select[@id='is_active']")
	private WebElement status_drp;// select the status of the record[all,
									// active, inactive]

	@FindBy(xpath = "//input[@value='Add New']")
	private WebElement Add_adhocform; // add adhoc form button

	@FindBy(xpath = "//input[@id='formName']")
	private WebElement form_name; // add the form name

	@FindBy(xpath = "//span[@class='multiselect-selected-text']")
	private WebElement select_campus; // select the campus drop down

	@FindBy(xpath = "(//label[@class='checkbox'])[2]")
	private WebElement select_campus_value; // select the campus value from the
											// list

	@FindBy(xpath = "//input[@id='adhocFormSaveContinueBtn']")
	private WebElement save_adhoc_form; // save and continue adhoc form

	@FindBy(xpath = "(//select[@class='form-control'])[last()-1]")
	private WebElement adhoc_field_drp; // field drop down

	@FindBy(xpath = "(//input[@placeholder='Field Name'])[last()]")
	private WebElement field_name;// pass the value to the field name

	@FindBy(xpath = "//button[@id='addNewAdhocFormField']")
	private WebElement add_next_field; // click on next field button

	@FindBy(xpath = "(//input[@placeholder='Value 1'])[last()]")
	private WebElement value_checkbox; // value for checkbox option
	@FindBy(xpath = "(//input[@placeholder='Text 1'])[last()]")
	private WebElement text_checkbox; // text for checkbox option

	@FindBy(xpath = "(//input[@class='btn btn-success'])[2]")
	private WebElement save_fields; // save the fields

	@FindBy(xpath = "//h4[.='Max reached']")
	private WebElement max_reached; // adhoc form max reached

	@FindBy(xpath = "(//img[@data-original-title='Fields'])[1]")
	private WebElement fields_icon; // field icon under the action column

	@FindBy(xpath = "//h4[.='* Marked fields are mandatory']")
	private WebElement mandatory_fields; // mandatory fields pop up

	@FindBy(xpath = "//h4[.='Max reached']")
	private WebElement max_field_reached;// maximun allowed field limit reached

	@FindBy(xpath = "//h4[.='Arrival date already exist']")
	private WebElement arrival_date_already_exist; // only one arrival date
													// field is allowed,
	@FindBy(xpath = "//input[@value='Arrival Date']")
	private WebElement arrival_fieldname; // if there is field with name arrival
											// date

	@FindBy(xpath = "//button[@id='removeAdhocFormField']")
	private WebElement remove_field; // remove the last field

	@FindBy(xpath = "//input[@id='confirmRemoveFieldBtn']")
	private WebElement Yes_remove_field;

	@FindBy(xpath = "//h2[.='Add Adhoc Form']")
	private WebElement label_add_adhocform;

	@FindBy(xpath = "//input[@class='btn btn-success preventTagClose']")
	private WebElement maxlimit_popup;

	@FindBy(xpath = "//label[@aria-expanded='false']")
	private WebElement field_collapsed; // if the field is collapsed then

	/*
	 * @FindBy(xpath = "") private WebElement k;
	 */

	public AdhocForm(WebDriver driver) {
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

	public void status() {
		elementtobeclickable(15, status_drp);
		Select drp = new Select(status_drp);
		drp.selectByValue("all");
	}

	public void Record_details() {
		boolean record = no_records.isDisplayed();
		if (record) {
			System.out.println("The adhoc form table is empty");
		} else {
			System.out.println("Adhoc form history exist");
		}
	}

	public void Add_adhoc() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		elementtobeclickable(15, Add_adhocform);
		Add_adhocform.click();
		Thread.sleep(3000);
		String add_adhoc_url = driver.getCurrentUrl();
		System.out.println("add_adhoc_url " + add_adhoc_url);

		Thread.sleep(4000);
		// boolean form_name_value = form_name.isDisplayed();
		try {
			if (isElementDisplayed(form_name)) {
				System.out.println("Navigated to add new adhoc form page");

				elementtobeclickable(30, form_name);
				form_name.sendKeys("Automation"); // pass the value to form name
													// field

				elementtobeclickable(30, select_campus);
				select_campus.click(); // click on campus drop down
				elementtobeclickable(15, select_campus_value);
				select_campus_value.click(); // select the campus value
				elementtobeclickable(15, select_campus);
				select_campus.click(); // again click on campus field to dismiss
										// the
										// drop down

				js.executeScript("arguments[0].click();", save_adhoc_form); // scroll
																			// and
																			// click
																			// on
																			// save
																			// and
																			// continue
				js.executeScript("arguments[0].scrollIntoView(true)",
						save_adhoc_form);
			}

			else {

				driver.navigate().refresh();
				Thread.sleep(3000);
				elementtobeclickable(15, fields_icon);
				fields_icon.click();
				js.executeScript("arguments[0].scrollIntoView(true)",
						remove_field);
				if (isElementDisplayed(field_collapsed)) {
					// WebElement expand_field_panel= driver.findElement(
					// By.xpath("(//h4[@class='panel-title'])[last()-2]"));
					// elementtobeclickable(15,expand_field_panel);
					// expand_field_panel.click();
					elementtobeclickable(15, add_next_field);
					add_next_field.click(); // click on next field button
				}

			}
		} catch (NoSuchElementException e) {
			// e.printStackTrace();
			System.out.println("No such element exception is handled ");
			System.out.println(e);
		}

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

	public void add_fields_to_adhocform() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(3000);
		elementtobeclickable(40, adhoc_field_drp);
		adhoc_field_drp.click();
		Select fielddrp = new Select(adhoc_field_drp);
		List<WebElement> field_options = fielddrp.getOptions();
		System.out.println("size : " + field_options.size());

		for (int i = 0; i < field_options.size() - 6; i++) {

			if ((i != 8) && (i != 10) && (i != 16)) {
				WebElement y = driver.findElement(By
						.xpath("(//input[@value='Close'])[last()-2]"));

				fielddrp.selectByIndex(i);
				// js.executeScript("arguments[0].scrollIntoView(true)",
				// remove_field);
				Thread.sleep(3000);
				String field_selected = adhoc_field_drp.getAttribute("value");
				System.out.println("value : " + field_selected);
				elementtobeclickable(30, field_name);
				field_name.sendKeys(field_selected); // pass the field name
				List<WebElement> arrival_field = driver.findElements(By
						.xpath("//input[@value='Arrival Date']"));
				System.out.println("arrival size " + arrival_field);
				if (arrival_field.size() == 2) {
					System.out.println("Arrival date field exist");
					elementtobeclickable(30, adhoc_field_drp);
					adhoc_field_drp.click();
				}


				else {
					System.out.println("main else part");
					elementtobeclickable(15, add_next_field);
					add_next_field.click(); // click on next field button
					Thread.sleep(4000);
					if (isElementDisplayed(y)
							&& isElementDisplayed(mandatory_fields)) {
						System.out.println(y.getText());
						System.out.println("mandatory field already exist");
						elementtobeclickable(15, y);
						y.click();
						elementtobeclickable(15, value_checkbox);
						value_checkbox.sendKeys("dropdowm");
						elementtobeclickable(15, text_checkbox);
						text_checkbox.sendKeys("dropdown");
						elementtobeclickable(30, add_next_field);
						add_next_field.click();

						Thread.sleep(3000);
						js.executeScript("window.scrollBy(0, 5000)", "");
						// js.executeScript("arguments[0].scrollIntoView(true)",save_fields);
						elementtobeclickable(30, adhoc_field_drp);
						adhoc_field_drp.click();
					} else if (isElementDisplayed(y)
							&& isElementDisplayed(max_field_reached)) {
						System.out.println("max field already exist");
						elementtobeclickable(15, y);
						y.click();
						remove_field.click();
						elementtobeclickable(30, Yes_remove_field);
						Yes_remove_field.click();
					}

					else {

						elementtobeclickable(30, adhoc_field_drp);
						adhoc_field_drp.click();
						List<WebElement> field_count = driver.findElements(By
								.xpath("//input[@id='fieldCount']"));
				int	Fieldcount=	field_count.size();
						if (Fieldcount==19) {
							elementtobeclickable(30, remove_field);
							remove_field.click();
							elementtobeclickable(30, Yes_remove_field);
							Yes_remove_field.click();
						} else {
							elementtobeclickable(30, adhoc_field_drp);
							adhoc_field_drp.click();
						}

					}
				}
			}
		}

		elementtobeclickable(30, save_fields);
		js.executeScript("arguments[0].click();", save_fields);
	}
}
