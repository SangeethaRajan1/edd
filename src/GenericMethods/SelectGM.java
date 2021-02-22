package GenericMethods;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectGM {
		public void Selectbyindex(WebElement ele,int index)
		{
			Select s1= new Select(ele);
			s1.selectByIndex(index);
		}
		public void Selectbyvalue(WebElement ele,String value)
		{
			Select s1= new Select(ele);
			s1.selectByValue(value);
		}
		public void SelectbyvisibleText(WebElement ele,String value)
		{
			Select s1= new Select(ele);
			s1.selectByVisibleText(value);
		}
		public void Deselectbyindex(WebElement ele,int index)
		{
			Select s1= new Select(ele);
			s1.deselectByIndex(index);
		}
		public void Deselectbyvalue(WebElement ele,String value)
		{
			Select s1= new Select(ele);
			s1.deselectByValue(value);
		}
		public void Deselectbyvisibletext(WebElement ele,String value)
		{
			Select s1= new Select(ele);
			s1.deselectByVisibleText(value);
		}
		public void Deselectall(WebElement ele)
		{
			Select s1= new Select(ele);
			s1.deselectAll();
		}
		public List<String>  Getalloptions(WebElement ele)
		{
			Select s1= new Select(ele);
			List<WebElement> opt = s1.getOptions();
			List<String> allopt = new ArrayList<String>();
			for(WebElement e:opt)
			{
				String str=e.getText();
				allopt.add(str);
				
			}
			return allopt;
		}
		public List<String> Getselectedoptions(WebElement ele)
		{
			Select s1= new Select(ele);
			List<WebElement> selectedopt = s1.getAllSelectedOptions();
			List<String> allselectedopt = new ArrayList<String>();
			for(WebElement e:selectedopt)
			{
				String str=e.getText();
				allselectedopt.add(str);
				
			}
			return allselectedopt;
			
		}


}
