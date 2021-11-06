import java.util.Scanner;

public class armstrongNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Scanner sc = new Scanner(System.in)
		
		int n = 153;
		int j=n;
		int sum=0;
		
		if (n>0) {
		
		while(n>0) {
			sum = (int) (sum+Math.pow(n%10,3));
			n=n/10;			
		}		
		
		System.out.println(sum);
		
		if(sum==j) {
			System.out.println("armstrong number");
		}
		else {
			System.out.println("Not");
		}

	}
	}
}
