package listeners;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import testCases.Base_Class;

/**@author Dibyendu(DibyenduGithub)
 * This is My_Listener Class inside listeners Package to Track and handle all the Test          	Events.
 * Here I've demonstrated onTestSuccess & onTestFailure Methods.
 * onTestSuccess- Just a Simple PASS Test Message. 
 * onTestFailure- TakesScreenshotMethod Used with the Help of the BaseClass Driver,Fetched the FailedResult Name &Attached with .png Extension-Stored inside ScreenShotsFolder.
 */

public class My_Listener extends Base_Class implements ITestListener{

	ExtentTest test;	
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Passed");
	}

	public void onTestFailure(ITestResult result) {
		String FailedMethod = result.getMethod().getMethodName();
		System.out.println("Failed Method Name- "+FailedMethod );
		
		//EventFiringWebDriver ts=new EventFiringWebDriver(Base.driver);
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		try {
			String dest = "./ScreenShotsFolder/"+FailedMethod+".png";
			FileUtils.copyFile(src, new File(dest));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			}

	
	

}
