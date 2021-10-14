package test1;

import java.util.Arrays;
import java.util.Scanner;

public class GetInput {

	Scanner sc = new Scanner(System.in);
	
	int getInt() {
		int a=sc.nextInt();
		return a;
		}
	
	String getString() {
		String a=sc.nextLine();
		return a;
		}
	
	int[][] getArray(int s1, int s2) {
		
		//System.out.println("Enter the size for first dimenssion of array s1:");
		///int s1 =sc.nextInt();
		
			//System.out.println("Enter the size for second dimenssion of array s2:");
			//int s2 =sc.nextInt();
			
			int[][] a = new int[s1][s2];
			
			for(int i=0; i<s1;i++) {
				for(int j=0; j<s2;j++) {
				a[i][j]=sc.nextInt();
				}
			}
			System.out.println(Arrays.toString(a));
		return a;
		}

}
