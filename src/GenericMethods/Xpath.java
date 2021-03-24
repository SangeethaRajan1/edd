package GenericMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Xpath {
	public void xpath(WebDriver driver, String AN, String AV, String tag) {
		String xp = "//" + tag
				+ "[@" + AN + "=" + "'" + AV + "']";
		 driver.findElement(By.xpath(xp)).click();

	
	}
	public WebElement xpath_without_click(WebDriver driver, String AN, String AV, String tag) {
		String xp = "//" + tag
				+ "[@" + AN + "=" + "'" + AV + "']";
		 WebElement element=driver.findElement(By.xpath(xp));

	return element;
	}
	//td[@data-date='2021-03-17']
}
