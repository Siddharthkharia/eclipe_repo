import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MinMaxSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> arr= new ArrayList<Integer>();
		
		Scanner sc =new Scanner(System.in);
		
		for(int i=0;i<5;i++) {
			arr.add((int) sc.nextLong());
		}
		
		miniMaxSum(arr);
		sc.close();

	}
	
	
    public static void miniMaxSum(List<Integer> arr) {
    	// Write your code here
    	
    	Collections.sort(arr);
//
//		long smallest= arr.get(0);
//		long largest=arr.get(4);
    	long sum=0;
				
//		for (int i=1;i<arr.size();i++) {
//			
//			if(smallest>arr.get(i)) {
//				smallest=arr.get(i);
//			}
//			
//			if(largest<arr.get(i)) {
//				largest=arr.get(i);
//			}
//		}

			
    	for(int i=0;i<arr.size();i++) {
    		sum=sum+(long)arr.get(i);
    	}
    	
    	System.out.print(sum-arr.get(4)+" ");
    	System.out.print(sum-arr.get(0));
    	
    }

}
