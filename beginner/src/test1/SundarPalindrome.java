package test1;

import java.util.Scanner;

public class SundarPalindrome {
	
	public String Reverso(String x) {
		
		String y="";
		int l=x.length();
		
		for(int i=l-1;i>=0;i--) {
			y=y + x.charAt(i);
		}
		return y ;
	}
	
	public static void main (String[] args) {
		
		Scanner sc= new Scanner(System.in);
		String a=sc.next();
		
	//	StringBuilder sb = new StringBuilder(a);
	//	String x = sb.reverse().toString();
		SundarPalindrome Golmal= new SundarPalindrome();
		String ulta= Golmal.Reverso(a);
		
		if (ulta==a) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Not a Palindrome");
		}
		sc.close();
	}

}
