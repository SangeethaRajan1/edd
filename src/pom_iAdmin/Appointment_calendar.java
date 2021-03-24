package pom_iAdmin;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import GenericMethods.Base_page;
import GenericMethods.GMaction;
import GenericMethods.SelectGM;
import GenericMethods.Xpath;

public class Appointment_calendar extends Base_page {
	@FindBy(xpath = "//span[.='Settings']")
	public WebElement settings_page;

	@FindBy(xpath = "//a[.='Calendar']")
	public WebElement Calendar_module;

	@FindBy(xpath = "//select[@id='iAdminUserDrp']")
	public WebElement admindrp;

	@FindBy(xpath = "//select[@id='SlotDurationDrp']")
	public WebElement slotduration;

	@FindBy(xpath = "//input[@id='SaveApptSlotDuration']")
	public WebElement save_slot_duration;

	@FindBy(xpath = "(//input[@class='btn btn-success'])[1]")
	public WebElement successful_popup;

	@FindBy(xpath = "//span[.='month']")
	public WebElement month_from_calendar;

	@FindBy(xpath = "//td[@class='fc-day fc-tue fc-widget-content fc-today fc-state-highlight']")
	public WebElement todays_slot;

	@FindBy(xpath = "//select[@id='evt_campus']")
	public WebElement select_campus;

	@FindBy(xpath = "//textarea[@id='evt_venue']")
	public WebElement venue_slot;

	@FindBy(xpath = "//button[@id='saveAppointmentSlot']")
	public WebElement save_slot;

	@FindBy(xpath = "(//span[@class='fc-event-title'])[1]")
	public WebElement slots_available; // check whether any slots are available

	@FindBy(xpath = "(//span)[35]")
	public WebElement slots_available1; // check whether any slots are available

	@FindBy(xpath = "//div[@class='fc-view fc-view-month fc-grid']")
	public WebElement all_available_dates_of_the_month; // date of the month

	@FindBy(xpath = "//button[@id='deleteAppointmentSlot']")
	public WebElement delete_slot;

	@FindBy(xpath = "//button[@id='confirmYes']")
	public WebElement confirm_delete;

	@FindBy(xpath = "//select[@id='evt_startTime']")
	public WebElement starttime;

	@FindBy(xpath = "//span[@class='glyphicon glyphicon-refresh']")
	public WebElement refresh;

	public Appointment_calendar(WebDriver driver) {
		super(driver);
	}

	public void Expand_settings() throws InterruptedException // expand the
																// setting tab
																// to select
																// calendar
																// option

	{
		Thread.sleep(4000);
		GMaction gm = new GMaction();
		gm.Movetoelement(driver, settings_page);
	}

	public void Calendar() { // click on calendar option from the settings tab
		GMaction gm = new GMaction();
		gm.Movetoelement(driver, Calendar_module);
		gm.Click(driver, Calendar_module);
	}

	public void admin_select() { // select the first admin name displayed from
									// the drop down
		elementtobeclickable(15, admindrp);
		Select sel = new Select(admindrp);
		sel.selectByIndex(1);

	}

	public void Slot_duration() throws InterruptedException { // select the slot
																// duration and
																// save it
		Thread.sleep(3000);
		SelectGM sel = new SelectGM();
		sel.SelectbyvisibleText(slotduration, "30 Minutes");
		System.out.print("seleted the drp");
		elementtobeclickable(15, save_slot_duration);
		save_slot_duration.click();
		elementtobeclickable(15, successful_popup); // dismiss the pop up after
													// saving slot duration
		successful_popup.click();
		Thread.sleep(3000);
		admin_select();// select the admin again from the drop down
		System.out.println("moved to another method");
	}

	public void select_monthview() throws InterruptedException // select the
																// month view
																// from the
																// calendar
	{
		Thread.sleep(3000);
		elementtobeclickable(15, month_from_calendar);
		GMaction act = new GMaction();
		act.Click(driver, month_from_calendar);
		// month_from_calendar.click();
	}

