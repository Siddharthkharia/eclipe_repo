package test1;

//import java.util.Scanner;

public class PrimeNum extends GetInput{

	public String primeChecker(int x) {
	
		int i=1;int counter=0;
		
	if(x==2) {
		return "Prime";
	}
	else {
		for (i=2;i<x/2;i++) {
			
			if (x%i==0) {
				counter++;
			}
		}
		
		if(counter>0) {
			return "Not a Prime";
		}
		else {
			return "Prime";
		}
		
	}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Scanner sc= new Scanner(System.in);		
		//sc.close();

		PrimeNum chori =new PrimeNum();
		int a;
		System.out.println("number daalo");
		a=chori.getInt();	
		System.out.println(chori.primeChecker(a));		
	}

}
