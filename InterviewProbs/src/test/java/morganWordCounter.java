import java.util.HashMap;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.formula.functions.Count;
import org.testng.annotations.Test;

public class morganWordCounter {
	
	public static void main(String[] args) {
		
		String s= "to the moon alphaaaaa! beta. gamma! charlie, alpha-beta";	
		
		System.out.println(wordCounter(s));
		
	}
	
	public static int wordCounter(String s) {
		
		int count=0;
		
		String[] str=s.split("\\s+");
		
		for(int i=0;i<str.length;i++) {
			
			if(!(NumberUtils.isParsable(str[i]))) {
				
				if(str[i].contains("!") || str[i].contains(",") || str[i].contains("?")||str[i].contains(".")) {
					str[i]=str[i].substring(0, str[i].length()-1);
				}
				if(str[i].matches("[a-zA-Z]+")|| str[i].contains("-")) {
						count++;
						System.out.println("count added for word :- "+str[i]);
					}
			}
			
		}
		
		
		
		return count;
	}
}