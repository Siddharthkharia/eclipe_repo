package test1;

public class Mathee {
	
	
	
	public int getSum(int a, int b) {
		int c;
		c=a+b;		
		System.out.println("Sum of a & b =c is: "+c);
		return c;
	}
	
	
	public static void main(String args[]) {
		
		int x = 3;
		int y = 5;
		Mathee m1 = new Mathee();
		int z;
		 z=m1.getSum(x,y);
		System.out.println("z ki value:" +z);
	}

}
