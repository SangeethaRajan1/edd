package GenericMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class GMaction {
		public void Movetoelement(WebDriver driver,WebElement element)
		{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		}
		public void Contextclcik(WebDriver driver,WebElement element)
		{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
		}
		public void Click(WebDriver driver,WebElement element)
		{
		Actions act= new Actions(driver);
		act.click(element).perform();
		}
	}