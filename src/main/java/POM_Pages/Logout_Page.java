package POM_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_Page {
	
		public Logout_Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(id="react-burger-menu-btn")
		private WebElement burgerBtn;
		@FindBy(linkText="Logout")
		private WebElement logoutLink;
		
		public WebElement getBurgerBtn() {
			return burgerBtn;
		}
		public WebElement getLogoutLink() {
			return logoutLink;
		}
		
		public void logoutMenuClick(WebDriver driver)
		{
			Actions act=new Actions(driver);
			act.moveToElement(burgerBtn).click().perform();
		}
		public void logoutLinkClick(WebDriver driver)
		{
			Actions act1=new Actions(driver);
			act1.moveToElement(logoutLink).click().perform();
		}
		
		
		
}
