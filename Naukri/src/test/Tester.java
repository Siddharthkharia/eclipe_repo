package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tester {
	
	static int ScrShotCtr=0;
	
	public static void snapshot(WebDriver oDriver) {
		int count=ScrShotCtr;
		TakesScreenshot scrShot = ((TakesScreenshot)oDriver);
		File file = scrShot.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("./Screenshots/test_"+count+".png"));
			System.out.println("the Screenshot is taken and saved as test_"+count+".png");
			ScrShotCtr++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver oWebDriver = new ChromeDriver();
		
		oWebDriver.get("https://www.google.com");
		WebElement searchBox = oWebDriver.findElement(By.xpath("//input[@class='gLFyf gsfi']"));
		searchBox.sendKeys("is selenium good");
		searchBox.submit();
		snapshot(oWebDriver);
		oWebDriver.findElement(By.xpath("//a[text()='News']")).click();
		snapshot(oWebDriver);
		oWebDriver.quit();
	}

}
