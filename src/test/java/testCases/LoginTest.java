package testCases;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import POM_Pages.Login_Page;
import POM_Pages.Logout_Page;
import generic_Utility.Excel_Utility;
import listeners.My_Listener;

/**@author Dibyendu (DibyenduGithub)
 *Fetched DataSets using TestNG dataProvider annotation with DataProvider Class  	Location inside the Test Method 'login'
 * Params- Name and Password.
 * on Failure 'login' method call the Listener class from the Specified Location.
 * Performed Actions using POM pages & methods.
 */


@Test(dataProviderClass = Excel_Utility.class, dataProvider = "testData")
@Listeners(My_Listener.class)
public class LoginTest extends Base_Class {

	public void login(String name, String password) throws Throwable {
		Login_Page in = new Login_Page(driver);
		in.usernameType(name);
		in.passwordType(password);
		in.loginClick();
		Thread.sleep(2000);

		Logout_Page out = new Logout_Page(driver);
		out.logoutMenuClick(driver);
		Thread.sleep(2000);
		out.logoutLinkClick(driver);
		Thread.sleep(2000);

	}

}
