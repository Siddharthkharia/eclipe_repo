package AutoHackathon.Project;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class CommonLib 
{


	//-----------------------------------------------
	//Define the method for proxy
	//-----------------------------------------------
	public static Proxy getProxy() throws Exception
	{
		Proxy oProxy = new Proxy();
		String sProxyString = String.format("%s:%d", AutomationConstants.sProxyHostName,AutomationConstants.iProxyPort);

		oProxy.setProxyType(ProxyType.MANUAL);
		oProxy.setHttpProxy(sProxyString);
		oProxy.setSslProxy(sProxyString);

		return oProxy;

	}

	//-----------------------------------------------
	//Define the method of Desired capability of the browsers - javascript = true and set the Proxy for the browser
	//-----------------------------------------------
	public static DesiredCapabilities getCapability() throws Exception
	{
		DesiredCapabilities oCapability = new DesiredCapabilities();
		oCapability.setJavascriptEnabled(true);
		//oCapability.setCapability("proxy", getProxy());

		return oCapability;
	}

	//-----------------------------------------------
	//set InterExplorer options by merging the Desired Capability
	//-----------------------------------------------
	public static InternetExplorerOptions getIEOptions() throws Exception
	{
		InternetExplorerOptions oIEOptions = new InternetExplorerOptions();
		oIEOptions.merge(getCapability());
		oIEOptions.ignoreZoomSettings();
		oIEOptions.introduceFlakinessByIgnoringSecurityDomains();

		return oIEOptions;
	}

	//-----------------------------------------------
	//set ChromeOptions by merging the Desired Capability
	//-----------------------------------------------
	public static ChromeOptions getChromeOptions() throws Exception
	{
		ChromeOptions oChromeOptions = new ChromeOptions();
		oChromeOptions.merge(getCapability());

		return oChromeOptions;
	}

	//-----------------------------------------------
	//set FirefoxOptions by merging the Desired Capability
	//-----------------------------------------------
	public static FirefoxOptions getFirefoxOptions() throws Exception
	{
		FirefoxOptions oFirefoxOptions = new FirefoxOptions();
		oFirefoxOptions.merge(getCapability());

		return oFirefoxOptions;
	}

	//----------------------------------------
	//Define browserId
	//----------------------------------------
	public static int getBrowserId(String sBrowserName) throws Exception
	{
		if (sBrowserName.equalsIgnoreCase("ie")) return 1;
		if (sBrowserName.equalsIgnoreCase("firefox")) return 2;
		if (sBrowserName.equalsIgnoreCase("chrome")) return 3;
		if (sBrowserName.equalsIgnoreCase("htmlunit")) return 4;

		return -1;
	}

	//-------------------------------------------
	//Define getDriver type
	//-------------------------------------------

	public static WebDriver getDriver(String sBrowserName) throws Exception
	{
		WebDriver oDriver;

		switch (getBrowserId(sBrowserName))
		{
		case 1:
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ AutomationConstants.sIEDriverPath);
			oDriver = new InternetExplorerDriver(getIEOptions());
			break;

		case 2:
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+AutomationConstants.sGeckoDriverPath);
			oDriver = new FirefoxDriver(getFirefoxOptions());
			break;

		case 3:
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+AutomationConstants.sChromeDriverPath);
			oDriver = new ChromeDriver(getChromeOptions());
			break;

		default:
			throw new Exception("Unknown browsername =" + sBrowserName +
					" valid names are: ie,firefox,chrome,htmlunit");			
		}


		if (getBrowserId(sBrowserName) != 4)
		{
			oDriver.manage().window().maximize();
		}

		oDriver.manage().deleteAllCookies();
		oDriver.manage().timeouts().pageLoadTimeout(AutomationConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
		oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);

		return oDriver;

	}

	//-------------------------------------------
	//Define remoteDriver type
	//-------------------------------------------
	public static WebDriver getRemoteDriver(String sHubUrl, String sBrowserName) throws Exception
	{
		WebDriver oDriver;
		DesiredCapabilities oCapability = getCapability();

		switch (getBrowserId(sBrowserName)) 
		{
		case 1:
			oCapability.setBrowserName("internet explorer");
			break;

		case 2:
			oCapability.setBrowserName("firefox");
			break;

		case 3:
			oCapability.setBrowserName("chrome");
			break;

		case 4:
			oCapability.setBrowserName("htmlunit");

		default:
			throw new Exception("Unknown browsername = " + sBrowserName +
					"  Valid names are: ie,firefox,chrome,htmlunit");
		}

		oCapability.setPlatform(Platform.WINDOWS);

		oDriver = new RemoteWebDriver(new URL(sHubUrl), oCapability);

		if (getBrowserId(sBrowserName) != 4)
		{
			oDriver.manage().window().maximize();
		}


		oDriver.manage().deleteAllCookies();
		oDriver.manage().timeouts().pageLoadTimeout(AutomationConstants.lngPageLoadTimeout, TimeUnit.SECONDS);
		oDriver.manage().timeouts().implicitlyWait(AutomationConstants.lngImplicitWaitTimeout, TimeUnit.SECONDS);

		return oDriver;
	}
	
	public static boolean sendKeys(WebDriver oDriver, By identifier, String text){
		WebElement oElement = oDriver.findElement(identifier);
		if(oElement.isDisplayed() && oElement.isEnabled()){
			oElement.sendKeys(text);
			return true;
		}else{
			return false;
		}
		
	}
	
	public static boolean setAttribute(WebDriver oDriver, By identifier, String attribute, String value){
		WebElement oElement = oDriver.findElement(identifier);
		if(oElement.isDisplayed() && oElement.isEnabled()){
			JavascriptExecutor jsExec = (JavascriptExecutor)oDriver;
			jsExec.executeScript("arguments[0].setAttribute('" + attribute + "','" + value + "')",oElement);
			//oElement.sendKeys();
			return true;
		}else{
			return false;
		}
		
	}

}
