package AutoHackathon.Project;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class MyTestNGBaseClass {
	
	public WebDriver oDriver;
	public static ExtentReports oExtentReport;
	public static ExtentTest oExtentTest;

	@BeforeSuite
	public void BeforeSuite() throws Throwable{
		oExtentReport = new ExtentReports("Reports/TestSuiteReport.html", true);
		oExtentReport.loadConfig(new File("config.xml"));
	}
	
	//********************************************************
	//preconditions
	//********************************************************
	@Parameters({"BrowserToOpen","AppUrl"})
	@BeforeClass
	public void automationSetup(String sBrowserName,String sUrl) throws Exception
	{
		oDriver = CommonLib.getDriver(sBrowserName);
		//oDriver = CommonLib.getRemoteDriver("http://192.168.228.2:4444/wd/hub", sBrowserName);
		oDriver.get(sUrl);
		Thread.sleep(6000);
	}

	//********************************************************
	//End of execution
	//********************************************************
	@AfterClass
	public void automationTeardown() throws Exception
	{
		oDriver.quit();
	}
	
	@AfterSuite
	public void afterSuite()  throws Throwable{
		oExtentReport.endTest(oExtentTest);
		oExtentReport.flush();
	}


}
