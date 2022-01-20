import java.util.regex.Matcher;

import org.hamcrest.Matchers;

public class tsys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s= "One two Three";
		
		String[] arr= s.split(" "); 
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<arr.length;i++) {
			
			sb.append(arr[i]);
		}
		
		String s2= sb.toString();
		
		System.out.println(s2);
		
		
		
		for(int i=0;i<s.length();i++) {
			
			
		}

	}

}