	public void Current_select_date() throws InterruptedException {

		DateFormat dateformat = new SimpleDateFormat("YYYY/MM/dd");
		Date d = new Date();
		String d1 = dateformat.format(d);
		String date = d1.toString();
		String current_date = date.replace("/", "-"); // todays date

		System.out.println("todays date= " + current_date);
		Thread.sleep(4000);
		try {
			List<WebElement> elex = driver.findElements(By.tagName("td"));
			int count = elex.size();

			for (int i = 4; i < count; i++) {

				String slot_date = elex.get(i).getAttribute("data-date");

				Xpath locator = new Xpath();

				if (slot_date.equals(current_date)) {
					System.out.println("slot date equals current date");

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 300)", "");
					Thread.sleep(3000);
					locator.xpath(driver, "data-date", slot_date, "td");// click
																		// on
																		// the
																		// slot

					Date time = new Date();// current time
					DateFormat timeformat = new SimpleDateFormat("h:mm a");
					String timeformat1 = timeformat.format(time);
					String time_value = timeformat1.toString();
					System.out.println("time" + time_value);

					Select s = new Select(starttime);
					List<WebElement> op = s.getOptions();

					for (int k = 0; k < op.size(); k++) {
						/*
						 * String timestring=op.get(k).getText(); int
						 * v=Integer.parseInt(timestring);
						 * System.out.println(v); int
						 * timeint=Integer.parseInt(time_value);
						 * System.out.println(timeint); if(timeint<v) {
						 * s.selectByIndex(k); }
						 */
						if (k > op.size() - 2) {
							s.selectByIndex(k);
						}

					}

					SelectGM sel_camp1 = new SelectGM();
					sel_camp1.Selectbyindex(select_campus, 1); // select the
																// campus
																// from the
																// dropdown
																// of
																// appointment
																// pop up
					venue_slot.sendKeys(Keys.CONTROL + "a");
					venue_slot.sendKeys(Keys.DELETE); // delete the venue
														// which is
														// displayed by
														// default on
														// the page
					Thread.sleep(3000);
					venue_slot
							.sendKeys("venue for appointment calendar from automation"); // sent
																							// the
					// venue
					elementtobeclickable(15, save_slot);
					save_slot.click(); // save the slot

				}

			}

		}

		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
	}

	public void delete_slot() throws InterruptedException {

		Thread.sleep(3000);

		Actions action = new Actions(driver);
		action.moveToElement(slots_available).moveToElement(slots_available1)
				.click().build().perform();

		elementtobeclickable(15, delete_slot);
		delete_slot.click();
		elementtobeclickable(15, confirm_delete);
		confirm_delete.click();
		System.out.println("slots deleted");
	}

	public void drag() throws AWTException {
		// drag the slot to next date
		// tomorrows date
		Date d2 = new Date();
		java.util.Calendar c = java.util.Calendar.getInstance();
		c.setTime(d2);
		c.add(java.util.Calendar.DATE, 1);
		d2 = c.getTime();
		System.out.println(d2 + "is tomorrows date");
		DateFormat dateformat_tomorrow = new SimpleDateFormat("YYYY/MM/dd");
		String tomorrow = dateformat_tomorrow.format(d2);
		String tomorrow1 = tomorrow.replace("/", "-");
		System.out.println(tomorrow1 + "tomorrows date");

		Xpath locator1 = new Xpath();
		WebElement ellement = locator1.xpath_without_click(driver, "data-date",
				tomorrow1, "td");

		Date d3 = new Date();
		java.util.Calendar c1 = java.util.Calendar.getInstance();
		c1.setTime(d3);
		c1.add(java.util.Calendar.DATE, -1);
		d3 = c1.getTime();
		System.out.println(d3 + "is yesterdays date");
		DateFormat dateformat_yest = new SimpleDateFormat("YYYY/MM/dd");
		String yest = dateformat_yest.format(d3);
		String yset1 = yest.replace("/", "-");
		System.out.println(yset1 + "yesterdays date");

		// Xpath l = new Xpath();
		// WebElement yestr = l.xpath_without_click(driver, "data-date", yset1,
		// "td");
	WebElement drag1=driver.findElement(By
				.xpath("//div[@class='fc-event fc-event-hori fc-event-draggable fc-event-start fc-event-end ui-draggable']"));
		Actions drag_slot = new Actions(driver);
		// drag_slot.dragAndDrop(slots_available,
		// ellement).dragAndDrop(slots_available1, ellement).build().perform();
		drag_slot.dragAndDrop(drag1, ellement);
		drag_slot.clickAndHold(drag1).pause(1000)
				.moveToElement(ellement).pause(1000).release().perform();
		// Robot r = new Robot();
		// r.keyPress(KeyEvent.VK_ENTER);
		// r.keyRelease(KeyEvent.VK_ENTER);

	}
}
