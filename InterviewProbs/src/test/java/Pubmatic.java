import java.util.Scanner;

public class Pubmatic {

	public static int chkfn(int n, int count) {
		int ones=0;
		int tens=0;
		int j=0;
		for (int i=n+1;;i++) {
			if(i<=99) {
				ones=i%10;
				tens=i/10;
				if(ones+tens==10) {
					j++;
					if(j==count)
						return i;
				}
			}	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sum of the digit is 10
		
		
		Scanner sc = new Scanner(System.in);
		
		int start=sc.nextInt();
		int cnt = sc.nextInt();
		
		System.out.println(chkfn(start,cnt));
		sc.close();
	}
}