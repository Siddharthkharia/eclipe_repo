import java.util.ArrayList;

import org.apache.commons.lang3.math.NumberUtils;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.specification.RequestSpecification;


public class paytmTest {

	public static void main(String[] args) {
		String sentence= "jds dsaf lkdf kdsa fkldsf, adsbf ldka ads? asd bfdal ds bf[l. akf dhj ds 878  dwa WE DE 7475 dsfh ds  RAMU 748 dj.";
		String[] arr= sentence.split(" ");
		
		int count=0;
		
		for(int i=0;i<arr.length;i++) {
			
			if(!(NumberUtils.isParsable(arr[i]))) {
				
				arr[i].trim();
				if(arr[i]==null) {
					System.out.println(arr[i]);
					count++;
					
				}				
			
			}
		}
		
		System.out.println(count);
		
	}
	
	
}
