package pom_iAdmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import GenericMethods.Base_page;

public class Login_page extends Base_page 
{
@FindBy(xpath="//input[@id='Email']")private WebElement username;
@FindBy(xpath="//input[@id='Password']")private WebElement password;
@FindBy(xpath="//input[@value='SIGN-IN']")private WebElement Signin;
@FindBy(xpath="//div[@data-instituteid='5']") private WebElement institute_selection;
@FindBy(xpath="//input[@id='LoginYes']")private WebElement session_popup;
public Login_page(WebDriver driver) 
{
	super(driver);
}
public void Sendusername(String uname)
{
	Visiblityof(10,username);
	username.sendKeys(uname);
	
}
public void sendpassword(String pswd)
{
	Visiblityof(10,password);
	password.sendKeys(pswd);
	}
public void signin()
{
	Signin.click();
	}
public void sessionpopup()
{
	boolean session = session_popup.isDisplayed();
	if(session)
	{
	session_popup.click();
	}
	else
	{
		System.out.println("There is no previous session related pop up");
	}
	}
public void Instituteselection() throws InterruptedException
{
	
	Thread.sleep(3000);
	boolean multi_account=institute_selection.isDisplayed();
	if(multi_account)
	{
		Visiblityof(30,institute_selection);
		institute_selection.click();
		System.out.println("Selected the institute from the list");
	}
	else
	{
		System.out.println("The user have only 1 active institute");
	}
	
	}

}
