package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page {
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	private WebElement usernameField;
	@FindBy(id="password")
	private WebElement passwordField;
	@FindBy(id="login-button")
	private WebElement loginbtn;
	
	public WebElement getUsernameField() {
		return usernameField;
	}
	public WebElement getPasswordField() {
		return passwordField;
	}
	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void usernameType(String uname)
	{
		usernameField.sendKeys(uname);
	}
	public void passwordType(String pass)
	{
		passwordField.sendKeys(pass);
	}
	public void loginClick()
	{
		loginbtn.click();
	}
	

}
