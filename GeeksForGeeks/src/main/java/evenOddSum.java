//Problem statement//
/*
 * "https://practice.geeksforgeeks.org/problems/java-loops-set-1/0"
 * 
 * For a given N, prints the sum of even and odd integers of the first N natural numbers.

Input:
First line of the input contains an integer T which denotes the number of test cases. Then T test cases follow.  Each test case contains a single line containing N.

Output: 
For each test case, print space separated sums of even and odd integers of the first N natural numbers respectively.

Constraints:
1 <= T< = 200
1<=N<=10000

Example:
Input:
2
1
6 
Output:
0 1
12 9  
*/

import java.util.*;
public class evenOddSum {
	public static void main (String[] args)
	 {
		Scanner sc =new Scanner(System.in);
		int T= sc.nextInt();
		int i=0;
		while(i<T) {
			int sumEven=0;
			int sumOdd=0;
			int N=sc.nextInt();
			for (int j=1;j<=N;j++) {
				if(j%2==0)
					sumEven=sumEven + j;
				else
					sumOdd=sumOdd + j;
			}
			
		System.out.println(sumEven+" " +sumOdd);
		i++;
		}
	 
	 sc.close();
	 }
}