//Problem Statement//
/*
 * "https://practice.geeksforgeeks.org/problems/playing-with-mobile-numbers/0"
 * Given an number. The task is to tell whether the number is valid indian mobile number or not. Print "Valid" if it is a valid indian mobile number, otherwise print "Invalid". 

 

Rules for valid :-indian mobile number

The number should contain 10 or 11 or 12 digits.
If it contains 10 digits, then first  digit should be 7 or 8 or 9.
If it contains 11 digits, then first  digit should be 0 and second rule follwed.
If it contains 12 digits, then first two digits should be 91 and second rule followed .
Input: 

The first line contains a single integer T i.e. the number of test cases. Each test case contains a single number(N) in string representing a mobile number 
Output:

Corresponding to each test case, print "Valid"  if inumber is valid indian mobile number otherwise printf "Invalid" on a new line.
Constraints:

1<=T<=20
10<=  |N| <= 12

here |N| denotes the size of number string.
Example:

Input:

3
07456789011
6782580124
919828689528

Output:

Valid
Invalid
Valid
*/

import java.util.*;
public class PlsyingMobileNum {


	public static boolean ruleTwo(String number) {
		if((number.charAt(0)=='7') || (number.charAt(0)=='8') || (number.charAt(0)=='9') )
			return true;
		else
			return false;
	}			
	public static boolean ruleThree(String number) {
		if((number.charAt(0)=='0') && (ruleTwo(number.substring(1))))
			return true;
		else
			return false;
	}
	public static boolean ruleFour(String number){
		if((number.charAt(0)=='9') && (number.charAt(1)=='1') && (ruleTwo(number.substring(2))))
			return true;
		else 
			return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int i=0;
		
		while(i<T){
			String mobNum=sc.next();
			int len=mobNum.length();
			//System.out.println(len+" "+ mobNum.charAt(0));
			//PlsyingMobileNum rule=new PlsyingMobileNum();
			
			boolean ruleVal=false;
			
			switch (len){
				case 10:{
					ruleVal=ruleTwo(mobNum);
					if(ruleVal==true) {
						System.out.println("Valid");
						break;
					}
					else {
						System.out.println("Invalid");
						break;
					}
				}
				case 11:{
					ruleVal=ruleThree(mobNum);
					if(ruleVal==true) {
						System.out.println("Valid");
						break;
					}
					else {
						System.out.println("Invalid");
						break;
					}
				}
				case 12:{
					ruleVal=ruleFour(mobNum);
					if(ruleVal==true) {
						System.out.println("Valid");
						break;
					}
					else {
						System.out.println("Invalid");
						break;
					}
				}
				default:{
					System.out.println("Invalid");
					break;
				}
			}
		i++;
		}
		sc.close();

	}

}
