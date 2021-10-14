package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import main.Homepage;
import main.LandingPage;

public class testing {

	static WebDriver oDriver;
	
	public static void waitfn() {
		
		synchronized (oDriver)
		{
			try {
				oDriver.wait(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) throws Exception {

// Web Driver initiliasations
		
		WebDriverManager.chromedriver().setup();		
		
		oDriver = new ChromeDriver(); //Driver ob 

		//Wait Object created		
		WebDriverWait oWait = new WebDriverWait(oDriver, 20);
		
//LandingPage Object created and login function called 		
		LandingPage oLandingPage = new LandingPage();
		oLandingPage.login(oDriver, oWait);

//Homepage to move toedit profile
		Homepage oHomepage = new Homepage();
		oHomepage.editProfile(oDriver, oWait);
		
		waitfn();
		
		oDriver.quit();	
		
		
	}
	
}
