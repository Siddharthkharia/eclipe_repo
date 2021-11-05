import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserWebDriver {
	
	public static String getBrowserName() {
		String browserName = "Invalid Browser";
		Scanner sc= new Scanner(System.in);
		System.out.println("choose the browser name:");
		System.out.println("select 1 for Chrome");
		System.out.println("select 2 for Firefox");
		int input=sc.nextInt();
				
		if (input==1)
			browserName="chrome";
		else if(input==2)
			browserName="firefox";
		sc.close();
		return browserName;
	}

	public static WebDriver initDriver (){
		
		WebDriver oDriver = null;

		String projectpath =System.getProperty("user.dir");
		
		
		String driverId=new String(getBrowserName());
		System.out.println("Selected browser : " +driverId);	
		
				
		if (driverId.equalsIgnoreCase("chrome")){
							
		//ChromeDriver
			
			//Using Set System property
				//System.setProperty("webdriver.chrome.driver", projectpath+"\\Drivers\\Chrome\\chromedriver.exe");
		
			//Using WebDriverManager 
			WebDriverManager.chromedriver().setup();
			
			oDriver =new ChromeDriver(); //Object Driver crated for ChromeDriver
						
		}	
		else if(driverId.equalsIgnoreCase("firefox")){
				
		//FirefoxDriver
			
			//Using Set System Property
				//System.setProperty("webdriver.gecko.driver", projectpath+"\\Drivers\\FirefoxGecko\\geckodriver.exe");
		
			//Using WebDriverManager 
			WebDriverManager.firefoxdriver().setup();
			
			
			
			oDriver = new FirefoxDriver(); //Object Driver crated for FirefoxDriver
		}
		else if(driverId.equalsIgnoreCase("Invalid Browser"))
			System.out.println("WebDriver init not present");
		return oDriver;
	}
	 
}
