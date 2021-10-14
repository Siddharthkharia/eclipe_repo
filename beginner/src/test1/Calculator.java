package test1;

import java.util.Scanner;

public class Calculator {

	private static Scanner sc;

	public int getSum (int a, int b) {

		int c=a+b;
		
		return c;
	}
	
	public int getSubt (int a, int b) {

		int c=a-b;
		
		return c;
	}

	public int getDivide (int a, int b) {

		int c=a/b;
		
		return c;
	}
	
	public int getInto (int a, int b) {

		int c=a*b;
		
		return c;
	}

	public int evenOdd (int a) {

		int c=a%2;
		return c;
	}

		public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc = new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		
		Calculator chora = new Calculator();
		int xOddEven=chora.evenOdd(x);
		int yOddEven=chora.evenOdd(y);
		
		if(xOddEven != yOddEven){
			System.out.println("The Sum of the given no is  : "+ chora.getSum(x, y));
			
		}
		else {
			System.out.println("Condition Failed" );
		}

		
		if(x>y){
			System.out.println("The subtraction of the given no is  : "+ chora.getSubt(x, y));
			
		}
		else {
			System.out.println("Condition Failed as y is smaller than x" );
		}	
		

		if(x>0 && y>0){
			System.out.println("The multiplication of the given no is  : "+ chora.getInto(x, y));
			
		}
		else {
			System.out.println("Condition Failed as" );
		}	
		
	}
}