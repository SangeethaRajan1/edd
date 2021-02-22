package pom_iAdmin;

import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import GenericMethods.Base_page;
import GenericMethods.GMaction;
import GenericMethods.SelectGM;

public class Adhoc_scheduler extends Base_page {
	@FindBy(xpath = "//span[.='Adhoc']")
	private WebElement adhoc_tab; // mouse hover to adhoc tab

	@FindBy(xpath = "(//span[@class='menuMaxSize'])[5]")
	private WebElement scheduler_page;// navigate to adhoc form
	
	@FindBy(xpath = "//button[@class='btn btn-success']")
	private WebElement sch_button; // click on schedule button
	
	@FindBy(xpath = "//input[@id='txtDisplayName']")
	private WebElement sch_name;
	
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'])[1]")
	private WebElement select_adhoc;
	
	@FindBy(xpath = "(//label[@class='checkbox'])[1]")
	private WebElement first_adhocform ;
	
	@FindBy(xpath = "(//span[@class='multiselect-selected-text'])[2]")
	private WebElement select_champion;
	
	@FindBy(xpath = "(//label[@class='radio-inline'])[1]")
	private WebElement filetype_excel;
	
	@FindBy(xpath = "(//label[@class='radio-inline'])[6]")
	private WebElement include_all;
	
	@FindBy(xpath = "(//label[@class='radio-inline'])[7]")
	private WebElement sch_daily;
	
	@FindBy(xpath = "//input[@id='ReportScheduleStartDate']")
	private WebElement datepicker_startdate;
	
	@FindBy(xpath = "//input[@id='SaveReportScheduleBtn']")
	private WebElement save;

	public Adhoc_scheduler(WebDriver driver) {
		super(driver);
	}
	public void Expand_adhoc() throws InterruptedException // mouse hover to the adhoc tab
	{
		// driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		String xpath = "//span[.='Adhoc']";
		visibilityofelementlocated(30, xpath);
		GMaction mouse_hover = new GMaction();
		mouse_hover.Movetoelement(driver, adhoc_tab);
		Thread.sleep(3000);

	}
	public void sch_page() throws InterruptedException // click on forms
	// option from adhoc
	// tab and navigate
	// to adhoc scheduler
	// page
{

GMaction mouse_hover_forms = new GMaction();
Thread.sleep(3000);
mouse_hover_forms.Movetoelement(driver,scheduler_page );
elementtobeclickable(15, scheduler_page);
scheduler_page.click();
Thread.sleep(3000);

}

	public void Adhoc_sch() { // click on schedule button
		elementtobeclickable(15, sch_button);
		sch_button.click();
	}
	public void Adhoc_sch_details() // enter the details
	{
		elementtobeclickable(15,sch_name);
		sch_name.sendKeys("Scheduled by automation"); //pass the name of the ad-hoc scheduler
		
		elementtobeclickable(15,select_adhoc);
		select_adhoc.click(); // select the adhoc form which needs to be scheduled
		
		first_adhocform.click();// select the first adhoc form
		select_adhoc.click();//dismiss the drop down
		
		elementtobeclickable(15,filetype_excel); // select the file type as excel
		filetype_excel.click();
		
	//	elementtobeclickable(15,select_champion);
		//select_champion.click(); // select champion
		
		elementtobeclickable(15,include_all); // select the all radio button from include option
		include_all.click();
		
		elementtobeclickable(15,sch_daily);//select daily option for the option "when"
		sch_daily.click();
		
		Date date= new Date();
		String date2 = date.toString();
		String date3 = date2.replace(":", "-");
		
		elementtobeclickable(15,datepicker_startdate);
		datepicker_startdate.sendKeys(date3);
		
		elementtobeclickable(15,save);
		save.click();
		
		driver.navigate().refresh();
	}

}
