import java.util.HashMap;

import org.apache.commons.lang3.math.NumberUtils;
import org.apache.poi.ss.formula.functions.Count;
import org.testng.annotations.Test;

public class lineCount {
	
	public static void main(String[] args) {
		
		String s= "Alpha is beaten by    the gammaaa 123443   for charlie";	
		
		System.out.println(lineCounter(s));
		
	}
	
	public static int lineCounter(String s) {
		
		int count=0;
		
		String[] str=s.split("\\s+");
		
		for(int i=0;i<str.length;i++) {
			
			if(!(NumberUtils.isParsable(str[i]))) {
				count++;
				System.out.println("count added for word :- "+str[i]);
				if(str[i]==null) {
					count--;
					System.out.println("count removed by -1 for :- space");
				}
			}
		}
		return count;
	}
}