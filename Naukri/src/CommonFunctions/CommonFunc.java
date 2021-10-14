package CommonFunctions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CommonFunc {

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
}
