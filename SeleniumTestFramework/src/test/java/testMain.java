import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class testMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver oDriver=null;
		oDriver=BrowserWebDriver.initDriver();

		oDriver.get("https://www.youtube.com");

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		oDriver.get("https://www.amazon.com");
		

		try {
			Thread.sleep(7000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		oDriver.quit();		
	}
}
